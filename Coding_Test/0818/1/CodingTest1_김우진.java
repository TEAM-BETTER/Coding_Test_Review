package CodingTest13;

/**
 * isDigit : 숫자가 나오기 전 문자들을 체크
 * isNegative : 음수 체크 용
 *
 * 1. 숫자가 나오기 전 문자들을 확인하기 위해 isDigit으로 확인 후
 *      숫자가 나오면 answer에 더해줌
 *      전에 더해진 숫자가 있으면 *10으로 자릿수 이동 후 숫자 더하기
 *
 * 2. 문제 제시 된 대로 정수 범위를 벗어나면 정수 범위내로 리턴
 *
 */

public class CodingTest1_김우진 {

    public static int solution(String s) {
        long answer = 0;
        boolean isDigit = false;
        boolean isNegative = false;

        for (int i = 0; i < s.length(); i++) {

            if (isDigit && !Character.isDigit(s.charAt(i))) {
                break;
            }

            if (!isDigit && s.charAt(i) == '-') {
                isNegative = true;
            }

            //숫자가 나왔으면 isDigit은 true로 바꿔주고 answer값에 더해줌
            //이후에 isDigit이 true인 상태에서 숫자가 아닌 문자가 나오면 break;
            if (!isDigit && Character.isDigit(s.charAt(i))) {
                isDigit = true;
                answer = Long.valueOf(s.substring(i, i + 1));

                if (isNegative) {
                    answer *= -1;
                }

                continue;
            }

            if (isDigit == false) {
                continue;
            }

            answer = 10 * answer;

            if (isNegative) {
                answer -= (s.charAt(i) - '0');
            } else {
                answer += (s.charAt(i) - '0');
            }

            if (answer < Integer.MIN_VALUE) {
                answer = Integer.MIN_VALUE;

                break;
            }

            if (answer > Integer.MAX_VALUE) {
                answer = Integer.MAX_VALUE;

                break;
            }
        }

        return (int) answer;
    }

    public static void main(String[] args) {
        String s = " - 42514243zero123base";

        System.out.println(solution(s));
    }
}