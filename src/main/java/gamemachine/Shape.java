package gamemachine;

/**
 * Represents the three different shapes for the game as enums:
 * - SCISSOR
 * - ROCK
 * - PAPER
 * <p>
 * <p>
 * The game rules regarding the corresponding shapes is implemented like a state-machine in method play()
 */
public enum Shape implements ShapeRule {

    SCISSOR {
        @Override
        public GameResult play(final Shape shape) {
            switch (shape) {
                case PAPER:
                    return GameResult.WIN;
                case ROCK:
                    return GameResult.LOSS;
            }
            return GameResult.TIE;
        }
    }, ROCK {
        @Override
        public GameResult play(final Shape shape) {
            switch (shape) {
                case SCISSOR:
                    return GameResult.WIN;
                case PAPER:
                    return GameResult.LOSS;
            }
            return GameResult.TIE;
        }
    }, PAPER {
        @Override
        public GameResult play(final Shape shape) {
            switch (shape) {
                case ROCK:
                    return GameResult.WIN;
                case SCISSOR:
                    return GameResult.LOSS;
            }
            return GameResult.TIE;
        }
    }

}
