// 문제에서 시키는대로 직접 평균 구해서 넣었습니다.
class Solution {
    public int[][] solution(int[][] image, int K) {
        int[][] answer = new int[image.length][image[0].length];
        int len = K / 2; // 정 중앙을 기준으로 탐색해야 하는 길이
        int row = answer.length;
        int col = answer[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                answer[i][j] = getAvg(i, j, len, answer, image);
            }
        }
        return answer;
    }

    public int getAvg(int i, int j, int len, int[][] answer, int[][] image) {
        int row = answer.length;
        int col = answer[0].length;
        int k = 2 * len + 1;
        int sum = 0;

        for(int a = i - len; a <= i + len; a++) {
            for(int b = j - len; b <= j + len; b++) {
                if (a < 0 || a >= row || b < 0 || b >= col) continue;
                sum += image[a][b];
            }
        }

        return sum / (k * k);
    }
}