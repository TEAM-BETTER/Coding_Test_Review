package CodingTest3;

// 정확성 12점
// 이 문제는 주요 인사를 암살할 경우, 주변 성의 암살자는 암살하지 못 하는 문제인데 이 부분을 해결하지 못 해 실패 케이스가 나온거 같습니다..
// 그래서 디피 배열을 두개를 만들어 하나는 처음 인덱스 시작하고 하나는 두 번째 인덱스 부터 시작해서 둘 중 맥스 값을 뽑을까도 생각했는데 시간이 없어서 시도해보지는 못 했습니다.
public class CodingTest03_한규빈 {

    public static int solution(int N, int[] rewards) {
        int[] dp = new int[N];

        // 첫 번째 보상과 두 번째 보상 중 큰 값 저장
        dp[1] = Math.max(rewards[0], rewards[1]);

        // for loop을 돌면서 i 번째 성을 골랐을 때 최대 값을 찾아 줌
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], rewards[i] + dp[i - 2]);
        }

        return dp[N - 1];
    }

    public static void main(String[] args) {
        int N = 6;
        int[] rewards = {5, 10, 5, 7, 5, 9};
        System.out.println(solution(N, rewards));

        N = 10;
        rewards = new int[]{1, 1, 10, 1, 1, 1, 10, 1, 1, 10};
        System.out.println(solution(N , rewards));
    }
}
