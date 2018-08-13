package player;

import gamemachine.GameResult;
import gamemachine.Shape;

import java.util.Random;

/**
 * Represents a player of ScissorPaperRocks.
 * A player has a name and knows the number of the last game results.
 * Implement a player with the name/defaultShape constructor to define a defaultShape, which is returned each time
 * when the player has to choose a shape (instead of random shape).
 */
public class Player {

    private static final Random RANDOM = new Random();

    private String name;

    private int wins = 0;
    private int losses = 0;
    private int ties = 0;

    private Shape defaultShape;

    public Shape chooseShape() {
        return defaultShape != null ? defaultShape : Shape.values()[RANDOM.nextInt(Shape.values().length)];
    }

    public Player(String name) {
        this.name = name;
    }

    public Player(String name, Shape defaultShape) {
        this.name = name;
        this.defaultShape = defaultShape;
    }

    public void handleResult(final GameResult result) {
        switch (result) {
            case WIN:
                this.wins++;
                break;
            case LOSS:
                this.losses++;
                break;
            case TIE:
                this.ties++;
                break;
        }
    }

    public void logResultToConsole() {
        System.out.println(String.format("Player '%s' won '%d' games, lost '%d' games and has '%d' ties.",
                name, wins, losses, ties));
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTies() {
        return ties;
    }
}
