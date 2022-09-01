package CodingTest14;

/**
 * 1. nonZeroLeading : 문자열 앞자리에 0이 있으면 제거
 *
 * 2. answerCharArray : 배열에 K만큼 자른 문자열을 하나씩 넣어줌
 *    sCharArray : s 문자열 그대로 숫자 하나씩 배열에 넣어줌
 *
 * 3. sCharArray[i]와 answerCharArray[idx] 하나씩 비교
 *    -> 만약 sCharArray[i]가 더 크면 패스
 *    -> 아니면 서로 숫자를 바꿔서 answerCharArray[idx]가 더 작은 수가 오게 함
 *
 * 4. 탐색이 끝나면 answerCharArray 에 문자열 s에서 큰 숫자 순서대로 k개 제거
 *    마지막으로 nonZeroLeading를 통해 앞자리 0이 오는 경우 0 제거 후 answer 리턴
 *
 */

public class CodingTest2_김우진 {

    static String nonZeroLeading(String s) {
        int idx = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                idx = i;

                break;
            }
        }
        return idx == -1 ? "0" : s.substring(idx);
    }

    public static String solution(String s, int k) {
        char[] answerCharArray = s.substring(k).toCharArray();
        char[] sCharArray = s.toCharArray();

        for (int i = k - 1; i >= 0; i--) {
            int idx = 0;

            while (idx < answerCharArray.length) {
                if (answerCharArray[idx] < sCharArray[i]) {
                    break;
                }

                char temp = answerCharArray[idx];
                answerCharArray[idx] = sCharArray[i];
                sCharArray[i] = temp;

                idx++;
            }
        }

        String answer = new String(answerCharArray);

        return nonZeroLeading(answer);
    }

    public static void main(String[] args) {
        String s = "1122911";
        int k = 2;

        System.out.println(solution(s, k));
    }
}
