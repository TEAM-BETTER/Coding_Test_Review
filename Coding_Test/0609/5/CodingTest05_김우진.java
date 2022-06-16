package CodingTest3;

/**
 * 1. 주어진 index값이 클리어해야할 보스
 * 2. optional에 따라 보스를 클리어하는 경우 / 패스하는 경우의 함수값을 만듦
 * 3. 해당 보스를 패스하면 index값을 +1해서 다음보스의 조건을 만나게 함
 * 4. 해당 보스를 클리어하면 health[idx] / attack 한 값에
 *      남은 health가 없으면 +time, 남은 health가 있으면 +time +1로 처리하고 다음보스 만남
 * 5. 주어진 index만큼 모든 보스를 만나면 answer와 현재 time변수를 비교해서 작은값을 answer에 넣어준다.
 *
 */

public class CodingTest05_김우진 {

        /**
         * 답을 저장하는 변수
         * 최소 시간을 구해야하므로 일단 최댓값을 넣어둠
         */
        public static int answer = Integer.MAX_VALUE;

        public static void func(int idx, int attack, int time, int[] reward, int[] health, int[] optional) {
                // 필수 보스를 모두 처치했을 경우 answer와 time을 비교하여 answer에 최솟값 저장
                if (idx == reward.length) {
                        answer = Math.min(answer, time);

                        return;
                }

                // 필수로 깨야하는 보스가 아닐 경우 해당 보스 처치하지 않고 넘어가는 재귀함수 호출
                if (optional[idx] == 1) {
                        func(idx + 1, attack, time, reward, health, optional);
                }

                /**
                 * 선택형 보스를 처치하는 로직
                 * 현재 보스의 체력 / attack + (보스의 체력 % attack != 0) 값이 보스를 처치하는데 걸린 시간
                 */
                int addTime = health[idx] / attack;

                if (health[idx] % attack != 0) {
                        addTime++;
                }

                /**
                 * idx + 1: 다음 보스
                 * attack + reward[idx]: 보상으로 얻은 공격력 추가
                 * time + addTime: 시간 추가
                 */
                func(idx + 1, attack + reward[idx], time + addTime, reward, health, optional);
        }

        public static int solution(int[] reward, int[] health, int[] optional) {
                func(0, 1, 0, reward, health, optional);

                return answer;
        }
}