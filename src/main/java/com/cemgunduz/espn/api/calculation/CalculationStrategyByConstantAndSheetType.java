package com.cemgunduz.espn.api.calculation;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cemgunduz.espn.entity.BasketballPlayer;
import com.cemgunduz.espn.entity.SheetType;
import com.cemgunduz.espn.entity.StatSheet;

public class CalculationStrategyByConstantAndSheetType extends AbstractCalculationStrategyByConstant {

	public static final Map<SheetType, Double> typeWeight;
	private List<String> mapKeys = 
			Arrays.asList("fgm","fga","ftm","fta","3pm","ast","stl","blk","reb","to","pts");
	
	static
	{
		Map<SheetType, Double> map = new HashMap<SheetType, Double>();
        map.put(SheetType.SEASON, 0.30);
        map.put(SheetType.PROJECTION, 0.10);
        map.put(SheetType.LAST_SEASON, 0.0);
        map.put(SheetType.DAYS_7, 0.10);
        map.put(SheetType.DAYS_15, 0.15);
        map.put(SheetType.DAYS_30, 0.35);

        /*
        map.put(SheetType.SEASON, 0.30);
		map.put(SheetType.PROJECTION, 0.10);
		map.put(SheetType.LAST_SEASON, 0.0);
		map.put(SheetType.DAYS_7, 0.10);
		map.put(SheetType.DAYS_15, 0.15);
		map.put(SheetType.DAYS_30, 0.35);
         */
		
		typeWeight = Collections.unmodifiableMap(map);
	}
	
	public double calculate(BasketballPlayer player) {
		
		double value = 0;
		Map<String, Double> playerStatMap = new HashMap<String, Double>();
		
		for(StatSheet sheet : player.getStatSheets())
		{
			value += super.calculateByStatSheet(sheet) * typeWeight.get(sheet.getSheetType());
			
			for(String key : mapKeys)
			{
				if(playerStatMap.get(key) == null)
					playerStatMap.put(key, super.getStatMap().get(key) * typeWeight.get(sheet.getSheetType()));
				else
					playerStatMap.put(key, super.getStatMap().get(key) * typeWeight.get(sheet.getSheetType())
							+ playerStatMap.get(key));
			}
		}
		
		player.setStatMap(playerStatMap);
		player.setValue(value);
		//player.setValuePerMinute(value/player.getSeasonStatSheet().getMin());
		
		return value; 
	}

}
