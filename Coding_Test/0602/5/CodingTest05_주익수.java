class Solution {
    public int[][] solution(int[][] image, int K) {

    }
        int[][] answer = new int[image.length][image[0].length]; //answer 배열의 경우, 입력 배열의 사이즈만큼 선언

        int overSize = (int) K / 2; // 외곽 연산의 경우, 외부 영역이 0으로 초기화된 배열이 필요하므로 K 값을 2로 나눴을 때, 사이즈만큼 오버하기 위해 사이즈 선언
        int[][] array = new int[image.length + overSize * 2][image[0].length + overSize * 2];
        int sum = 0; //각 인덱스마다 평균값을 구하기 위한 변수


        for (int i = 0; i < image.length; i++) { //array 배열의 overSize만큼의 사이즈를 제외한 내부에 입력배열값 삽입
            for (int j = 0; j < image[0].length; j++) {
                array[i + overSize][j + overSize] = image[i][j];
            }
        }

        for (int i = overSize; i < image.length + overSize; i++) { //입력사이즈만큼의 각 좌표를 순회하는 반복문
            for (int j = overSize; j < image[0].length + overSize; j++) {
                sum = 0;
                for (int x = overSize * -1; x <= overSize; x++) { //각 인덱스기준으로 K값만큼의 범위의 합을 연산해주는 반복문
                    for (int y = overSize * -1; y <= overSize; y++) {
                         sum += array[i + x][j + y];
                    }
                }
                answer[i - overSize][j - overSize] = sum / (K * K); //정답 배열에 해당 인덱스의 평균값 삽입
            }
        }

        return answer;
    }

}