package CodingTest2;

/**
 * 분할정복을 이용하여 가운데를 기준으로 분할하여 풀이
 * 히스토리그램 문제는 유명한 문제이기 때문에 풀어보시는걸 추천드립니다.
 * https://www.acmicpc.net/problem/6549
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class CodingTest2_한규빈 {

    public static int solution(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        return divide(left, right, heights);
    }

    public static int divide(int left, int right, int[] heights) {
        if (left == right) {
            return heights[left];
        }

        // 가운데 위치를 구함
        int mid = (right + left) / 2;

        // 가운데 위치를 기준으로 왼쪽 부분의 넓이 오른쪽 부분의 넓이를 구하여 둘 중 큰 넓이를 저장
        int result = Math.max(divide(left, mid, heights), divide(mid + 1, right, heights));

        // 겹치는 구간의 넓이를 구함
        int low = mid;
        int high = mid + 1;
        int minHeight = Math.min(heights[low], heights[high]);
        result = Math.max(result, minHeight * 2);

        // 위에서 구한 값이 최대 값이 아닐 수 있으므로 합친 두 구간에서 넓이를 구해 최대 값을 구해 줌
        while (low > left || high < right) {
            // 높이가 큰 쪽으로 확장하면서 minHeight를 작은 것으로 업데이트 하면서 최대 넓이를 구함
            if (high < right && (low == left || heights[low - 1] < heights[high + 1])) {
                high++;
                minHeight = Math.min(minHeight, heights[high]);
            }
            else {
                low--;
                minHeight = Math.min(minHeight, heights[low]);
            }
           result = Math.max(result, minHeight * (high - low + 1));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 2, 1, 3, 4, 2, 5}));

//        System.out.println(solution(new int[]{3, 4, 5, 6, 5, 4, 3, 2, 1}));
    }
}
