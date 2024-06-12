package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Robin on 2024/06/12.
 * Description : SequentialInputReader 테스트
 */
class SequentialInputReaderTest {
    @Test
    @DisplayName("피연산자와 연산자를 올바르게 읽어오는지 확인.")
    void testSequentialInputReader() {
        //TODO: Given
        String input = "3+5*2-6";
        SequentialInputReader reader = SequentialInputReader.loadReader(input);

        //TODO: When
        Queue<Integer> numbers = reader.getNumbers();
        Queue<Character> operators = reader.getOperators();

        //TODO: Then
        assertEquals(3, numbers.poll());
        assertEquals(5, numbers.poll());
        assertEquals(2, numbers.poll());
        assertEquals(6, numbers.poll());

        assertEquals('+', operators.poll());
        assertEquals('*', operators.poll());
        assertEquals('-', operators.poll());
    }
}