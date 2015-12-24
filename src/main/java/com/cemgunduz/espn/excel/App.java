package com.cemgunduz.espn.excel;

public class App {

	public static void main(String[] args) {
		
		ExcelMapper mapper = new ExcelMapper();
		
		mapper.testReportOnGoksinStyleExcel("cem.xls");
		
		System.out.println("--------------");
		
		mapper.testReportOnGoksinStyleExcel("goktug.xls");
		
		System.out.println("--------------");
		
		mapper.testReportOnGoksinStyleExcel("jameson.xls");
		
		System.out.println("--------------");
		
		mapper.testReportOnGoksinStyleExcel("tolga.xls");
		
		System.out.println("--------------");
		
		mapper.testReportOnGoksinStyleExcel("bavbek.xls");
		
		System.out.println("--------------");
		
		mapper.testReportOnGoksinStyleExcel("batuhan.xls");
		
		System.out.println("--------------");
		
		mapper.testReportOnGoksinStyleExcel("ege.xls");
		
		System.out.println("--------------");
		
		mapper.testReportOnGoksinStyleExcel("cahit.xls");
		
		System.out.println("--------------");
		
		mapper.testReportOnGoksinStyleExcel("freeagents.xls");
		
		System.out.println("--------------");
		
		//mapper.testReportOnGoksinStyleExcel("players.xls");
		
	}
}
