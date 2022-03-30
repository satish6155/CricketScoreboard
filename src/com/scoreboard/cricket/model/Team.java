package com.scoreboard.cricket.model;

import java.util.ArrayList;
import java.util.List;

public class Team {

    List<Player> players = new ArrayList<>();
    ScoreBoard scoreBoard;
    Player currentBattingPlayer;
    Player offStrikePlayer;
    Player currentBowlingPlayer;
    String name;

    public Team(String name) {
        this.name = name;
    }

    public Team() {
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    public Player getCurrentBattingPlayer() {
        return currentBattingPlayer;
    }

    public void setCurrentBattingPlayer(Player currentBattingPlayer) {
        this.currentBattingPlayer = currentBattingPlayer;
    }

    public Player getCurrentBowlingPlayer() {
        return currentBowlingPlayer;
    }

    public void setCurrentBowlingPlayer(Player currentBowlingPlayer) {
        this.currentBowlingPlayer = currentBowlingPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getOffStrikePlayer() {
        return offStrikePlayer;
    }

    public void setOffStrikePlayer(Player offStrikePlayer) {
        this.offStrikePlayer = offStrikePlayer;
    }

    public void changeStrike() {
        Player tmp = this.currentBattingPlayer;
        this.currentBattingPlayer = this.offStrikePlayer;
        this.offStrikePlayer = tmp;
    }

    @Override
    public String toString() {
        return "Team{" +
                "players=" + players +
                ", scoreBoard=" + scoreBoard +
                ", currentBattingPlayer=" + currentBattingPlayer +
                ", offStrikePlayer=" + offStrikePlayer +
                ", currentBowlingPlayer=" + currentBowlingPlayer +
                ", name='" + name + '\'' +
                '}';
    }
}
