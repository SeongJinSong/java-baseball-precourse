package baseball.game;

import baseball.model.BaseBallNumber;
import baseball.port.inbound.StandardInput;
import baseball.port.outbound.StandardOutput;
import baseball.status.Exit;
import baseball.status.GameStatus;
import baseball.status.Ready;

public class BaseBallGameController {
    private GameStatus gameStatus = new Ready();
    private BaseBallNumber computerBaseBallNumber;
    private BaseBallNumber playerBaseBallNumber;
    public void play(){
        gameStatus = gameStatus.play(this);
    }
    public void init() {
        computerBaseBallNumber = new BaseBallNumber();
    }
    public boolean isExit(){
        return gameStatus.isExit();
    }
    public void getPlayerInput() {
        StandardOutput.print("숫자를 입력해주세요: ");
        String result = StandardInput.readLine();
        try {
            playerBaseBallNumber = new BaseBallNumber(result);
        } catch (IllegalArgumentException e) {
            StandardOutput.println("게임 종료");
            gameStatus = new Exit();
            throw e;
        }
    }
    public String judge(){
        Referee referee = new Referee(computerBaseBallNumber, playerBaseBallNumber);
        return referee.judge();
    }

}
