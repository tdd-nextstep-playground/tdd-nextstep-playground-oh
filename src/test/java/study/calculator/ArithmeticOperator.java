package study.calculator;

import calculator.ArithmeticOperations;

/**
 * Created by Robin on 2024/06/12.
 * Description : 연산자 기호 저장
 */

public enum ArithmeticOperator {
    ADDITION('+') {
        @Override
        public double apply(double operand1, double operand2) {
            return operations.add(operand1, operand2);
        }
    },
    SUBTRACTION('-') {
        @Override
        public double apply(double operand1, double operand2) {
            return operations.subtract(operand1, operand2);
        }
    },
    MULTIPLICATION('*') {
        @Override
        public double apply(double operand1, double operand2) {
            return operations.multiply(operand1, operand2);
        }
    },
    DIVISION('/') {
        @Override
        public double apply(double operand1, double operand2) {
            return operations.divide(operand1, operand2);
        }
    };

    private final char symbol;
    private static final ArithmeticOperations operations = new ArithmeticOperations();

    ArithmeticOperator(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public abstract double apply(double operand1, double operand2);

    public static ArithmeticOperator fromSymbol(char symbol) {
        for (ArithmeticOperator operator : values()) {
            if (operator.getSymbol() == symbol) {
                return operator;
            }
        }
        throw new IllegalArgumentException("Invalid operator: " + symbol);
    }
}