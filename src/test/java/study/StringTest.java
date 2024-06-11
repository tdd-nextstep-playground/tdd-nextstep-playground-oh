package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StringTest {
    @Test
    @Order(0)
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
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
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환.")
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
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 ()을 제거하고 \"1,2\"를 반환.")
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
    @DisplayName("\"abc\" 값이 주어졌을 때 특정 위치의 문자를 가져오는지 확인.")
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
    @Test
    @DisplayName("\"abc\" 값이 주어 지고 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생.")
    void charAt_메서드_테스트2() {
        //given
        String given = "abc";
        int maxLength = given.length();
        //when
        Runnable methodThatThrowsIndexOutOfBoundsException = () -> {
            given.charAt(maxLength + 1);
        };
        //then
        Assertions.assertThatThrownBy(methodThatThrowsIndexOutOfBoundsException::run).isInstanceOf(IndexOutOfBoundsException.class);
    }

}
