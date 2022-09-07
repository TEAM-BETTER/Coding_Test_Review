package CodingTest15;

import java.util.PriorityQueue;

public class CodingTest3_김우진 {
	/**
	 * State : score, idx값을 가지고, score 내림차순으로 정렬 (MaxHeap)
	 *
	 * PriorityQueue 에 초기값 arr[0], 0을 넣어주고 arr배열 탐색
	 *
	 * pq에서 꺼낸 값의 idx가 i-k보다 작으면 해당 범위 아니므로 꺼내서 버림
	 * 해당 범위 안이면 answer값은 arr[i] + pq.peek의 score더한값으로 업데이트
	 * pq에 answer값을 score로 i값은 idx 넣어주어 이동시 변화한 score와 idx값 체크
	 *
	 * arr배열 다 돌았을 때 answer값 리턴
	 *
	 */

	static class State implements Comparable<State> {
		int score;

		int idx;

		public State(int score, int idx) {
			this.score = score;
			this.idx = idx;
		}

		@Override
		public int compareTo(State o) {
			return o.score - score;
		}
	}

	public static int solution(int[] arr, int k) {
		PriorityQueue<State> pq = new PriorityQueue<>();
		pq.add(new State(arr[0], 0));
		int answer = 0;

		for (int i = 1; i < arr.length; i++) {
			while (pq.peek().idx < (i - k)) {
				pq.poll();
			}

			answer = arr[i] + pq.peek().score;
			pq.add(new State(answer, i));
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] arr = {3, -4, 5, 1, 3, -5, -12, 4, -4, 5};
		int k = 3;

		System.out.println(solution(arr, k));
	}
}