import java.util.stream.Collectors;
import java.util.stream.IntStream;
/*
단순하게 문자열 배열로 정렬하는 방식입니다.
 */
class Solution {
    public String solution(int[] numbers) {
        String answer = IntStream.of(numbers)   //정수형 배열을 stream으로 선언
                .mapToObj(String::valueOf)      //배열의 각 요소를 String으로 변환
                .sorted((s1, s2) -> (s2+s1).compareTo(s1+s2))   // compareTo 함수로 비교해서 정렬합니다.
                .collect(Collectors.joining());     // 정렬된 값들을 1개의 string객체로 만들어 줍니다.


        if (answer.startsWith("0")) return "0";     // 정렬했을때 맨앞값이 0이면 모든 값이 0이므로 0을 리턴합니다.
        return answer;
    }
}