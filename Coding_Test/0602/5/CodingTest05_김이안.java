/*
    제 기준에서는 제일 쉬운 문제였습니다.
    영상처리를 이미 경험해봐서 그런지 문제 이해하기도 쉬웠습니다.
*/
class Solution {
    public static int pixel(int[][] image, int col, int row, int K){
        int sum = 0;
        int a = K/2;
        for (int i = col - K/2; i <= col + K/2; i++) {  // 행 인덱스 - K/2 ~ 행 인덱스 + K/2
            for (int j = row - K/2; j <= row + K/2; j++) {  // 열 인덱스 - K/2 ~ 열 인덱스 + K/2
                if(i >= 0 && i < image.length && j >= 0 && j < image[0].length){    // 인덱스 범위 안쪽 값만 더해줍니다.
                    sum += image[i][j];
                }
            }
        }
        return sum/(K*K);
    }
    public int[][] solution(int[][] image, int K) {
        int[][] answer = new int[image.length][image[0].length];
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                answer[i][j] = pixel(image, i, j, K);       // 계산한 값을 answer 배열에 추가
            }
        }
        return answer;
    }
}