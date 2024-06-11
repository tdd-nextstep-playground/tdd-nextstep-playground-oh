package calculator;

import calculator.ArithmeticOperations;

/**
 * Created by Robin on 2024/06/11.
 * Description : 계산기 인터페이스 생성.
 */
public interface Calculator<T extends Number> {
    T calculate();
}
