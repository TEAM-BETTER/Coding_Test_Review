/**
 * 제가 0 개국어여서 읽고 이해하는데 오래걸렸습니다... 
 * 이해하고 보니 릿코드 파스칼 삼각형 과 유사한 문제 여서 똑같이 접근해서 풀었습니다.
 * 윗블럭에서 가져올 아이들 좌 상 우 이렇게 가져오는데 예외처리를 가장 왼쪽 오른쪽
 * 예를들어 이렇게 각각 두개 씩만 가져오면 됩니다.
 *  1 2 3 4
 *  3 3 3 3 // 1번자리 후보군 (1+3),(3+2) , 4번자리 후보군 (3+3),(3+4)
 */

import java.util.*;

class Solution {
    public int solution(int depth, int n, int[][] blocks) {
        if(depth == 0) return blocks[depth][n]; // 1층이라면 그냥 1층 반환해주면 됩니다,
        for (int i = 1; i <= depth; i++) { // 지하 depth 층까지 갈 for문
            for (int j = 0; j < blocks[i].length; j++) {
                if(j == 0){ //0번자리 예외처리
                    blocks[i][j] += Math.min(blocks[i-1][j], blocks[i-1][j+1]);
                }else if(j == blocks[i].length-1){ //끝자리 예외처리
                    blocks[i][j] += Math.min(blocks[i-1][j],blocks[i-1][j-1]);
                }else{
                    int min = Math.min(blocks[i-1][j-1],blocks[i-1][j]); //좌 상 비교
                    min = Math.min(blocks[i-1][j+1],min); //그거에 우 비교
                    blocks[i][j]+=min; //작은 값 토스
                }
            }
        }
    return blocks[depth][n];
}
}