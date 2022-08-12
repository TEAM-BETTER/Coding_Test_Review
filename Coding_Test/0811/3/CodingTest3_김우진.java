package CodingTest12;

/**
 * 1. isAllOne : 전부 1인지 확인하는 메서드
 *    pressSwitch : 3-스위치 누르는 메서드
 *
 2. func 메서드를 통해 모든 경우의 수를 확인하고 끝에 도달했을 때 전부 1이면 answer 업데이트
 *
 * 3. 2번에서 answer가 업데이트 됐으면 answer 반환 아니면 -1 반환
 *
 */

public class CodingTest3_김우진 {

    static int answer = Integer.MAX_VALUE;

    static boolean isAllOne(int[] stats) {
        for (int stat : stats) {
            if (stat == 0) {
                return false;
            }
        }
        return true;
    }

    static void pressSwitch(int idx, int[] stats) {
        // idx값이 stats 배열 범위 내에 있을 때, 3 - 스위치 눌러줌
        if (idx > 0) {
            stats[idx - 1] = 1 - stats[idx - 1];
        }

        stats[idx] = 1 - stats[idx];

        if (idx < stats.length - 1) {
            stats[idx + 1] = 1 - stats[idx + 1];
        }
    }

    static void func(int idx, int cnt, int[] stats) {

        //끝까지 도달했고, 전부 1이면 answer 업데이트
        if (idx == stats.length) {
            if (isAllOne(stats)) {
                answer = Math.min(answer, cnt);
            }
            return;
        }

        // 현재 인덱스에 대해 스위치를 안 누르고 다음 인덱스로 넘어감
        func(idx + 1, cnt, stats);

        // 현재 인덱스에 대해 스위치를 누르고 다음 인덱스로 넘어감
        // 다시 원복을 시켜야하므로 func 호출 후 다시 pressSwitch
        pressSwitch(idx, stats);
        func(idx + 1, cnt + 1, stats);
        pressSwitch(idx, stats);
    }

    public static int solution(int[] stats) {
        func(0, 0, stats);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) {
        int[] stats = {1, 1, 0, 1, 0, 1};

        System.out.println(solution(stats));
    }
}