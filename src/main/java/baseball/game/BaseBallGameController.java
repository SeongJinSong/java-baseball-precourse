package baseball.game;

import baseball.model.BaseBallNumber;
import baseball.model.Referee;
import baseball.view.status.GameStatus;
import baseball.view.status.Ready;

public class BaseBallGameController {
    private GameStatus gameStatus = new Ready();
    private BaseBallNumber computerBaseBallNumber;
    private BaseBallNumber playerBaseBallNumber;

    public void play() {
        gameStatus = gameStatus.play(this);
    }

    public void init() {
        computerBaseBallNumber = new BaseBallNumber();
    }

    public boolean isExit() {
        return gameStatus.isExit();
    }

    public void setPlayerBaseBallNumber(BaseBallNumber baseBallNumber) {
        playerBaseBallNumber = baseBallNumber;
    }

    public Referee judge() {
        Referee referee = new Referee(computerBaseBallNumber, playerBaseBallNumber);
        return referee.judge();
    }

}
