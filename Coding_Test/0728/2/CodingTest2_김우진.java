package CodingTest10;

/**
 *  그리디 연습문제에서 풀었던 풀이
 * 1. charNum 배열에 주어진 int를 숫자 하나씩 넣는다.
 * 2. charNum 배열을 역순으로 돌면서 당시 가장 큰 수와 비교해서
 *      max값을 nums배열에 넣어 가장 큰 수를 기록해둠.
 * 3. 반복문을 통해 charNums[i] - '0'의 값과 nums[i + 1]의 값을 비교
 *      nums[i + 1]값이 크면 다시 반복문을 통해 charNums 의 위치를 찾음.
 *      해당하는 값은 tmp에 넣고 charNums[j] 와 charNums[i]값을 바꿔줌
 * 4. 바뀐 charNums 리턴
 */
public class CodingTest2_김우진 {
    public static int solution(int num) {

        char[] charNums = String.valueOf(num).toCharArray();
        int[] nums = new int[charNums.length];

        int max = Integer.MIN_VALUE;

        for (int i = charNums.length - 1; i >= 0; i--) {
            max = Math.max(charNums[i] - '0', max);
            nums[i] = max;
        }

        for (int i = 0; i < charNums.length - 1; i++) {
            if (charNums[i] - '0' < nums[i + 1]) {
                for (int j = charNums.length - 1; j >= i + 1; j--) {
                    if (charNums[j] - '0' == nums[i + 1]) {
                        char tmp = charNums[j];
                        charNums[j] = charNums[i];
                        charNums[i] = tmp;
                        return Integer.parseInt(String.valueOf(charNums));
                    }
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(solution(43824));
    }
}