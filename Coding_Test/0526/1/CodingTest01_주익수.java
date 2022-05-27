class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 3; i <= n; i++) {
            if (isPrime(i)) //소수일 경우, answer에 count
                answer++;
        }
        return answer;
    }

    public boolean isPrime(int num) {
        for (int i = 3; i < num; i++) {
            if (num % i == 0) //나눠질 경우, 소수가 아님
                return false;
        }
        return true;
    }
}