package com.cemgunduz.espn.mongo;

import com.cemgunduz.espn.entity.BasketballPlayer;
import com.cemgunduz.espn.entity.StatSheet;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class BasketballPlayerMongoDao extends AbstractMongoDao {
	
	/* CONTINUE MAYBE LATER */
	private static final String TABLE_NAME = "player";
	
	public void getPlayer(String playerName)
	{
		DBCollection table = db.getCollection(TABLE_NAME);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", playerName);
		DBCursor cursor = table.find(searchQuery);
	}
	
	public void savePlayer(BasketballPlayer p)
	{
		DBCollection table = db.getCollection(TABLE_NAME);
		BasicDBObject document = new BasicDBObject();
		document.put("name", p.getName());
		document.put("player_team", p.getPlayerTeamName());
		document.put("fgm", "mkyong");
		document.put("fga", "mkyong");
		document.put("ftm", "mkyong");
		document.put("fta", "mkyong");
		document.put("fgm", "mkyong");
		document.put("fgm", "mkyong");
		document.put("fgm", "mkyong");
		document.put("fgm", "mkyong");
		document.put("fgm", "mkyong");
		document.put("fgm", "mkyong");
		document.put("fgm", "mkyong");
		document.put("fgm", "mkyong");
		document.put("fgm", "mkyong");
		document.put("age", 30);
		table.insert(document);
	}
	
	private void savePlayer(BasketballPlayer p, StatSheet s)
	{
		DBCollection table = db.getCollection(TABLE_NAME);
		BasicDBObject document = new BasicDBObject();
		document.put("name", p.getName());
		document.put("player_team", p.getPlayerTeamName());
		document.put("fgm", s.getFgm());
	}
	
	public void deletePlayer(String playerName)
	{
		DBCollection table = db.getCollection(TABLE_NAME);
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("name", "mkyong");
		table.remove(searchQuery);
	}
}
