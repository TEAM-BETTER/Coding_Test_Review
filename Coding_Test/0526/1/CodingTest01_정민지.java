class Solution {
  // 소수 판별 함수
    static boolean isPrime (int n){
        if (n < 2) return false;
        /*
          1. 2부터 N까지의 모든 수, i^i이 n보다 작거나 같을 동안 반복
          2. n이 i의 배수일 경우 소수가 아님.
         */
        for(int i = 2; i*i <= n; i++){
            if (n % i == 0) return false;
        }
        return true;
    }
    public int solution (int n) {
        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (isPrime(i)) answer++;
        }
        return answer;
    }
}
