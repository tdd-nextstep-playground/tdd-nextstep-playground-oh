package study.calculator;

/**
 * Created by Robin on 2024/06/11.
 * Description : ArithmeticOperator 클래스로 계산하는 계산기
 */
public class ArithmeticOperatorCalculator implements Calculator<Double>{
    private final double operand1;
    private final double operand2;
    private final ArithmeticOperator operator;

    public ArithmeticOperatorCalculator(double operand1, double operand2, char operator) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operator = ArithmeticOperator.fromSymbol(operator);
    }

    @Override
    public Double calculate() {
        return operator.apply(operand1, operand2);
    }
}
