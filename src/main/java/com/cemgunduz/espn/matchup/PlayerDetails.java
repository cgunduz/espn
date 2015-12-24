package com.cemgunduz.espn.matchup;

/**
 * Created by cgunduz on 11/12/2015.
 */
public class PlayerDetails {

    private String name;
    private int totalMatchesLeft;

    public PlayerDetails(String name, int totalMatchesLeft) {
        this.name = name;
        this.totalMatchesLeft = totalMatchesLeft;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalMatchesLeft() {
        return totalMatchesLeft;
    }

    public void setTotalMatchesLeft(int totalMatchesLeft) {
        this.totalMatchesLeft = totalMatchesLeft;
    }
}
