package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BaseBallNumberTest {
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