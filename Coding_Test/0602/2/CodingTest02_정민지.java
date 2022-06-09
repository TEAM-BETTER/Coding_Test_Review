import java.util.*;
class Solution {
  // 데크를 배열로 바꿔주는 함수
    public int[] toArrayDeq(Deque deque) {
        int[] arr = new int[deque.size()];
        int cnt = 0;
        while (!deque.isEmpty()) {
            arr[(arr.length - 1) - cnt] = (int) deque.pollLast();
            cnt++;
        }
        return arr;
    }
    public int[] solution(int[] a, int[] b) {
        // 두 배열 중 길이가 더 큰 배열의 길이
        int max = a.length < b.length ? b.length : a.length;
        // 데크 선언
        Deque deque = new ArrayDeque();
        // 배열을 다 돌았는지 확인할 cnt, 올림을 담당하는 carry
        int cnt = 0, carry = 0;
        // 같으면 배열을 다 순회한 것이기 때문에 중단, 아니면 계속 =>
        while (max != cnt) {
          // 만약 배열 순회가 끝났을 경우 ((length - 1) - cnt) < 0 이면 0, 아니면 배열의 요소를 넘김
            int tmpA = (a.length - 1) - cnt >= 0 ? a[(a.length - 1) - cnt] : 0;
            int tmpB = (b.length - 1) - cnt >= 0 ? b[(b.length - 1) - cnt] : 0;
            // 합은 올림 숫자와 두 배열의 숫자들
            int sum =  tmpA + tmpB + carry;
            // 자리 올림
            carry = sum / 10;
            // 데크에 들어가는 값은 우선 합의 나머지
            deque.addFirst(sum % 10);
            cnt++;
        }
        // 만약 반복문을 끝내고 나왔는데 자리 올림이 남아있다면 삽입
        if (carry != 0) deque.addFirst(carry);
        return toArrayDeq(deque);
    }
}
