import java.util.Arrays;

// 이분탐색 사용 가능
// 치킨 갯수 카운트 하는 곳에서 신경쓰면 같은 문제
public class Solution {
    public static int solution(int N, int M, int[] fry, int[] clean) {
        int answer = 0;
        int[] total = new int[N];                       // 치킨 튀기고 청소하는 시간까지 담는 배열

        for (int i = 0; i < N; i++) {                   // total[] = fry[] + clean[]
            total[i] = fry[i] + clean[i];
        }

        int max = Arrays.stream(total).max().getAsInt();// 가장 오래 걸리는 기계 값 찾기

        int left = 1;                                   // 가장 작은 시간
        int right = M * max;                           // 가장 큰 시간 => 가장 오래 걸리는 치킨 기계로 M 번 튀기기
        int chicken = 0;                                // 치킨 갯수 카운트할 변수

        while (left <= right) {                         // 이분탐색 시작
            int mid = (left + right) / 2;
            chicken = 0;
            for (int i = 0; i < N; i++) {               // 걸린 시간으로 그 기계가 튀길 수 있는 치킨 갯수를 chicken 변수에 더해줌
                chicken += (mid / total[i]);            // (시간 / total[]) => 청소까지하고 치킨을 만드는 과정
                if ((mid % total[i]) >= fry[i]) {       // (시간 / total[]) 남은 시간에 clean 작업 안하고 튀길 수 있는 갯수 있는지 확인
                    chicken += 1;
                }
            }

            if (chicken >= M) {                         // M 개보다 많거나 같다면 시간이 많은 것이므로 최대값 줄이기 right 값 mid - 1 로 변환
                right = mid - 1;
            } else {                                    // M 개보다 작으면 시간 부족이므로 left 값 mid + 1 로 변환
                left = mid + 1;
            }
        }                                               // while 문 다 돌고 나오면 chicken 값은 M - 1
        // left 값일 때 M 개를 만들 수 있는 최소 시간
        answer = left;
        return answer;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 6};
        int[] b = new int[]{2, 1};
//        System.out.println(solution(2, 20, a, b));
        System.out.println("++++++++++++++++++++++++++++++++++++");
        a = new int[]{2, 2, 1, 3};
        b = new int[]{2, 4, 3, 2};
        System.out.println(solution(4, 2, a, b));

        System.out.println(Integer.MAX_VALUE);
    }
}