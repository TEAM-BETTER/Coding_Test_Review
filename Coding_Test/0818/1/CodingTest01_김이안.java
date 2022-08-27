/*
* 12점 코드입니다... 예외 생각이 안나서 그냥 넘겨 버렸어요 ㅎㅎ;;
* */
class Solution {
    public int solution(String s) {
        s = s.replace(" ", "");     // 공백 먼저 지우기
        long num = 0;               // 리턴할 숫자
        int sign = 1;               // 양수, 음수 판별
        char[] chars = s.toCharArray();
        int i = 0;
        if (i < chars.length && (chars[i] == '-' || chars[i] == '+')) {         // 부호 판별
            sign = chars[i] == '-' ? -1 : 1;
            i++;
        }
        while (i < chars.length && chars[i] <= '9' && chars[i] >= '0') {        // 숫자만 탐색
            num = num * 10 + chars[i] - '0';
            i++;
            if (num > Integer.MAX_VALUE && sign == 1) {     // 현재까지 저장한 숫자가 Integer.Max 를 넘을 경우 리턴
                return sign * Integer.MAX_VALUE;
            }
            if (num > Integer.MAX_VALUE && sign == -1) {    // 현재까지 저장한 숫자가 Integer.Min 을 넘을 경우 리턴
                return sign * Integer.MIN_VALUE;
            }
        }
        return (int) num * sign;
    }
}