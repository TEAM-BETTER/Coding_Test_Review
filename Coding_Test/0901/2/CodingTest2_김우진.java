package CodingTest15;

import static java.lang.Math.*;

import java.util.Arrays;

/**
 *    주어진 배열 buckets 을 오름차순 정렬한 후, 이분탐색
 *
 *    left = 1; right = buckets[len - 1]; mid = (left + right) / 2;
 *
 *    mid 값을 최소 거리 후보값으로 두고 isCandidate 메서드에서 체크
 *
 *    isCandidate : 처음 bucket을 기준으로 mid 간격으로 몇 개의 공을 위치할 수 있는지 확인
 *   즉, placed는 농구공 개수, placed 가 m 보다 큰 수가 되는지 체크
 *
 *    isCandidate 가 true 면 answer 을 업데이트해주고,
 *    최적의 값을 찾기위해 left = mid + 1로 업데이트해서 다시 탐색
 *
 *    isCandidate 가 false면 right = mid - 1로 업데이트 해서 다시 탐색
 *
 *    left값이 right값을 만날때까지 isCandidate 로 이분탐색 반복해서 최적의 값을 탐색한다.
 *
 */

public class CodingTest2_김우진 {

	static boolean isCandidate(int distance, int[] buckets, int m) {
		int placed = 1;
		int cur = buckets[0];

		for (int bucket : buckets) {
			if (bucket - cur >= distance) {
				placed++;

				cur = bucket;
			}
		}

		return placed >= m;
	}

	public static int solution(int[] buckets, int m) {
		Arrays.sort(buckets);

		int len = buckets.length;
		int left = 1;
		int right = buckets[len - 1];
		int answer = 0;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (isCandidate(mid, buckets, m)) {
				answer = max(answer, mid);
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return answer;
	}
}
