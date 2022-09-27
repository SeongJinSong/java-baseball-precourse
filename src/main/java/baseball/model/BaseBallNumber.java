package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BaseBallNumber {
    private final List<Character> number;

    public BaseBallNumber() {
        number = new ArrayList<>();
    }

    public BaseBallNumber(List<Character> number) {
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

    public static String makeNumber(){
        boolean[] visited = new boolean[10];
        StringBuilder sb = new StringBuilder();
        while(sb.length()<3){
            int randomPick = Randoms.pickNumberInRange(1,9);
            if(visited[randomPick])continue;
            visited[randomPick]=true;
            sb.append(randomPick);
        }
        return sb.toString();
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
