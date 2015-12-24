package com.cemgunduz.espn.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.cemgunduz.espn.api.calculation.CalculationStrategy;
import com.cemgunduz.espn.api.calculation.CalculationStrategyByConstant;
import com.cemgunduz.espn.entity.BasketballPlayer;

public class ExcelMapper {

	public List<BasketballPlayer> readExcelPlayerData(String fileLocation) throws IOException
	{
		FileInputStream file = new FileInputStream(new File(fileLocation));
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		List<BasketballPlayer> players = new ArrayList<BasketballPlayer>();
		for(int i = 1; i < 500; i++)
		{
			HSSFRow row = sheet.getRow(i);

			/***** FIX IT *******/
			
			if(row == null || row.getCell(0) == null)
				break;
			
			/***** FIX IT *******/
			
			
			String fgRaw = row.getCell(2).toString();
			String ftRaw = row.getCell(4).toString();
			
			int fgRawSlashIndex = fgRaw.indexOf("/");
			int ftRawSlashIndex = ftRaw.indexOf("/");
			double fgm = Double.valueOf(fgRaw.substring(0, fgRawSlashIndex));
			double fga = Double.valueOf(fgRaw.substring(fgRawSlashIndex+1));
			double ftm = Double.valueOf(ftRaw.substring(0, ftRawSlashIndex));
			double fta = Double.valueOf(ftRaw.substring(ftRawSlashIndex+1));
			
			BasketballPlayer player = new BasketballPlayer();
			player.setId(i);
			player.setName(row.getCell(0).toString());
			player.getSeasonStatSheet().setAst(Double.valueOf(row.getCell(8).toString()));
			player.getSeasonStatSheet().setBlk(Double.valueOf(row.getCell(10).toString()));
			player.getSeasonStatSheet().setFga(fga);
			player.getSeasonStatSheet().setFgm(fgm);
			player.getSeasonStatSheet().setFgp(Double.valueOf(row.getCell(3).toString()));
			player.getSeasonStatSheet().setFta(fta);
			player.getSeasonStatSheet().setFtm(ftm);
			player.getSeasonStatSheet().setFtp(Double.valueOf(row.getCell(5).toString()));
			player.getSeasonStatSheet().setP3m(Double.valueOf(row.getCell(6).toString()));
			player.getSeasonStatSheet().setPts(Double.valueOf(row.getCell(12).toString()));
			player.getSeasonStatSheet().setReb(Double.valueOf(row.getCell(7).toString()));
			player.getSeasonStatSheet().setStl(Double.valueOf(row.getCell(9).toString()));
			player.getSeasonStatSheet().setTo(Double.valueOf(row.getCell(11).toString()));
			player.getSeasonStatSheet().setMin(Double.valueOf(row.getCell(1).toString()));
			
			players.add(player);
			
		}
		
		return players;
	}
	
	public void testReportOnGoksinStyleExcel(String filename)
	{
		ExcelMapper mapper = new ExcelMapper();
		List<BasketballPlayer> players = new ArrayList<BasketballPlayer>();
		try {
			players = mapper.readExcelPlayerData(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Problem");
			e.printStackTrace();
		}
		
		CalculationStrategy calculator = new CalculationStrategyByConstant();
		for(BasketballPlayer p : players)
			calculator.calculate(p);
		
		Collections.sort(players);
		int i = 0;
		double totalVal = 0;
		
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
}
