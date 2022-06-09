/*
    1. 배열을 오름차순 정렬
    2. 배열의 첫번째 인덱스 값을 가져옵니다 (인덱스마다 검색을 하지 않기 위해)
    3. 첫번째 인덱스 값에서 1씩 더하며 비교하며 다르면 리턴합니다.

    처음에 배열 정렬할 때 stream.sort를 사용했는데 효율성에서 감점받아서 Arrays.sort로 변경하고 효율성 통과했습니다.
*/
import java.util.Arrays;
class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int firstValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i] != firstValue+1) return numbers[i-1]+1;
            firstValue++;
        }
        return 0;
    }
}