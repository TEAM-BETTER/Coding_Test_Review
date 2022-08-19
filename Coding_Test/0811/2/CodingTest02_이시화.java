package codiingTest.codingTest12.p2;

import java.util.Arrays;

// 효율성  테스트 0점
// 가장 낮은 높이부터 가장 높은 높이까지 차례대로 높이를 높여가며 가장 큰 값을 찾았습니다.
public class Solution {
    public static int solution(int[] heights) {
        int[] temp = heights.clone();               // 높이 순으로 정렬하기위해 clone 후 sort
        Arrays.sort(temp);
        int answer = temp[temp.length - 1];         // 처음 가장 큰 직사각형은 밑변이 1, 높이가 가장 큰 idx = 가장 큰 값

        int bottomLen = 0;                          // 밑변 길이 초기화
        for (int i = 0; i < temp.length - 1; i++) { // 가장 낮은 높이부터 가장 높은 높이까지 for 문
            for (int j = 0; j < heights.length; j++) {  // 밑변 계산 하기 위한 for 문 0부터 height.length -1  까지 돌면서 높이에 따라 계산
                if (heights[j] >= temp[i]) {            // 기준 높이 보다 높다면 직사각형을 만들 수 있으므로 밑변 길이 ++
                    bottomLen++;
                } else {                                // 아니라면 지금까지 측정된 밑변길이와 높이를 곱하여 answer 에 저장된 값중 큰 값을 선택
                    answer = Math.max(answer, bottomLen * temp[i]);
                    bottomLen = 0;
                }
                if (j == heights.length - 1) {          // heights.length - 1 까지 왔다면 지금까지 더 이상 밑변 길이를 늘리거나 할 수 없으므로 answer 업데이트
                    answer = Math.max(answer, bottomLen * temp[i]);
                    bottomLen = 0;
                }
            }
        }
        return answer;
    }
}
