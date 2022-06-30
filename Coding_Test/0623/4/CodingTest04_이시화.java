import java.util.Arrays;

// 이분탐색 사용
// 나무가지 길이가 가능한 가장 짧은 길이와 가장 긴 길이를 기준으로 탐색 시작
public class Solution {
    public static int solution(int N, int[] branches) {
        int answer = 0;
        int count = 0;                                      // 나무가지 갯수 저장 변수
        int max = Arrays.stream(branches).max().getAsInt(); // 가장 긴 나무가지 길이

        int left = 1;                                       // 가장 작은 길이
        int right = max;                                    // 가장 긴 길이

        while (left <= right) {                             // 이분탐색 시작
            int mid = (left + right) / 2;
            count = 0;
            for (int branch : branches) {                   // mid 값을 기준으로 만들 수 있는 나무가지 갯수 기록
                count += branch / mid;
            }

            if (count < N) {                                // 나무가지 갯수가 N 보다 작을 경우 mid 값이 크므로 right 를 mid - 1 로 변경
                right = mid - 1;
            } else {                                        // 나무가지 갯수가 N 보다 같거나 클 경우 mid 값이 작으므로 left 값을 mid + 1 로 변경
                left = mid + 1;
            }
        }                                                   // while 문을 다 돌고 나면 left = right + 1 상태가 됨
        // 이때 나무가지 갯수는 N - 1이므로 right 값이 mid 일때 N 개를 만들 수 있는 최대 값
        answer = right;
        if (right == 0) {                                   // right 값이 0 이면 불가능하므로 -1 반환
            return -1;
        }

        for (int branch : branches) {                       // 불가능 확인 하는 부분
            count += branch / answer;
        }

        if (count < N) {
            return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = new int[]{6, 7, 10, 16, 12};
        System.out.println(solution(10, a));
    }
}
