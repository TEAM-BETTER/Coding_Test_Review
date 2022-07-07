import java.util.Arrays;

public class CodingTest01_윤지용 {
    public static int[] solution(int[] values) {
        int[] answer = {0, 0};

        int left = 0;
        int right = 0;
        int leng = 0; // 최대 길이
        while((right + 1) < values.length) { // 오른쪽 포인터 끝까지
            if(values[right] < values[right + 1]) { // 다음 값이 더 크면
                if((right + 1) - left > leng) { // 최대값이 더 길면 업데이트
                    leng = (right + 1) - left;
                    answer[0] = left;
                    answer[1] = (right + 1);
                }
            } else { // 왼쪽 포인터 당겨와
                left = (right + 1);
            }
            right++;
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] values = {103, 152, 124, 165, 152, 154, 159, 160, 200, 195, 205, 206, 204, 189, 156};
        System.out.println(Arrays.toString(solution(values)));

        values = new int[]{4, 10, 8, 14, 16, 20, 19, 21, 24, 30, 9, 5};
        System.out.println(Arrays.toString(solution(values)));
    }
}