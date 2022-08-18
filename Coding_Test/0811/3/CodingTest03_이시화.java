package codiingTest.codingTest12.p3;

import java.util.Arrays;
import java.util.PriorityQueue;

// 효율성에서 런타임 애러 3개 발생
// 이진법으로 바꾸어 dp로 풀이 priorityQueue 로 bfs 실행
public class Solution {
    private static class Num implements Comparable<Num> {       // 이진법 수와 변경한 횟수 count 를 기록하기위한 class
        int num;
        int binaryNum;
        int count;

        public Num(int num, int count) {
            this.num = num;
            this.binaryNum = getBinaryNum(num);
            this.count = count;
        }

        @Override
        public int compareTo(Num o) {
            return this.count - o.count;
        }
    }

    public static int solution(int[] status) {
        int allOneNum = 0;                                   // 이진법 마지막 수인 11111 을 구하기위한 변수
        int len = status.length;
        allOneNum = getAllOneNum(len, allOneNum);            // 1111 을 구하는 메소드 (가독성을 위해 변환)

        int[] dp = new int[(int) Math.pow(2, len)];          // 이진법 갯수만큼 dp 배열 초기화
        Arrays.fill(dp, 100000);
        int num = arrToNum(status);
        dp[getBinaryNum(num)] = 0;                           // dp 시작점 0 으로 초기화
        if (num == allOneNum) {                              // (예외처리) 만약 모든 숫자가 1 이라서 스위치를 바꿀 필요 없을 경우
            return 0;                                        // 0 반환
        }

        PriorityQueue<Num> queue = new PriorityQueue<>();    // Priority Queue 를 이용해 dfs 로 dp 업데이트
        queue.add(new Num(num, 0));                    // 초기 값 queue 에 저장

        while (!queue.isEmpty()) {                           // dfs 시작
            Num cur = queue.poll();                          // 현재 숫자
            int[] arr = numToAr(cur.num, len);               // 현재 숫자를 배열로 한자리씩 저장
            for (int i = 0; i < arr.length; i++) {           // 0 번째 자리부터 arr.length - 1 번쨰 까지 스위치를 켜보면서 dp 에 업데이트
                int[] temp = arr.clone();
                int next = changeSwitch(i, temp);
                int nextBinary = getBinaryNum(next);
                if (next == allOneNum) {
                    return cur.count + 1;
                }
                if (dp[nextBinary] > cur.count + 1) {
                    dp[nextBinary] = cur.count + 1;
                    queue.add(new Num(next, cur.count + 1));
                }
            }
        }
        return -1;                                          // while 문을 빠져나왔다면 만들 수 없으므로 -1 반환
    }

    private static int getAllOneNum(int len, int allOneNum) {   // 모든 자리가 1이 되는 숫자를 구하기 위한 메소드
        for (int i = 0; i < len - 1; i++) {
            allOneNum += 1;
            allOneNum *= 10;
        }
        allOneNum += 1;
        return allOneNum;
    }

    public static int getBinaryNum(int num) {                   // 2진법 수를 얻기위한 메소드
        return Integer.parseInt(String.valueOf(num), 2);
    }

    public static int[] numToAr(int num, int len) {             // num 숫자의 각 자리수를 arr 로 바꾸는 메소드
        int[] answer = new int[len];
        while (num > 0) {
            answer[len - 1] = num % 10;
            num /= 10;
            len--;
        }

        return answer;
    }

    public static int arrToNum(int[] status) {                  // arr 배열을 int 숫자로 바꾸는 메소드
        int answer = 0;
        for (int j : status) {
            answer *= 10;
            answer += j;
        }
        return answer;
    }

    public static int changeSwitch(int n, int[] status) {   //
        int len = status.length;
        for (int i = -1; i <= 1; i++) {
            if (isPossible(n + i, len)) {
                status[n + i] = inverter(status[n + i]);
            }
        }

        return arrToNum(status);
    }

    public static boolean isPossible(int n, int len) {  // 배열 안에 들어갈 idx 검증 메소드
        return n >= 0 && n < len;
    }

    public static int inverter(int n) {                 // 배열안의 숫자 1을 0, 0을 1로 바꾸는 메소드
        return n == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 1, 0, 1, 0, 1};
        System.out.println(solution(a));
        a = new int[]{1, 0, 1, 0, 1, 0, 1, 0, 1, 1};
        System.out.println(solution(a));

        a = new int[]{1};
        System.out.println(solution(a));
    }
}
