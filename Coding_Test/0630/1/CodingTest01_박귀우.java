// 단조 증가를 하기때문에 뒤로만 비교해주면 된다고 생각해서
// 두개의 변수를 지정해서 옮겨주기로 결정
// 정확성 1개 통과 못했습니다. ㅠ
class Solution {
    public int[] solution(int[] values) {
        if (values.length == 1)
            return new int[] { 0, 0 };
        // 1개인 경우 0,0 으로 해야할지 뭔지 잘모르겠지만 일단 00 으로 했습니다.

        int p1 = 0; // 변수1
        int p2 = 0; // 변수2
        int maxLen = Integer.MIN_VALUE; // 길이 비교를 위한 변수
        int[] answer = new int[] { p1, p2 }; // 정답을 담을 변수

        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] < values[i + 1]) { // 말그대로 뒤로 비교하면서 크다면 나를 증가시켜줌
                p2++;
            } else {
                if (p2 - p1 + 1 > maxLen) {
                    maxLen = p2 - p1 + 1;
                    answer = new int[] { p1, p2 };
                }
                p1 = p2 + 1; // 뒤에가 작은경우이기 떄문에 p2+1 로 리뉴얼
                p2++;
            }
        }
        return answer;
    }
}