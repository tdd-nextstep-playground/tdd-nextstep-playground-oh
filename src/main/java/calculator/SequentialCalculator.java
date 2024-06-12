package calculator;

import java.util.Queue;

/**
 * Created by Robin on 2024/06/12.
 * Description : 먼저 받은 순서 대로 계산 하는 계산기 클래스 구현
 */
public class SequentialCalculator {
    private final Queue<Double> operands;
    private final Queue<Character> operators;

    public SequentialCalculator(Queue<Double> operands, Queue<Character> operators) {
        this.operands = operands;
        this.operators = operators;
    }

    public double calculate() {
        if (operands.size() < 2 || operands.size() != operators.size() + 1) {
            throw new IllegalStateException("Insufficient operands or invalid operators.");
        }

        double result = operands.remove();
        while (!operands.isEmpty()) {
            Double secondOperand = operands.remove();
            Character operator = operators.remove();
            result = performOperation(result, secondOperand, operator);
        }
        return result;
    }

    private double performOperation(double operand1, double operand2, Character operator) {
        return new ArithmeticOperatorCalculator(operand1, operand2, operator).calculate();
    }
}
