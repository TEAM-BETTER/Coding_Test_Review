/*
- dfs
- Here 클래스 안에 움직인 카운터랑 낮인지 밤인지 체크하는 변수 추가
- 낮이면 0, 2 갈 수 있고 밤이면 0만 가고 2면 제자리에서 카운트만 추가
이런식으로 풀었습니다.

점수는 8 / 20입니다.

 */

import java.util.LinkedList;
import java.util.Queue;

public class CodingTest03 {

    public static int answer;
    public static boolean sun = true;
    public static boolean[][] visited;
    public static final int[][]dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static class Here {
        int a;
        int b;
        int moveCnt;
        boolean sunShine;

        public Here(int a, int b, int moveCnt, boolean sunShine) {
            this.a = a;
            this.b = b;
            this.moveCnt = moveCnt;
            this.sunShine = sunShine;
        }
    }

    public static int solution(int[][] maze) {
        visited = new boolean[maze.length][maze[0].length];

        Queue<Here> queue = new LinkedList<>();
        queue.add(new Here(0, 0, 0, false));
        visited[0][0] = true;

        int answer = -1;

        while(!queue.isEmpty()) {
            Here cur = queue.poll();

            // 밤낮 바꾸는 구간
            if(cur.moveCnt % 5 == 0) {
                cur.sunShine = !cur.sunShine;
            }

            // 끝점 도착
            if(cur.a == maze.length - 1 && cur.b == maze[0].length - 1) {
                answer = cur.moveCnt;
                break;
            }

            for (int[] d : dir) {
                int x = cur.a + d[0];
                int y = cur.b + d[1];
                if(x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && !visited[x][y]) {
                    if(sun) { // 낮이면
                        if(maze[x][y] == 0 || maze[x][y] == 2) { // 2도 이동 가능
                            visited[x][y] = true;
                            queue.offer(new Here(x, y, cur.moveCnt + 1, cur.sunShine));
                        }
                    } else { // 밤이면
                        if(maze[x][y] == 0) { // 0만 이동가능
                            visited[x][y] = true;
                            queue.offer(new Here(x, y, cur.moveCnt + 1, cur.sunShine));
                        }
                        else if(maze[x][y] == 2) { // 2는 가지않고 제자리에 있고 카운트만 늘리기
                            queue.offer(new Here(cur.a, cur.b, cur.moveCnt + 1, cur.sunShine));
                        }
                    }
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        int[][] maze = {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 2, 0, 0}, {1, 1, 0, 1, 0, 1}, {0, 0, 0, 0, 1, 0}, {1, 1, 1, 0, 2, 0}};
//        int[][] maze = {{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}};
        System.out.println(solution(maze));
    }
}
