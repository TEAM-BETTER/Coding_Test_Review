/*
아이디어
높이 1부터 시작해서 최대 높이까지 Max값 저장 및 출력
각 높이당 최대값은 투포인터로 0 ~ 그 높이가 나오는 곳까지, 그 높이가 나온 곳부터 ~ 다음 그 높이가 나오는 곳까지
5 3 1 3 1 5 라면
높이가 1일때: (높이가 1) X (start = 0 , end = 마지막 인덱스까지) -> 밑변
높이가 2일때: (높이 2) X (start = 0 , end = 3 일때 한번 멈춤) -> 밑변 -> Max 체크
                     X (start 3 , end = 5 일때 한번 멈춤) -> 밑변 -> Max 체크
                     X (start = 5 , end = 6 일때 마지막) -> 밑변 -> Max 체크

                     이런식의 아이디어입니다.
 */

// 정확성 10, 효율성 8점 코드입니다. 시간초과났어용..

public class CodingTest02 {
    public static int solution(int[] heights) {
        int max = 0;
        int maxHeight = 0;
        // 배열 돌면서 최대 높이 확인
        for (int i = 0; i < heights.length; i++) {
            maxHeight = Math.max(maxHeight, heights[i]);
        }
        // 1부터 최대높이까지 브루트포스
        for (int i = 1; i <= maxHeight; i++) {
            int start = 0; // 왼쪽 인덱스
            int end = 0; // 오른쪽 인덱스
            while(end <= heights.length - 1) { // end가 끝까지 갈때까지
                // end 인덱스 밀어주기
                while(end <= heights.length - 1 && heights[end] >= i) {
                    end++;
                }
                // Max값 체크하기
                if(start == 0 && end == heights.length - 1) {
                    max = Math.max(max, ((end - start + 1) * i));
                } else {
                    int candidate = ((end - start) * i);
                    max = Math.max(max, candidate);
                }
                // 인덱스 조절
                end++;
                start = end;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = {3, 4, 5, 6, 5, 4, 3, 2, 1};
        System.out.println(solution(heights));
    }
}
