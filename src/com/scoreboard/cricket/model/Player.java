package com.scoreboard.cricket.model;

public class Player {

    String name;
    int runsScored;
    int wicketTaken;
    int fours;
    int sixes;
    int ballsFaced;
    int order;

    public Player() {
    }

    public Player(String name, int order) {
        this.name = name;
        this.order = order;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getWicketTaken() {
        return wicketTaken;
    }

    public void setWicketTaken(int wicketTaken) {
        this.wicketTaken = wicketTaken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addScore(int runs) {
        this.setRunsScored(this.runsScored + runs);
    }

    public int getFours() {
        return fours;
    }

    public void setFours(int fours) {
        this.fours = fours;
    }

    public int getSixes() {
        return sixes;
    }

    public void setSixes(int sixes) {
        this.sixes = sixes;
    }

    public void increamentFoursByOne() {
        this.fours++;
    }

    public void increamentSixesByOne() {
        this.sixes++;
    }

    public int getBallsFaced() {
        return ballsFaced;
    }

    public void setBallsFaced(int ballsFaced) {
        this.ballsFaced = ballsFaced;
    }

    public void increamentBallsFacedByOne() {
        this.ballsFaced++;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", runsScored=" + runsScored +
                ", wicketTaken=" + wicketTaken +
                ", fours=" + fours +
                ", sixes=" + sixes +
                ", ballsFaced=" + ballsFaced +
                ", order=" + order +
                '}';
    }
}
