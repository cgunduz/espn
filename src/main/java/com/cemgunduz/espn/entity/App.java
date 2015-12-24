package com.cemgunduz.espn.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.cemgunduz.espn.api.calculation.CalculationStrategy;
import com.cemgunduz.espn.api.calculation.CalculationStrategyByConstant;

public class App {

	public static void main(String[] args) {
		
		BasketballPlayer player = new BasketballPlayer();
		player.setId(1);
		player.setName("Chris Paul");
		player.getSeasonStatSheet().setAst(12.5);
		player.getSeasonStatSheet().setBlk(0.1);
		player.getSeasonStatSheet().setFga(14.2);
		player.getSeasonStatSheet().setFgm(6.3);
		player.getSeasonStatSheet().setFgp(6.3/14.2);
		player.getSeasonStatSheet().setFta(5.9);
		player.getSeasonStatSheet().setFtm(5.6);
		player.getSeasonStatSheet().setFtp(5.6/5.9);
		player.getSeasonStatSheet().setP3m(1.1);
		player.getSeasonStatSheet().setPts(19.3);
		player.getSeasonStatSheet().setReb(5.2);
		player.getSeasonStatSheet().setStl(2.5);
		player.getSeasonStatSheet().setTo(3.2);
		player.getSeasonStatSheet().setMin(36.0);
		

		BasketballPlayer player2 = new BasketballPlayer();
		player2.setId(2);
		player2.setName("Brandon Jennings");
		player2.getSeasonStatSheet().setAst(7.1);
		player2.getSeasonStatSheet().setBlk(0.1);
		player2.getSeasonStatSheet().setFga(16.3);
		player2.getSeasonStatSheet().setFgm(6.3);
		player2.getSeasonStatSheet().setFgp(6.3/16.3);
		player2.getSeasonStatSheet().setFta(3.6);
		player2.getSeasonStatSheet().setFtm(2.4);
		player2.getSeasonStatSheet().setFtp(2.4/3.6);
		player2.getSeasonStatSheet().setP3m(1.7);
		player2.getSeasonStatSheet().setPts(16.8);
		player2.getSeasonStatSheet().setReb(3.8);
		player2.getSeasonStatSheet().setStl(1.7);
		player2.getSeasonStatSheet().setTo(2.6);
		player2.getSeasonStatSheet().setMin(34.1);
		

		
		BasketballPlayer player3 = new BasketballPlayer();
		player3.setId(3);
		player3.setName("Mike Conley");
		player3.getSeasonStatSheet().setAst(5.6);
		player3.getSeasonStatSheet().setBlk(0.3);
		player3.getSeasonStatSheet().setFga(14.4);
		player3.getSeasonStatSheet().setFgm(7.3);
		player3.getSeasonStatSheet().setFgp(7.3/14.4);
		player3.getSeasonStatSheet().setFta(3.3);
		player3.getSeasonStatSheet().setFtm(2.9);
		player3.getSeasonStatSheet().setFtp(2.9/3.3);
		player3.getSeasonStatSheet().setP3m(1.3);
		player3.getSeasonStatSheet().setPts(18.8);
		player3.getSeasonStatSheet().setReb(2.3);
		player3.getSeasonStatSheet().setStl(1.5);
		player3.getSeasonStatSheet().setTo(2.0);
		player3.getSeasonStatSheet().setMin(33.2);
		

		
		BasketballPlayer player4 = new BasketballPlayer();
		player4.setId(4);
		player4.setName("MCW");
		player4.getSeasonStatSheet().setAst(7.4);
		player4.getSeasonStatSheet().setBlk(0.9);
		player4.getSeasonStatSheet().setFga(15.1);
		player4.getSeasonStatSheet().setFgm(5.7);
		player4.getSeasonStatSheet().setFgp(5.7/15.1);
		player4.getSeasonStatSheet().setFta(4.9);
		player4.getSeasonStatSheet().setFtm(3.6);
		player4.getSeasonStatSheet().setFtp(3.6/4.9);
		player4.getSeasonStatSheet().setP3m(1.7);
		player4.getSeasonStatSheet().setPts(16.6);
		player4.getSeasonStatSheet().setReb(5.4);
		player4.getSeasonStatSheet().setStl(2.3);
		player4.getSeasonStatSheet().setTo(3.3);
		player4.getSeasonStatSheet().setMin(36.3);
		

		
		BasketballPlayer player5 = new BasketballPlayer();
		player5.setId(5);
		player5.setName("Evan Turner");
		player5.getSeasonStatSheet().setAst(3.8);
		player5.getSeasonStatSheet().setBlk(0.0);
		player5.getSeasonStatSheet().setFga(17.5);
		player5.getSeasonStatSheet().setFgm(8.2);
		player5.getSeasonStatSheet().setFgp(8.2/17.5);
		player5.getSeasonStatSheet().setFta(5.4);
		player5.getSeasonStatSheet().setFtm(4.5);
		player5.getSeasonStatSheet().setFtp(4.5/5.4);
		player5.getSeasonStatSheet().setP3m(0.5);
		player5.getSeasonStatSheet().setPts(21.3);
		player5.getSeasonStatSheet().setReb(6.6);
		player5.getSeasonStatSheet().setStl(1.0);
		player5.getSeasonStatSheet().setTo(3.5);
		player5.getSeasonStatSheet().setMin(36.6);
		

		BasketballPlayer player6 = new BasketballPlayer();
		player6.setId(6);
		player6.setName("Arron Afflalo");
		player6.getSeasonStatSheet().setAst(3.8);
		player6.getSeasonStatSheet().setBlk(0.0);
		player6.getSeasonStatSheet().setFga(15.1);
		player6.getSeasonStatSheet().setFgm(7.5);
		player6.getSeasonStatSheet().setFgp(7.5/15.1);
		player6.getSeasonStatSheet().setFta(5.5);
		player6.getSeasonStatSheet().setFtm(4.5);
		player6.getSeasonStatSheet().setFtp(4.5/5.4);
		player6.getSeasonStatSheet().setP3m(3.0);
		player6.getSeasonStatSheet().setPts(22.5);
		player6.getSeasonStatSheet().setReb(4.7);
		player6.getSeasonStatSheet().setStl(0.8);
		player6.getSeasonStatSheet().setTo(2.5);
		player6.getSeasonStatSheet().setMin(36.7);
		

		
		BasketballPlayer player7 = new BasketballPlayer();
		player7.setId(7);
		player7.setName("Paul Pierce");
		player7.getSeasonStatSheet().setAst(2.5);
		player7.getSeasonStatSheet().setBlk(0.2);
		player7.getSeasonStatSheet().setFga(10.0);
		player7.getSeasonStatSheet().setFgm(4.0);
		player7.getSeasonStatSheet().setFgp(4.0/10.0);
		player7.getSeasonStatSheet().setFta(4.8);
		player7.getSeasonStatSheet().setFtm(4.1);
		player7.getSeasonStatSheet().setFtp(4.1/4.8);
		player7.getSeasonStatSheet().setP3m(1.0);
		player7.getSeasonStatSheet().setPts(13.1);
		player7.getSeasonStatSheet().setReb(5.5);
		player7.getSeasonStatSheet().setStl(0.9);
		player7.getSeasonStatSheet().setTo(2.3);
		player7.getSeasonStatSheet().setMin(30.8);
		

		
		BasketballPlayer player8 = new BasketballPlayer();
		player8.setId(8);
		player8.setName("Corey Brewer");
		player8.getSeasonStatSheet().setAst(1.4);
		player8.getSeasonStatSheet().setBlk(0.2);
		player8.getSeasonStatSheet().setFga(11.5);
		player8.getSeasonStatSheet().setFgm(5.4);
		player8.getSeasonStatSheet().setFgp(5.4/11.5);
		player8.getSeasonStatSheet().setFta(3.1);
		player8.getSeasonStatSheet().setFtm(2.3);
		player8.getSeasonStatSheet().setFtp(2.3/3.1);
		player8.getSeasonStatSheet().setP3m(1.1);
		player8.getSeasonStatSheet().setPts(14.2);
		player8.getSeasonStatSheet().setReb(2.5);
		player8.getSeasonStatSheet().setStl(1.9);
		player8.getSeasonStatSheet().setTo(1.7);
		player8.getSeasonStatSheet().setMin(33.5);
		

		
		BasketballPlayer player9 = new BasketballPlayer();
		player9.setId(9);
		player9.setName("Zach Randolph");
		player9.getSeasonStatSheet().setAst(1.7);
		player9.getSeasonStatSheet().setBlk(0.2);
		player9.getSeasonStatSheet().setFga(12.9);
		player9.getSeasonStatSheet().setFgm(6.8);
		player9.getSeasonStatSheet().setFgp(6.8/12.9);
		player9.getSeasonStatSheet().setFta(3.5);
		player9.getSeasonStatSheet().setFtm(2.8);
		player9.getSeasonStatSheet().setFtp(2.8/3.5);
		player9.getSeasonStatSheet().setP3m(0.0);
		player9.getSeasonStatSheet().setPts(16.5);
		player9.getSeasonStatSheet().setReb(9.4);
		player9.getSeasonStatSheet().setStl(0.6);
		player9.getSeasonStatSheet().setTo(2.3);
		player9.getSeasonStatSheet().setMin(31.8);
		

		
		BasketballPlayer player10 = new BasketballPlayer();
		player10.setId(7);
		player10.setName("David West");
		player10.getSeasonStatSheet().setAst(2.4);
		player10.getSeasonStatSheet().setBlk(1.5);
		player10.getSeasonStatSheet().setFga(10.6);
		player10.getSeasonStatSheet().setFgm(4.5);
		player10.getSeasonStatSheet().setFgp(4.5/10.6);
		player10.getSeasonStatSheet().setFta(2.7);
		player10.getSeasonStatSheet().setFtm(2.2);
		player10.getSeasonStatSheet().setFtp(2.2/2.7);
		player10.getSeasonStatSheet().setP3m(0.1);
		player10.getSeasonStatSheet().setPts(11.4);
		player10.getSeasonStatSheet().setReb(7.1);
		player10.getSeasonStatSheet().setStl(1.1);
		player10.getSeasonStatSheet().setTo(1.6);
		player10.getSeasonStatSheet().setMin(30.4);
		

		
		BasketballPlayer player11 = new BasketballPlayer();
		player11.setId(11);
		player11.setName("Anthony Davis");
		player11.getSeasonStatSheet().setAst(1.7);
		player11.getSeasonStatSheet().setBlk(4.1);
		player11.getSeasonStatSheet().setFga(15.4);
		player11.getSeasonStatSheet().setFgm(7.7);
		player11.getSeasonStatSheet().setFgp(7.7/15.3);
		player11.getSeasonStatSheet().setFta(6.6);
		player11.getSeasonStatSheet().setFtm(5.5);
		player11.getSeasonStatSheet().setFtp(5.5/6.6);
		player11.getSeasonStatSheet().setP3m(0.0);
		player11.getSeasonStatSheet().setPts(21.0);
		player11.getSeasonStatSheet().setReb(10.8);
		player11.getSeasonStatSheet().setStl(1.9);
		player11.getSeasonStatSheet().setTo(1.3);
		player11.getSeasonStatSheet().setMin(35.5);
		

		
		BasketballPlayer player12 = new BasketballPlayer();
		player12.setId(12);
		player12.setName("Chris Bosh");
		player12.getSeasonStatSheet().setAst(0.8);
		player12.getSeasonStatSheet().setBlk(1.4);
		player12.getSeasonStatSheet().setFga(9.7);
		player12.getSeasonStatSheet().setFgm(5.6);
		player12.getSeasonStatSheet().setFgp(5.6/9.7);
		player12.getSeasonStatSheet().setFta(5.0);
		player12.getSeasonStatSheet().setFtm(4.0);
		player12.getSeasonStatSheet().setFtp(4.0/5.0);
		player12.getSeasonStatSheet().setP3m(1.0);
		player12.getSeasonStatSheet().setPts(16.3);
		player12.getSeasonStatSheet().setReb(5.6);
		player12.getSeasonStatSheet().setStl(0.6);
		player12.getSeasonStatSheet().setTo(1.4);
		player12.getSeasonStatSheet().setMin(28.2);
		

		
		BasketballPlayer player13 = new BasketballPlayer();
		player13.setId(13);
		player13.setName("DeAndre Jordan");
		player13.getSeasonStatSheet().setAst(0.8);
		player13.getSeasonStatSheet().setBlk(2.0);
		player13.getSeasonStatSheet().setFga(7.0);
		player13.getSeasonStatSheet().setFgm(4.0);
		player13.getSeasonStatSheet().setFgp(4.0/7.0);
		player13.getSeasonStatSheet().setFta(4.8);
		player13.getSeasonStatSheet().setFtm(2.1);
		player13.getSeasonStatSheet().setFtp(2.1/4.8);
		player13.getSeasonStatSheet().setP3m(0.0);
		player13.getSeasonStatSheet().setPts(10.1);
		player13.getSeasonStatSheet().setReb(13.2);
		player13.getSeasonStatSheet().setStl(1.2);
		player13.getSeasonStatSheet().setTo(1.5);
		player13.getSeasonStatSheet().setMin(35.7);
		

		
		List<BasketballPlayer> players = new ArrayList<BasketballPlayer>();
		players.add(player);
		players.add(player2);
		players.add(player3);
		players.add(player4);
		players.add(player5);
		players.add(player6);
		players.add(player7);
		players.add(player8);
		players.add(player9);
		players.add(player10);
		players.add(player11);
		players.add(player12);
		players.add(player13);
		
		CalculationStrategy calculator = new CalculationStrategyByConstant();
		for(BasketballPlayer p : players)
			calculator.calculate(p);
		
		Collections.sort(players);
		int i = 0;
		double totalVal = 0;
		for(BasketballPlayer p : players)
		{
			i++;
			System.out.println(i + ". " + p.getName() + " -> " + p.getValue()
					+ " (per min) -> " + p.getValuePerMinute() + " (true shoot) -> " 
					+ p.getSeasonStatSheet().getTsp() + " stat map -> " + p.getStatMap().toString());
			/*
			System.out.println(p.getSeasonStatSheet().getTsp());
			System.out.println(p.getSeasonStatSheet().getVal());
			*/
			
			totalVal += p.getValue();
		}
		
		System.out.println("\nTotal Val : " + totalVal);
		
	}
}
