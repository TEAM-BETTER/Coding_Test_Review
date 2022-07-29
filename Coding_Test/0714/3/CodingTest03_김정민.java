/*
* 프로그래머스 도둑질 문제랑 똑같은 문제 입니다.
* 원형으로 되어 있어서 처음 봤을 때 case를 나누기 어려웠었던 기억이 납니다.
* 원형으로 되어 있고 안되어 있고를 떠나서 이웃하지 않게 최대한 많이 선택해야 보상이 최대가 된다는 것은 쉽게 알 수 있을 것 같습니다.
* 이 문제는 첫 번째 성을 골랐을 때와 첫 번째 성을 고르지 않았을 때로 case를 나누면 모든 case를 고려 할 수가 있습니다.
* dp[i]는 i번 째 성을 골랐을 때 점수의 최대 값 입니다.
* dp[i] = max(dp[i-1], dp[i-2] + reards[i])
* */
class Solution {
    public int solution(int N, int[] rewards) {
        int answer = 0;
        if (N <= 3) {
            for (int i = 0; i < N; i++) {
                answer = Math.max(answer, rewards[i]);
            }
            return answer;
        }

        int[] firstSelectDp = new int[N]; //처음 성을 고르는 경우 dp
        int[] firstNotSelectDp = new int[N]; // 처음 성을 고르지 않는 경우 dp

        firstSelectDp[0] = rewards[0];
        firstSelectDp[1] = rewards[0];

        firstNotSelectDp[0] = 0;
        firstNotSelectDp[1] = rewards[1];

        for (int i = 2; i < N; i++) {
            firstSelectDp[i] = Math.max(firstSelectDp[i-1], rewards[i] + firstSelectDp[i-2]);
            firstNotSelectDp[i] = Math.max(firstNotSelectDp[i-1], rewards[i] + firstNotSelectDp[i-2]);
        }

        // 제출 할 때는 못봤는데 여기서 최대값을 왜 또 구했는지 몰르겠네요?? 이 코드 없어도 통과할 거 같아요
        for (int i = 0; i < N; i++) {
            answer = Math.max(firstNotSelectDp[i], answer);
            answer = Math.max(firstSelectDp[i], answer);
        }

        return Math.max(firstSelectDp[N-2], firstNotSelectDp[N-1]);
    }
}