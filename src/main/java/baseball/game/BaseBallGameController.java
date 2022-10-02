package baseball.game;

import baseball.model.BaseBallNumber;
import baseball.port.inbound.StandardInput;
import baseball.port.outbound.StandardOutput;
import baseball.status.Exit;
import baseball.status.GameStatus;
import baseball.status.Ready;
import baseball.status.Playing;

public class BaseBallGameController {
    private GameStatus gameStatus = new Ready();
    private BaseBallNumber computerBaseBallNumber;
    private BaseBallNumber playerBaseBallNumber;
    public void play(){
        gameStatus = gameStatus.play(this);
    }
    public void init() {
        computerBaseBallNumber = new BaseBallNumber();
        gameStatus = new Playing();
    }
    public boolean isExit(){
        return gameStatus.isExit();
    }

    public BaseBallNumber getPlayerBaseBallNumbers() {
        return playerBaseBallNumber.getNumbers();
    }
    public BaseBallNumber getComputerBaseBallNumbers() {
        return computerBaseBallNumber.getNumbers();
    }
    public void getPlayerInput() {
        StandardOutput.print("숫자를 입력해주세요: ");
        String result = StandardInput.readLine();
        checkValid(result);
        playerBaseBallNumber = new BaseBallNumber(result);
    }
    private void checkValid(String result) {
        if(!BaseBallNumber.isValid(result)) {
            System.out.println("게임 종료");
            gameStatus = new Exit();
            throw new IllegalArgumentException("invalid baseball number");
        }
    }
}
