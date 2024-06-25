package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConsoleInputIntegerReaderTest {

    private ConsoleInputIntegerReader reader;

    @BeforeEach
    public void setUp() {
        reader = new ConsoleInputIntegerReader();
    }

    @Test
    @DisplayName("정상적인 입력을 테스트.")
    public void testRunWithValidInput() {
        // given
        String input = "10\n20\n30\n40\n50\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        reader = new ConsoleInputIntegerReader(scanner);

        // when
        reader.run(5);

        int[] expected = {10, 20, 30, 40, 50};

        // then
        assertArrayEquals(expected, reader.getInputItems());
    }

    @Test
    @DisplayName("입력을 부족하게 제공하여 NoSuchElementException이 발생하는지 테스트.")
    public void testRunWithInsufficientInput() {
        // given
        String input = "10\n20\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        reader = new ConsoleInputIntegerReader(scanner);

        // then
        assertThrows(NoSuchElementException.class, () -> reader.run(5));
    }

    @Test
    @DisplayName("잘못된 입력을 제공한 후 올바른 입력을 다시 시도하여 입력이 올바르게 처리되는지 테스트.")
    public void testRunWithInvalidInput() {
        // given
        String input = "10\nabc\n30\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(in);
        reader = new ConsoleInputIntegerReader(scanner);

        // when
        reader.run(2);

        int[] expected = {10, 30};
        int[] actual = reader.getInputItems();

        // then
        assertArrayEquals(expected, new int[]{actual[0], actual[1]});
    }

    @Test
    @DisplayName("count가 0일 때 IllegalArgumentException이 발생하는지 테스트.")
    public void testRunWithZeroCount() {
        assertThrows(IllegalArgumentException.class, () -> reader.run(0));
    }

    @Test
    @DisplayName("count가 음수일 때 IllegalArgumentException이 발생하는지 테스트.")
    public void testRunWithNegativeCount() {
        assertThrows(IllegalArgumentException.class, () -> reader.run(-1));
    }
}
