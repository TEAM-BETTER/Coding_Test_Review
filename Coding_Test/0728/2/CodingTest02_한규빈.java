package CodingTest2;

/**
 * 파라미터로 받은 숫자를 배열로 만들고 시작하였습니다.
 * left, right 포인터를 주고  nums[left] <= nums[right] true 조건이면
 * 그 전 모든 숫자와 비교하여 midIdx를 구한뒤 midIdx와 스왑해주는 방식으로 진행하였습니다.
 */
public class CodingTest02_한규빈 {

    public static int solution(int num) {
        String str_num = Integer.toString(num);
        int[] nums = new int[str_num.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = str_num.charAt(i) - '0';
        }

        int left = 0;
        int right = 1;
        int answer = Integer.MIN_VALUE;
        while (right < nums.length) {
            if (nums[left] <= nums[right]) {

                int maxNum = nums[right];
                int minIdx = 0;
                for (int i = right - 1; i >= 0; i--) {
                    if (maxNum > nums[i]) {
                        minIdx = i;
                    }
                }

                int temp = nums[right];
                nums[right] = nums[minIdx];
                nums[minIdx] = temp;

                int res = 0;
                for (int i = 0; i < nums.length; i++) {
                    res = res * 10 + nums[i];
                }

                int temp2 = nums[right];
                nums[right] = nums[minIdx];
                nums[minIdx] = temp2;

                answer = Math.max(res, answer);
                left = right;
            }

            right = right + 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(14235));
    }
}
