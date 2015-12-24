package com.cemgunduz.espn.report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cemgunduz.espn.api.calculation.CalculationStrategy;
import com.cemgunduz.espn.api.calculation.CalculationStrategyByConstantAndSheetType;
import com.cemgunduz.espn.entity.BasketballPlayer;
import com.cemgunduz.espn.entity.Team;
import com.cemgunduz.espn.scrape.Scraper;

public class Report {

	List<BasketballPlayer> players;
	
	double team_min = 0.0;
	double team_fgm = 0.0;
	double team_fga = 0.0;
	double team_fgp = 0.0;
	double team_ftm = 0.0;
	double team_fta = 0.0;
	double team_ftp = 0.0;
	double team_p3m = 0.0;
	double team_reb = 0.0;
	double team_ast = 0.0;
	double team_stl = 0.0;
	double team_blk = 0.0;
	double team_to = 0.0;
	double team_pts = 0.0;
	double totalVal = 0.0;
	
	boolean teamInfoLock = false;
	
	/* ----------------------------- */
	
	private static final double SUCCESS_THRESHOLD = 0.25;
	private static final double SUCCESS_THRESHOLD_PERCENTAGE_FOR_FG = 0.25;
	private static final double SUCCESS_THRESHOLD_PERCENTAGE_FOR_FT = 0.04;
	private static final double BELOW_THRESHOLD_MODIFIER = 0.6;
	
	public Report()
	{
		this(300);
	}
	
