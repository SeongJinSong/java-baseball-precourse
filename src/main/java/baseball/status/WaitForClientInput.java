package baseball.status;

import baseball.game.BaseBallGameController;

public class WaitForClientInput implements GameStatus{
    @Override
    public GameStatus play(BaseBallGameController controller) {
        controller.getPlayerInput();
        return new Playing();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
