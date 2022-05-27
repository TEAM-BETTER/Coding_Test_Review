class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 3; i <= n; i++) {
            if (isPrime(i))
                answer++;
        }
        return answer;
    }

    public boolean isPrime(int num) {
        for (int i = 3; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}