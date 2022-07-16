import java.util.Arrays;
// 2. 삽질의 대가
// 20점, 0.xx ms

    /*
    프로그래머스의 정수 삼각형과 유사한 문제라서 비슷하게 풀었습니다.
    문제 제출할 때는 거꾸로(상향식) 구현하려다가 꼬이는 바람에 4점 밖에 못 받았는데
    토요일에 다시 하향식으로 구현하니까 답이 나와 아쉽네요..
    */

    public static int solution(int depth, int n, int[][] blocks) {

        if(depth == 0){
            return blocks[depth][n];
        }

        for(int i = 1; i <= depth; ++i) {       // depth행까지 내려간다.
            for (int j = 0; j < blocks[i].length; ++j) {
                if (j == 0) {
                    blocks[i][j] += Math.min(blocks[i - 1][j], blocks[i - 1][j + 1]);
                } else if (j == blocks[i].length - 1) {
                    blocks[i][j] += Math.min(blocks[i - 1][j - 1], blocks[i - 1][j]);
                } else {
                    blocks[i][j] += Math.min(Math.min(blocks[i - 1][j - 1], blocks[i - 1][j]), blocks[i - 1][j + 1]);
                }
            }
        }
        return blocks[depth][n];
    }
