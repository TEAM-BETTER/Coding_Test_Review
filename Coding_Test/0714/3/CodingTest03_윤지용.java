public class CodingTest03_윤지용 {
    public static int solution(int N, int[] rewards) {
        // 예외처리
        if(N == 1) {
            return rewards[0];
        }
        if(N == 2) {
            return Math.max(rewards[0], rewards[1]);
        }
        // 저는 마지막 성에 침입했을 때 첫번째 성에 침입했는지 안했는지를 체크하는게 어려워서
        // 처음 시작을 2가지 버전으로 나누었습니다.
        // 1) 첫번째 성에 침입한경우 -> dp에서 마지막이 아니라 그 전 dp값을 리턴
        // 2) 첫번째 성에 침입 안한경우-> dp에서 마지막 dp값을 리턴
        // -> 그 후 두 값을 비교하여 최대값을 리턴

        // 첫번째 성 침입경우
        int[] dp1 = new int[N];
        dp1[0] = rewards[0];
        dp1[1] = rewards[1];
        for (int i = 2; i < N; i++) {
            dp1[i] = Math.max(dp1[i - 2] + rewards[i], dp1[i - 1]);
        }
        int answer1 = dp1[N-2];


        // 첫번째 성 침입 안한경우
        int[] dp2 = new int[N];
        dp2[0] = 0;
        dp2[1] = rewards[1];
        for (int i = 2; i < N; i++) {
            dp2[i] = Math.max(dp2[i - 2] + rewards[i], dp2[i - 1]);
        }
        int answer2 = dp2[N-1];

        return Math.max(answer1, answer2);
    }


    public static void main(String[] args) {
        int N = 6;
        int[] rewards = {5, 10, 5, 7, 5, 9};
        System.out.println(solution(N, rewards));
    }
}