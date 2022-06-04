package codingTest3;

import java.util.ArrayList;
import java.util.Stack;

public class CodingTest03_한규빈 {

    public static String solution(String code) {
        StringBuffer answer = new StringBuffer();
        Stack<String> stack = new Stack<>();
        StringBuffer sb; // 압축 문자열을 압축 저장하기 위한 buffer

        for (String s : code.split("")) {

            stack.add(s); // stack에 문자 추가
            if (s.equals("}")){
                // 문자가 } 이면 반복문을 통해 {}사이에 문자를 string buffer에 저장
                sb = new StringBuffer();
                while (!stack.peek().equals("{")) {
                    if(!stack.peek().equals("}")) {
                        sb.append(stack.pop());
                    } else {
                        stack.pop();
                    }
                }
                stack.pop(); // 반복문을 다 돈후 { 를 제거
                String revers = sb.reverse().toString(); // string buffer에는 문자가 거꾸로 추가 되었기 때문에 문자를 뒤집어 줌
                String st = "";
                int n = Integer.parseInt(stack.pop()); // { 앞에 얼마나 압축했는지에 대한 정수 n이 있기 때문에 stack에서 마지막 문자를 pop해서 나온 숫자 만큼 반복문을 돌려서 st에 문자를 추가
                for (int i = 0; i < n; i++) {
                    st += revers;
                }

                // 압축 해제한 문자를 다시 스택에 넣어 줌
               for(String str : st.split("")) {
                   stack.add(str);
               }
            }
        }

        // 압축이 해제된 문자열을 string buffer에 추가
        ArrayList<String> list = new ArrayList<>(stack);
        for (int i = 0; i < list.size(); i++) {
            answer.append(list.get(i));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        String code = "5{he2{l}o}friend";
        System.out.println(solution(code));
    }
}
