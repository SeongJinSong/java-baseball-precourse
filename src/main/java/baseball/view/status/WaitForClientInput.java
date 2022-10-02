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
        controller.setPlayerBaseBallNumber(new BaseBallNumber(result));
        return new Verifying();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
