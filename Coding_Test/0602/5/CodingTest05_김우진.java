package CodingTest2;

public class CodingTest05_김우진 {
    /**
     * 1. yLen과 xLen의 인덱스 값을 순회하는것 => 2차원 배열을 좌표값처럼 순회함
     * 2. 좌상단에서 0.0보다 좌측에 있는 값, 즉 인덱스가 -가 되는 칸은 0임
     *    반대로 우하단값도 yLen,xLen의 인덱스값보다 큰 값의 좌표는 0임
     * 3. 반복문을 돌면서 범위값 자체를 leftY,leftX에 해당하는범위 부터 잡고
     * rightY,rightX값까지 해당하는 범위로 잡아서 그 안에 해당하는 좌표배열만 더한값을 average에 넣어줌
     * 4. answer에는 average값을 k*k로 나눈 값 즉 평균값을 넣어줌
     *
     * @param images
     * @param K
     * @return
     */

    public static int[][] solution(int[][] images, int K) {
        int yLen = images.length; // image 한변의 길이
        int xLen = images[0].length;
        int[][] answer = new int[yLen][xLen];

        for (int y = 0; y < yLen; y++) {
            for (int x = 0; x < xLen; x++) {
                long average = 0;

                // 좌상단 칸
                int leftY = Math.max(0, y - K / 2);
                int leftX = Math.max(0, x - K / 2);
                // 우하단 칸
                int rightY = Math.min(y + K / 2, yLen - 1);
                int rightX = Math.min(x + K / 2, xLen - 1);

                for (int i = leftY; i <= rightY; i++) {
                    for (int j = leftX; j <= rightX; j++) {
                        average += images[i][j];
                    }
                }

                answer[y][x] = (int) (average / (K * K));
            }
        }

        return answer;
    }
}
