package baseball.game;

import baseball.model.BaseBallNumber;

public class Referee {
    private int ballCount = 0;
    private int strikeCount = 0;
    private final String computer;
    private final String player;

    public Referee(BaseBallNumber computer, BaseBallNumber player) {
        this.computer = computer.getNumberString();
        this.player = player.getNumberString();
    }

    public String judge() {
        for (int i = 0; i < computer.length(); i++) {
            countStrike(computer.charAt(i), player.charAt(i));
        }
        for (char c : player.toCharArray()) {
            countBall(c);
        }
        ballCount = ballCount - strikeCount;
        return ballCount + " " + strikeCount;
    }

    private void countBall(char input) {
        for (char c : computer.toCharArray()) {
            countBall(c, input);
        }
    }

    private void countStrike(char c1, char c2) {
        if (c1 == c2) {
            strikeCount++;
        }
    }

    private void countBall(char c1, char c2) {
        if (c1 == c2) {
            ballCount++;
        }
    }
}
