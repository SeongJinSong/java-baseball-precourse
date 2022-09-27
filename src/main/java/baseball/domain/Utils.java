package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {
    public static String makeNumber(){
        boolean[] visited = new boolean[10];
        int[] a = new int[10];
        StringBuilder sb = new StringBuilder();
        while(sb.length()<3){
            int randomPick = Randoms.pickNumberInRange(1,9);
            if(visited[randomPick])continue;
            visited[randomPick]=true;
            sb.append(randomPick);
        }
        return sb.toString();
    }
}
