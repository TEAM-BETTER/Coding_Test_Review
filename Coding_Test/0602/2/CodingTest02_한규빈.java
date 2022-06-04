package codingTest2;

import java.util.Stack;

public class CodingTest02_한규빈 {
    public static int[] solution(int[] a, int[] b) {
        int[] answer = {};
        Stack<Integer> stack = new Stack<>();
        int max = Math.max(a.length, b.length); // 두 배열 중 큰 배열 사이즈 만큼 반복문을 돌리기 위한 max 변수

        // 맨 뒤 인덱스 부터 계산하기 위해서 맨 뒤 인덱스 변수들 추가
        int aIdx = a.length - 1;
        int bIdx = b.length - 1;
        int cnt = max;
        int carry = 0; // carry bit를 위한 변수 추가
        while (cnt > 0) {
            // idx가 0 이하 일 경우 0 을 대입
            int aNum = aIdx >= 0 ? a[aIdx] : 0;
            int bNum = bIdx >= 0 ? b[bIdx] : 0;
            int sum = carry + aNum + bNum;
            if(sum > 9) {
                // 각 자리를 더한 값이 10 이상이면 carry 변수에 1을 대입 후
                // sum에서 10을 뺀 값을 stack에 추가
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            stack.push(sum);

            aIdx--;
            bIdx--;
            cnt--;
        }

        // 반복문을 다 돈 후 carry bit가 1일 경우 stack에 1추가
        if(carry == 1) {
            stack.push(1);
        }

        answer = new int[stack.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 1, 4, 6};
        int[] b= {6, 1, 0, 4, 4};
        System.out.println(solution(a, b));

        a = new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        b= new int[]{1};
        System.out.println(solution(a, b));
    }
}
