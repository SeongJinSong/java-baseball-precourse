package baseball.model;

import java.util.HashSet;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

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
    void check(){
        BaseBallNumber baseBallNumber1 = new BaseBallNumber("425");
        assertThat(baseBallNumber1.check("123")).isEqualTo("0 1");
        assertThat(baseBallNumber1.check("456")).isEqualTo("1 1");
        assertThat(baseBallNumber1.check("789")).isEqualTo("0 0");

        BaseBallNumber baseBallNumber2 = new BaseBallNumber("713");
        assertThat(baseBallNumber2.check("123")).isEqualTo("1 1");
        assertThat(baseBallNumber2.check("145")).isEqualTo("1 0");
        assertThat(baseBallNumber2.check("671")).isEqualTo("2 0");
        assertThat(baseBallNumber2.check("216")).isEqualTo("0 1");
        assertThat(baseBallNumber2.check("713")).isEqualTo("0 3");
    }

    @Test
    void isValidTest(){
        assertThat(BaseBallNumber.isValid("111")).isFalse();
        assertThat(BaseBallNumber.isValid("012")).isFalse();
        assertThat(BaseBallNumber.isValid("a12")).isFalse();
        assertThat(BaseBallNumber.isValid("212")).isFalse();
        assertThat(BaseBallNumber.isValid("123")).isTrue();
    }
}