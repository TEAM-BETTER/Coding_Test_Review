package CodingTest2;

import java.util.Stack;

public class CodingTest03_김우진 {

    /**
     * 1. stack에 Character로 넣어줌
     * 2. 받은 문자열을 char로 바꿈
     * 3. } 문자를 만나면 반복문으로 char를 pop시켜줌
     * 4. 만약 숫자를 만나면 멈춤 이 숫자는 repeatcnt가 됨
     * 5. { 가 나올때까지 pop한 char를 temp문자열에 넣어줌
     * 6. { 가 나와서 temp에 문자열이 완성되면 repeatCnt만큼 반복함
     * 6-1. 이때 temp에 해당하는 문자열도 pop으로 진행했으므로, 역순으로 나옴
     * 6-2. 때문에 반대로 출력하도록 for (int k = temp.length() - 1; k >= 0; k--) {
     * temp의 길이 - 1 **부터 역순으로 출력해주는 반복문을 사용함
     * 7. 3-6 반복
     * 8. code.length만큼 반복이 다 끝나면 stack에 쌓인 코드를 꺼내줌
     * 9. FIFO형 이기때문에 원하는 값의 반대로 출력이 되므로, reverse를 통해 다시 역순으로 만들어줌
     * 완성!
     *
     * @param code
     * @return
     */
    public static String solution(String code) {
        String answer = "";

        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);

            if (c == '}') {
                String temp = "";
                int repeatCnt = 0;

                while (true) {
                    char cur = stk.pop();

                    if ('0' <= cur && cur <= '9') {
                        repeatCnt = cur - '0';

                        break;
                    }

                    if (cur != '{') {
                        temp += cur;
                    }
                }

                for (int j = 0; j < repeatCnt; j++) {
                    for (int k = temp.length() - 1; k >= 0; k--) {
                        stk.push(temp.charAt(k));
                    }
                }
            } else {
                stk.push(c);
            }
        }


        while (!stk.empty()) {
            answer += stk.pop();
        }


        StringBuffer stringBuffer = new StringBuffer(answer);
        answer = stringBuffer.reverse().toString();

        return answer;
    }
}
