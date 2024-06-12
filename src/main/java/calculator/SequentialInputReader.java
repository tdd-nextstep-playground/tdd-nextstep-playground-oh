package calculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Robin on 2024/06/12.
 * Description : 연산자와 피연산자로 이루어진 문자열을 피연산자 Queue(numbers), 연산자 Queue(operators)로 반환.
 */
public class SequentialInputReader {
    public static final String NUMBER_REGEX = "\\d+";
    public static final String OPERATOR_REGEX = "[-+*/]";
    private static final String EXPRESSION_TOKEN_PATTERN = NUMBER_REGEX + "|" + OPERATOR_REGEX;
    Queue<Integer> numbers;
    Queue<Character> operators;
    private final Matcher matcher;

    public SequentialInputReader(String text) {
        this.matcher = Pattern.compile(EXPRESSION_TOKEN_PATTERN).matcher(text);
        this.numbers = new LinkedList<>();
        this.operators = new LinkedList<>();
    }

    public static SequentialInputReader loadReader(String text) {
        SequentialInputReader reader = new SequentialInputReader(text);
        reader.saveNumbersAndOperators();
        return reader;
    }

    public void saveNumbersAndOperators() {
        while (matcher.find()) {
            String token = matcher.group();
            addNumbersIfNumber(token);
            addOperatorsIfOperator(token);
        }
    }

    private void addNumbersIfNumber(String token) {
        if (isNumber(token)) {
            numbers.add(Integer.parseInt(token));
        }
    }

    private void addOperatorsIfOperator(String token) {
        if (isOperator(token)) {
            operators.add(token.charAt(0));
        }
    }

    private boolean isOperator(String token) {
        return token.matches(OPERATOR_REGEX);
    }

    private boolean isNumber(String token) {
        return token.matches(NUMBER_REGEX);
    }

    public Queue<Integer> getNumbers() {
        return numbers;
    }

    public Queue<Character> getOperators() {
        return operators;
    }
}
