/*
아이디어는,
1. 1의자리에서부터 자리수 올려가면서 가장 큰 수를 pick
2. 제일 큰 자리수에서 내려가면서 가장 큰 수보다 작은 첫번째 수 pick
3. 자리 교체
 */
import java.util.Stack;

public class CodingTest02_윤지용 {
    public static int solution(int num) {
        int answer = 0;
        int numCnt = 0;
        int copyNum = num;

        // 숫자를 list로 만들기
        Stack<Integer> stack = new Stack<>();
        while (copyNum > 0) {
            int cur = copyNum % 10;
            stack.push(cur);
            copyNum = copyNum / 10;
            numCnt++;
        }

        int[] arr = new int[numCnt];
        for (int i = 0; i < numCnt; i++) {
            arr[i] = stack.pop();
        }

        // 에외처리 (뒤로가면서 계속 숫자가 같거나 작아지면 그대로 반환)
        boolean notExeptionFlag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] < arr[i + 1]) {
                notExeptionFlag = false;
                break;
            }
        }
        if(notExeptionFlag) {
            return num;
        }

        int maxInt = -1;
        int maxIntIndex = -1;
        for (int i = arr.length - 1; i > 0; i--) {
            if(arr[i] >= arr[0] && arr[i] > maxInt) { // 여기서 >= 으로 안하고 > 로 했다가 예외발생(n=10일때 0이 출력됨)
                maxInt = arr[i]; // 가장 큰 수 체크
                maxIntIndex = i; // 그 수의 인덱스 체크
            }
        }

        // 자리교체
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < maxInt) {
                int tmp = arr[i];
                arr[i] = arr[maxIntIndex];
                arr[maxIntIndex] = tmp;
                break;
            }
        }

        // 다시 숫자로 만들어주기
        int cnt = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            answer += arr[i] * Math.pow(10, cnt);
            cnt++;
        }

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(solution(98244949)); // 99244948
        System.out.println(solution(10));
    }
}