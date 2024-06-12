package calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Robin on 2024/06/12.
 * Description : 연산자와 피연산자로 이루어진 문자열을 피연산자 Queue(numbers), 연산자 Queue(operators)로 반환.
 */
public class OperandOperatorParser {
    public static final String NUMERIC_PATTERN = "\\d+";
    public static final String OPERATOR_PATTERN = "[-+*/]";
    private static final String EXPRESSION_TOKEN_PATTERN = NUMERIC_PATTERN + "|" + OPERATOR_PATTERN;
    Queue<Double> operands;
    Queue<Character> operators;
    private final Matcher matcher;

    public OperandOperatorParser(String text) {
        this.matcher = Pattern.compile(EXPRESSION_TOKEN_PATTERN).matcher(text);
        this.operands = new LinkedList<>();
        this.operators = new LinkedList<>();
    }

    public static OperandOperatorParser parse(String text) {
        OperandOperatorParser reader = new OperandOperatorParser(text);
        reader.extractOperandsAndOperators();
        return reader;
    }

    public void extractOperandsAndOperators() {
        while (matcher.find()) {
            String token = matcher.group();
            addOperandIfNumeric(token);
            addOperatorIfOperator(token);
        }
    }

    private void addOperandIfNumeric(String token) {
        if (isNumeric(token)) {
            operands.add(Double.parseDouble(token));
        }
    }

    private void addOperatorIfOperator(String token) {
        if (isOperator(token)) {
            operators.add(token.charAt(0));
        }
    }

    private boolean isOperator(String token) {
        return token.matches(OPERATOR_PATTERN);
    }

    private boolean isNumeric(String token) {
        return token.matches(NUMERIC_PATTERN);
    }

    public Queue<Double> getOperands() {
        return operands;
    }

    public Queue<Character> getOperators() {
        return operators;
    }
}
