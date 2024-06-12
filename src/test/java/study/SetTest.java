package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Robin on 2024/06/11.
 * Description :
 */

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
    @DisplayName("Set의 크기를 확인.")
    void size_메서드_테스트() {
        //given
        int result = 3;
        //when
        int size = numbers.size();
        //then
        Assertions.assertThat(size).isEqualTo(result);
    }

    @DisplayName("Set에 1, 2, 3 값이 존재하는지 확인.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains_메서드_테스트(int number) {
        //when
        boolean isContained = numbers.contains(number);
        //then
        Assertions.assertThat(isContained).isTrue();
    }

    @DisplayName("Set에 입력 값이 존재하는지 확인. 입력 값에 따라 결과 값이 다른 경우 확인.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void contains_메서드_테스트_2(int input, boolean expected) {
        //when
        boolean isContained = numbers.contains(input);
        //then
        Assertions.assertThat(isContained).isEqualTo(expected);
    }


}
