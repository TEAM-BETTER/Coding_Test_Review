class Solution {
    public int solution(int n) {
        int answer = 0;

        //n 이 1이면 소수 없음
        if(n < 2) {return 0;}

        //n 까지 모든 숫자를 홀수로 나눠 소수갯수 체크
        for(int i=1;i<=n;i++){
            int remainCnt = 0;

            //n이 2이면 소수 1개
            if(i == 2) {answer++; continue;}
            for(int j=1;j<=i;j=j+2){
                int remain = i%j;
                if(remain == 0) {
                    remainCnt++;
                }

                // 나눠서 0이 되는게 1과 본인일 경우 --> 소수
                if((i==j || j == i+1) && remainCnt==2){
                    answer++;
                }

            }
        }
        return answer;
    }
}