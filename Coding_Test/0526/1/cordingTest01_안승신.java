class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i < n; i++) { //입력된 n보다 작은 수 모두를 불러오는 반복문
            int cnt = 0; //소수를 판별하기 위한 카운팅 변수
            for (int j = 1; j <= i; j++) { //i이하의 모든 수로 나누어 보려고요
                if(i%j == 0) { //i가 j로 나누어 떨어지는가?
                    cnt++;
                }
            }
            if(cnt == 2) { //소수는 1과 자기 자신으로 밖에 나누어 떨어지지 않으므로 카운팅 변수가 2가 되어야 함
                answer++;
            }
        }

        return answer;
    }
}