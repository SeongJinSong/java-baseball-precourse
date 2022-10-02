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
    void check(){
        BaseBallNumber baseBallNumber1 = new BaseBallNumber(Arrays.asList('4', '2', '5'));
        assertThat(baseBallNumber1.compare("123")).isEqualTo("0 1");
        assertThat(baseBallNumber1.compare("456")).isEqualTo("1 1");
        assertThat(baseBallNumber1.compare("789")).isEqualTo("0 0");

        BaseBallNumber baseBallNumber2 = new BaseBallNumber(Arrays.asList('7', '1', '3'));
        assertThat(baseBallNumber2.compare("123")).isEqualTo("1 1");
        assertThat(baseBallNumber2.compare("145")).isEqualTo("1 0");
        assertThat(baseBallNumber2.compare("671")).isEqualTo("2 0");
        assertThat(baseBallNumber2.compare("216")).isEqualTo("0 1");
        assertThat(baseBallNumber2.compare("713")).isEqualTo("0 3");
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