import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // int형 배열을 String 배열로 변환
        String[] answer = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        // 내림차순 정렬
        Arrays.sort(answer, (a, b) -> (b + a).compareTo(a + b));
        // 해당 배열을 문자열로 변환
        return String.join("", answer);
    }
}
