package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Robin on 2024/06/12.
 * Description : SequentialCalculator 테스트
 */
class SequentialCalculatorTest {

    @Test
    @DisplayName("순차적 계산 올바르게 수행되는지 확인.")
    void testSequentialCalculator() {
        //TODO: Given
        Queue<Double> operands = new LinkedList<>();
        operands.add(3.0);
        operands.add(5.0);
        operands.add(2.0);
        operands.add(6.0);

        Queue<Character> operators = new LinkedList<>();
        operators.add('+');
        operators.add('*');
        operators.add('-');

        SequentialCalculator calculator = new SequentialCalculator(operands, operators);

        //TODO: When
        double calculate = calculator.calculate();

        //TODO: Then
        assertEquals(10, calculate);
    }
}