import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// 효율성 테스트 3개 통과 X
public class Solution {
    public static int[] solution(int[] start, int[] time) {
        PriorityQueue<int[]> workQ = new PriorityQueue<>((x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
        // stat 배열에서 꺼내오는 순서를 위한 PriorityQueue  // stat , time 배열의 인자를 기준으로 오름차순으로
        PriorityQueue<int[]> delayWorkQ = new PriorityQueue<>((x, y) -> x[1] != y[1] ?
                x[1] - y[1] : (x[0] != y[0] ? x[0] - y[0] : x[2] - y[2]));
        // 실행 되기를 기다리는 PriorityQueue // stat, time, idx 순서로 오름차순
        for (int i = 0; i < start.length; i++) {            // workQ 에 stat 배열과 time 배열을 idx 끼리 합쳐서 idx 와 함께 저장
            workQ.add(new int[]{start[i], time[i], i});
        }

        int curTime = 0;                                    // 현재 시간 기록하는 변수
        boolean IDLE = true;                                // 현재 실행되는 프로세스가 아무것도 없을떄 ture
        int[] now = new int[3];                             // 현재 실행되는 프로세스를 담을 배열
        ArrayList<Integer> answer = new ArrayList<>();      // 정답을 담을 배열
        if (!workQ.isEmpty()) {                             // 첫번째 실행될 프로세스 하나를 꺼내어서 now 에 저장
            now = workQ.poll();                             // 처음 시작될 프로세스 stat 가 9999 이면 9999 까지 카운트하는거 줄일 수 있음
            curTime = now[0];
            IDLE = false;
            answer.add(now[2]);
        }

        while (!workQ.isEmpty() || !delayWorkQ.isEmpty()) { // workQ 와 delayWorkQ 가 비어 있을 떄 까지 반복
            IDLE = now[1] <= 0;                             // 현재 실행되는 프로세스의 time 이 모두 지났을 때 IDLE = true

            if (!workQ.isEmpty() && curTime >= workQ.peek()[0]) { // workQ 에서 꺼낼지 말지 결정하는 if 문 (현재 시간이 workQ 에서 다음에 나올 stat 시간보다 크면 꺼냄)
                while (!workQ.isEmpty() && curTime >= workQ.peek()[0]) {    // stat 시간이 같은 인자가 있을수 있으므로 다 나올떄 까지 실행
                    delayWorkQ.add(workQ.poll());                   // 꺼내온 것들 모두 delayWorkQ 에 넣고 누가 now 에 저장될지 결정 할 것
                }                                                   // 처음 코드를 작성 할 때 worQ 에서 꺼낸 값과 delayWorkQ 에서 나올 값을
            }                                                       // 따로 아래 위 if 문에 넣어서 비교하며 작성하였는데 너무 복잡해져서
                                                                    // 일딴 workQ 에서 나온 값도 delayWorkQ 에 넣어서 계산 하기로 바꿈

            if (!delayWorkQ.isEmpty() && IDLE) {                    // delayWorkQ 에서 뽑아 낼지 말지 결정하는 if 문 IDLE ture 일떄 뽑아냄
                now = delayWorkQ.poll();
                answer.add(now[2]);                                 // now 에 저장 된 다는 것은 실행된다는 것이므로 정답 배열에 추가
                IDLE = false;                                       // 프로세스 실행중이므로 IDLE false 로 변경(하지만 아무대도 쓰이지 안음...)
            }

            if (now[1] == 0) {                                      // 효율성 테스트 시간 초과를 피하기위한 몸부림 (효과가 있긴 했지만 여전히 효율성 테스트 통과 X)
                curTime = !workQ.isEmpty() ? workQ.peek()[0] :      // 만약 stat 배열이 {0, 99982, 99983, 99985, 99986} 와 같을 때  0에서 99982 까지 1씩 시간을 카운터 하지 않기 위한 코드
                        (!delayWorkQ.isEmpty() ? delayWorkQ.peek()[1] : curTime + 1);
            }

            if (now[1] == 1) {                                      // 현재 실행되는 프로세스의 time 을 감소시키는 코드
                curTime++;                                          // 55번째 줄에 curTime += now[1] 을 하게되면
                now[1] = 0;                                         // 문제에서 제공된 테스트 케이스 2번에서 오류 발생했음
            } else {
                curTime += now[1] - 1;
                now[1] -= now[1] - 1;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray(); // ArrayList 를 int[] 배열로 바꾸어 출력
    }

    public static void main(String[] args) {
        int[] a = {0, 99982, 99983, 99985, 99986};
        int[] b = {2, 4, 2, 1, 3};

        System.out.println(Arrays.toString(solution(a, b)));

    }


}
