package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split_메서드_테스트() {
        //given
        String delimiter = ",";
        String given = "1,2";
        String[] result = new String[]{"1", "2"};
        //when
        String[] stringArrSplitByDelimiter = given.split(delimiter);
        //then
        Assertions.assertThat(stringArrSplitByDelimiter).contains(result[1], result[0]);
        Assertions.assertThat(stringArrSplitByDelimiter).containsExactly(result[0], result[1]);
        Assertions.assertThat(stringArrSplitByDelimiter).doesNotContain(delimiter);
    }

    @Test
    void split_메서드_구분자_포함_안될때_테스트() {
        //given
        String delimiter = ",";
        String given = "1";
        String[] result = new String[]{"1"};
        //when
        String[] stringArrSplitByDelimiter = given.split(delimiter);
        //then
        Assertions.assertThat(stringArrSplitByDelimiter).contains(result[0]);
        Assertions.assertThat(stringArrSplitByDelimiter).containsExactly(result[0]);
        Assertions.assertThat(stringArrSplitByDelimiter).doesNotContain(delimiter);
    }

    @Test
    void substring_메서드_테스트() {
        //given
        String given = "(1,2)";
        String result = "1,2";
        //when
        String substringRemoveParentheses = given.substring(1, 4);
        //then
        Assertions.assertThat(substringRemoveParentheses).isEqualTo(result);
    }

    @Test
    @DisplayName("charAt_메서드_테스트")
    void charAt_메서드_테스트() {
        //given
        String given = "abc";
        char a = 'a';
        char b = 'b';
        char c = 'c';
        int maxLength = given.length();
        //when
        char charAtA = given.charAt(0);
        char charAtB = given.charAt(1);
        char charAtC = given.charAt(2);
        Runnable methodThatThrowsIndexOutOfBoundsException = () -> {
            given.charAt(maxLength + 1);
        };
        //then
        Assertions.assertThat(charAtA).isEqualTo(a);
        Assertions.assertThat(charAtB).isEqualTo(b);
        Assertions.assertThat(charAtC).isEqualTo(c);
        Assertions.assertThatThrownBy(methodThatThrowsIndexOutOfBoundsException::run).isInstanceOf(IndexOutOfBoundsException.class);

    }
}
