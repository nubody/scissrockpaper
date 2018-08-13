import gamemachine.Shape;
import player.Player;
import service.GameService;

public class Game {

    public static void main(String[] args) {

        GameService gameService = new GameService();

        Player playerA = new Player("Player A");
        Player playerB = new Player("Player B", Shape.PAPER);

        gameService.runScissorRockPapers(playerA, playerB, 100);
    }

}
