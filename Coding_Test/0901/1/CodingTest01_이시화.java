package codiingTest.codingTest15.p1;


// 여러가지 경우를 생각하여 if 문을 이용하였습니다.
// spring security 에서 로그인 부분을 구현하는 부분과 비슷한 생각이 들었습니다.
public class Solution {
    public boolean solution(String s) {
        int smallE = 0;         // 소문자 갯수 저장 변수
        int bigE = 0;           // 대문자 갯수 저장 변수
        int spatialS = 0;       // 특수문자 갯수 저장 변수
        int num = 0;            // 숫자 갯수 저장 변수
        char beforeS = '~';     // 이전에 봤던 문자 저장 변수
        int countBeforeS = 0;   // 같은 문자가 얼마나 나왔는지 저장하는 변수
        boolean upDown = false; // up true down false
        int continuousCount = 0;// 연속된 문자가 얼마나 나왔는지 저장하는 변수

        // s 글자수 체크
        if (!(s.length() >= 6 && s.length() <= 20)) {
            return false;
        }

//        아스키 코드
//        !=33 @=64 #=35 $=36 %= 37 ^=94 &=38 *=43 (=40 )=41
//        숫자 48~57
//        대문자 65~90
//        소문자 97~122

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            //문자들 돌면서 숫자, 소문자, 대문자, 특수문자 갯수 측정
            if (a >= 48 && a <= 57) {
                num++;
            } else if (a >= 65 && a <= 90) {
                bigE++;
            } else if (a >= 97 && a <= 122) {
                smallE++;
            } else {
                spatialS++;
            }

            // 이전 문자와 현재 비교하는 문자가 같다면
            if (a == beforeS) {     // 연속된 같은 문자 변수 증가
                beforeS++;
            } else {                // 다르다면 연속된 같은 문자 변수 0으로 초기화
                beforeS = 0;
            }

            // 연속된 문자 체크
            if ((a + 1) == beforeS) { //증가하는 방향으로 체크
                if (upDown) {
                    continuousCount++;
                } else {
                    continuousCount = 1;
                }

                upDown = true;
            } else if ((a - 1) == beforeS) { // 감소하는 방향으로 체크
                if (!upDown) {
                    continuousCount++;
                } else {
                    continuousCount = 1;
                }

                upDown = false;
            }

            // 연속된 문자와 같은문자 연속 체크
            if (beforeS >= 3 || continuousCount >= 2) {
                return false;
            }
        }

        // 모든 문자가 하나씩 들어갔는지 체크
        if (bigE == 0 || smallE == 0 || spatialS == 0 || num == 0) {
            return false;
        }
        return true;
    }
}