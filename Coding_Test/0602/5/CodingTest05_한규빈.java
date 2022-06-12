package codingTest5;

public class CodingTest05_한규빈 {
    public static int[][] solution(int[][] image, int K) {
        int[][] answer = new int[image.length][image[0].length];
        int val = K / 2; // 현재 위치를 중심으로 사각형의 상단 좌측 꼭지점 위치와 하단 우측 꼭지점 위치를 구하기 위한 값
        int de = K * K; // 평균을 나눠 줄 값
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j <image[0].length ; j++) {
                int iStart = i - val < 0 ? 0 : i - val; // K X K 가상 사각형의 row 시작 점
                int iEnd = i + val > image.length - 1 ? image.length - 1 : i + val; // K X K 가상 사각형의 row 끝 점
                int jStart = j - val < 0 ? 0 : j - val; // K X K 가상 사각형의 col 시작 점
                int jEnd = j + val > image[0].length - 1 ? image[0].length - 1 : j + val; // K X K 가상 사각형의 col 끝 점

                int sum = 0;
                for (int k = iStart; k <=iEnd; k++) {
                    for (int l = jStart; l <=jEnd ; l++) {
                        sum += image[k][l];
                    }
                }
                answer[i][j] = sum / de;
            }
        }

        return answer;
    }



    public static void main(String[] args) {
        int[][] image = {{4, 5, 2, 6, 7},
                {5, 4, 2, 4, 6},
                {6, 8, 4, 8, 7},
                {7, 3, 6, 6, 4},
                {5, 0, 4, 1, 5}};
        System.out.println(solution(image, 3));

        image = new int[][]{{99, 183, 239, 24, 109},
                {113, 147, 248, 108, 168},
                {224, 36, 130, 98, 82},
                {45, 227, 187, 98, 241},
                {166, 122, 206, 216, 106}};
        System.out.println(solution(image, 5));
    }
}
