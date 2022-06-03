
/*
미제출 문항입니다. 정답을 보장하지 않습니다.

문제해결전략

stack을 통해서 특정 문자에 도달하면 push, pop 이던 특정 로직을 수행하도록 함.

1. 닫는 괄호가 아닌경우에는 모두 push
2. 닫는괄호가 나오면
    1) {가 나올때까지 block에 저장(pop이 역순으로 되기 때문에 block도 역순임을 기억)
    2) 그다음 pop된 값은 정수로 반복 횟수이므로 retry변수에 입력
    3) for문으로 block값을 push (block이 역순임을 기억해서 내림차순으로 돌려야함)
3. stack에 쌓여있는 값을 for문으로 answer에 더해줌.


 */

import java.util.ArrayList;
import java.util.Stack;

public class Problem3 {
    public String solution(String code) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char c : code.toCharArray()) {
            if (c != '}') {
                stack.push(c);
            } else {                                          // } 이 등장하면
                ArrayList<Character> block = new ArrayList<>(); // block을 생성해줌

                while (stack.peek() != '{') {      // { 가 나오기 전까지 값을 block에 담기(자료는 거꾸로 되어있음)
                    block.add(stack.pop());
                }

                stack.pop();// { 없애기

                int retry = Character.getNumericValue(stack.pop());      // retry 횟수 저장 (반복문에서 pop쓰면 또적용됨;)
                for (int i = 0; i < retry; i++) {
                    for (int j = block.size() - 1; j >= 0; j--) {  // block의 값 거꾸로해서 retry만큼 push
                        stack.push(block.get(j));
                    }
                }
            }
        }

        for (char c : stack){
            answer += c;
        }

        return answer;
    }



    public static void main(String[] args) {
        String code = "5{he2{l}o}friend";
//        String code = "he2{l}o";
        Problem3 test = new Problem3();

        System.out.println(test.solution(code));
    }
}
