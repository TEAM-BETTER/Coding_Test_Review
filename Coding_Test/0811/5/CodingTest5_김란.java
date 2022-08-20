/*
5번 - 20점
엊그제 백준에서 풀었던 문제가 나와서 놀랐습니다.
기존의 BFS 문제에서 벽을 한번 깰 수 있다는 조건이 추가된 문제입니다.
먼저, Position 클래스를 만들어서 (row, col, 거리, broken) 매개변수로 줬습니다.
그러고나서 while문 안의 for문 내용을 구성하는 부분이 까다로웠습니다.
for문 안에는 벽을 만난 경우와 벽이 아닌 경우로 나누고
각각 벽을 부순적 있는 경우, 없는 경우로 나누어 Queue에 새로운 Position을 담아주도록 구현했습니다.
그리고 visited배열은 부순적 있는지 없는지까지 구분할 수 있도록 3차원으로 구현했습니다.
 */

import java.util.LinkedList;
import java.util.Queue;

class CodingTest5_김란 {

    static int[][] direction = {{-1, 0}, {1,  0}, {0, -1}, {0, 1}};
    static class Position{
        int row;
        int col;
        int dis;
        boolean broken;
        public Position(int row, int col, int dis, boolean broken) {
            this.row = row;
            this.col = col;
            this.dis = dis;
            this.broken = broken;
        }
    }

    public  static  int solution(int N, int M, int[][] maze) {

        Queue<Position> q = new LinkedList<>();
        q.add(new Position(0, 0, 0, false));
//        System.out.println("currRow: " + 0 +  ", currCol: " + 0);

        boolean[][][] visited = new boolean[N][M][2];
        // (row, col)까지 오는 동안 벽을 부순적이 있으면 visited[row][col][1] = true
        // (row, col)까지 오는 동안 벽을 부순적이 없으면 visited[row][col][0] = true

        while (!q.isEmpty()) {
            Position currPosition = q.poll();
            int currRow = currPosition.row;
            int currCol = currPosition.col;
            int currDis = currPosition.dis;

            // 목적지에 도달한 경우 - 탈출 조건
            if (currPosition.row == N - 1 && currPosition.col == M - 1) {
                return currPosition.dis;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = currRow + direction[i][0];
                int nextCol = currCol + direction[i][1];
                int nextDis = currDis + 1;

                if(nextRow < 0 || nextRow >= N ||
                   nextCol < 0 || nextCol >= M) continue;

                // 벽이 아닌 경우 => 부술 필요 없이 그냥 지날 수 있다.
                if(maze[nextRow][nextCol] == 0 ){
                    if(!currPosition.broken && !visited[nextRow][nextCol][0]){      // 부순 적 없으면
                        visited[nextRow][nextCol][0] = true;
                        q.add(new Position(nextRow, nextCol, nextDis, false));

                    }else if(currPosition.broken && !visited[nextRow][nextCol][1]){  // 부순 적 있으면
                        visited[nextRow][nextCol][1] = true;
                        q.add(new Position(nextRow, nextCol, nextDis,true));
                    }
//                     System.out.printf("(%d, %d) -> (%d, %d)%n", currPosition.row, currPosition.col, nextRow, nextCol);

                // 벽인 경우 - 부술 수 있는 경우에만 실행
                }else if(maze[nextRow][nextCol] == 1 && !currPosition.broken){
                    q.add(new Position(nextRow, nextCol, nextDis, true));
                    visited[nextRow][nextCol][1] = true;
                }
            }
        }
        // 목표 지점에 도달하지 못했는데 Queue가 비어 있는 경우에만 실행되는 반환값 -1
        return  -1;
    }

    public static void main(String[] args) {

        int[][] maze = {{0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 1, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 0, 1, 0, 1},
                        {0, 0, 0, 0, 1, 0},
                        {1, 1, 1, 0, 0, 0}};
        System.out.println(solution(6, 6, maze));   // 10

        maze = new int[][]{

                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0}};
        System.out.println(solution(5, 5, maze));   // 8
    }
}
