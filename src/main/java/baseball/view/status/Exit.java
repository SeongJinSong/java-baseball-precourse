package baseball.view.status;

import baseball.game.BaseBallGameController;
import baseball.view.port.outbound.StandardOutput;

public class Exit implements GameStatus {
    @Override
    public GameStatus play(BaseBallGameController controller) {
        StandardOutput.println("게임 종료");
        return new Exit();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
