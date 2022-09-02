/*
* 제 머리로는 완전탐색 말고는 없었어요.. 효율 0점 입니다.
* */
class Solution {
	public int solution(int[] nums) {
		int answer = Integer.MAX_VALUE;
		int n = nums.length / 3;
		for (int i = 0; i < nums.length - n + 1; i++) {
			int sumFirst = 0;
			int sumSecond = 0;
			int cnt = (nums.length - n) / 2;
			for (int j = 0; j < nums.length; j++) {
				if (j < i || j >= i + n) {
					if (cnt > 0) {
						sumFirst += nums[j];
						cnt--;
					} else {
						sumSecond += nums[j];
					}
				}
			}
			int diff = sumFirst - sumSecond;
			answer = Math.min(answer, diff);
		}
		return answer;
	}
}