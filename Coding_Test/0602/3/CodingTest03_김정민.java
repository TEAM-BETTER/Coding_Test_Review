import java.util.Stack;

/**
 *  이 문제를 처음 보고 느낀 풀이법은 올바른 괄호 판단하기의 해법과 비슷하다고 생각했습니다.
 *  알파벳과 중괄호를 직접 저장하는 스택을 사용하다가 각 원소의 순서를 이용해야 하는 점이 있어서 인덱스를 저장하였습니다.
 *
 *  그림으로 해설 하는 것이 가장 쉽지만 간단하게 제 코드에 대한 설명을 드리겠습니다.
 *  문자열을 쭉 읽어가면서 '{' 가 나오면 문자열 스택에 넣습니다.
 *  숫자가 나오면 numStack에 넣습니다.
 *  '}'가 나온다면 압축된 문자열을 풀어주는 처리를 해 줍니다.
 *  1. {가 다시 나올때까지 스택에서 문자열을 꺼냅니다. 그러면 {abc} -> {cba} 이런 결과를 얻게 됩니다.
 *  2. 이때 주의해야 할 점이 3{ab2{he}o} 와 같은 상황인데 마지막으로 풀었던 압축문자열의 위치보다 앞에있느냐 뒤에 있느냐에 따라서 문자열 압축을 해제하는 순서가 달라지게 됩니다.
 *  이 문자열은 3 * (abheheo) 를 형태로 해제를 시켜줘야 합니다.
 *  3. 문자열을 다 꺼내면 before temp(현재 압축 해제가 진행된 문자열) after 순으로 합쳐주고 다시 temp에 저장합니다.
 *
 *  제가 생각하는 이 문제 풀이의 핵심은
 *  위치정보를 파악해야 한다는 점
 *  { 를 스택에 넣음 으로써  }가 나왔을 때 어디까지 빼야 하는 지를 구분할 수 있다는 점 인것 같습니다.
 */
class Solution {
    public String solution(String code) {
        String answer = "";
        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> characterStack = new Stack<>();

        String temp = ""; // 마지막으로 압축 해제된 문자열을 저장하는 변수 급하게 짜느라 이름이 영 별로네요
        int lastCloseIndex = -1;

        for(int i = 0; i < code.length(); i++) {
            char c = code.charAt(i); // 인덱스 정보를 읽어서 문자를 가지고 옵니다.
            // { 면 스택에 넣어줍니다
            if (c == '{') {
                characterStack.push(i);
                //숫자도 마찬가지로 스택에 넣어줍니다.
            }else if ('0' <= c && c <= '9') {
                numStack.push(c - '0');
            }else if (c == '}') {
                String subString = ""; // temp를 업데이트 하기전에 중간 연산을 위해 사용하는 변수
                String beforeString = ""; // 마지막으로 압축이 풀어진 문자열보다 앞에 있는 데이터
                String afterString = ""; // 마지막으로 압축이 풀어진 문자열보다 뒤에있는 데이터

                // {} 안에 있는 문자열을 모두 꺼냅니다
                // 이때 마지막에 압축이 풀어진 문자열보다 앞에 있는지 뒤에 있는지에 따라서 데이터를 저장합니다.
                while (true) {
                    int index = characterStack.pop();
                    char stackElement = code.charAt(index);
                    if (stackElement == '{') break;

                    // lastCloseIndex가 -1이라면 한번도 압축이 해제가 되지 않은경우입니다.
                    if (lastCloseIndex == -1 || index < lastCloseIndex) {
                        beforeString += stackElement;
                    }else {
                        afterString += stackElement;
                    }
                }
                // 스택에서 꺼낸다면 문자열이 역순으로 나오기 때문에 다시 역순으로 바꿔줍니다.
                beforeString = new StringBuffer(beforeString).reverse().toString();
                afterString = new StringBuffer(afterString).reverse().toString();

                // 압축이 해제된 적이 있다면 이번 압축에서 곱하기 할 문자열은 before + temp + after 입니다.
                if (!temp.equals("")) subString = beforeString + temp + afterString;
                else subString = beforeString + afterString; // 아닌경우에는 before + after 입니다.
                String plusString = subString;// 압축을 늘려주기 위해 사용할 단위를 plusString으로 이름을 지었는데 token으로 할 걸 그랬네요

                // 계속 더해서 압축을 해제 해줍니다.
                int num = numStack.pop();
                for(int j = 0; j < num-1; j++) {
                    subString += plusString;
                }

                temp = subString;
                // 더이상 압축을 해제 할 필요가 없는 경우 answer에 답을 누적 시켜줍니다.
                if (numStack.empty()) {
                    answer += temp;
                    temp = "";
                }
                lastCloseIndex = i;
            }else {
                // 압축을 해제할 필요가 없는 문자열 들입니다.
                if (numStack.empty()) answer += c;
                else characterStack.push(i);
            }
        }
        return answer;
    }
}