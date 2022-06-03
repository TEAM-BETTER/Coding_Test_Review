import java.util.Arrays;
/*
* 배열을 오름차순으로 정렬
* [1, 2, 3, 5, 6, 7, 8, 9]
* 맨앞에서 끝에서 두번쨰까지 앞의 원소랑 비교를하며 연속된 수 인지 판단
* number[i] + 1 == number[i+1]
* 아니라면 연속되지 않은 수이고 오름차순으로 정렬되어 있으므로 가장먼저 연결되어 있지 않은 수가 가장 작은 연결되지 않은 수
* */
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] + 1 != numbers[i+1]) {
                answer = numbers[i] + 1;
                break;
            }
        }
        return answer;
    }
}