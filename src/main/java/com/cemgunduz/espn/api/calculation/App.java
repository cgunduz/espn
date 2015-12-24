package com.cemgunduz.espn.api.calculation;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.cemgunduz.espn.entity.BasketballPlayer;
import com.cemgunduz.espn.scrape.Scraper;

public class App {

	public static void main(String[] args) {
		
		List<BasketballPlayer> players = null;
		try {
			players = Scraper.scrapePlayers(400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CalculationStrategy calculationStrategy = new CalculationStrategyByConstantAndSheetType();
		
		for(BasketballPlayer player : players)
			calculationStrategy.calculate(player);
		
		Collections.sort(players);
		
		for(BasketballPlayer player : players)
			System.out.println(player.getName() + " -> " + player.getValue());
	}
}
