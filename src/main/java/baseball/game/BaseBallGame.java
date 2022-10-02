package baseball.game;

public class BaseBallGame {
    private final BaseBallGameController baseBallGameController = new BaseBallGameController();
    public void start(){
        while (!baseBallGameController.isExit()) {
            baseBallGameController.play();
        }
    }
}
