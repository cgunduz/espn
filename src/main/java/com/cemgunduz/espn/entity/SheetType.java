package com.cemgunduz.espn.entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum SheetType {

	SEASON, DAYS_30, DAYS_15, DAYS_7, LAST_SEASON, PROJECTION;
	
	private static final Map<SheetType,String> scrapeParameters;
	
	static {
        Map<SheetType, String> aMap = new HashMap<SheetType, String>();
        aMap.put(SEASON, "currSeason");
        aMap.put(DAYS_30, "last30");
        aMap.put(DAYS_15, "last15");
        aMap.put(DAYS_7, "last7");
        aMap.put(LAST_SEASON, "lastSeason");
        aMap.put(PROJECTION, "projections");
        scrapeParameters = Collections.unmodifiableMap(aMap);
    }
	
	public static String getScrapeParameter(SheetType type)
	{
		return scrapeParameters.get(type);
	}
}
