import java.util.Stack;

class Solution {
    public int[] solution(int[] a, int[] b) {

        Stack<Integer> stackA = new Stack<>(); //a 배열에 대한 스택
        Stack<Integer> stackB = new Stack<>(); //b 배열에 대한 스택
        Stack<Integer> stackAnswer = new Stack<>(); //정답 배열을 저장할 스택

        int maxSize = (a.length > b.length) ? a.length : b.length; //가산 연산의 경우, 연산횟수가 a,b 중 큰 배열의 값 + 1이므로

        for (int i : a)  //스택 초기화
            stackA.push(i);
        for (int i : b)  //스택 초기화
            stackB.push(i);

        int num = 0; //a, b의 각 자리값을 더한 후, 올림값을 저장해두는 변수
        int nowNum = 0; //a, b의 각 자리값을 더한 후, 10으로 나눴을때 나머지를 저장해두는 변수
        int sum = 0; //a,b의 각 자리값을 더한 값,

        for (int i = 0; i < maxSize; i++) { //maxSize만큼 연산하는 반복문
            if (!stackA.empty() && !stackB.empty()) { //a, b 스택이 모두 비어있지 않을 때, 해당 연산 수행
                sum = stackA.pop() + stackB.pop() + num;
                nowNum = sum % 10;
                num = sum / 10;

                stackAnswer.push(nowNum); //연산 결과값 저장
            }
            else if (stackB.empty()) { //b 스택이 비어있을 경우, a의 값만 빼어 올림값과 연산
                sum = stackA.pop() + num;
                nowNum = sum % 10;
                num = sum / 10;

                stackAnswer.push(nowNum);
            }
            else { //a 스택이 비어있을 경우, b의 값과 올림값을 합함
                sum = stackB.pop() + num;
                nowNum = sum % 10;
                num = sum / 10;

                stackAnswer.push(nowNum);
            }
            if (stackA.empty() && stackB.empty() && num > 0) //각 연산들이 끝난 후에도 올림값이 존재할 경우, 연산횟수 +1
                stackAnswer.push(num);
        }

        int cnt = 0; //answer 배열에 값을 초기화시키기 위한 변수
        int[] answer = new int[stackAnswer.size()]; //stackAnswer의 사이즈만큼 선언

        while(!stackAnswer.empty()) { //Answer Stack이 빌때까지 값 삽입
            answer[cnt] = stackAnswer.pop();
            cnt++;
        }

        return answer;
    }
}