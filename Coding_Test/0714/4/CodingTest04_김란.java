public class CodingTest04_김란 {

    public int solution(int[][] maze){
        boolean[][] closed;
        int mod = 1007;
        int keyRow = -1;
        int keyCol = -1;
        closed = new boolean[maze.length][maze[0].length]; // 잠긴 방 체크

        // closed 처리, 모든 칸에 0 넣기
        // 잠긴 경우
        for(int i = 0; i < maze.length; ++i){
            for(int j = 0; j < maze[i].length; ++j){
                if(maze[i][j] == 1) {
                    closed[i][j] = true;
                    maze[i][j] = 0;     // 잠긴 방을 0으로 안 바꾸면 오류가 나네.. (위에나 왼쪽에 잠긴 방이 있는 경우에 더해서 그럴텐데?)
                }
            }
        }
        // 열쇠 행, 열의 값을 찾는다.
        for(int i = 0; i < maze.length; ++i){
            for(int j = 0; j < maze[i].length; ++j) {
                if (maze[i][j] == 2) {
                    keyRow = i;
                    keyCol = j;
                    maze[i][j] = 0;
                    break;
                }
            }
            if(keyRow != -1){
                break;
            }
        }
//        System.out.println(keyRow);
//        System.out.println(keyCol);

        int first = 0;
        int second = 0;
        maze[0][0] = 1;   // 초깃값

        // first (시작 => key)
        for(int i = 0; i <= keyRow; ++i){
            for(int j = 0;j <= keyCol; ++j){

                // 시작 위치거나나 또는 잠긴 경우 또는 왼쪽, 위쪽 모두 막힌 경우 빠져 나간다.
                if(closed[i][j] == true || (i == 0 && j == 0) ){
                    continue;
                }
                // open
                if(j == 0){
                    maze[i][j] += maze[i  - 1][j] % mod;  // 등호도 상관 없을듯어차피 0이니깐
                    continue;
                }
                if(i == 0){
                    maze[i][j] += maze[i][j - 1] % mod;
                    continue;
                }
                if(closed[i - 1][j] == true && closed[i][j - 1] == true){
                    continue;
                }

                // 왼쪽 또는 위 (한 쪽만 closed)
                if(closed[i - 1][j] == true){
                    maze[i][j] += maze[i][j - 1] % mod;
                    continue;
                }
                if(closed[i][j - 1] == true){
                    maze[i][j] += maze[i - 1][j] % mod;
                    continue;
                }
                maze[i][j] += (maze[i][j - 1]  + maze[i  - 1][j]) % mod;
            }
        }

        first = maze[keyRow][keyCol] % mod;     //
//        System.out.println("first : " + first);

        if(first == 0){
            return  0;
        }
        if(keyRow == maze.length - 1 && keyCol == maze[0].length - 1){  // 도착위치에 열쇠가 있는 경우
            return first % 1007;
        }

        maze[keyRow][keyCol] = 1;       // 초깃값을 준다.

        // second (key => 마지막)
        for(int i = keyRow;i < maze.length; ++i){
            for(int j = keyCol; j < maze[0].length; ++j){

                // 시작위치거나 잠겼으면 나간다. 위에나 왼쪽 까지 모두 잠긴 경우도 나간다.
                if(closed[i][j] == true || (i == keyRow && j == keyCol) ){
                    continue;
                }
                // open
                if(j == keyCol){
                    maze[i][j] += maze[i  - 1][j] % mod;
                    continue;
                }
                if(i == keyRow){
                    maze[i][j] += maze[i][j - 1] % mod;
                    continue;
                }
                if(closed[i - 1][j] == true && closed[i][j - 1] == true){
                    continue;
                }

                // 왼쪽 또는 위 한 쪽만 잠긴 경우
                if(closed[i - 1][j] == true){
                    maze[i][j] += maze[i][j - 1] % mod;
                    continue;
                }
                if(closed[i][j - 1] == true){
                    maze[i][j] += maze[i - 1][j] % mod;
                    continue;
                }
                maze[i][j] += (maze[i][j - 1] + maze[i  - 1][j]) % mod;
            }
        }
        second = maze[maze.length - 1][maze[0].length  - 1] % mod;
//        System.out.println("second : " + second);

        // maze행렬 확인
//        for(int[] m : maze){
//            System.out.println(Arrays.toString(m));
//        }

        return (first * second) % mod;
    }

}
