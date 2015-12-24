package com.cemgunduz.espn.api.calculation;

import com.cemgunduz.espn.entity.BasketballPlayer;
import com.cemgunduz.espn.entity.StatSheet;

public class CalculationStrategyByConstant extends AbstractCalculationStrategyByConstant {

	public double calculate(BasketballPlayer player) {
		
		double value = super.calculateByStatSheet(player.getSeasonStatSheet());
		
		player.setStatMap(super.getStatMap());
		player.setValue(value);
		player.setValuePerMinute(value/player.getSeasonStatSheet().getMin());
		
		return value; 
	}

}
