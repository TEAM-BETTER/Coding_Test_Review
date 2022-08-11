// 백준 알고리즘 중 똑같은 문제가 있습니다. (2178번 미로탐색)
// 출발점부터 특정 지점까지 도달하기 위해 이동한 횟수를 저장하는 2차원 배열 map을 만들었습니다.
// map의 출발지점부터 각 칸 까지 1씩 늘려가며 bfs로 탐색했습니다.
// map의 도착지점에는 최단거리로 이동한 횟수가 저장되며, 0이라면 탈출할 수 없는 경우입니다.

import java.util.LinkedList;
import java.util.Queue;


public class CodingTest05_임요한 {

    static int[] LR = {1, -1, 0, 0};
    static int[] UD = {0, 0, 1, -1};

    static int[][] map;

    public int solution(int N, int M, int[][] maze) {
        int answer = 0;

        map = new int[N][M];

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int X = now[0];
            int Y = now[1];

            for (int i = 0; i < LR.length; i++) {
                int ud = X + UD[i];
                int lr = Y + LR[i];

                if (ud < 0 || ud >= map.length || lr < 0 || lr >= map[0].length) {
                    continue;
                }

                if (map[ud][lr] != 0 || maze[ud][lr] != 0) {
                    continue;
                }

                q.add(new int[]{ud, lr});
                map[ud][lr] += map[X][Y] + 1;
            }
        }
        return map[N - 1][M - 1] == 0 ? -1 : map[N - 1][M - 1];
    }
}