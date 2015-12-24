package com.cemgunduz.espn.api.calculation;

import java.util.HashMap;
import java.util.Map;

import com.cemgunduz.espn.entity.BasketballPlayer;
import com.cemgunduz.espn.entity.StatSheet;

public abstract class AbstractCalculationStrategyByConstant implements CalculationStrategy {

		// NBA LAST SEASON VALUES AS DEFAULT
		protected double CONST_MIN = 32.0;
		protected double CONST_FGM = 39.1;
		protected double CONST_FGA = 84.8;
		protected double CONST_FGP = 0.448;
		protected double CONST_FTM = 21.3;
		protected double CONST_FTA = 27.1;
		protected double CONST_FTP = 0.749;
		protected double CONST_P3M = 8.1;
		protected double CONST_REB = 40.3;
		protected double CONST_AST = 22.8;
		protected double CONST_STL = 7.6;
		protected double CONST_BLK = 4.9;
		protected double CONST_TO = 13.9;
		protected double CONST_PTS = 105.4;
		
		private Map<String,Double> statMap;
		
		public Map<String, Double> getStatMap() {
			return statMap;
		}

		protected double calculateByStatSheet(StatSheet s) {
			
			statMap = new HashMap<String, Double>();

			return calculateUnitContribution(s.getFgm(), CONST_FGM, 1, "fgm") +
					calculateUnitContribution(s.getFga() - s.getFgm(), CONST_FGA - CONST_FGM, -1, "fga") +
					calculateUnitContribution(s.getFtm(), CONST_FTM, 1, "ftm") +
					calculateUnitContribution(s.getFta() - s.getFtm(), CONST_FTA - CONST_FTM, -1, "fta") +
					calculateUnitContribution(s.getP3m(), CONST_P3M,1, "3pm") +
					calculateUnitContribution(s.getReb(), CONST_REB,1, "reb") +
					calculateUnitContribution(s.getAst(), CONST_AST,1, "ast") +
					calculateUnitContribution(s.getStl(), CONST_STL,1, "stl") +
					calculateUnitContribution(s.getBlk(), CONST_BLK,1, "blk") +
					calculateUnitContribution(s.getTo(), CONST_TO, -1, "to") +
					calculateUnitContribution(s.getPts(), CONST_PTS,1, "pts");
			
		}
		
		private double calculateUnitContribution(double contr, double needed, String attr)
		{
			return calculateUnitContribution(contr, needed, 1, attr);
		}
		
		private double calculateUnitContribution(double contr, double needed, double multiplier, String attr)
		{
			double val = contr*multiplier/needed;
			statMap.put(attr, val);
			
			return val;
		}
}
