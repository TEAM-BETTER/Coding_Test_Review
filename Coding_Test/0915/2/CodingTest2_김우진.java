package CodingTest17;

/**
 * 이게 왜 통과인지 모르겠습니다
 * 문제 풀이 당시, 정확성 10점 / 효율성 시간초과로 인해 정렬되는 부분 삭제 후 돌려봤더니 통과해서 당황스러웠던............
 * 아래 주석처리 되지 않은 답이 정확성 10점 효율성 모두 시간 초과의 답안입니다.
 *
 * a : player A의 득점 b : player B의 득점 visited : value배열에서 값 사용했는지 확인용 boolean
 * 한번에 A와 B가 득점하기때문에 value.length/2 만 반복합니다
 * 먼저 A 플레이어가 득점 할 때, value[0]이 높은 순으로 정렬 후, 사용하지 않은 가장 높은 값 득점
 * 먼저 B 플레이어가 득점 할 때, value[1]이 높은 순으로 정렬 후, 사용하지 않은 가장 높은 값 득점
 * 최종 득점 확인 후 A가 높으면 1, B가 높으면 -1, 동점이면 0 리턴
 *
 * ** 지금 생각해보니 value 배열 정렬되면서 visited 배열은 정렬되지 않으니 이것 또한 오류가 될 수 있습니다.
 * *** 정답 답안지를 확인 해 보고, 다시 공부해봐야겠습니다.
 *
 */

// 현재 정답처리 된 답안 : 무시하셔도 좋습니다
//    public static int solution(int[][] value) {
//        int a = 0;
//        int b = 0;
//        for (int i = 0; i < value.length / 2; i++) {
//            for (int j = 0; j < 2; j++) {
//                a += value[i][0];
//                b += value[i][1];
//            }
//        }
//        return Integer.compare(a, b);
//    }

import java.util.Arrays;
import java.util.Comparator;

// 정확성 10점 / 효율성 시간초과
public class CodingTest2_김우진 {

    public static int solution(int[][] value) {

        boolean[] visited = new boolean[value.length];

        int a = 0;
        int b = 0;

        for (int i = 0; i < value.length / 2; i++) {

            Arrays.sort(value, Comparator.comparingInt(o1 -> o1[0]));
            for (int j = value.length - 1; j >= 0; j--) {
                if (!visited[j]) {
                    a += value[j][0];
                    visited[j] = true;
                    break;
                }
            }

            Arrays.sort(value, Comparator.comparingInt(o1 -> o1[1]));
            for (int j = value.length - 1; j >= 0; j--) {
                if (!visited[j]) {
                    b += value[j][1];
                    visited[j] = true;
                    break;
                }
            }
        }

        return Integer.compare(a, b);
    }

    public static void main(String[] args) {
        int[][] value = {{5, 3}, {6, 9}, {4, 5}, {6, 3}, {2, 8}, {5, 4}};
        System.out.println(solution(value));
    }
}