package com.cemgunduz.espn.scrape;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.cemgunduz.espn.entity.BasketballPlayer;
import com.cemgunduz.espn.entity.SheetType;
import com.cemgunduz.espn.entity.StatSheet;

public class Scraper {

	static final String PROPERTIES_FILE_PATH = "espn.properties";
	static final String PLAYER_URL;
	static final String PLAYER_URL_START_INDEX;
	static final String PLAYER_URL_INDEX_MULTIPLIER; 
	static final String PLAYER_URL_SHEET_TYPE_PREFIX; 
	
	static
	{
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(PROPERTIES_FILE_PATH));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PLAYER_URL = (String)properties.get("espn_scrape_player_url");
		PLAYER_URL_START_INDEX = (String)properties.get("espn_scrape_player_url_start_index");
		PLAYER_URL_INDEX_MULTIPLIER = (String)properties.get("espn_scrape_player_url_index_multiplier");
		PLAYER_URL_SHEET_TYPE_PREFIX = (String)properties.get("espn_scrape_player_url_sheet_type_prefix");
	}
	
	public static List<BasketballPlayer> scrapePlayers(int amount) throws IOException
	{
		List<BasketballPlayer> players = new ArrayList<BasketballPlayer>();
		players = Scraper.scrapePlayers(players, amount, SheetType.SEASON);
		players = Scraper.scrapePlayers(players, amount, SheetType.LAST_SEASON);
		players = Scraper.scrapePlayers(players, amount, SheetType.PROJECTION);
		players = Scraper.scrapePlayers(players, amount, SheetType.DAYS_30);
		players = Scraper.scrapePlayers(players, amount, SheetType.DAYS_15);
		players = Scraper.scrapePlayers(players, amount, SheetType.DAYS_7);
		return players;
	}
	
	public static List<BasketballPlayer> scrapePlayers(List<BasketballPlayer> players, int amount, 
			SheetType sheetType) throws IOException
	{
		if(players == null || players.size() == 0)
			players = new ArrayList<BasketballPlayer>();
		
		String index = PLAYER_URL_START_INDEX;
		int loopFor = amount/Integer.parseInt(PLAYER_URL_INDEX_MULTIPLIER) + 1;
		for(int i = 0; i < loopFor; i++)
		{
			String url = PLAYER_URL + index + PLAYER_URL_SHEET_TYPE_PREFIX + SheetType.getScrapeParameter(sheetType);
			String authRelated = "{\"swid\":\"{88C95830-C1E8-40D4-8958-30C1E850D4A1}\"}";
			Document doc = Jsoup.connect(url).
					header("Host","games.espn.go.com").
					userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36").
					header("Cookie", "fbalm_playertableviewset_clubhouse=upcomingschedule#lastSeason; fbalm_playertableviewset_freeagency=stats#currSeason; FBA_LM_COOKIE=AAAAARoAAAAFAQALY291bnRyeUNvZGUBAANubGQBAA9jbGllbnRJUEFkZHJlc3MBAAs3Ny43Mi4xMTIuNQEACmZyb21UZWFtSWQDAAAAAwEACHNlYXNvbklkAwAAB#ABAAhsZWFndWVJZAMAAi1K; ESPN-FANTASYLM-PROD-ac=XTR; ESPN-FANTASYLM-PROD.auth=disneyid; s_fid=7C1475FE0F54CF09-04DBA90A1A5949A7; cookieMonster=1; __gads=ID=bad7767fb6e391b1:T=1445731099:S=ALNI_MYqi9LYoKmCZHwHtj7nysH0hk3pTA; userAB=1; DS=bmVkc3RhdC5uZXQ7OzA7O2NvbXNjb3JlIGIudi47A; DE2=bmxkO25oO2Ftc3RlcmRhbTticm9hZGJhbmQ7NTs1OzU7LTE7NTIuMzc4Mjc7NC45MDU5OTs1Mjg7Mzk2NjsxNzE4OzU7bmw7A; broadbandAccess=espn3-false%2Cnetworks-false; CRBLM=CBLM-001:AAAAAAABB3cAAAABB4sAAAABArAAAAABAEoAAAABBFEAAAABAzgAAAABB98AAAABA3gAAAABBNsAAAABBFMAAAAB; CRBLM_LAST_UPDATE=1447150097:{88C95830-C1E8-40D4-8958-30C1E850D4A1}; oidNAVY=XrZf5W7GhKsAkdTEUTljxWWoA2BRLjs#FkED3HnL3yiJoVml5vHW2OaVWn7mw8I5uYVLZQ7KphPHtAzba8p5nMQMl6Slmcd8z3IEYZrmhHs#tCeaFDzhuq1hkOO9IBomRRlxQkjoottt$tmae9$vgq8vLFUzpv$E5iPVTAskV7L14#6bXPFqmWrH1ZrkluCZB3dejwGlXRT20lc3crwioFZJiXUdNKBJrvPGNNcODEghNHj0IR0c8JcC7eB6pgSZg$ZOR7U1ZiviIh1r5Xb4TUoNPiMddkg7NbI0j1qNSuM; espn_s2=AECwXDLOOyMTBQ1vHL%2FXMmqdkqEw3wCpXAYz%2Fw3IaVCDzTzSfhnReUswHiOBeoYw62TsPbwGvUe0efiDlwtrwkArnCbk6BODOjiiSoSp734ddbycQfFgWrKJiiXwsKAyzJ%2BhXzVdsS80gW4M80y4ioWrN44GsnYu5%2F6QP8qK7xpPEMOEzkRkHDVxxEtKZIaiyOApsonOvpdVfS19sMWmlaDHXz5V%2BH%2B%2FSCvO%2F4kBdhFHuZHfK4Y78NWhD%2F0YYiA9tENiztjcdAb%2BCufdC0xBHayA; _omnicwtest=1447151042096; SWID={88C95830-C1E8-40D4-8958-30C1E850D4A1}; espnAuth={\"swid\":\"{88C95830-C1E8-40D4-8958-30C1E850D4A1}\"}; s_pers=%20s_c24%3D1447151084440%7C1541759084440%3B%20s_c24_s%3DLess%2520than%25207%2520days%7C1447152884440%3B%20s_gpv_pn%3Dfantasy%253Abasketball%253Afba%253Aflexpop-_ppc-OVERVIEW%7C1447152884449%3B; s_sess=%20s_ppv%3D88%3B%20s_cc%3Dtrue%3B%20s_omni_lid%3D%3B%20s_sq%3D%3B; s_vi=[CS]v1|2B12FFA70530D7FE-40000305A000462A[CE]").
					get();
			Elements tableRows = doc.select("[id^=plyr]");
			for(org.jsoup.nodes.Element tableRow : tableRows)
			{
				Elements tdElements = tableRow.select("td");

				Boolean isUnavailable = tdElements.get(0).toString().contains("<span title=\"Out\" style=\"font-weight:bold;color: red;\">O</span>");
				
				String playerName = tableRow.select(".playertablePlayerName").select("a").text();
				String playerTeamName = isUnavailable ? "FA" : tdElements.get(2).text();
				String fga = cleanEmptyData(getSlashSeperatedData(tdElements.get(9).text())[1]);
				String fgm = cleanEmptyData(getSlashSeperatedData(tdElements.get(9).text())[0]);
				String fgp = cleanEmptyData(tdElements.get(10).text());
				String fta = cleanEmptyData(getSlashSeperatedData(tdElements.get(11).text())[1]);
				String ftm = cleanEmptyData(getSlashSeperatedData(tdElements.get(11).text())[0]);
				String ftp = cleanEmptyData(tdElements.get(12).text());
				String p3m = cleanEmptyData(tdElements.get(13).text());
				String reb = cleanEmptyData(tdElements.get(14).text());
				String ast = cleanEmptyData(tdElements.get(15).text());
				String stl = cleanEmptyData(tdElements.get(16).text());
				String blk = cleanEmptyData(tdElements.get(17).text());
				String to = cleanEmptyData(tdElements.get(18).text());
				String pts = cleanEmptyData(tdElements.get(19).text());
				
				/** MAYBE A SECOND REQUEST HERE ? **/
				
				// containing -> view=upcomingschedule
				
				/** SECOND REQ **/
				
				/** LOL ***/
				/** MANUAL OVERRIDE FOR TRADES ***/
				
				/*
				if(playerName.contains("George Hill"))
					playerTeamName = "FA";
				if(playerName.contains("Jared Sullinger"))
					playerTeamName = "FA";
				if(playerName.contains("Ersan Ilyasova"))
					playerTeamName = "FA";
					*/

				/** LOL ***/
				
				BasketballPlayer player = new BasketballPlayer();
				player.setName(playerName);
				player.setPlayerTeamName(playerTeamName);
				
				StatSheet sheet = new StatSheet();
				sheet.setMin(35);
				sheet.setFga(Double.valueOf(fga));
				sheet.setFgm(Double.valueOf(fgm));
				sheet.setFgp(Double.valueOf(fgp));
				sheet.setFta(Double.valueOf(fta));
				sheet.setFtm(Double.valueOf(ftm));
				sheet.setFtp(Double.valueOf(ftp));
				sheet.setP3m(Double.valueOf(p3m));
				sheet.setReb(Double.valueOf(reb));
				sheet.setAst(Double.valueOf(ast));
				sheet.setStl(Double.valueOf(stl));
				sheet.setBlk(Double.valueOf(blk));
				sheet.setTo(Double.valueOf(to));
				sheet.setPts(Double.valueOf(pts));
				
				sheet.setSheetType(sheetType);
				
				if(!players.contains(player))
				{
					player.setSeasonStatSheet(sheet);
					players.add(player);
				}
				players.get(players.indexOf(player)).getStatSheets().add(sheet);
			}
			
			index = String.valueOf(Integer.parseInt(index) + Integer.parseInt(PLAYER_URL_INDEX_MULTIPLIER));
		}
		
		return players;
	}
	
	private static String cleanEmptyData(String s)
	{
		if(s.equals(0) || s.equals(null) || s.equals("--") || s.equals("--/--"))
			return "0.01";
		
		return s;
	}
	
	private static String[] getSlashSeperatedData(String s)
	{
		String data[] = new String[2];
		int index = s.indexOf("/");
		if(index == -1)
		{
			data[0] = "0.01";
			data[1] = "0.01";
		}
		else
		{
			data[0] = s.substring(0,index);
			data[1] = s.substring(index+1);
		}
		
		return data;
	}
}
