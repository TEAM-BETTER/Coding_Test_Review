/*
미제출 문항입니다. 정답이 보장되지 않습니다.
테스트코드 예제는 통과인데 테스트에서 직접 넣어보면 점수가 다 안나올것 같다는 생각이 듭니다.

해결전략

자료구조를 활용하라는 문제 같은데, 산술적으로 풀릴것 같아서 푸는데 집중했습니다.
1. 변수 정하기
pendingQueue = 대기중인 큐의 개수;
ms = 대기시간

table의 ms를 올려주고 큐값을 하나 올려줌
delay를 넘어가면 큐값을 하나 내려줌

큐값이 capcity를 넘어가면 메세지소실값을 더해줌
*/

public class Problem4 {
    public int solution(int delay, int capacity, int[] times) {
        int ms = 0;
        int pendingQueue = 0; // 대기중인 큐의 개수
        int missingMessage = 0; // 소실된 메시지의 수
        for (int i = 0; i < times.length; i++) {
            ms += times[i];     // 다음 메시지 전달 소요시간을 대기시간에 넣어줌
            if(ms >= delay) {      //대기시간이 delay보다 커졌다면, 큐가 해결됨
                pendingQueue--;
                ms -= delay;
            }
            if(pendingQueue > capacity){ // 대기중인 큐가 capacity보다 많으면 missing메시지임
                missingMessage++;
            }
            pendingQueue++; // 제거가 우선이었기 때문에 생성을 나중으로
        }

        return missingMessage;
    }
    public static void main(String[] args) {
        Problem4 test = new Problem4();
        int delay = 5;
        int capacity = 5;
        int[] times = {3, 2, 0, 0, 2, 3, 0, 0, 2, 2, 5};
        int a = test.solution(delay, capacity, times);
        System.out.println(a);

    }
}
