package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {
    @Test
    @DisplayName("임의의 숫자 사이즈 검증")
    void makeNumberSize(){
        assertThat(Utils.makeNumber().length()).isEqualTo(3);
    }

    @Test
    @DisplayName("랜덤으로 만든 숫자가 중복되지 않는다는것을 검증")
    void makeNumberNoOverlap(){
        try {
            int n = 100;
            while (n-- > 0) {
                HashSet<Character> hs = new HashSet<>();
                for (char c : Utils.makeNumber().toCharArray()) {
                    if (!hs.add(c)) throw new RuntimeException();
                }
            }
        }
        catch (Exception e){
            fail();
        }
    }
}