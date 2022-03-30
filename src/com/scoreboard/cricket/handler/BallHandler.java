package com.scoreboard.cricket.handler;

import com.scoreboard.cricket.model.Match;

public class BallHandler {

    public static Match handleBall(String ball, Match match) {
        switch (ball) {
            case "W":
                handleWicket(match);
                break;
            case "Wd":
                handleWideBall(match);
                break;
            case "NB":
                handleNoBall(match);
                break;
            default:
                handleScoringBall(ball, match);
        }
        return match;
    }

    private static void handleWicket(Match match) {
        match.getCurrentBattingTeam().getCurrentBattingPlayer().increamentBallsFacedByOne();
        match.getCurrentBattingTeam().getScoreBoard().incrementWicketsDownByOne();
        match.getCurrentBattingTeam().getScoreBoard().incrementCurrentOverBalls();
        int maxPlayerNumber = Math.max(match.getCurrentBattingTeam().getCurrentBattingPlayer().getOrder(), match.getCurrentBattingTeam().getOffStrikePlayer().getOrder());

        //check If all wickets not down
        if (maxPlayerNumber < match.getCurrentBattingTeam().getPlayers().size() - 1) {
            match.getCurrentBattingTeam().setCurrentBattingPlayer(match.getCurrentBattingTeam().getPlayers().get(maxPlayerNumber + 1));
        }
        handleOverFinished(match);
    }

    private static void handleWideBall(Match match) {
        match.getCurrentBattingTeam().getScoreBoard().addScore(1);
    }

    //Can be used later
    private static void handleNoBall(Match match) {
    }

    private static void handleScoringBall(String ball, Match match) {
        match.getCurrentBattingTeam().getCurrentBattingPlayer().increamentBallsFacedByOne();
        try {
            int score = Integer.parseInt(ball);
            match.getCurrentBattingTeam().getCurrentBattingPlayer().addScore(score);
            match.getCurrentBattingTeam().getScoreBoard().addScore(score);
            match.getCurrentBattingTeam().getScoreBoard().incrementCurrentOverBalls();
            if (score == 4) {
                match.getCurrentBattingTeam().getCurrentBattingPlayer().increamentFoursByOne();
            } else if (score == 6) {
                match.getCurrentBattingTeam().getCurrentBattingPlayer().increamentSixesByOne();
            }
            //change strike
            else if (score % 2 == 1) {
                match.getCurrentBattingTeam().changeStrike();
            }

            handleOverFinished(match);

        } catch (NumberFormatException e) {
            System.out.println("Can't convert " + ball + "into numbers.");
        }
    }

    //if current over is finished
    private static void handleOverFinished(Match match) {

        if (match.getCurrentBattingTeam().getScoreBoard().getCurrentOverBalls() > 6) {
            match.getCurrentBattingTeam().getScoreBoard().incrementCompletedOvers();
            match.getCurrentBattingTeam().getScoreBoard().setCurrentOverBalls(1);
            match.getCurrentBattingTeam().changeStrike();
            printScoreBoard(match);

            if (match.getCurrentBattingTeam().getScoreBoard().getCompletedOvers() < match.getOversCount()) {
                System.out.println("Over " + (match.getCurrentBattingTeam().getScoreBoard().getCompletedOvers() + 1) + ":");
            }
        }
    }

    //TODO Move to other utility class
    private static void printScoreBoard(Match match) {

        System.out.println("Scorecard for " + match.getCurrentBattingTeam().getName());

        System.out.println("Player Name Score 4s 6s Balls");

        match.getCurrentBattingTeam().getPlayers().stream().forEach(player -> {
            System.out.println(player.getName() + " " + player.getRunsScored() + " " + player.getFours() + " " + player.getSixes() + " " + player.getBallsFaced());
        });
        System.out.println("Total: " + match.getCurrentBattingTeam().getScoreBoard().getScore() + "/" + match.getCurrentBattingTeam().getScoreBoard().getWicketsDown());
        if (match.getCurrentBattingTeam().getScoreBoard().getCurrentOverBalls() < 6)
            System.out.println("Overs: " + match.getCurrentBattingTeam().getScoreBoard().getCompletedOvers());
        System.out.println("");
    }
}
