package com.cemgunduz.espn.matchup;

import com.cemgunduz.espn.entity.StatSheet;

/**
 * Created by cgunduz on 11/10/2015.
 */
public class TeamStats {

    private String teamName;
    private StatSheet sheet;
    private Integer teamId;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public StatSheet getSheet() {
        return sheet;
    }

    public void setSheet(StatSheet sheet) {
        this.sheet = sheet;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "TeamStats{" +
                "sheet=" + sheet +
                '}';
    }
}
