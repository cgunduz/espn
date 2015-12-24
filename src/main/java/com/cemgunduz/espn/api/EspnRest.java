package com.cemgunduz.espn.api;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class EspnRest {

	static final String PROPERTIES_FILE_PATH = "espn.properties";
	static final String API_KEY;
	static final String SHARED_SECRET;
	static final String REQUEST_URL; 
	static final String ACTIVE_VERSION; 
	static final String BASKETBALL_BASE_REQUEST_PATH;
	static final String BASKETBALL_BASE_REQUEST_URL;	
	
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
		
		API_KEY = (String)properties.get("espn_api_key");
		SHARED_SECRET = (String)properties.get("espn_shared_secret");
		REQUEST_URL = (String)properties.get("espn_request_url");
		ACTIVE_VERSION = (String)properties.get("espn_active_version");
		BASKETBALL_BASE_REQUEST_PATH = (String)properties.get("espn_basketball_base_request_path");
		
		BASKETBALL_BASE_REQUEST_URL = REQUEST_URL + ACTIVE_VERSION + 
				BASKETBALL_BASE_REQUEST_PATH;
		
		
	}
	
	private String addParam(String request, String paramName, String paramValue)
	{
		return request + paramName + "=" + paramValue + "&" ;
	}
	
	public String getAthlete(int athleteId)
	{
		String request = BASKETBALL_BASE_REQUEST_URL + "athletes/" + String.valueOf(athleteId) + "?";
		request = addParam(request,"apikey",API_KEY);
		
		return request;
	}
	
	public String getAllAthletes()
	{
		String request = BASKETBALL_BASE_REQUEST_URL + "athletes/" + "?";
		request = addParam(request,"apikey",API_KEY);
		
		return request;
	}
}
