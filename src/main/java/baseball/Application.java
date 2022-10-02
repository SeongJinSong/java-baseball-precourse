package baseball;

import baseball.game.BaseBallGame;
import baseball.model.BaseBallNumber;
import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseBallGame baseBallGame = new BaseBallGame();
        baseBallGame.start();
    }
}
