import java.util.Arrays;

// 정확성 8점 짜리 입니다.
class Solution {
    public int[] solution(int[] values) {
        if (values.length == 1) {
            return new int[]{ 0, 0 };
        }

        int[] answer = new int[2];

        int st = 0; // 투포인터의 시작
        int end = 1; // 투포인터의 끝
        int maxLen = -1;

        while (st < values.length) {
            // 증가일 때만 end를 1개씩 증가 시켜 줍니다.
            // while문을 나오게 되면 end는 증가하지 않게 됩니다
            // [1 ,2 ,3 ,2] 이런상황이라면 end는 4를 가르키게 됩니다.
            while (end < values.length && values[end-1] < values[end]) {
                end++;
                if (end >= values.length) break;
                int curLen = end - st;
                // end가 증가하는 상황에서 계속해서 Length를 비교하여 최대 길이가 되면 정답을 바꿔줍니다.
                if (curLen > maxLen) {
                    answer[0] = st;
                    answer[1] = end - 1;
                    maxLen = curLen;
                }
            }
            st = end;
            end = st + 1;
        }

        return answer;
    }
}