package service;

import org.junit.Test;
import player.Player;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class GameServiceTest {

    @Test
    public void playing100RoundsOfScissorRockPaperWithTwoPlayersSuccessful() {
        // given
        GameService gameService = new GameService();

        Player playerA = new Player("a");
        Player playerB = new Player("a");

        // when
        gameService.runScissorRockPapers(playerA, playerB, 100);

        // then
        assertThat(playerA.getTies(), is(playerB.getTies()));

        assertThat(playerA.getWins(), is(greaterThan(0)));
        assertThat(playerA.getLosses(), is(greaterThan(0)));

        assertThat(playerB.getWins(), is(greaterThan(0)));
        assertThat(playerB.getLosses(), is(greaterThan(0)));
    }

}