package com.cemgunduz.espn.report;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {


		Report report = new Report();
		report.showFA();

		/*
		report.showTeam("EGE");


		report.showTeam("KORI");
		report.showTeam("LDN");
		report.showTeam("ZNO");
		report.showTeam("BAVB");Jolene123
		report.showTeam("KKO");
		report.showTeam("DAYI");
		report.showTeam("NGGR");
		*/
		//report.getExtensiveTeamResult(Arrays.asList("EGE", "LDN", "DAYI", "NGGR"));
		report.getExtensiveTeamResult(Arrays.asList("AI", "ELON", "ZKO", "CAT", "NGGA", "ZNO", "DAYI", "BAVB"));
        report.showConstantsForSumOfAllTeams();
		//report.showConstantsForSumOfAllTeams();
		//report.getExtensiveTeamResult(Arrays.asList("EGE", "LDN", "ZNO", "DAYI"));
		/*
		report.getExtensiveTeamResult(Arrays.asList("EGE", "LDN"));
		report.getExtensiveTeamResult(Arrays.asList("POPO", "NGGR"));
		report.getExtensiveTeamResult(Arrays.asList("KKO", "DAYI"));
		report.getExtensiveTeamResult(Arrays.asList("ZNO", "BAVB"));

		/*
		new Report(149).showConstants();
		new Report(299).showConstants();

		new Report().showConstantsForSumOfAllTeams();
		*/

	}
}