	public Report(int scrapeFor)
	{
		try {
			players = Scraper.scrapePlayers(scrapeFor);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CalculationStrategy calculationStrategy = new CalculationStrategyByConstantAndSheetType();
		
		for(BasketballPlayer player : players)
			calculationStrategy.calculate(player);
		
		Collections.sort(players);
	}
	
	public void showConstants()
	{
		System.out.println("Constant Report");
		System.out.println("----------------------------");
		
		int i = 0;
		for(BasketballPlayer player : players)
		{
			registerTeamInfo(player);
			i++;
		}
		
		showTeamInfo();
		System.out.println("-----------------------------");
	}
	
	public void showConstantsForSumOfAllTeams()
	{
		System.out.println("Constant Report");
		System.out.println("----------------------------");
		
		int i = 0;
		for(BasketballPlayer player : players)
		{
			if(!player.getPlayerTeamName().equals("FA"))
			{
				registerTeamInfo(player);
				i++;
			}
		}
		
		showTeamInfo();
		System.out.println("-----------------------------");
	}
	
	public void showFA()
	{
		System.out.println("FA Report");
		System.out.println("----------------------------");
		
		int i = 0;
		for(BasketballPlayer player : players)
		{
			if(i>50)
				break;
			if(player.getPlayerTeamName().equals("FA") || player.getPlayerTeamName().indexOf("WA") > -1)
			{
				registerTeamInfo(player);
				i++;
				showPlayerInfo(i, player);
			}
		}
		
		showTeamInfo();
		System.out.println("-----------------------------");
	}
	
	public void showAllPlayers()
	{
		System.out.println("DA Report");
		System.out.println("----------------------------");
		
		int i = 0;
		for(BasketballPlayer player : players)
		{
				registerTeamInfo(player);
				i++;
				showPlayerInfo(i, player);
		}
		
		showTeamInfo();
		System.out.println("-----------------------------");
	}
	
	public void showTeam(String teamName)
	{
		System.out.println("Team Report : " + teamName);
		System.out.println("----------------------------");
		
		int i = 0;
		for(BasketballPlayer player : players)
		{
			if(player.getPlayerTeamName().equals(teamName))
			{
				registerTeamInfo(player);
				i++;
				showPlayerInfo(i, player);
			}
		}
		
		showTeamInfo();
		System.out.println("-----------------------------");
	}
	
	public void getExtensiveTeamResult(List<String> teamNames)
	{
		System.out.println("Extensive Team Report Result");
		
		List<Team> teams = new ArrayList<Team>();
		
		for(String teamName : teamNames)
		{
			showTeam(teamName);
			
			Team team = new Team();
			team.setTeamName(teamName);
			team.setTeam_ast(team_ast);
			team.setTeam_blk(team_blk);
			team.setTeam_fga(team_fga);
			team.setTeam_fgm(team_fgm);
			team.setTeam_fgp(team_fgp);
			team.setTeam_fta(team_fta);
			team.setTeam_ftm(team_ftm);
			team.setTeam_ftp(team_ftp);
			team.setTeam_min(team_min);
			team.setTeam_p3m(team_p3m);
			team.setTeam_pts(team_pts);
			team.setTeam_reb(team_reb);
			team.setTeam_stl(team_stl);
			team.setTeam_to(team_to);
			
			teams.add(team);
		}
		
		for(Team team : teams)
		{
			double modifier_free_points = 0;
			double absolute_points = 0;
			double points = 0;
			
			for(Team oppTeam: teams)
			{
				
				if(oppTeam.getTeamName().equals(team.getTeamName()))
					continue;
				
				if(oppTeam.getTeam_ast() + SUCCESS_THRESHOLD < team.getTeam_ast())
				{
					modifier_free_points++;
					absolute_points++;
					points++;
				}
				else if(oppTeam.getTeam_ast() < team.getTeam_ast())
				{
					modifier_free_points++;
					points += BELOW_THRESHOLD_MODIFIER;
				}
				if(oppTeam.getTeam_blk() + SUCCESS_THRESHOLD < team.getTeam_blk())
				{
					modifier_free_points++;
					absolute_points++;
					points++;
				}
				else if(oppTeam.getTeam_blk() < team.getTeam_blk())
				{
					modifier_free_points++;
					points += BELOW_THRESHOLD_MODIFIER;
				}
				
				if(oppTeam.getTeam_reb() + SUCCESS_THRESHOLD < team.getTeam_reb())
				{
					modifier_free_points++;
					absolute_points++;
					points++;
				}
				else if(oppTeam.getTeam_reb() < team.getTeam_reb())
				{
					modifier_free_points++;
					points += BELOW_THRESHOLD_MODIFIER;
				}
				
				if(oppTeam.getTeam_stl() + SUCCESS_THRESHOLD < team.getTeam_stl())
				{
					modifier_free_points++;
					absolute_points++;
					points++;
				}
				else if(oppTeam.getTeam_stl() < team.getTeam_stl())
				{
					modifier_free_points++;
					points += BELOW_THRESHOLD_MODIFIER;
				}
				
				if(oppTeam.getTeam_pts() + SUCCESS_THRESHOLD < team.getTeam_pts())
				{
					modifier_free_points++;
					absolute_points++;
					points++;
				}
				else if(oppTeam.getTeam_pts() < team.getTeam_pts())
				{
					modifier_free_points++;
					points += BELOW_THRESHOLD_MODIFIER;
				}
				
				if(oppTeam.getTeam_p3m() + SUCCESS_THRESHOLD < team.getTeam_p3m())
				{
					modifier_free_points++;
					absolute_points++;
					points++;
				}
				else if(oppTeam.getTeam_p3m() < team.getTeam_p3m())
				{
					modifier_free_points++;
					points += BELOW_THRESHOLD_MODIFIER;
				}
				
				if(oppTeam.getTeam_to() - SUCCESS_THRESHOLD > team.getTeam_to())
				{
					modifier_free_points++;
					absolute_points++;
					points++;
				}
				else if(oppTeam.getTeam_to() > team.getTeam_to())
				{
					modifier_free_points++;
					points += BELOW_THRESHOLD_MODIFIER;
				}
				
				if(oppTeam.getTeam_fgm()/oppTeam.getTeam_fga() + SUCCESS_THRESHOLD_PERCENTAGE_FOR_FG < team.getTeam_fgm()/team.getTeam_fga())
				{
					modifier_free_points++;
					absolute_points++;
					points++;
				}
				else if(oppTeam.getTeam_fgm()/oppTeam.getTeam_fga() < team.getTeam_fgm()/team.getTeam_fga())
				{
					modifier_free_points++;
					points += BELOW_THRESHOLD_MODIFIER;
				}
				
				if(oppTeam.getTeam_ftm()/oppTeam.getTeam_fta() + SUCCESS_THRESHOLD_PERCENTAGE_FOR_FT < team.getTeam_ftm()/team.getTeam_fta())
				{
					modifier_free_points++;
					absolute_points++;
					points++;
				}
				else if(oppTeam.getTeam_ftm()/oppTeam.getTeam_fta() < team.getTeam_ftm()/team.getTeam_fta())
				{
					modifier_free_points++;
					points += BELOW_THRESHOLD_MODIFIER;
				}
			}
			
			System.out.println("Team " + team.getTeamName() + " -> " + modifier_free_points + " points -> " + points + " | absolute -> " 
			+ absolute_points + "| directedness -> " + absolute_points/points);
		}
	}
	
	private void showPlayerInfo(int num, BasketballPlayer player)
	{
		System.out.println(num + ") " + player.getName() + " -> " + player.getValue());
		System.out.println(player.getStatMap().toString());
	}
	
	private void showPlayerInfo(BasketballPlayer player)
	{
		System.out.println(player.getName() + " -> " + player.getValue());
		System.out.println(player.getStatMap().toString());
	}
	
	private void registerTeamInfo(BasketballPlayer p)
	{
		if(teamInfoLock)
		{
			clearTeamInfo();
			teamInfoLock = false;
		}

		totalVal += p.getValue();
		
		team_fgm += p.getStatMap().get("fgm");
		team_fga += p.getStatMap().get("fga");
		//team_fgp += p.getStatMap().get("fgp");
		team_ftm += p.getStatMap().get("ftm");
		team_fta += p.getStatMap().get("fta");
		//team_ftp += p.getStatMap().get("ftp");
		team_p3m += p.getStatMap().get("3pm");
		team_reb += p.getStatMap().get("reb");
		team_ast += p.getStatMap().get("ast");
		team_stl += p.getStatMap().get("stl");
		team_blk += p.getStatMap().get("blk");
		team_to += p.getStatMap().get("to");
		team_pts += p.getStatMap().get("pts");
	}
	
	private void showTeamInfo()
	{
		teamInfoLock = true;
		
		System.out.println("\nTeam Stats :");
		System.out.println("Team FG% -> : " + team_fgm + team_fga);
		System.out.println("Team FT% -> : " + team_ftm + team_fta);
		System.out.println("Team 3PM -> : " + team_p3m);
		System.out.println("Team REB -> : " + team_reb);
		System.out.println("Team AST -> : " + team_ast);
		System.out.println("Team STL -> : " + team_stl);
		System.out.println("Team BLK -> : " + team_blk);
		System.out.println("Team TO -> : " + team_to);
		System.out.println("Team PTS -> : " + team_pts);
		
		System.out.println("\nTotal Val : " + totalVal);
	}
	
	private void clearTeamInfo()
	{
		team_min = 0.0;
		team_fgm = 0.0;
		team_fga = 0.0;
		team_fgp = 0.0;
		team_ftm = 0.0;
		team_fta = 0.0;
		team_ftp = 0.0;
		team_p3m = 0.0;
		team_reb = 0.0;
		team_ast = 0.0;
		team_stl = 0.0;
		team_blk = 0.0;
		team_to = 0.0;
		team_pts = 0.0;
		totalVal = 0.0;
	}
}
