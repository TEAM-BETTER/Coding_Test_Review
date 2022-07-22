import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

// 풀다가 시간이 다 갔네요. 일단 pr먼저 날리고, 주말에 시간나면 다시 업데이트 해보겠습니다. (자신은없습니다)
// dp칸을 채워갈 때 거꾸로 채워가려고 생각했습니다.
// 지금 보니 정렬은 시작시간 순으로 했어야 했나 봅니다.
// dp배열은 dp[n] = n일에 상담을 했을때의 최대값
// 점화식 = dp[해당 상담의 시작일] = Math.max(dp[해당 상담의 끝일] + price(해당 상담의 가격), dp[해당 상담의 시작일 다음날])

public class CodingTest01_윤지용 {
    static class Work {
        int start;
        int end;
        long price;

        public Work(int start, int end, long price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }
    }

    public static long solution(int[] start, int[] end, int[] price) {
        ArrayList<Work> arr = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            arr.add(new Work(start[i], end[i], price[i]));
        }

        Collections.sort(arr, (x1, x2) -> x1.end - x2.end);

        long[] dp = new long[10000];
        for (int i = start.length - 1; i >= 0; i--) {
            if(i + 1 < start.length - 1) {
                dp[i] = Math.max(dp[end[i]] + price[i], dp[i + 1]);
            } else {
                dp[i] = dp[end[i]] + price[i];
            }
        }
        return dp[0];


    /*
    for (Work item : arr) {
        System.out.println("시작시간: " + item.start + "  끝시간: " + item.end + " 가격: " + item.price);
    }
     */
    }

    public static void main(String[] args) {
        int[] start = {1, 5, 10, 6, 5};
        int[] end = {5, 6, 12, 9, 12};
        long[] price = {10, 40, 30, 20, 50};
        ArrayList<Work> arr = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            arr.add(new Work(start[i], end[i], price[i]));
        }
    }
}