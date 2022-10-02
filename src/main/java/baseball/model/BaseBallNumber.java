package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BaseBallNumber {
    private final List<Character> numbers;

    public BaseBallNumber() {
        numbers = new ArrayList<>();
        makeNumber();
    }

    public BaseBallNumber(String s) {
        if (!isValidBaseballNumber(s)) {
            throw new IllegalArgumentException("invalid baseball number");
        }
        numbers = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            numbers.add(s.charAt(i));
        }
    }

    public String getNumberString() {
        StringBuilder sb = new StringBuilder();
        for (char c : numbers) {
            sb.append(c);
        }
        return sb.toString();
    }

    public String makeNumber() {
        boolean[] visited = new boolean[10];
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 3) {
            checkNumberAndAppend(visited, sb);
        }
        return sb.toString();
    }

    private void checkNumberAndAppend(boolean[] visited, StringBuilder sb) {
        int randomPick = Randoms.pickNumberInRange(1, 9);
        if (visited[randomPick]) {
            return;
        }
        visited[randomPick] = true;
        numbers.add((char)(randomPick + '0'));
        sb.append(randomPick);
    }

    public boolean isValidBaseballNumber(String input) {
        if (input.length() != 3) {
            return false;
        }
        HashSet<Character> hs = new HashSet<>();
        return !checkBaseBallNumberRule(input, hs);
    }

    private boolean checkBaseBallNumberRule(String input, HashSet<Character> hs) {
        for (char c : input.toCharArray()) {
            if (c - '0' < 1 || c - '0' > 9 || !hs.add(c)) {
                return true;
            }
        }
        return false;
    }
}
