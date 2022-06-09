import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
* 주의!!!! 전체 16점 짜리 코드입니다.
* 정확성: 10
* 속도 :6
*
* */

/*
* 저는 times를 직접 이용하는게 불편해서 각 도달 시간을 직접 구해서 문제 풀이를 하였습니다.
* 그래서 각 시간이 delay로 나누어 떨어질 때 마다 큐에서 제거를 하는 방식으로 접근 했습니다.
* */
class Solution {
    public int solution(int delay, int capacity, int[] times) {
        int answer = 0;
        int[] arrivalTimes = new int[times.length + 1];
        arrivalTimes[0] = 0; // 최초 도착은 무조건 0
        for(int i = 1; i < arrivalTimes.length; i++) {
            arrivalTimes[i] = arrivalTimes[i-1] + times[i-1]; // 각 요소의 도착 시간
        }

        Queue<Integer> q = new LinkedList<>();
        int arrivalIndex = 0; // 각 요소의 도착시간에 접근하는 인덱스
        int curTime = 0; // 시간을 0에서 마지막 도착 시간까지 늘려나가는 방식으로 접근하기 위해서 선언한 변수

        /*
        * 이부분이 최종 도착시간이 최대 10억이고 delay가 1이 될 수 있기 때문에 최대 10억번이상의 연산을 하게 되서 시간초과가 나는 것 같습니다.
        * curTime을 최대한 땡겨주는 방식으로 처리를 해도 시간초과가 나서 그냥 이대로 제출 했습니다.
        * 지금 이 부분 while문을 times를 직접이용해서 처리하면 최대 1만인가 10만인가 연산안에 통과할 수 있기 때문에 times를 이용하는 방법으로 코드를 다시 짜는것이 좋을 것 같습니다.
        * */
        while (curTime <= arrivalTimes[arrivalTimes.length-1]) {
            if (!q.isEmpty()) q.poll(); // 큐가 비어있지 않다면 빼줍니다 curTime은 항상 delay 만큼 증가하기 때문에

            // 현재시간에 도착해야하는 모든 메세지를 큐의 용량이 허락하는한 큐에 넣어줍니다
            while ( arrivalIndex < arrivalTimes.length && arrivalTimes[arrivalIndex] <= curTime ) {
                if (q.size() < capacity) q.add(arrivalTimes[arrivalIndex]);
                else answer++; // 도달하지 못하면 answer를 증가시켜줍니다.

                arrivalIndex++;
            }

            curTime += delay;
        }

        return answer;
    }
}
