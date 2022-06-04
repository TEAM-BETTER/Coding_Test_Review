package codingTest4;

import java.util.LinkedList;
import java.util.Queue;

public class CodingTest04_한규빈 {

    public static int solution(int delay, int capacity, int[] times) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        int time = 0; // 메세지 처리를 위한 변수 추가
        for (int i = 0; i < times.length; i++) {
            time += times[i];
            if(time >= delay) {
                // time이 delay보다 크거나 같으면
                // time 에서 delay 뺀 값을 다시 time에 넣어 주고
                // queue 하나 제거
                time -= delay;
                queue.poll();
            }
            if(queue.size() < capacity) {
                // queue size가 queue 용량보다 작을 때만 queue에 추가
                queue.add(times[i]);
            } else {
                // queue가 꽉 찼을 때 손실된 메세지 카운트 증가
               answer += 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int delay = 5;
        int capacity = 5;
        int[] times = {3, 2, 0, 0, 2, 3, 0, 0, 2, 2, 5};
        System.out.println(solution(delay, capacity, times));

        delay = 3;
        capacity = 5;
        times = new int[]{2, 2, 0, 4, 2, 3, 0, 0, 1, 2, 5, 0, 3, 4, 0};
        System.out.println(solution(delay, capacity, times));


    }
}
