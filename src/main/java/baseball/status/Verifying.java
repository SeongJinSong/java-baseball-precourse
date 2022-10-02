package baseball.status;

import baseball.game.BaseBallGameController;
import baseball.port.outbound.StandardOutput;
import baseball.view.GameView;

public class Verifying implements GameStatus {
    @Override
    public GameStatus play(BaseBallGameController controller) {
        String result = controller.judge();
        String response = GameView.response(result);
        StandardOutput.println(response);
        if ("3스트라이크".equals(response)) {
            StandardOutput.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return new Finish();
        }
        return new WaitForClientInput();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
