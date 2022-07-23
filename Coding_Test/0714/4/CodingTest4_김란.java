//import java.util.Arrays;
//// 4번 문제 틀림
//public class Test4 {
//
//    public static  int solution(int[][] maze) {
//
//        for(int i = 0;i < maze.length; ++i){
//            for(int j = 0;j < maze[i].length; ++j){
//                if (maze[i][j] == 1){
//                    maze[i][j] = -1;
//                }
//            }
//        }
//        int answer1 = 0;
//        int answer2 = 0;
//
//        int mod = 1007;
//        int[][] dp = new int[maze.length + 1][maze[0].length + 1];
//
//        // 1은 잠긴방, 2는 열쇠 가지고 마지막 까지 간다.
//        // 오른쪽 또는 아래쪽쪽
//
//        maze[0][0] = 1; // 출발지점
//
//        int keyRow = 0;
//        int keyCol = 0;
//
//
//        for(int i = 0; i < maze.length; ++i){
//            for(int j = 0; j < maze[i].length; ++j){
//
//                if(i < maze.length - 1 && j < maze[0].length - 1 && maze[i+1][j] == -1 && maze[i][j + 1] == -1){
//                    return 0;
//                }
//
//                if(maze[i][j] == 1){    // 잠긴 방
//                    continue;
//                }
//                if((i == 0 || j == 0) && maze[i][j] != 2 && maze[i][j] != -1){
//                    maze[i][j] += 1;
//                }
//                if(maze[i][j] == 2){
//                    answer1 = maze[i-1][j] +  maze[i][j -1];
//                     keyRow = i;
//                     keyCol = j;
//
//                    break;
//                }
//            }
//        }
//
//        System.out.println(keyRow);
//        System.out.println(keyCol);
//        maze[keyRow][keyCol] = 1;
//
//        for(int i = keyRow; i < maze.length; ++i){      // 1 ~ 2까지
//            for(int j = keyCol; j < maze[i].length; ++j){
//
//                // 얄쇠 다음행열 부터 시작하는데
//                // 여기서 위에나 왼쪽이 -1(잠)
//                // 또는 현위치가 잠긴 때  -1는 경우의 수를 더하지 않는다.
//                if(i == keyRow && j == keyCol){
//                    maze[keyRow][keyCol] = 1;
//                    continue;
//                }
//
//                if(maze[i][j] == -1) {
//                    continue;
//                }
//
//                // 위에만 잠김
//                if(maze[i - 1][j] == -1){
//                    maze[i][j] += maze[i][j - 1];
//                    continue;
//                }
//                // 왼쪽 잠김
//                if(maze[i][j - 1] == -1){
//                    maze[i][j] += maze[i - 1][j];
//                    continue;
//                }
//
//                // 둘다 안 잠긴때
//                 maze[i][j] = maze[i-1][j] = maze[i][j-1];
//            }
//        }
//        answer2 = maze[maze.length - 1][maze[0].length - 1];
//
//        for(int[] m: maze){
//            System.out.println(Arrays.toString(m));
//        }
//
//        return answer1 * answer2;
//    }
//
//    public static void main(String[] args) {
//
//        int[][] maze = {{0, 1, 0, 0}, {1, 2, 0, 0}, {1, 0, 0, 0}};  // 0
//        System.out.println(solution(maze));
//        System.out.println();
//
//        maze = new int[][]{{0, 1, 0}, {0, 2, 0}, {1, 0, 0}};
//        System.out.println(solution(maze)); // 2
//        System.out.println();
//
//
//        maze = new int[][]{{0, 1, 0, 0},
//                            {0, 0, 0, 1},
//                            {1, 0, 2, 0},
//                            {0, 0, 0, 0}};
//        System.out.println(solution(maze)); // 2
//
//
//
//    }
//}
