import java.util.Arrays;

class Solution {
    public int[] solution(int[] a, int[] b) {
        // 둘 다 0이라면 합은 0
        if (a.length == 0 && b.length == 0) return new int[0];
        a = reverseArray(a);
        b = reverseArray(b);

        int maxLength = Math.max(a.length, b.length); // 두 숫자중 긴 자리수
        int carry = 0; // 올려진수
        int[] answer = new int[maxLength + 1];//긴자리수에서 올라 갈 수도 있어서 미리 자리수를 올려서 선언

        // 가장작은 자리수 부터 합을 구한다.
        for(int i = 0; i < maxLength; i++) {
            int sum = 0;
            // i가 각 숫자의 길이를 초과하지 않는다면 더해준다.
            if (i < a.length) sum += a[i];
            if (i < b.length) sum += b[i];

            // 올려진 숫자가 존재한다면 합에 포함 해준다.
            if (carry >= 1) {
                sum += carry;
                carry = 0;
            }

            // 합이 10보다 크다면 올림수가 존재한다.
            if (sum >= 10) {
                carry += sum / 10;
                sum %= 10;
            }
            answer[i] = sum;
        }
        // 마지막 올림수가 있는지 체크
        if (carry >= 1)
            answer[maxLength] = carry;
        // 다시 답안 양식에 맞춰서 돌려준다.
        answer = reverseArray(answer);
        // 맨 앞자리가 0일 경우 원래 있던 배열에서 사이즈를 다시 줄여야 하기 때문에 새로운 배열을 만들어준다.
        if (answer[0] == 0) {
            int[] temp = new int[maxLength];
            for(int i = 1; i < answer.length; i++) {
                temp[i-1] = answer[i];
            }
            answer = temp;
        }
        return answer;
    }

    // 배열을 역순으로 뒤집어서 반환 해주는 함수
    public int[] reverseArray(int[] a) {
        int[] ret = new int[a.length];

        for(int i = a.length - 1, j = 0; i >= 0; i--, j++) {
            ret[j] = a[i];
        }

        return ret;
    }
}