/*
    코드는 정신없지만 20점은 받았습니다... ㅎㅎ

*/
import java.util.Stack;
class Solution {
    public static String calc(String code, int num, int startIdx, int endIdx){
        StringBuilder resultString = new StringBuilder();
        StringBuilder calcString = new StringBuilder();         // 괄호 안쪽 값을 저장
        Stack<Character> pairs = new Stack<Character>();        // 괄호 짝을 찾기위한 스택
        boolean isValid = false;                                // 괄호가 열려 있을때를 체크
        int curStartIdx = startIdx;                             // 괄호가 열린 인덱스
        int curEndIdx = endIdx;                                 // 닫힌 괄호 인덱스
        int curNum = num;                                       // 괄호앞의 숫자 값
        for (int i = curStartIdx; i <= curEndIdx; i++) {
            char c = code.charAt(i);
            if(Character.getNumericValue(c) > 0 && Character.getNumericValue(c) < 10 ){ // 숫자일 경우
                if(pairs.size() == 0){
                    num = Character.getNumericValue(c);
                    isValid = true;
                }
            }else if(c == '{'){
                pairs.add(c);
                if(pairs.size() == 1) {
                    startIdx = i;
                }
            }else if(c == '}'){
                pairs.pop();

                if (pairs.size() ==0){
                    endIdx = i;
                    calcString.append(calc(code, num, startIdx+1, endIdx-1));   // 괄호안의 문자열을 다시 계산
                    isValid = false;
                }
            }else if(!isValid) calcString.append(c);

        }
        for (int i = 0; i < curNum; i++) {              // 괄호안의 문자열을 숫자만큼 반복
            resultString.append(calcString.toString());
        }
        return resultString.toString();
    }
    public String solution(String code) {
        String answer = calc(code,1, 0,code.length()-1);
        return answer;
    }
}