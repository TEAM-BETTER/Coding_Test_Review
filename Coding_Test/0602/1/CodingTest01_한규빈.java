package codingTest1;

import java.util.Arrays;

/**
 * 대부분의 사람들이 풀었을 거 같으므로 따로 주석은 달지 않겠습니다!!
 */
public class CodingTest01_한규빈 {

    public static int solution(int[] numbers) {
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] - numbers[i]!= 1) {
               return numbers[i] + 1;

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {9, 4, 2, 3, 7, 5};
        System.out.println(solution(nums));
    }
}
