package gamemachine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class ShapeTest {

    @Test
    public void scissorChallengingScissorIsATie() {
        // when
        GameResult result = Shape.SCISSOR.play(Shape.SCISSOR);

        // then
        assertThat(result, is(GameResult.TIE));
    }

    @Test
    public void scissorIsSmashedByRockAndLoses() {
        // when
        GameResult result = Shape.SCISSOR.play(Shape.ROCK);

        // then
        assertThat(result, is(GameResult.LOSS));
    }

    @Test
    public void scissorCutsPaperAndWins() {
        // when
        GameResult result = Shape.SCISSOR.play(Shape.PAPER);

        // then
        assertThat(result, is(GameResult.WIN));
    }

    @Test
    public void rockSmashesScissorAndWins() {
        // when
        GameResult result = Shape.ROCK.play(Shape.SCISSOR);

        // then
        assertThat(result, is(GameResult.WIN));
    }

    @Test
    public void rockChallengingRockIsATie() {
        // when
        GameResult result = Shape.ROCK.play(Shape.ROCK);

        // then
        assertThat(result, is(GameResult.TIE));
    }

    @Test
    public void rockIsCoverdByPaperAndLoses() {
        // when
        GameResult result = Shape.ROCK.play(Shape.PAPER);

        // then
        assertThat(result, is(GameResult.LOSS));
    }

    @Test
    public void paperIsCutByScissorAndLoses() {
        // when
        GameResult result = Shape.PAPER.play(Shape.SCISSOR);

        // then
        assertThat(result, is(GameResult.LOSS));
    }

    @Test
    public void paperCoversRockAndWins() {
        // when
        GameResult result = Shape.PAPER.play(Shape.ROCK);

        // then
        assertThat(result, is(GameResult.WIN));
    }

    @Test
    public void paperChallengingPaperIsATie() {
        // when
        GameResult result = Shape.PAPER.play(Shape.PAPER);

        // then
        assertThat(result, is(GameResult.TIE));
    }

}