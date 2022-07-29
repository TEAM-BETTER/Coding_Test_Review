package codiingTest.codingTest10.p2;


import java.util.Arrays;

// 자리를 바꾸어 가장 큰 수를 만들기 위해서
// 맨 뒷자리부터 가장 큰 수를 DP 에 기록하며 저장
// 저장된 DP와 Original num 과 앞자리 숫자 부터 비교하여 다른 지점을 찾음
// 그 자리 숫자를 바꾸어 주면 가장 큰 숫자
public class Solution {
    public static int solution(int num) {
        int answer = 0;
        String numString = String.valueOf(num);             // 다루기 쉽게 String 으로 변환
        char[] numOrigin = numString.toCharArray();         // Original num 을 배열화
        char[] numDP = new char[numString.length()];        // DP 를 기록할 배열

        int maxNum = 0;                                     // 가장 큰숫자를 기록할 변수
        for (int i = numString.length() - 1; i >= 0; i--) { // 맨 뒷자리 부터 큰 숫자를 DP 에 기록
            if ((numString.charAt(i) - '0') >= maxNum) {
                maxNum = (numString.charAt(i) - '0');
                numDP[i] = numString.charAt(i);
            } else {
                numDP[i] = numDP[i + 1];
            }
        }

        if (Arrays.equals(numOrigin, numDP)) {              // 만약 DP와 numOrigin 배열이 같다면 가장 큰 숫자 이므로 num return
            return num;
        } else {                                            // 아니라면 DP와 numOrigin 배열의 앞자리 숫자부터 다른 지점을 찾고
            int first = 0;                                   // 다른 지점을 바꾸어주면 가장 큰수 완성
            int last = 0;
            for (int i = 0; i < numDP.length; i++) {
                if (numDP[i] != numOrigin[i]) {
                    first = i;
                    break;
                }
            }

            for (int i = numDP.length - 1; i >= 0; i--) {
                if (numDP[i] == numDP[first]) {
                    last = i;
                    break;
                }
            }
            char temp = numOrigin[first];
            numOrigin[first] = numOrigin[last];
            numOrigin[last] = temp;

            for (char c : numOrigin) {
                answer *= 10;
                answer += c - '0';
            }
            return answer;
        }

    }

    public static void main(String[] args) {
        System.out.println(solution(1234));
    }
}










