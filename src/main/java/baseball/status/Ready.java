package baseball.status;

import baseball.game.BaseBallGameController;

public class Ready implements GameStatus{
    @Override
    public GameStatus play(BaseBallGameController controller) {
        controller.init();
        return new WaitForClientInput();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
