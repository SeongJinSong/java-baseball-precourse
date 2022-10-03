package baseball.view.status;

import baseball.game.BaseBallGameController;
import baseball.model.BaseBallNumber;
import baseball.view.port.inbound.StandardInput;
import baseball.view.port.outbound.StandardOutput;

public class WaitForClientInput implements GameStatus {
    @Override
    public GameStatus play(BaseBallGameController controller) throws IllegalArgumentException {
        StandardOutput.print("숫자를 입력해주세요: ");
        String result = StandardInput.readLine();
        try {
            controller.setPlayerBaseBallNumber(new BaseBallNumber(result));
        } catch (IllegalArgumentException e) {
            StandardOutput.println("잘못된 값을 입력하셨습니다.");
            return new Exit();
        }
        return new Verifying();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
