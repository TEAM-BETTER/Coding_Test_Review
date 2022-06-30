// 이번문제는 비슷한 문제를 바로 전날 알고리즘 소모임에서 풀었고, 빠르게 풀어갈수 있었습니다.
// https://www.acmicpc.net/problem/1654(백준 전선 문제입니다.)
// 지팡이 의 모든 길이를 더해 원하는길이만큼 나눈다면 그걸 최대의 수로 지정후 이분탐색을 진행했습니다.

import java.util.*;

class CodingTest04_박귀우 {
    public int solution(int n, int[] number) {
        int left = 1;
        int right = Arrays.stream(number).sum() / n;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int rs = 0;
            for (int i = 0; i < number.length; i++) {
                rs += number[i] / mid;
            }
            // 이번에 break 를 작성하지 않은 이유는 현재의 값보다 더 최적의 값이 나올수 있어
            // left right 교차지점 까지 탐색을 진행해줍니다.
            if (rs >= n) {
                answer = Math.max(mid, answer);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
