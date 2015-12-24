package com.cemgunduz.espn.matchup;

/**
 * Created by cgunduz on 11/12/2015.
 */
public enum PlayerName {

    JAMESON(8), CEM(3), EGE(5), CAHIT(7), TOLGA(1), BATU(4), GOKSIN(6), GOKTUG(2);

    private int teamId;

    private PlayerName(int teamId)
    {
        this.teamId = teamId;
    }

    public int getId()
    {
        return teamId;
    }

}
