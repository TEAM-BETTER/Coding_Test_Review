package CodingTest17;

import java.util.Collections;
import java.util.PriorityQueue;

public class CodingTest4_김우진 {

    /**
     * curFuel: 현재 가진 급유량
     * loc: 위치
     * len: station 배열의 길이값
     * idx: station 배열의 idx 체크값
     * answer: 얼마나 급유했는지 cnt
     * pq: 이동 할 수 있는 범위 내, 얻을 수 있는 연료 값을 연료 내림차순 정렬
     *
     * 목적지보다 위치값이 같거나 더 커지면 반복 종료, answer값 리턴
     *
     * idx값이 station 배열의 범위 안에 있고, station[idx]가 현재 위치보다 적으면 해당 연료통 획득 가능
     *      -> pq에 fuel[idx++] 추가
     *
     * 만약 dest까지 도달하지 못했는데, pq에 남은 값이 없으면 목적지 도달 실패 -1리턴
     *
     * pq에 저장된 가장 큰 값을 꺼내고, answer ++
     *      -> 꺼낸 pq 값을 curFuel에 넣어주고,
     *      다음 반복 시 curFuel을 loc에 더해서, 갈 수 있는 최대 거리값 계산
     *
     */

    public static int solution(int dest, int start, int[] station, int[] fuel) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int curFuel = start;
        int loc = 0;
        int len = station.length;
        int idx = 0;
        int answer = 0;

        while (loc < dest) {
            loc += curFuel;
            curFuel = 0;

            if (loc >= dest) {
                return answer;
            }

            while (idx < len && station[idx] < loc) {
                pq.add(fuel[idx++]);
            }

            if (pq.isEmpty()) {
                return -1;
            }

            curFuel += pq.poll();
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int dest = 12;
        int start = 6;
        int [] station ={2,3,5,10};
        int [] fuel = {5,2,3,1};
        System.out.println(solution(dest,start,station,fuel));
    }
}
