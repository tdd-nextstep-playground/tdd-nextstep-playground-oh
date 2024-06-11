package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * Created by Robin on 2024/06/12.
 * Description : ArithmeticOperator 클래스로 계산하는 계산기 테스트
 */
class ArithmeticOperatorCalculatorTest {

    @Order(1)
    @DisplayName("사칙연산 정상 수행 확인.")
    @ParameterizedTest
    @CsvSource(value = {"3.0:+:-2.0:1.0", "3:-:1:2", "13:*:13:169", "144:/:4:36"}, delimiter = ':')
    void calculate(double operand1, char operator, double operand2, double expected) {
        //TODO: When
        ArithmeticOperatorCalculator calculator = new ArithmeticOperatorCalculator(operand1, operand2, operator);
        Double calculatedResult = calculator.calculate();
        //TODO: Then
        org.assertj.core.api.Assertions.assertThat(calculatedResult).isEqualTo(expected);
    }

    @Order(1)
    @DisplayName("사칙연산 존재하지 않는 연산자일때, IllegalArgumentException 반환 확인.")
    @ParameterizedTest
    @CsvSource(value = {"3.0:%:-2.0", "3:_:1", "13:=:13", "144:@:4"}, delimiter = ':')
    void calculate2(double operand1, char operator, double operand2) {
        //TODO: When
        Runnable methodThatThrowsIllegalArgumentException = () -> {
            new ArithmeticOperatorCalculator(operand1, operand2, operator);
        };
        //TODO: Then
        Assertions.assertThatThrownBy(methodThatThrowsIllegalArgumentException::run)
                .isInstanceOf(IllegalArgumentException.class);
    }
}