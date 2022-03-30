package com.scoreboard.cricket.model;

public class ScoreBoard {
    int score;
    int wicketsDown;
    int completedOvers;
    int currentOverBalls;
    int totalBalls;

    public ScoreBoard() {
        this.currentOverBalls = 1;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getWicketsDown() {
        return wicketsDown;
    }

    public void setWicketsDown(int wicketsDown) {
        this.wicketsDown = wicketsDown;
    }

    public int getCompletedOvers() {
        return completedOvers;
    }

    public void setCompletedOvers(int completedOvers) {
        this.completedOvers = completedOvers;
    }

    public int getCurrentOverBalls() {
        return currentOverBalls;
    }

    public void setCurrentOverBalls(int currentOverBalls) {
        this.currentOverBalls = currentOverBalls;
    }

    public int getTotalBalls() {
        return totalBalls;
    }

    public void setTotalBalls(int totalBalls) {
        this.totalBalls = totalBalls;
    }

    public void addScore(int runs) {
        this.score = this.score + runs;
    }

    public void incrementWicketsDownByOne() {
        this.wicketsDown++;
    }

    public void incrementCurrentOverBalls() {
        this.currentOverBalls++;
    }

    public void incrementCompletedOvers() {
        this.completedOvers++;
    }

    @Override
    public String toString() {
        return "ScoreBoard{" +
                "score=" + score +
                ", wicketsDown=" + wicketsDown +
                ", completedOvers=" + completedOvers +
                ", currentOverBalls=" + currentOverBalls +
                ", totalBalls=" + totalBalls +
                '}';
    }
}
