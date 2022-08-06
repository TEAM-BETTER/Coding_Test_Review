/*
* 자꾸 에러가 나길래 long으로 바꾸기도 해 보고 그랬지만..
* 계속 에러가 나서 해결 못 했습니다 ㅠ
* 10점 짜리 입니다.
* */
class Solution {
    public long solution(int n, int num) {
        long answer = num;

        for (int i = 0; i < n; i++) {
            answer = convert(answer);
        }

        return answer % 10004;
    }

    public long convert(long num) {
        int[] numCount = new int[10];
        String strNum = num + "";

        for (char c : strNum.toCharArray()) {
            numCount[c - '0']++;
        }

        StringBuilder ret = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            if (numCount[i] == 0) continue;
            ret.append(i).append(numCount[i]);
        }

        return Long.parseLong(ret.toString());
    }
}