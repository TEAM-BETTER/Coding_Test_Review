package codiingTest.codingTest11.p1;


// reading zero 를 위해 num 값을 String 으로 변환하여 풀이
public class Solution {
    public static int solution(int n, int num) {
        String number = String.valueOf(num);        // num 값을 String 으로 받는 변수

        for (int i = 0; i < n; i++) {               // num 값을 String 으로 받는 변수
            int[] arr = countNum(number);           // 각 자리 숫자를 기록하는 함수
            number = makeNum(arr);                  // 위에서 만든 arr 배열을 토대로 String number 를 업데이트
        }

        return Integer.parseInt(number) % 10004;    // 10004 로 나눈 결과값 반환
    }

    public static int[] countNum(String num) {      // 각자리 숫자 갯수 세는 함수
        int[] arr = new int[10];
        for (int i = 0; i < num.length(); i++) {
            arr[num.charAt(i) - '0']++;
        }
        return arr;
    }

    public static String makeNum(int[] arr) {       // arr 에 기록된 값을 숫자로 변경하는 함수
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (arr[i] > 0) {
                answer.append(i);
                answer.append(arr[i]);
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 54223));
        System.out.println(solution(1, 1000));
    }
}
