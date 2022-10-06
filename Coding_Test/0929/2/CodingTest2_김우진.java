package CodingTest19;

public class CodingTest2_김우진 {

    /**
     * 주어진 param0의 숫자 카운트, 대문자 카운트
     * 만약 숫자없고, 대문자 없고, 길이가 5보다 작으면 false, 아니면 true 리턴
     */

    public static boolean solution(String param0) {
        boolean answer = false;
        int isDigit = 0;
        int isUpper = 0;

        for (char x : param0.toCharArray()) {
            if (Character.isDigit(x)) {
                isDigit++;
            }
            if (Character.isUpperCase(x)) {
                isUpper++;
            }
        }

        if(isDigit != 0 && isUpper != 0 && param0.length() >= 5) {
            return true;
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "insTaLLNow";
        System.out.println(solution(s));
    }
}