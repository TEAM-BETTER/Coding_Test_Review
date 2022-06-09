import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        // 작은 수를 쉽게 뽑기 위해 정렬
        Arrays.sort(numbers);
        // 가장 첫 번째 숫자 삽입
        int answer = numbers[0];
        // 그 이후 숫자부터 만약 연속되는지 확인하고 연속되지 않는다면 연속되었을 때 나올 숫자 반환
        for (int i = 1; i < numbers.length; i++) {
            if ((answer + 1) != numbers[i]) return answer + 1;
            answer = numbers[i];
        }
        return answer;
    }
}
