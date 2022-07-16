import java.util.Arrays;

// 4번 풀이
// 14점, 효율성(1,2,3) 미통과(시간 초과)


    /*
    14점 - 효율성 테스트 세 개중 2개는 시간 초과, 하나는 실패 - 어느 부분에서 최적화를 해야할 지 궁금합니다.

    중학교 때 배우는 경우의 수 구하는 문제, 1행과 1열에 1씩 표시하고 대각선끼리 더하는 방식을 이용했습니다.
    이 문제도 테스트 때는 멘붕이어서 4점 밖에 못 받았는데 다시 풀어보니까 간단한 문제라서 너무 아쉬웠습니다.
    다른 분들과 비슷하게 (시작 -> 열쇠 경우의수) * (열쇠 -> 마지막 경우의수) 를 통해 구현했습니다.
    다른 분들은 메서드를 이용하셨는데 저도 다음에는 깔끔하게 구현해야겠다 느꼈습니다.
     */


    public static  int solution(int[][] maze) {

        boolean[][] closed; // 잠긴 방 표시
        int mod = 1007;
        int keyRow = -1;
        int keyCol = -1;
        closed = new boolean[maze.length][maze[0].length];

        // closed 처리, 모든 칸에 0 넣기
        // 잠긴 경우
        for(int i = 0; i < maze.length; ++i){
            for(int j = 0; j < maze[i].length; ++j){
                if(maze[i][j] == 1) {
                    closed[i][j] = true;
                    maze[i][j] = 0;     // 잠긴 방을 0으로 안 바꾸면 오류가 나는데 코드 중 어느 부분 때문인지 아직도 모르겠습니다..ㅜㅜ
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

        int first = 0;
        int second = 0;
        maze[0][0] = 1;   // 초깃값

        // first (시작 => key)
        for(int i = 0; i <= keyRow; ++i){
            for(int j = 0;j <= keyCol; ++j){

                // 시작 위치거나나 또는 잠긴 경우 빠져 나간다.
                if(closed[i][j] == true || (i == 0 && j == 0) ){
                    continue;
                }
                // 시작하는 열
                if(j == 0){
                    maze[i][j] += maze[i  - 1][j] % mod;
                    continue;
                }
                // 시작하는 행
                if(i == 0){
                    maze[i][j] += maze[i][j - 1] % mod;
                    continue;
                }
                if(closed[i - 1][j] == true && closed[i][j - 1] == true){
                    continue;
                }

                // 왼쪽 또는 위 closed (한 쪽만 closed)
                if(closed[i - 1][j] == true){
                    maze[i][j] += maze[i][j - 1] % mod;
                    continue;
                }
                if(closed[i][j - 1] == true){
                    maze[i][j] += maze[i - 1][j] % mod;
                    continue;
                }
                // 왼쪽과 위쪽 둘다 더할 수 있는 경우
                maze[i][j] += (maze[i][j - 1] + maze[i  - 1][j]) % mod;
            }
        }
        first = maze[keyRow][keyCol] % mod;

        if(first == 0){         // 첫번째 경우가 0이면 빠져 나간다.
            return  0;
        }
        if(keyRow == maze.length - 1 && keyCol == maze[0].length - 1){  // 도착 위치에 열쇠가 있는 경우는 열쇠 -> 도착 경우의수 구할 필요 없다.
            return first % 1007;
        }

        maze[keyRow][keyCol] = 1;       // 초깃값을 준다.

        // second (key => 마지막)
        for(int i = keyRow;i < maze.length; ++i){
            for(int j = keyCol; j < maze[0].length; ++j){

                // 시작 위치거나 잠겼으면 나간다.
                if(closed[i][j] == true || (i == keyRow && j == keyCol) ){
                    continue;
                }
                // 시작하는 열
                if(j == keyCol){
                    maze[i][j] += maze[i  - 1][j] % mod;
                    continue;
                }
                // 시작하는 행
                if(i == keyRow){
                    maze[i][j] += maze[i][j - 1] % mod;
                    continue;
                }
                // 위에나 왼쪽 까지 모두 잠긴 경우도 나간다.
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
                // 왼쪽과 위 쪽 모두 열린 경우
                maze[i][j] += (maze[i][j - 1] + maze[i  - 1][j]) % mod;
            }
        }
        second = maze[maze.length - 1][maze[0].length  - 1] % mod;
        return (first * second) % mod;
    }
