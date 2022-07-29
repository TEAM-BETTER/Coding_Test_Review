// idx : 출발 인덱스
// nums[idx] : 출발 인덱스에 있는 숫자
// remNum : 한칸 이동할때마다 줄어드는 nums[idx]
// 이동하면서 remNum을 줄여가며 이동한 위치의 숫자와 비교하여 remNum이 더 작다면 출발idx를 바꿔가며 구했습니다.

public class CodingTest04_임요한 {
    public boolean solution(int[] nums) {
        boolean answer = false;

        int idx = 0;
        int remNum = nums[idx];
        for (int i = idx+1; i <= idx + nums[idx]; i++) {
            if (i == nums.length - 1) {
                return true;
            }
            remNum--;
            if (nums[i] >= remNum) {
                idx = i; // 앞으로 이동할수있는 수보다 현재 도착한 수가 더 크다면 출발idx를 교체
                remNum = nums[idx];
            }
        }
        return answer;
    }
}
