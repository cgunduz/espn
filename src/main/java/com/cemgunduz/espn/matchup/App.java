package com.cemgunduz.espn.matchup;

import com.cemgunduz.espn.api.calculation.CalculationStrategyByConstantAndSheetType;
import com.cemgunduz.espn.entity.BasketballPlayer;
import com.cemgunduz.espn.entity.SheetType;
import com.cemgunduz.espn.entity.StatSheet;

import java.io.IOException;
import java.util.List;

/**
 * Created by cgunduz on 11/12/2015.
 */
public class App {

    public static void main(String[] args) throws IOException {

        List<BasketballPlayer> playerList = com.cemgunduz.espn.scrape.Scraper.scrapePlayers(300);

        MatchupDetails matchupDetails = Scraper.scrapeMatchDetails();

        List<TeamStats> allTeamStats = Scraper.scrapeTeamTotalsSoFar();

        TeamStats team1 = findStat(PlayerName.CEM, allTeamStats);
        TeamStats team2 = findStat(PlayerName.EGE, allTeamStats);

        team1 = fillTeamStatByProjection(team1, playerList, matchupDetails);
        team2 = fillTeamStatByProjection(team2, playerList, matchupDetails);

        System.out.println(team1);
        System.out.println(team2);

    }

    public static BasketballPlayer findPlayer(String playerName, List<BasketballPlayer> playerList)
    {
        for(BasketballPlayer basketballPlayer : playerList)
        {
            if(basketballPlayer.getName().contains(playerName))
                return basketballPlayer;
        }

        return null;
    }

    public static TeamStats findStat(PlayerName playerName, List<TeamStats> allTeamStats)
    {
        for(TeamStats teamStats : allTeamStats)
        {
            if(playerName.getId() == teamStats.getTeamId())
                return teamStats;
        }

        return null;
    }

    public static TeamStats fillTeamStatByProjection(TeamStats fillable, List<BasketballPlayer> playerList, MatchupDetails matchupDetails) throws IOException {

        List<PlayerDetails> playerDetailsList = Scraper.getPlayerDetails(fillable, matchupDetails);

        for(PlayerDetails playerDetails : playerDetailsList)
        {
            BasketballPlayer basketballPlayer = findPlayer(playerDetails.getName(), playerList);
            for(StatSheet sheet : basketballPlayer.getStatSheets())
            {
                double weight = CalculationStrategyByConstantAndSheetType.typeWeight.get(sheet.getSheetType());
                fillable.getSheet().setAst(fillable.getSheet().getAst() + playerDetails.getTotalMatchesLeft() * weight * sheet.getAst());
                fillable.getSheet().setPts(fillable.getSheet().getPts() + playerDetails.getTotalMatchesLeft() * weight * sheet.getPts());
                fillable.getSheet().setBlk(fillable.getSheet().getBlk() + playerDetails.getTotalMatchesLeft() * weight * sheet.getBlk());
                fillable.getSheet().setP3m(fillable.getSheet().getP3m() + playerDetails.getTotalMatchesLeft() * weight * sheet.getP3m());
                fillable.getSheet().setReb(fillable.getSheet().getReb() + playerDetails.getTotalMatchesLeft() * weight * sheet.getReb());
                fillable.getSheet().setStl(fillable.getSheet().getStl() + playerDetails.getTotalMatchesLeft() * weight * sheet.getStl());
                fillable.getSheet().setTo(fillable.getSheet().getTo() + playerDetails.getTotalMatchesLeft() * weight * sheet.getTo());

                fillable.getSheet().setFgm(fillable.getSheet().getFgm() + playerDetails.getTotalMatchesLeft() * weight * sheet.getFgm());
                fillable.getSheet().setFga(fillable.getSheet().getFga() + playerDetails.getTotalMatchesLeft() * weight * sheet.getFga());
                fillable.getSheet().setFta(fillable.getSheet().getFta() + playerDetails.getTotalMatchesLeft() * weight * sheet.getFta());
                fillable.getSheet().setFtm(fillable.getSheet().getFtm() + playerDetails.getTotalMatchesLeft() * weight * sheet.getFtm());

            }

        }

        return fillable;
    }
}
