/*
프로그래머스 정수 삼각형 문제랑 비슷해서 금방 풀었던 문제였습니다
탑다운으로 계산했습니다!
*/
class Solution {
    public int solution(int depth, int n, int[][] blocks) {
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < depth; i++) {       // 두번째 열부터 depth 이전 인덱스 까지만 계산
            for (int j = 0; j < blocks[i].length; j++) {
                int min = Integer.MAX_VALUE;
                int curVal = blocks[i][j];
                if(j-1>0) min = Math.min(blocks[i-1][j-1] + curVal,min);
                if(j+1< blocks[i-1].length) min = Math.min(blocks[i-1][j+1] + curVal,min);
                min = Math.min(blocks[i-1][j] + curVal,min);        //해당 인덱스를 윗열중 최소 값을 더해줍니다.
                blocks[i][j] = min;
            }
        }
        //depth 인덱스 계산
        if(n-1>0) answer = Math.min(blocks[depth-1][n-1] + blocks[depth][n],answer);
        if(n+1< blocks[depth-1].length) answer = Math.min(blocks[depth-1][n+1] + blocks[depth][n],answer);
        answer = Math.min(blocks[depth-1][n] + blocks[depth][n],answer);
        return answer;
    }
}