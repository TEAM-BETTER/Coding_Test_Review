/*
로직짜기 제일 어려웠던 문제였습니다 ㅠㅠㅠ
클래스를 이용해 start 오름차순으로 정렬하고
끝 배열(제일 늦는 start)부터 계산했습니다
 */
import java.util.*;
class Solution {
    static class schedule implements Comparable<schedule>{
        int start;
        int end;
        int price;
        schedule(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.price = profit;
        }
        public int compareTo(schedule o) {
            return this.start - o.start;    // 오름차순 정렬
        }
    }
    public int solution(int[] start, int[] end, int[] price) {
        int n = start.length;
        schedule[] schedules = new schedule[n];
        for (int i=0; i<n; i++) {
            schedules[i] = new schedule(start[i], end[i], price[i]);
        }
        Arrays.sort(schedules);             // 처음에는 우선순위 큐로 풀이를 했는데 인덱스로 직접 값을 확인하는게 편할 것 같아서 바꿨습니다.
        int[] dp = new int[n];              // dp배열에는 price 값을 이용합니다. 해당 시간대의 최대 price 합 값이 저장됩니다.
        dp[n-1] = schedules[n-1].price;     // dp의 맨 뒷배열을 제일 늦는 start의 price 값으로 지정해줍니다.
        for (int i=n-2; i >=0; i--) {
            dp[i] = Math.max(schedules[i].price, dp[i+1]);
            for (int j=i+1; j < n; j++) {
                if (schedules[i].end <= schedules[j].start) {
                    dp[i] = Math.max(dp[i], schedules[i].price + dp[j]);
                    break;
                }
            }
        }
        return dp[0];
    }
}