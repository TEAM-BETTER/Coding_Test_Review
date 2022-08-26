/*
 1번
 처음에 12점을 받았지만 아래와 같이 완전히 수정했습니다.
 여러 가지 테스트케이스 만들어서 시도해봤는데 20점 짜리인지는 아직 모르겠네요 ㅎㅎ

 가장 먼저 공백을 제거하고나서 부호가 있는지없는지 확인
 그 다음 부호가 있는 경우에는 s를 substring으로 자르기
 그러고나서 반복문으로 숫자 앞의 쓸모없는 0을 삭제
 다음으로 반복문에서 숫자가 아닌 값이 나오면 s의 뒷부분을 자르기

 ... 순서대로 실행했습니다.
 문제만 보면 간단한데 구현이 복잡하네요...ㅎㅎ ㅠ
틀린 부분있으면 코멘트 부탁드립니다 :)

 */

public class CodingTest01_김란 {

    public static int solution(String s) {

        s = s.trim();
        String sign = "";
        if(s.charAt(0) == '-'){
            sign = "minus";
        }
        else if(s.charAt(0) == '+'){
            sign = "plus";
        }

        // 앞뒤 공백을 제거한다.
        if(sign.equals("minus") ||  sign.equals("plus")){
            s = s.substring(1);
            s = s.trim();
        }

        // 모두 0으로 이뤄진 경우, 탈출 조건
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; ++i){
            if(chars[i] != '0'){
                break;
            }
            if(i == chars.length - 1){
                return 0;
            }
        }

        // s의 앞부분에 쓸모없는 0을 한 글자씩 삭제 - 유효한 숫자의 맨 앞 인덱스 찾기
        int digit =  s.length();   // 반복문에서 쓰일 자릿수
        for(int i = 1; i < digit; ++i) {

            if(s.charAt(0) != '0'){
                break;
            }
            s = s.substring(1); // 여기 괄호 안에 i로 했다가 고치느라 오래 걸림..
        }

        // 한 글자씩 숫자가 맞는지 확인하면서 s에 덧붙인다. - 유효한 숫자의 맨 뒤 인덱스 찾기
        digit =  s.length();    // 초기화
        for(int i = 0; i < digit; ++i){
            if(!Character.isDigit(s.charAt(i))){    // 숫자가 아닌 다른 문자가 나오면 break
                s = s.substring(0, i);
                break;
            }
        }

        // MAX_VALUE 또는 MIN_VALUE를 넘어서는 경우
        double answer = Double.parseDouble(s);
        if(answer > Integer.MAX_VALUE){
            if(sign.equals("minus") ){       // 음수 양수 처리를 따로 해야되나? 절댓값이 다른니까?
                return Integer.MIN_VALUE;
            }
            return Integer.MAX_VALUE;
        }

        // 정수 - 음수 처리
        if(sign.equals("minus")){
            return  (-1) * Integer.parseInt(s);
        }
        // 정수 - 양수 처리
        return Integer.parseInt(s);
    }

    public static void main(String[] args) {

        String s = " - 42514243zero123base";    // -42514243
        System.out.println(solution(s));

        s = " + 00051241231004242542514243_41251243";   // 2147483647
        System.out.println(solution(s));

        s = " + 42514243zero123base";   // 42514243
        System.out.println(solution(s));

        s = " - 00051241231004242542514243_41251243";   // -2147483648
        System.out.println(solution(s));

        s = " - 00002147483648zero";   //  -2147483648
        System.out.println(solution(s));

        s = " 00003147483648324324234_zero";   //  2147483647
        System.out.println(solution(s));

        s = " + 00003147483648324324234_zero";   //  2147483647
        System.out.println(solution(s));

        s = " - 00002147483647zero";   //  -2147483647
        System.out.println(solution(s));

        s = "0000000000000000000000000000056000";   // 56000
        System.out.println(solution(s));

        s = "0000000000000000000000000000560000000";   // 560000000
        System.out.println(solution(s));
    }
}
