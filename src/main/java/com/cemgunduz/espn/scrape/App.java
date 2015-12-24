package com.cemgunduz.espn.scrape;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.cemgunduz.espn.entity.BasketballPlayer;
import com.cemgunduz.espn.entity.SheetType;

public class App {

	public static void main(String[] args) throws IOException {
		
		List<BasketballPlayer> players = new ArrayList<BasketballPlayer>();
		System.out.println("startin");
		players = Scraper.scrapePlayers(players, 400, SheetType.SEASON);
		System.out.println("done");
		players = Scraper.scrapePlayers(players, 400, SheetType.LAST_SEASON);
		System.out.println("done");
		players = Scraper.scrapePlayers(players, 400, SheetType.PROJECTION);
		players = Scraper.scrapePlayers(players, 400, SheetType.DAYS_30);
		players = Scraper.scrapePlayers(players, 400, SheetType.DAYS_15);
		players = Scraper.scrapePlayers(players, 400, SheetType.DAYS_7);
		System.out.println("hey");
	}
}
