package baseball.view;

public class GameView {
    public static String response(String input) {
        int ball = Integer.parseInt(input.split(" ")[0]);
        int strike = Integer.parseInt(input.split(" ")[1]);
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }
        if (ball != 0 && strike != 0) {
            return ball + "볼 " + strike + "스트라이크";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return ball + "볼";
    }
}
