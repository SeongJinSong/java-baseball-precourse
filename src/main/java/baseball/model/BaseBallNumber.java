package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BaseBallNumber {
    private final List<Character> numbers;

    public BaseBallNumber() {
        numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add((char)(Randoms.pickNumberInRange(1, 9)+'0'));
        }
    }

    public BaseBallNumber(List<Character> number) {
        this.numbers = number;
    }

    public BaseBallNumber(String s) {
        numbers = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            numbers.add(s.charAt(i));
        }
    }

    public String compare(String input){
        int ballCnt = 0, strikeCnt = 0;
        for (int i = 0; i < input.length(); i++) {
            int idx = numbers.indexOf(input.charAt(i));
            if(idx!=-1){
                if(i==idx)strikeCnt++;
                else ballCnt++;
            }
        }
        return ballCnt + " " + strikeCnt;
    }

    public BaseBallNumber getNumbers(){
        return this;
    }

    public String getNumberString(){
        StringBuilder sb = new StringBuilder();
        for(char c : numbers) sb.append(c);
        return sb.toString();
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
