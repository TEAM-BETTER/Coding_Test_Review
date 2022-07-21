package ch04.codingTest8.p3;


import java.util.PriorityQueue;

// 그리디로 알고리즘으로 가장 큰 값부터 선택하면 될 줄 알았는데 전혀 되지 안았습니다.
// 다시 생각해보니 옛날에 풀었던 계단 올라가기 문제와 비슷한것 같습니다.
// 계단 문제는 https://www.acmicpc.net/problem/2579 이것 입니다.
public class Solution {
    public int solution(int N, int[] rewards) {
        int answer = 0;
        boolean[] isKilled = new boolean[rewards.length]; // 죽인 성을 확인하기위한 배열

        PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> y[1] - x[1]); // 보상이 가장 큰 값을 꺼내기 위한 PQ
        for (int i = 0; i < rewards.length; i++) {                               // PQ 에 모든 성에 대한 정보 입력
            queue.add(new int[]{i, rewards[i]});
        }

        while (!queue.isEmpty()) {                                              // PQ가 빌 떄 까지 시행
            int[] now = queue.poll();

            if (!isKilled[now[0]]) {                                            // 방문할 수 있는 성인지 확인
                for (int i = -1; i <= 1; i++) {                                 // 방문 가능하다면 방문 후 주변 성 방문 못하도록 boolean 배열 업데이트
                    isKilled[circleNum(now[0] + i, rewards.length)] = true;
                }
                answer += rewards[now[0]];
            }
        }

        return answer;
    }

    public static int circleNum(int n, int leg) {                               // 원형 배열 숫자 확인하기위한 메소드
        if (n == -1) {
            return leg - 1;
        }

        if (n == leg) {
            return 0;
        }

        return n;
    }
}

