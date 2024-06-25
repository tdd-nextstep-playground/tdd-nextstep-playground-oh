package game;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Robin on 2024/06/20.
 * Description : count 만큼의 인풋을 받아서 int[] 로 저장.
 */
public class ConsoleInputIntegerReader {
    private final Scanner scanner;
    private int[] inputItems;

    public ConsoleInputIntegerReader() {
        scanner = new Scanner(System.in);
    }

    public ConsoleInputIntegerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Count must be a positive integer.");
        }

        inputItems = new int[count];
        for (int i = 0; i < count; i++) {
            while (true) {
                System.out.printf("%d번째 수를 입력해주세요. : ", i + 1);
                try {
                    inputItems[i] = scanner.nextInt();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("유효한 정수를 입력해주세요.");
                    scanner.next();
                }
            }
        }
    }

    public int[] getInputItems() {
        return inputItems;
    }
}
