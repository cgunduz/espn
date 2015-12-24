package com.cemgunduz.espn.matchup;

/**
 * Created by cgunduz on 11/10/2015.
 */
public class MatchupDetails {

    int begin;
    int end;
    int remaining;
    String month;
    int matchupNo;

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getMatchupNo() {
        return matchupNo;
    }

    public void setMatchupNo(int matchupNo) {
        this.matchupNo = matchupNo;
    }
}
