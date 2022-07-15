
/**
 * 음 냅다 bfs 시전하고 테케만 통과하고 다틀렸습니다. ㅎㅎ
 * 끝나고 이안님이랑 이야기 나누고 보니 key 를 기준으로 나눠서 돌리면 되겠더라고요.. ㅠ
 * 토요일날 테스트해보고 업데이트 하겠습니다 .!
 * row,col 을 이용해서 오른쪽 혹은 아래로만 갈수 있기떄문에 방향설정
 * bfs 를 작성하다 보니 키를 현재 가지고 있는지 판별하기가 어려워서 그냥 배열을 한칸더만들어 주어서 해결했습니다.
 */

import java.util.*;

class Solution {
    int count;

    public int solution(int[][] maze) {
        int count = 0;
        int row = 0, col = 0;
        int[] dirs = { 0, 1, 0 };
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { row, col, keyCheck(row, col, maze) });
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            int key = pos[2];
            if (pos[0] == maze.length - 1 && pos[1] == maze[0].length - 1 && pos[2] != 0) {
                count++;
            }
            for (int i = 1; i < dirs.length; i++) {
                int nRow = pos[0] + dirs[i - 1];
                int nCol = pos[1] + dirs[i];
                if (0 <= nRow && 0 <= nCol && nRow < maze.length && nCol < maze[0].length && maze[nRow][nCol] != 1) {
                    if (key == 2) {
                        q.add(new int[] { nRow, nCol, key });
                    } else {
                        q.add(new int[] { nRow, nCol, keyCheck(nRow, nCol, maze) });
                    }
                }
            }
        }
        return count % 1007;
    }

    public int keyCheck(int row, int col, int[][] maze) {
        if (maze[row][col] == 2)
            return 2;
        return 0;
    }
}
