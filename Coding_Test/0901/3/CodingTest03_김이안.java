/*
* 우선순위 큐라고 써져있는데 생각도 못했네요
* 완전 탐색 같은 그리디입니다.
* */
class Solution {
	public int solution(int[] arr, int k) {
		int answer = arr[0];
		int index = 0;	 // 현재 인덱스
		while (index != arr.length - 1) {
			int max = Integer.MIN_VALUE;
			int maxIndex = index;
			for (int i = index + 1; i <= index + k; i++) { //k칸 만큼 반복문
				if (i < arr.length) {
					if (arr[i] > 0) {	// 양수일 시 무조건 이동
						maxIndex = i;
						break;
					} else if (i == arr.length - 1) {	// k칸 안에 마지막 인덱스가 있으면 도착
						maxIndex = i;
						break;
					} else if (arr[i] >= max) {	// k칸 안에 점수가 제일 높은 칸을 찾습니다.
						max = arr[i];
						maxIndex = i;
					}
				}
			}
			index = maxIndex;	// 이동
			answer += arr[index];	// 점수 추가
		}
		return answer;
	}
}