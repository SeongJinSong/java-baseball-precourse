package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseBallNumberTest {
    @Test
    @DisplayName("임의의 숫자 사이즈 검증")
    void makeNumberSize(){
        assertThat(BaseBallNumber.makeNumber().length()).isEqualTo(3);
    }

    @Test
    @DisplayName("랜덤으로 만든 숫자가 중복되지 않는다는것을 검증")
    void makeNumberNoOverlap(){
        try {
            int n = 100;
            while (n-- > 0) {
                HashSet<Character> hs = new HashSet<>();
                for (char c : BaseBallNumber.makeNumber().toCharArray()) {
                    if (!hs.add(c)) throw new RuntimeException();
                }
            }
        }
        catch (Exception e){
            fail();
        }
    }

    @Test
    @DisplayName("BaseBallNumber 가 정상적인지 판단하는 체크 로직")
    void isValidTest(){
        assertThat(BaseBallNumber.isValid("111")).isFalse();
        assertThat(BaseBallNumber.isValid("012")).isFalse();
        assertThat(BaseBallNumber.isValid("a12")).isFalse();
        assertThat(BaseBallNumber.isValid("212")).isFalse();
        assertThat(BaseBallNumber.isValid("123")).isTrue();
    }
}