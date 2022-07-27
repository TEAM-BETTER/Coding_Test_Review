package ch04.codingTest9.p1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 벨만포드 알고리즘으로 풀었습니다.
// 시작점에서 모든 곳으로 갈 수 있는 최소거리를 구할 수 있어서 벨만포드를 사용하였습니다.
public class Solution {
    public static int solution(int N, int[][] friend, int[][] time) {
        int answer = 0;
        int INF = Integer.MAX_VALUE;                          // cost 배열을 채울 때 쓰기위한 무한대값
        int[] cost = new int[N];                              // 모든 친구에게 퍼지는 시간을 기록할 배열
        Arrays.fill(cost, INF);                                // 배열 초기화
        cost[0] = 0;                                          // 시작점 초기화

        for (int i = 0; i < N; i++) {                         // 벨만포드 (음의 가중치가 없으므로 v+1 번째는 제외)
            for (int j = 0; j < friend.length; j++) {
                for (int k = 0; k < friend[j].length; k++) {
                    if (cost[j] != INF) {
                        if (cost[friend[j][k]] > cost[j] + time[j][k]) {
                            cost[friend[j][k]] = cost[j] + time[j][k];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {               // 모든 친구에게 퍼지는 시간 중 INF 값이 있으면 -1 리턴
            if (cost[i] == INF) {
                return -1;
            } else {
                answer = Math.max(answer, cost[i]); // 아니라면 가장 큰 값을 받아 리턴
            }
        }

        return answer;
    }

    // 테스트 케이스를 읽을 때 사용한 함수 입니다. 무시하셔도 됩니다.
    public static int[][] fileReader(String address, int[][] a) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader(address));
        String str;
        boolean input = false;
        List<Integer> aa = new ArrayList<>();
        List<List<Integer>> alist = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int row = 0;

        while ((str = bf.readLine()) != null) {
            for (int i = 0; i < str.length(); i++) {
                char m = str.charAt(i);
                switch (m) {
                    case ',':
                        if (input) {
                            aa.add(Integer.valueOf(sb.toString()));
                            sb = new StringBuilder();
                        }
                        break;
                    case '[':
                        input = true;
                        aa = new ArrayList<>();
                        break;
                    case ']':
                        aa.add(Integer.valueOf(sb.toString()));
                        sb = new StringBuilder();
                        alist.add(aa);
                        input = false;
                        break;
                    case ' ':
                        break;
                    default:
                        sb.append(m);
                        break;
                }
            }
        }
        a = new int[alist.size()][];
        for (int i = 0; i < alist.size(); i++) {
            a[i] = alist.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        int[][] a = new int[][]{{1, 4}, {2, 3}, {4}, {1, 3}, {0, 2}};
        int[][] b = new int[][]{{5, 2}, {6, 4}, {9}, {1, 5}, {2, 6}};
//        System.out.println(solution(5, a, b));

//        a = new int[][]{{1, 3}, {0}, {0}, {2}, {1, 2}};
//        b = new int[][]{{10, 3}, {8}, {4}, {8}, {19, 2}};
//        System.out.println(solution(5, a, b));
        a = new int[][]{};
        b = new int[][]{};

        String address = "/Users/isihwa/workspace/zerobase/강의자료/코테_답안/0721/테스트케이스/problem1/acc_test/4_i aa.txt";
        a = fileReader(address, a);
        address = "/Users/isihwa/workspace/zerobase/강의자료/코테_답안/0721/테스트케이스/problem1/acc_test/4_i bb.txt";
        b = fileReader(address, b);
        System.out.println(solution(500, a, b));
        System.out.println("정답 : " + 4);

    }
}
