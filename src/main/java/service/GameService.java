package service;

import gamemachine.Shape;
import player.Player;

/**
 * Service to trigger any number of games ScissirRockPapers for two players.
 */
public class GameService {

    public void runScissorRockPapers(final Player playerOne, final Player playerTwo, final int rounds) {
        for (int i = 0; i < rounds; i++) {
            Shape shapeA = playerOne.chooseShape();
            Shape shapeB = playerTwo.chooseShape();

            playerOne.handleResult(shapeA.play(shapeB));
            playerTwo.handleResult(shapeB.play(shapeA));
        }
    }
}
