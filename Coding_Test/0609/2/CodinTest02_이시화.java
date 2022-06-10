package ch03.codingTest.p2;


import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    private static class Num implements Comparable<Num> {           // PriorityQueue 를 사용하기 위한 Comparable implement!!
        int cur;                                                    // 현재 숫자 기록
        int count;                                                  // 몇번의 연산을 했는지 기록

        public Num(int cur, int count) {                            // 변수 넣어주는 생상자
            this.cur = cur;
            this.count = count;
        }


        @Override
        public int compareTo(Num o) {                               // Comparable Override 메소드 구현
            return this.count - o.count;
        }
    }

    public static int solution(int[] numbers, int target) {
        int answer = 0;
        int[] numCount = new int[target + 1];                   // 배열의 idx 숫자까지 만드는데 가작 작은 횟수를 기록
                                                                // ex) numCount[3] 배열에 2 가 들어있으면 3을 만드는데 두번의 연산이 필요하다는 뜻
        int MAX = Integer.MAX_VALUE;
        Arrays.fill(numCount, MAX);                              // 최소값을 넣기 위해 처음에 Integer 의 가장 큰 값을 넣어줌
        answer = culMinCount(numbers, numCount, target);

        return answer;
    }

    public static int culMinCount(int[] numbers, int[] numCount, int target) {  // bfs 를 이용한 함수
        PriorityQueue<Num> queue = new PriorityQueue<>();                       // PriorityQueue 를 활용하여 count 값이 가장 작은 값을 먼저
        // 뽑아내어 연산!!!
        queue.add(new Num(0, 0));                                    // 첫 연산을 위한 출발 지점 (현재 숫자가 0 이고 연산 횟수가 0인 값)

        while (!queue.isEmpty()) {                                              // queue 없을 떄 까지 돌리는 while 문
            Num now = queue.poll();                                             // 현재 queue 에서 뽑아낸 숫자!
                                                                                // now.cur = 현재 숫자, now.count = 현재까지 연산 횟수

            if (now.count > 100) {                                              // 연산 횟수가 100번이 넘어가면 안되는 조건 있으므로
                return -1;                                                      // count 100 보다 크면 -1 return
            }

            for (int number : numbers) {
                int nextNowMul = now.cur * number;                              // 현재 숫자에 numbers 배열의 숫자를 *곱하여* 확인해봄
                if (nextNowMul == target) {                                     // 타겟 숫자와 같다면 now.count 에 1을 더한 값이 최소값
                    return now.count + 1;
                }

                if (nextNowMul < target) {                                      // 나누거나 빼는 연산이 없으므로 target 숫자보다 커지면 해당 Num 객체는
                                                                                // 더이상 확인하지 않고 queue 에 다시 넣지도 안음
                    if (numCount[nextNowMul] > now.count + 1) {                 // target 보다 작은 객체라도 numCount 배열에 기록된 값보다 크면 더이상 확인 X
                        numCount[nextNowMul] = now.count + 1;                   // numCount 배열의 값보다 작으면 numCount 배열을 재정의 해주고 queue 에 다시 넣어줌
                        queue.add(new Num(nextNowMul, now.count + 1));
                    }
                }
//==============================================================================    윗 줄은 곱하는 연산 아래줄은 더하는 연산

                int nextNowPlus = now.cur + number;                             // 현재 숫자에 numbers 배열의 숫자를 *더하여* 확인해봄
                if (nextNowPlus == target) {                                    // 타겟 숫자와 같다면 now.count 에 1을 더한 값이 최소값
                    return now.count + 1;
                }

                if (nextNowPlus < target) {                                     // 50번째 줄 코드와 같음
                    if (numCount[nextNowPlus] > now.count + 1) {
                        numCount[nextNowPlus] = now.count + 1;
                        queue.add(new Num(nextNowPlus, now.count + 1));
                    }
                }
            }
        }

        return -1;                                                              // queue 의 값을 다 돌았음에도 return 되지 안았으면 못만드는것
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 1}, 10));
    }

}
