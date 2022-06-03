public class Solution {
    public static int solution(int delay, int capacity, int[] times) {
        int answer = 0;
        int totalTime = 0;                      // 현재 시간을 표시하기 위한 변수
        int curCap = 0;                         // 현재 용량을 표시하기 위한 변수

        for (int time : times) {                // times 배열을 for 문으로 돌면서 각 조건을 체크함
            totalTime += time;                  // 현재시간에 각 시간을 더함

            if (totalTime >= delay) {           // 더한 시간이 delay 시간보다 커지면 용량을 줄여야함
                totalTime -= delay;             // 현재 용량을 하나 줄이면서 현재 시간에서 delay 만큼 빼줌
                curCap--;                       // 이 작업을 먼저 하는 이유는 문제에 제거하는 작업을 먼저 한다고 적혀있어서!!
            }

            if (curCap >= capacity) {           // 만약 현재 용량이 최대 용량보다 같거나 크다면
                answer++;                       // 소실된 값 count
            } else {
                curCap++;                       // 아니라면 현재 용량 하나 증가!
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 1, new int[]{0,0,0,0,3}));
    }
}
