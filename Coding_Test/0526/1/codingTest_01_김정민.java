class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] primes = new boolean[n+1]; // 1~n까지 소수임을 알려주는 배열 flase이면 소수

        // 2부터 루트 n보다 작을 때까지
        for(int i = 2; i * i < n; i++) {
            if (primes[i]) continue; // 소수가 아니면 넘어간다

            // 소수의 배수는 소수가 아님
            for(int j = i + i; j < n; j += i) {
                primes[j] = true;
            }
        }

        // 소수의 개수를 세준다.
        for(int i = 2; i < n; i++) {
            if (!primes[i]) {
                answer++;
            }
        }

        return answer;
    }

}