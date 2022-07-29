/*
 미제출 답안입니다. 정답을 보장하지 않습니다.

전략
1. 평균을 구하는 매소드 생성 (모두 더한 값 / 더한 값의 갯수)
 1) 모두 더한 값 구하기
    - K * K 범위 안에 있는 값을 어떻게 하면 빠짐없이 더할것인가?
    - 지정된 좌표 기준으로 K/2까지를 기준까지 for문으로 더한다.
    - 배열을 벗어나는 값은 0이 되어야 하는데 exception 처리로 더하지 않게 함.

 2) 더한 값의 갯수 : K * K

2. 매소드로 이미지 호출

해결과정 설명
 1. 평균을 구할때, 처음에 모든 값을 더해주는 로직을 이것 하나로 정함

   try{ sum += input[row - i][column - j]; } catch (Exception ignored) {}
   try{ sum += input[row - i][column + j]; } catch (Exception ignored) {}
   try{ sum += input[row + i][column - j]; } catch (Exception ignored) {}
   try{ sum += input[row + i][column + j]; } catch (Exception ignored) {}

 2. 모든 값을 더해주려고 했는데 중복되는 경우 발생함.

 3. 디버깅과 노트로 image[0][0] K=3 일때 기준으로 그려가며 분석한 결과
    i, j 가 모두 0인경우 3개가 중복되고, i=0 인경우 j=0인경우는 두가지가 중복됨

 따라서 else if 구문으로 네가지를 나눔
    if(i == 0 && j == 0){ 좌표값
     } else if (i == 0) { 가로값
     } else if (j == 0) { 세로값
     } else { 나머지값
     }
*/
public class Problem5 {

    public int getAverage (int[][] input, int K, int row, int column){
        int sum = 0;
        int range = K / 2;

        for (int i = 0; i <= range ; i++) {
            for (int j = 0; j <= range; j++) {
                if ((i == 0 && j == 0)) {
                    sum += input[row][column];
                } else if (i == 0){
                    try{ sum += input[row][column - j]; } catch (Exception ignored) {}
                    try{ sum += input[row][column + j]; } catch (Exception ignored) {}
                } else if (j == 0){
                    try{ sum += input[row - i][column]; } catch (Exception ignored) {}
                    try{ sum += input[row + i][column]; } catch (Exception ignored) {}
                } else {
                    try{ sum += input[row - i][column - j]; } catch (Exception ignored) {}
                    try{ sum += input[row - i][column + j]; } catch (Exception ignored) {}
                    try{ sum += input[row + i][column - j]; } catch (Exception ignored) {}
                    try{ sum += input[row + i][column + j]; } catch (Exception ignored) {}
                }
            }
        }

        return sum / (K * K);
    }


    public int[][] solution(int[][] image, int K) {
        int imageLength = image.length; // 길이값 많이쓰여서 초기화해둠
        int[][] answer = new int[imageLength][imageLength];

        for (int i = 0; i < imageLength; i++) {
            for (int j = 0; j < imageLength; j++) {
                answer[i][j] = getAverage(image, K, i, j);
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

      int K = 3;

        Problem5 test = new Problem5();
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image.length; j++) {
                System.out.print(test.solution(image, K)[i][j] + " ");
            }
            System.out.println();
        }



    }
}
