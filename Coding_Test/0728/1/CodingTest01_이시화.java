package codiingTest.codingTest10.p1;

// 구현이 귀찮았던 문제
// 0~9 까지 모든 수를 구현하였기에 귀찮았습니다.
// 숫자 하나를 표현하는데 5개의 String 이 필요하였기에 5개를 나누어 line 에 맞게 구현해주었습니다
public class Solution {
    public static String[] solution(int n) {
        String[] answer = {"", "", "", "", ""};             // 5개의 줄을 더해줄 answer 배열 초기화
                                                            // new String[5]; 로 초기화하면 null 값이라 다른게 나옵니다
        String num = String.valueOf(n);                     // 입력값 n을 String 으로 바꾸어 처리하는게 편해서 바꾸었습니다.
        for (int i = 0; i < num.length(); i++) {            // 입력값의 각 자리 수에 맞추어 배열에 알맞은 값을 저장할 for 문
            for (int j = 1; j <= 5; j++) {                  // 각 입력값의 5줄을 정의할 for 문
                answer[j - 1] += makeString(num.charAt(i) - '0', j);    // 숫자를 이루기 위한 5 줄의 문자를 각 answer[] 에 추가
                if (i != num.length() - 1) {                // 맨 마지막 숫자 뒤에는 숫자별 띄어씌기가 있으면 오답이기 때문에 추가
                    answer[j - 1] += " ";
                }
            }
        }

        return answer;
    }

    public static String makeString(int n, int line) {      // 각 숫자와 5개의 줄을 정의해준 함수
        switch (n) {
            case 0:
                if (line == 1 || line == 5) {
                    return "#####";
                } else {
                    return "#---#";
                }

            case 1:
                return "--#--";

            case 2:
                if (line == 1 || line == 3 || line == 5) {
                    return "####";
                } else if (line == 2) {
                    return "---#";
                } else if (line == 4) {
                    return "#---";
                }

            case 3:
                if (line == 1 || line == 3 || line == 5) {
                    return "####";
                } else {
                    return "---#";
                }

            case 4:
                if (line == 3) {
                    return "#####";
                } else if (line < 3) {
                    return "#---#";
                } else {
                    return "----#";
                }

            case 5:
                if (line == 1 || line == 3 || line == 5) {
                    return "#####";
                } else if (line == 2) {
                    return "#----";
                } else {
                    return "----#";
                }

            case 6:
                if (line == 1 || line == 3 || line == 5) {
                    return "#####";
                } else if (line == 2) {
                    return "#----";
                } else {
                    return "#---#";
                }

            case 7:
                if (line == 1) {
                    return "#####";
                } else {
                    return "----#";
                }

            case 8:
                if (line == 1 || line == 3 || line == 5) {
                    return "#####";
                } else {
                    return "#---#";
                }

            case 9:
                if (line == 1 || line == 3) {
                    return "#####";
                } else if (line == 2) {
                    return "#---#";
                } else {
                    return "----#";
                }
        }

        return "??????"; // 없으면 오류나서 넣어준 값
    }

    public static void main(String[] args) {
        String[] a = solution(1234567890);
        for (int i = 0; i < 5; i++) {
            System.out.println(a[i] + " ");
        }
    }
}
