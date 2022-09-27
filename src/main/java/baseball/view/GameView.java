package baseball.view;

import baseball.model.BaseBallNumber;
import camp.nextstep.edu.missionutils.*;
public class GameView {
    private String state = "start";
    private BaseBallNumber baseBallNumber;
    public GameView(){
        baseBallNumber = new BaseBallNumber();
    }
    public String receiveInGame() {
        System.out.println("숫자를 입력해주세요 :");
        String result = Console.readLine();
        if(!BaseBallNumber.isValid(result)) {
            state = "exit";
            throw new IllegalArgumentException("invalid baseball number");
        }
        String response = response(baseBallNumber.check(result));
        System.out.println(response);
        if("3스트라이크".equals(response)){
            state="end";
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
        }
        return result;
    }

    public String response(String input){
        int ball = Integer.parseInt(input.split(" ")[0]);
        int strike = Integer.parseInt(input.split(" ")[1]);
        if(ball==0&&strike==0)return "낫싱";
        if(ball==0&&strike!=0)return strike+"스트라이크";
        if(ball!=0&&strike==0)return ball+"볼";
        if(ball!=0&&strike!=0)return ball+"볼 "+ strike+"스트라이크";
        throw new IllegalArgumentException("invalid baseball check response");
    }

    public void receiveOption(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String result = Console.readLine();
        if("1".equals(result)){
            baseBallNumber = new BaseBallNumber();
            state = "start";
            return;
        }
        if("2".equals(result)){
            state = "exit";
            return;
        }
        throw new IllegalArgumentException("invalid option");
    }
    public String getState() {
        return state;
    }
}
