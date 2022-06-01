/**
 * 금일 프로그래머스 1번 문제
 */

class Solution {
    public int solution(int n, int m) {
        int answer = 0;
        for (int i = n; i <= m; i++) {
            if (isPalindrome(i))
                answer++;
        }

        return answer;
    }

    public boolean isPalindrome(int n) {
        String s = Integer.toString(n);

        int left = 0;
        int right = s.length() - 1;

        char[] arr = s.toCharArray();

        while (left < right) {
            if (arr[left++] != arr[right--]) {
                return false;
            }
        }
        return true;
    }
}
