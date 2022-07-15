class Solution {
    static int totalEnergy = 0;

    public int solution(int depth, int n, int[][] blocks) {

        totalEnergy += blocks[depth][n]; // 전체 에너지의 합

        int minEnergy = Integer.MAX_VALUE;

        int N = 0;

        for (int i = n-1; i <= n+1; i++) { // 각 depth행에서 가장 작은 값이 들어있는 열을 찾는 for문입니다.
            if (depth > 0) {
                if (i <= blocks[depth - 1].length - 1 && i > -1) {
                    if (blocks[depth - 1][i] < minEnergy) {
                        minEnergy = blocks[depth - 1][i];
                        N = i;
                    }
                }
            } else {
                if (i <= blocks[depth].length - 1 && i > -1) {
                    if (blocks[depth][i] < minEnergy) {
                        minEnergy = blocks[depth][i];
                    }
                }
            }
        }
        
        if (depth != 0) {
            solution(depth - 1, N, blocks); // 맨 아래에서부터 depth를 1씩 줄이면서 재귀함수 돌렸습니다.
        }
        return totalEnergy;
    }


    public static void main(String[] args) {
        int depth = 3;
        int n = 0;
        int[][] blocks = {{1,2,4,1}, {1,6,4,9}, {5,6,9,4}, {55,14,21,14}};
        System.out.println(new Solution().solution(depth, n, blocks));
    }
}
