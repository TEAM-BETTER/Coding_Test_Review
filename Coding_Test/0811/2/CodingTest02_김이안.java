/*
* 각 직사각형을 탐색할 때마다 투포인터? 슬라이딩 윈도우? 방식으로
* 양 옆으로 범위를 확장하면서 넓이를 확인합니다!
* 현재까지 최대 넓이 값을 저장해주는 dp배열을 이용했습니다!
* */
class Solution {
    public int solution(int[] heights) {
        int answer = 0;
        int[] dp = new int[heights.length];
        dp[0] = heights[0];     // 첫 인덱스의 넓이 = height[0] * 1
        for (int i = 1; i < heights.length; i++) {
            int height = heights[i];    //각 인덱스의 높이를 기준으로 넓이를 구합니다
            int x1 = i;     // 왼쪽으로 탐색할 포인터
            int x2 = i;     // 오른쪽으로 탐색할 포인터
            for (int j = i-1; j >= 0 ; j--) {
                if(heights[j] >= heights[i]) x1 = j;        // i인덱스의 높이보다 j인덱스의 높이가 낮으면 탐색 끝
                else break;
            }
            for (int j = i+1; j < heights.length; j++) {
                if(heights[j] >= heights[i]) x2 = j;
                else break;
            }
            int area = (x2-x1+1)*heights[i];                // 가로 길이 = x2-x1+1, 세로 길이 = 높이
            dp[i] = Math.max(dp[i-1], area);                // 현재까지 최대 넓이를 배열에 저장
        }
        return dp[heights.length-1];                        // 마지막 인덱스(최대 넓이) 리턴
    }
}