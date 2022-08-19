package codiingTest.codingTest13.p1;

// 요청사항 구현 문제
// 맨앞에 부호 처리부분, 들어오면 추가해주는 부분, 문자 들어오면 끝나는 부분 구현
public class Solution {
    public static int solution(String s) {
        long clippingChecked = 0;       // int 범위 넘어서는지 확인하기 위한 long 변수
        int i = 0;                      // s index 확인히기 위한 변수
        boolean isMinus = false;        // 음수 부호가 나왔는지 확인
        boolean numberStarted = false;  // 숫자가 나온 이후 인지 확인하는 변수

        while (i < s.length()) {        // s 를 index 하나씩 보며 처리
            char next = s.charAt(i);
            switch (next) {             // 숫자라면 clippingChecked 변수에 더해줌
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    clippingChecked *= 10;
                    clippingChecked += (s.charAt(i) - '0'); // 숫자 더해줌
                    if (clippingChecked > Integer.MAX_VALUE && !isMinus) {  // 숫자가 int 최대범위 초과인지 확인
                        return Integer.MAX_VALUE;                           // 음수가 아니라면 최대값
                    }
                    if (clippingChecked > Integer.MAX_VALUE) {              // 음수라면 최소값 반환
                        return Integer.MIN_VALUE;
                    }
                    numberStarted = true;                                   // 숫자가 나왔으므로 뒤의 문자가 나온다면 멈춤을 위한변수
                    break;

                case '-':                       // 마이너스가 나왔을 때
                    if (!numberStarted) {       // 숫자가 시작 되지 안았다면 음수값을 표시해줌
                        isMinus = !isMinus;
                    } else {                    // 숫자가 나온 이후라면 문자 취급하므로 지금까지 모인 숫자를 리턴
                        return isMinus ? (int) -clippingChecked : (int) clippingChecked;
                    }
                    break;
                case ' ':
                case '+':                       // 마이너스부호처리와 똑같이 숫자가 시작되었다면 숫자 리턴
                    if (!numberStarted) {
                        return isMinus ? (int) -clippingChecked : (int) clippingChecked;
                    }
                    break;
                default:                        // 문자가 나오면 뒤의 index 를 무시하고 출력
                    return isMinus ? (int) -clippingChecked : (int) clippingChecked;
            }
            i++;
        }

        return isMinus ? (int) -clippingChecked : (int) clippingChecked;  // 문자 업이 s index 끝까지 도달했을 떄 리턴
    }

    public static void main(String[] args) {
        System.out.println(solution("00000010++1"));
    }
}
