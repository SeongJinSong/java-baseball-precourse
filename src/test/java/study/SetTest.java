package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    @DisplayName("요구사항 1 : Set의 크기 확인")
    void setSizeTest(){
        assertThat(numbers.size()).isEqualTo(3);
    }
    @Test
    @DisplayName("요구사항 2-1 : set contains 함수 확인")
    void setContainsTest(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();

    }
    @DisplayName("요구사항 2-2 : set contains 함수 확인")
    @ParameterizedTest(name = "{index} => {arguments} is contained : {0}")
    @ValueSource(ints = {1, 2, 3})
    void setContainsParameterizedTest(int input){
        assertThat(numbers.contains(input)).isTrue();

    }

    @DisplayName("요구사항 3 : set contains 아닌 경우 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void setContainsTest(int input, boolean expected){
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
