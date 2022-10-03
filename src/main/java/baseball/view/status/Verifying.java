package baseball.view.status;

import baseball.game.BaseBallGameController;
import baseball.model.Referee;
import baseball.view.port.outbound.StandardOutput;

public class Verifying implements GameStatus {
    @Override
    public GameStatus play(BaseBallGameController controller) {
        Referee result = controller.judge();
        String response = response(result);
        StandardOutput.println(response);
        if (result.getStrikeCount()==3) {
            StandardOutput.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            return new Finish();
        }
        return new WaitForClientInput();
    }

    @Override
    public boolean isExit() {
        return false;
    }

    public String response(Referee referee) {
        int ball = referee.getBallCount();
        int strike = referee.getStrikeCount();
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }
        if (ball != 0 && strike != 0) {
            return ball + "볼 " + strike + "스트라이크";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼";
    }
}
