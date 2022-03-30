package com.scoreboard.cricket.model;

public class Match {

    Team teamOne;
    Team teamTwo;
    int playersCount;
    int oversCount;
    Team currentBattingTeam;

    public Match(Team teamOne, Team teamTwo, int playersCount, int oversCount) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.playersCount = playersCount;
        this.oversCount = oversCount;
    }

    public Match() {
    }

    public Team getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(Team teamOne) {
        this.teamOne = teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(Team teamTwo) {
        this.teamTwo = teamTwo;
    }

    public int getPlayersCount() {
        return playersCount;
    }

    public void setPlayersCount(int playersCount) {
        this.playersCount = playersCount;
    }

    public int getOversCount() {
        return oversCount;
    }

    public void setOversCount(int oversCount) {
        this.oversCount = oversCount;
    }

    public Team getCurrentBattingTeam() {
        return currentBattingTeam;
    }

    public void setCurrentBattingTeam(Team currentBattingTeam) {
        this.currentBattingTeam = currentBattingTeam;
    }

    @Override
    public String toString() {
        return "Match{" +
                "teamOne=" + teamOne +
                ", teamTwo=" + teamTwo +
                ", playersCount=" + playersCount +
                ", oversCount=" + oversCount +
                ", currentBattingTeam=" + currentBattingTeam +
                '}';
    }
}
