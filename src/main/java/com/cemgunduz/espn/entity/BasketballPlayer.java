package com.cemgunduz.espn.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BasketballPlayer implements Comparable {

	private int id;
	private String name;
	private StatSheet seasonStatSheet;
	private List<StatSheet> statSheets;

	private String playerTeamName;
	private String basketballTeamName;
	
	/* CALCULATED */

	private double value;
	private Map<String,Double> statMap;
	private double valuePerMinute;
	
	/* CALCULATED */

	public BasketballPlayer()
	{
		seasonStatSheet = new StatSheet();
		statSheets = new ArrayList<StatSheet>();
	}
	
	public List<StatSheet> getStatSheets() {
		return statSheets;
	}

	public void setStatSheets(List<StatSheet> statSheets) {
		this.statSheets = statSheets;
	}
	
	public String getPlayerTeamName() {
		return playerTeamName;
	}

	public void setPlayerTeamName(String playerTeamName) {
		this.playerTeamName = playerTeamName;
	}

	public String getBasketballTeamName() {
		return basketballTeamName;
	}

	public void setBasketballTeamName(String basketballTeamName) {
		this.basketballTeamName = basketballTeamName;
	}
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Map<String, Double> getStatMap() {
		return statMap;
	}

	public void setStatMap(Map<String, Double> statMap) {
		this.statMap = statMap;
	}

	public double getValuePerMinute() {
		return valuePerMinute;
	}

	public void setValuePerMinute(double valuePerMinute) {
		this.valuePerMinute = valuePerMinute;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StatSheet getSeasonStatSheet() {
		return seasonStatSheet;
	}
	public void setSeasonStatSheet(StatSheet season) {
		this.seasonStatSheet = season;
	}
	
	@Override
	public boolean equals(Object o)
	{
		if( o instanceof BasketballPlayer)
		{
			BasketballPlayer player = (BasketballPlayer)o;
			return player.getName().equals(this.getName());
		}
	
		return false;	
	}
	
	public int compareTo(Object o) {
		
		if(!(o instanceof BasketballPlayer) )
			throw new UnsupportedOperationException();
		
		BasketballPlayer obj = (BasketballPlayer)o;
		
		if (obj.value - this.value > 0)
			return 1;
		
		return -1;
	}
	
}
