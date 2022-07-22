/*
이 문제도 한번 풀었던 문제라서 금방 풀었네요
코드도 간단해서 코멘트도 달게 없네요
 */
class Solution {
    public static int solution(int N, int[] rewards) {
        if(N == 1) return rewards[0];
        else if(N == 2) return Math.max(rewards[0], rewards[1]);
        else return Math.max(findMaxSum(0, N - 2, rewards), findMaxSum(1, N - 1, rewards));

    }

    public static int findMaxSum(int from, int to, int[] rewards) {
        int[] sumArr = new int[rewards.length - 1];
        sumArr[0] = rewards[from];
        sumArr[1] = Math.max(rewards[from + 1], rewards[from]);
        int idx = 2;
        for (int i = from + 2; i <= to; i++) {
            sumArr[idx] = Math.max((rewards[i] + sumArr[idx - 2]), sumArr[idx++ - 1]);
        }
        return sumArr[sumArr.length - 1];
    }
}