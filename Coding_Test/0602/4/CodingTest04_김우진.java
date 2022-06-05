package CodingTest2;

public class CodingTest04_김우진 {
    /**
     * 1. 메세지1개는 delay만큼 걸림, 메세지는 capacity까지 쌓을 수 있음
     * 2. 시간이 주어지는 만큼 반복, 주어진 시간들을 더하면 총 시간이 됨
     * 3. 먼저 해결한 수와, 해결 못한 수를 계산하기 전에, 시간차로 인해 해결 된 수를 정리해줘야함
     *  -delay는 한개의 메세지를 처리했다는 의미임
     * 3. 만약 지연되지않고 시간안에 처리하는 과정에서 (시간>지연) 해결한 숫자가 -가 될 수는 없음
     * 4. 때문에 그렇게 되면 cnt = Math.max(0, cnt - 1);를 통해 cnt = 0 이 되게 만들어줌
     * 5. 만약 capacity 허용량보다 처리숫자가 작으면 처리숫자를 늘려주고
     *  처리숫자가 허용량보다 커지면 소실된 수로 answer를 늘려준다.
     *  6. 주어진 시간동안 소실된 수의 값을 리턴한다.
     */

    public static int solution(int delay, int capacity, int[] times) {
        int answer = 0; //해결못한 수
        int time = 0; // 시간
        int cnt = 0; //해결한 수

        for (int i = 0; i < times.length; i++) {
            int duration = times[i];
            time += duration;

            if (time >= delay) {
                cnt = Math.max(0, cnt - 1);

                time -= delay;
            }

            if (cnt < capacity) {
                cnt++;
            } else {
                answer++;
            }
        }

        return answer;
    }
}
