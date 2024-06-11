package calculator;

import calculator.ArithmeticOperations;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


/**
 * Created by Robin on 2024/06/11.
 * Description : 사칙연산을 위한 클래스 테스트
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ArithmeticOperationsTest {
    ArithmeticOperations arithmeticOperations = new ArithmeticOperations();

    @Order(1)
    @DisplayName("덧셈 결과가 정상인지 확인.")
    @ParameterizedTest
    @CsvSource(value = {"3.0:5.0:8.0", "-3.12:-5.12:-8.24", "3:1:4", "0:0:0", "1:1:2"}, delimiter = ':')
    void testAdd(double inputA, double inputB, double expected) {
        //when
        double add = arithmeticOperations.add(inputA, inputB);
        //then
        Assertions.assertThat(add).isEqualTo(expected);
    }

    @Order(2)
    @DisplayName("뺄셈 결과가 정상인지 확인.")
    @ParameterizedTest
    @CsvSource(value = {"3.0:5.0:-2.0", "3:1:2", "0:0:0", "1:1:0"}, delimiter = ':')
    void testSubtract(double inputA, double inputB, double expected) {
        //when
        double subtract = arithmeticOperations.subtract(inputA, inputB);
        //then
        Assertions.assertThat(subtract).isEqualTo(expected);
    }

    @Order(3)
    @DisplayName("곱셈 결과가 정상인지 확인.")
    @ParameterizedTest
    @CsvSource(value = {"3.0:5.0:15.0", "3:5:15", "0:0:0", "1:1:1"}, delimiter = ':')
    void testMultiply(double inputA, double inputB, double expected) {
        //when
        double multiply = arithmeticOperations.multiply(inputA, inputB);
        //then
        Assertions.assertThat(multiply).isEqualTo(expected);
    }

    @Order(4)
    @DisplayName("나눗셈의 결과가 정상인지 확인")
    @ParameterizedTest
    @CsvSource(value = {"15:5:3", "15.0:2.0:7.5", "5.0:1.0:5.0"}, delimiter = ':')
    void testDivide(double inputA, double inputB, double expected) {
        //when
        double divide = arithmeticOperations.divide(inputA, inputB);
        //then
        Assertions.assertThat(divide).isEqualTo(expected);
    }

    @Order(5)
    @DisplayName("나눗셈의 제수(Divisor)값이 0일때 ArithmeticException 발생 확인.")
    @ParameterizedTest
    @CsvSource(value = {"15.0:0.0", "5:0", "0:0"}, delimiter = ':')
    void testDivideThrowArithmeticException(double inputA, double inputB) {
        //when
        Runnable methodThatThrowsArithmeticException = () -> {
            arithmeticOperations.divide(inputA, inputB);
        };
        //then
        Assertions.assertThatThrownBy(methodThatThrowsArithmeticException::run).isInstanceOf(ArithmeticException.class);
    }


}