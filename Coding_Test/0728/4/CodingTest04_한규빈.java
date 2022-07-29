package CodingTest4;

/**
 * 처음 인덱스부터 시작하여 1부터 param0[0]의 숫자까지 1씩 증가 시키면서 재귀적으로 풀었습니다.
 */
public class CodingTest04_한규빈 {

    public static boolean solution(int[] param0) {
        boolean answer = false;
        for (int i = 1; i < param0[0]; i++) {
            if (recur(param0, 0, i)) {
                return true;
            }
        }

        return answer;
    }

    public static boolean recur(int[] nums, int idx, int move) {
        // nums[idx] == 0 이면 더 이상 갈 수 없으므로 false
        if (nums[idx] == 0 ) {
            return false;
        }

        // 최대로 이동 할 수 있는 거리만큼 이동하였는데 배열의 끝에 도달하지 못 하면 false
        if (move == nums[idx] && idx > nums.length - 1) {
            return false;
        }

        // 배열의 제일 끝에 왔을 때 true
        if (idx == nums.length - 1) {
            return true;
        }

        // 현재 위치에서 1 ~ nums[idx] 이동
        for (int i = 1; i <= nums[idx] ; i++) {
            if (recur(nums, idx + i, i)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 1, 1, 0, 3};
        System.out.println(solution(nums));

        nums = new int[]{2, 3, 5, 2, 0, 2, 1, 1, 0, 0, 4};
        System.out.println(solution(nums));
    }
}
