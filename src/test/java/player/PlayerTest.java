package player;

import gamemachine.GameResult;
import gamemachine.Shape;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class PlayerTest {

    private static final String GIVEN_NAME = "givenName";

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void chooseRandomShapeWhenNoDefaultSymbolIsConfigured() {
        // given
        Player givenPlayer = new Player(GIVEN_NAME);

        // when
        List<Shape> resultShapes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            resultShapes.add(givenPlayer.chooseShape());
        }

        // then
        assertThat(resultShapes, is(not(empty())));
        assertThat(resultShapes, not(everyItem(is(Shape.PAPER))));
    }

    @Test
    public void configuredDefaultShapeShouldAlwaysBeReturnedWhenChoosingShape() {
        // given
        Player givenPlayer = new Player(GIVEN_NAME, Shape.PAPER);

        // when
        List<Shape> resultShapes = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            resultShapes.add(givenPlayer.chooseShape());
        }

        // then
        assertThat(resultShapes, everyItem(is(Shape.PAPER)));
    }

    @Test
    public void handlingGameResultGeneratesTheCorrectNumberOfWinsLossesAndTies() {
        // given
        Player givenPlayer = new Player(GIVEN_NAME);

        // when
        givenPlayer.handleResult(GameResult.WIN);
        givenPlayer.handleResult(GameResult.WIN);
        givenPlayer.handleResult(GameResult.WIN);

        givenPlayer.handleResult(GameResult.LOSS);
        givenPlayer.handleResult(GameResult.LOSS);
        givenPlayer.handleResult(GameResult.LOSS);
        givenPlayer.handleResult(GameResult.LOSS);

        givenPlayer.handleResult(GameResult.TIE);

        // then
        assertThat(givenPlayer.getWins(), is(3));
        assertThat(givenPlayer.getLosses(), is(4));
        assertThat(givenPlayer.getTies(), is(1));
    }

    @Test
    public void logCorrectResultToConsole() {
        // given
        Player givenPlayer = new Player(GIVEN_NAME);

        givenPlayer.handleResult(GameResult.WIN);
        givenPlayer.handleResult(GameResult.LOSS);
        givenPlayer.handleResult(GameResult.LOSS);
        givenPlayer.handleResult(GameResult.TIE);
        givenPlayer.handleResult(GameResult.TIE);
        givenPlayer.handleResult(GameResult.TIE);

        // when
        givenPlayer.logResultToConsole();

        // then
        assertThat(outContent.toString(), startsWith("Player 'givenName' won '1' games, lost '2' games and has '3' ties."));
    }
}