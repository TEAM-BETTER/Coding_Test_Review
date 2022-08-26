/*
1. 문자열 앞에 공백은 무시
2. 숫자보다 앞에 -, + 있는 경우 부호.
3. 숫자가 시작되면 연속해서 붙어있는 숫자는 정수. 이후 문자열의 나머지 부분은 무시
4. 정수 범위가 int범위 넘으면 클리핑(최대값으로, 최소값으로)
 */

public class CodingTest01 {

    public static long solution(String s) {
        long answer = 0;
        StringBuffer tmp = new StringBuffer();
        boolean isMinus = false;
        boolean isNum = false; // 문자만인지 확인하기

        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == ' ') { // 공백 지우기
                sb.deleteCharAt(i);
                i--;
                continue;
            }
            if(sb.charAt(i) == '-') { // 마이너스 체크
                isMinus = true;
                continue;
            }
            if(Character.isDigit(sb.charAt(i))) { // 숫자인경우 체크
                isNum = true;
                int start = i; // 시작점
                while(i < sb.length() && Character.isDigit(sb.charAt(i))) {
                    i++; // 끝점
                    if(i - start > 15) { // 자리수
                        break;
                    }
                }
                tmp.append(sb.substring(start, i));
                break;
            }
        }

        if(!isNum) {
            return 0;
        }

        String answerCandidate = "";

        if(tmp.charAt(0) == '0') { // 맨 앞이 0이면 0 다 없애기
            for (int i = 0; i < tmp.length(); i++) {
                if (tmp.charAt(i) == '0') {
                    while (i < tmp.length() && tmp.charAt(i) == '0') {
                        i++;
                    }
                    answerCandidate = tmp.substring(i);
                    break;
                }
            }
        } else { // 맨 앞에 0 없으면 그냥 받아오기
            answerCandidate = tmp.substring(0);
        }
        // 빈 문자열 예외처리
        if(answerCandidate.length() == 0) {
            return 0;
        }
        // 자리수 넘치면
        if(answerCandidate.length() > 15) {
            if(isMinus) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }
        }
        // 마이너스 비교
        answer = Long.parseLong(answerCandidate);
        answer = (isMinus==true) ? -answer : answer;

        if(answer > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if(answer < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "-+-123";
        System.out.println(solution(s));
    }
}
