package baseball.model;

public class BaseBallNumber {
    private final String number;

    public BaseBallNumber(String number) {
        this.number = number;
    }

    public String check(String input){
        int ballCnt = 0, strikeCnt = 0;
        for (int i = 0; i < input.length(); i++) {
            int idx = number.indexOf(input.charAt(i));
            if(idx!=-1){
                if(i==idx)strikeCnt++;
                else ballCnt++;
            }
        }
        return ballCnt + " " + strikeCnt;
    }
}
