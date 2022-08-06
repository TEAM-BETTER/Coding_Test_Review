
/*

5.미로 탈출 넘버원 - 20점

전에 코드업에서 비슷한 문제를 보았던 기억이 나네요.
기존의 BFS 코드와 다른 점이 있다면 최단 거리를 구하기 위한 부분입니다.
목표 지점까지 왔을 때, 지금까지의 최단 거리보다 현재 거리가 짧으면 업데이트해줘야 합니다.
그리고 목표 지점까지 못 가는 경우를 대비해서 flag 라는 변수를 선언하고 바뀌지 않으면 불가능이라 판단하여
-1을 반환하도록 로직을 짰습니다.

 */


import java.util.LinkedList;
import java.util.Queue;

public class CodingTest5_김란 {
    static int[][] DirMatrix = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int ColumnCnt;
    static int RowCnt;
    static int[][] VisitMatrix;
    static Queue<Integer> queueRow = new LinkedList<>();
    static Queue<Integer> queueCol = new LinkedList<>();
    static Queue<Integer> queueDistance = new LinkedList<>();
    static int ShortestDistance = Integer.MAX_VALUE;
    static int Distance = 0;
    static int flag = 0;

    public static int solution(int N, int M, int[][] maze) {

        VisitMatrix = new int[N][M];
        RowCnt = N;
        ColumnCnt = M;
        BFSmethod(0, 0, N - 1, M - 1, maze);
        if(flag == 0) {
            return -1;
        }
        return ShortestDistance;
    }

    public static void BFSmethod(int _startRow, int _startCol, int targetRow, int targetCol, int[][] maze) {

        VisitMatrix[_startRow][_startCol] = 1;
        queueRow.offer(_startRow);
        queueCol.offer(_startCol);
        queueDistance.offer(Distance);

//        System.out.println();
//        System.out.printf("시작: (%d, %d)\n", _startRow, _startCol);

        while(false == queueRow.isEmpty() && false == queueCol.isEmpty()) {

            int currRow = queueRow.poll();
            int currCol = queueCol.poll();
            int currDis = queueDistance.poll();

            if(currRow == targetRow && currCol == targetCol) {  // 목표 지점 도착
                flag = 1;
                if(currDis < ShortestDistance) {        // 더 짧은 길이 있다면? 업데이트한다.
                    ShortestDistance = currDis;
                }
                return;
            }
            for(int i = 0; i < 4; ++i) {

                int nextRow = currRow + DirMatrix[i][0];
                int nextCol = currCol + DirMatrix[i][1];
                int nextDis = currDis + 1;

                if(0 > nextRow || nextRow >= RowCnt || 0 > nextCol || nextCol >= ColumnCnt ){
                    continue;
                }
                if(1 == VisitMatrix[nextRow][nextCol] ) continue;

                if(0 == maze[nextRow][nextCol]) {

                    VisitMatrix[nextRow][nextCol] = 1;
                    queueRow.offer(nextRow);
                    queueCol.offer(nextCol);
                    queueDistance.offer(nextDis);
//                    System.out.printf("[%d]: (%d, %d)->(%d, %d)\n", nextDis, currRow, currCol, nextRow, nextCol) ;
                }
            }
        }
    }
    public static void main(String[] args) {

        int[][] maze = {{0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 1, 1, 0},
                        {0, 1, 0, 0, 0, 0},
                        {1, 1, 0, 1, 0, 1},
                        {0, 0, 0, 0, 1, 0},
                        {1, 1, 1, 0, 0, 0}};
        System.out.println(solution(6, 6, maze));   // 16
    }
}