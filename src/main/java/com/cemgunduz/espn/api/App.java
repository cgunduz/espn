package com.cemgunduz.espn.api;

public class App {

	public static void main(String[] args) {
	
		EspnRest restTest = new EspnRest();
		String asd = restTest.getAthlete(3);
		System.out.println(asd);
		
	}
	
}
