package baseball;

import baseball.model.BaseBallNumber;
import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameView gameview = new GameView();
        while (!"exit".equals(gameview.getState())) {
            if ("booting".equals(gameview.getState())) {
                gameview.receiveArgs();
            }else if("in-game".equals(gameview.getState())){
                gameview.receiveInGame();
            }else if("end".equals(gameview.getState())){
                gameview.receiveOption();
            }
        }
    }
}
