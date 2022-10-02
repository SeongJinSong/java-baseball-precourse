package baseball.status;

import baseball.game.BaseBallGameController;
import baseball.port.inbound.StandardInput;
import baseball.port.outbound.StandardOutput;

public class Finish implements GameStatus {
    public final String RESTART = "1";
    public final String EXIT = "2";

    @Override
    public GameStatus play(BaseBallGameController controller) {
        StandardOutput.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = StandardInput.readLine();

        if (RESTART.equals(input)) {
            return new Ready();
        }
        if (EXIT.equals(input)) {
            StandardOutput.println("게임 종료");
            return new Exit();
        }
        throw new IllegalArgumentException("게임 종료");
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
