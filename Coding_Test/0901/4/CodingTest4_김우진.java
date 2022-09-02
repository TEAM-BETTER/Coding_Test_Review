package CodingTest15;

import java.util.*;

public class CodingTest4_김우진 {

	/**
	 * numsDivide 의 중복 제거를 위해 divideSet 에 numsDivide 배열 값 add
	 *
	 * divide2cnt에 해당 값이 몇개가 들어갔는지 체크하기 위해,
	 * map 형식으로 키에는 배열의 값 그리고 밸류에 카운트 세어줌
	 *
	 * numsDivided 도 중복제거를 위해 dividedSet 에 numsDivided배열 값 add
	 *
	 * divideSet의 첫번째 값은 divide,
	 * dividedSet의 값들이 divide로 나누었을때 나머지가 0인지 확인
	 *
	 * 모두 나눠질 경우 조건을 충족하므로 answer를 출력
	 * 모두 나눠지지 않을 경우 divide를 삭제한 후 answer에 divide 개수 더함
	 *
	 * divideSet에 값이 남아 있지 않으면 -1 출력
	 *
	 */

	static Set<Integer> divideSet = new HashSet<>();

	static Map<Integer, Integer> divide2cnt = new HashMap<>();

	static Set<Integer> dividedSet = new HashSet<>();

	public static int solution(int[] numsDivide, int[] numsDivided) {
		for (int num : numsDivide) {
			divideSet.add(num);

			Integer cnt = divide2cnt.get(num);
			if (cnt == null) {
				divide2cnt.put(num, 1);
			} else {
				divide2cnt.put(num, cnt + 1);
			}
		}

		for (int num : numsDivided) {
			dividedSet.add(num);
		}

		int answer = 0;

		while (!divideSet.isEmpty()) {
			Integer divide = divideSet.stream().findFirst().orElse(null);
			boolean allDividable = true;

			for (int divided : dividedSet) {
				if (divided % divide != 0) {
					allDividable = false;

					break;
				}
			}

			if (allDividable) {
				return answer;
			}

			answer += divide2cnt.get(divide);
			divideSet.remove(divide);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] numsDivide = { 2, 9, 3, 6, 2, 4, 3 };
		int[] numsDivided = { 9, 18, 27, 9, 15 };

		System.out.println(solution(numsDivide, numsDivided));
	}
}
