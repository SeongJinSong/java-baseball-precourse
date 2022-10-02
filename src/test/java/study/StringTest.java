package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("요구사항 1 : split 함수 동작 테스트")
    void splitTest() {
        String s = "1,2";
        assertThat(s.split(",")).containsExactly("1", "2");
        String s2 = "1";
        assertThat(s2.split(",")).contains("1");
    }

    @Test
    @DisplayName("요구사항 2 : substirng 함수 동작 테스트")
    void substringTest() {
        String s = "(1,2)";
        assertThat(s.substring(1, s.length() - 1)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("요구사항 3 : charAt 함수 동작 테스트")
    void charAtTest() {
        String s = "abc";
        assertThat(s.charAt(0)).isEqualTo('a');
        assertThatThrownBy(() -> s.charAt(s.length()))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> s.charAt(s.length()))
                .withMessageMatching("String index out of range: 3");
        /* 자주 발생하는 Exception의 경우 Exception별 메서드 제공하고 있음
            assertThatIllegalArgumentException()
            assertThatIllegalStateException()
            assertThatIOException()
            assertThatNullPointerException()
         */

    }
}
