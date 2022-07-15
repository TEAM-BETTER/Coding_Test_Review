import java.util.Arrays;

class CodingTest02_임요한 {
    static int totalEnergy = 0;

    static int minEnergy = Integer.MAX_VALUE;

    public int solution(int depth, int n, int[][] blocks) {

        if (depth == 0) {
            return 0;
        }

        totalEnergy += blocks[depth][n]; // 전체 에너지의 합
        minEnergy = Integer.MAX_VALUE; // depth에서 가장 작은 블럭의 에너지

        int N = 0;

        for (int i = n-1; i <= n+1; i++) { // 각 depth행에서 가장 작은 값이 들어있는 열을 찾는 for문입니다.
            if (i <= blocks[depth - 1].length - 1 && i > -1) {
                if (depth - 1 == 0) { //
                    Arrays.sort(blocks[0]);
                    totalEnergy += blocks[0][0];
                    break;
                } else if (blocks[depth - 1][i] < minEnergy) {
                    minEnergy = blocks[depth - 1][i];
                    N = i;
                }
            }
        }
        solution(depth-1, N, blocks); // 맨 아래에서부터 depth를 1씩 줄이면서 재귀함수 돌렸습니다.

        return totalEnergy;
    }


    public static void main(String[] args) {
        int depth = 3;
        int n = 3;
        int[][] blocks = {{5,6,2,6}, {1,6,4,9}, {5,6,9,4}, {55,14,21,14}};

        System.out.println(new CodingTest02_임요한().solution(depth, n, blocks));
    }
}