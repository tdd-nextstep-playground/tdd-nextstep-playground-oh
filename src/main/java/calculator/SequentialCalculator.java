package calculator;

import java.util.Queue;

/**
 * Created by Robin on 2024/06/12.
 * Description : 먼저 받은 순서 대로 계산 하는 계산기 클래스 구현
 */
public class SequentialCalculator {
    private final Queue<Integer> numbers;
    private final Queue<Character> operators;

    public SequentialCalculator(Queue<Integer> numbers, Queue<Character> operators) {
        this.numbers = numbers;
        this.operators = operators;
    }

    public Integer calculate() {
        Integer operand1 = numbers.remove();
        while (!numbers.isEmpty()) {
            Integer operand2 = numbers.remove();
            Character operator = operators.remove();
            ArithmeticOperatorCalculator calculator = new ArithmeticOperatorCalculator(operand1, operand2, operator);
            operand1 = (int) Math.floor(calculator.calculate());
        }
        return operand1;
    }
}
