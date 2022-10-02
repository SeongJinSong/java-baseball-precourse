package baseball.status;

import baseball.game.BaseBallGameController;

public interface GameStatus {
    GameStatus play(final BaseBallGameController controller);
    boolean isExit();
}
