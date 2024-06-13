package calculator;

import java.util.*;

/**
 * Created by Robin on 2024/06/11.
 * Description : 계산기 실행하는 메인 함수
 */
public class CalculatorMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("계산할 문자열을 입력하세요. \nex.2 + 3 * 4 / 2");
        String text = scanner.nextLine();
        System.out.printf("입력된 문자열은 %s 입니다.%n", text);

        OperandOperatorParser inputSequentialReader = OperandOperatorParser.parse(text);
        Queue<Double> operands = inputSequentialReader.getOperands();
        Queue<Character> operators = inputSequentialReader.getOperators();
        SequentialCalculator calculator = new SequentialCalculator(operands, operators);
        double result = calculator.calculate();

        System.out.printf("%s = %s%n", text, result);
    }

}
