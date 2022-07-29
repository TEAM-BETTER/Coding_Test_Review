/*
효율성에서 모두 시간초과로 0점 맞은 코드입니다
dp로 안풀어도 될 것 같아서 시도해 봤는데 완전 싪패 ㅠㅠ
(시작점 - > 키 경우의 수) * (키 -> 도착점 경우의 수) 로 계산했습니다
 */
class Solution {
    public int solution(int[][] maze) {
        int answer = 0;
        int[] keyPos = new int[2];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if(maze[i][j] == 2){
                    keyPos[0] = j;      //키 좌표 찾기
                    keyPos[1] = i;
                }
            }
        }
        int toKey = findKey(0,0,keyPos,maze)%1007;      // 시작점 -> 키까지의 경우의 수
        int toEnd = findEnd(keyPos[0],keyPos[1],maze[0].length-1, maze.length-1,maze)%1007;     // 키 -> 도착점까지의 경우의 수
        return (toKey * toEnd)%1007;
    }
    static int findKey(int x, int y, int[] keyPos, int[][] maze){
        if(x > keyPos[0] || y > keyPos[1] || maze[y][x] == 1) return 0;
        else if(maze[y][x] == 2) {
            return 1;
        }
        return findKey(x+1, y, keyPos, maze) + findKey(x, y+1, keyPos, maze);
    }
    static int findEnd(int x, int y, int endX, int endY, int[][] maze){
        if(x > endX || y > endY || maze[y][x] == 1) return 0;
        else if(x == endX && y == endY) {
            return 1;
        }
        return findEnd(x+1, y, endX, endY, maze) + findEnd(x, y+1, endX, endY, maze);
    }
}