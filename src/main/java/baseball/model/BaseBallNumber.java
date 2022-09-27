package baseball.model;

import java.util.HashSet;

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

    public static boolean isValid(String input){
        if(input.length()!=3)return false;
        HashSet<Character> hs = new HashSet<>();
        for(char c : input.toCharArray()){
            if(c-'0'<1||c-'0'>9)return false;
            if(!hs.add(c))return false;
        }
        return true;
    }
}
