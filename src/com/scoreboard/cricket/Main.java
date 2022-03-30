package com.scoreboard.cricket;

import com.scoreboard.cricket.handler.BallHandler;
import com.scoreboard.cricket.model.Match;
import com.scoreboard.cricket.model.Player;
import com.scoreboard.cricket.model.ScoreBoard;
import com.scoreboard.cricket.model.Team;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("****** Cricket Scoreboard ******");

        Match match = initializeMatch();

        match.setTeamOne(initializeTeam("Team 1", match));
        match.setCurrentBattingTeam(match.getTeamOne());
        playInning(match);

        match.setTeamTwo(initializeTeam("Team 2", match));
        match.setCurrentBattingTeam(match.getTeamTwo());
        playInning(match);

        int teamOneScore = match.getTeamOne().getScoreBoard().getScore();
        int teamTwoScore = match.getTeamTwo().getScoreBoard().getScore();
        if (teamOneScore > teamTwoScore) {
            System.out.println("Result: " + match.getTeamOne().getName() + " won the match by " + (teamOneScore - teamTwoScore) + " runs");
        } else if (teamOneScore < teamTwoScore) {
            System.out.println("Result: " + match.getTeamTwo().getName() + " won the match by " + (teamTwoScore - teamOneScore) + " runs");
        } else {
            System.out.println("Result: Match tie!");
        }
    }

    private static void playInning(Match match) {
        Scanner scanner = new Scanner(System.in);
        ScoreBoard scoreBoard = match.getCurrentBattingTeam().getScoreBoard();

        System.out.println("Over 1:");
        while (scoreBoard.getCompletedOvers() < match.getOversCount()) {
            String nextBall = scanner.nextLine();
            BallHandler.handleBall(nextBall, match);

            //check if all wickets down
            if (match.getCurrentBattingTeam().getScoreBoard().getWicketsDown() == match.getCurrentBattingTeam().getPlayers().size() - 1) {
                return;
            }
        }
    }

    private static Match initializeMatch() {

        Scanner scanner = new Scanner(System.in);

        Match match = new Match();
        System.out.print("No. of players for each team: ");
        match.setPlayersCount(Integer.parseInt(scanner.nextLine()));

        System.out.print("No. of overs: ");
        match.setOversCount(Integer.parseInt(scanner.nextLine()));

        return match;
    }

    private static Team initializeTeam(String name, Match match) {

        Scanner scanner = new Scanner(System.in);

        Team team = new Team(name);
        team.setPlayers(new ArrayList<>());

        System.out.println("Batting Order for " + team.getName() + ": ");

        for (int i = 0; i < match.getPlayersCount(); i++) {
            team.getPlayers().add(new Player(scanner.nextLine(), i));
        }

        team.setScoreBoard(new ScoreBoard());
        team.setCurrentBattingPlayer(team.getPlayers().get(0));
        team.setOffStrikePlayer(team.getPlayers().get(1));
        return team;
    }
}
