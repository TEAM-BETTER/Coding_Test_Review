package CodingTest17;

public class CodingTest1_김우진 {

    /**
     * max : 가장 큰 수, min : 다음 큰 수, idx : 가장 큰 수의 인덱스 값
     *
     * 첫번째 반복문으로 가장 큰 수와 그 인덱스 값을 저장
     * 두번째 반복문으로 그 다음 큰 수를 구하기
     *
     * 리턴값 : (가장 큰 값 - 1 ) * ( 그 다음 큰 수 -1 )
     */

    public static int solution(int[] nums) {

        int max = 0;
        int min = 0;
        int idx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                idx = i;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (max == nums[i] && idx == i) {
                continue;
            }
            if (min < nums[i]) {
                min = nums[i];
            }
        }

        return (max - 1) * (min - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 3, 4, 4, 5, 2, 3, 4, 6, 6};
        System.out.println(solution(nums));
    }
}
