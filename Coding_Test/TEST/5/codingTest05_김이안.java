class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while(a!=b){
            /*
            n을 a와 b 중간값으로 초기화를 시켜줍니다.
            a 와 b는 2로 나눈값의 반올림을 해주면서 a=b로 수렴할 때까지 연산을 합니다.
            좀 더 간결한 코드로 할 수 있었는데 시간이 부족했네요

             */
            if (a < b){
                n = (b-a)/2 + a;
                if(a <= n && b > n){
                    answer ++;
                    a = Math.round((float)a/2);
                    b = Math.round((float)b/2);
                }
            }else{
                n = (a-b)/2 + b;
                if(b <= n && a > n){
                    answer ++;
                    b = Math.round((float)b/2);
                    a = Math.round((float)a/2);
                }
            }
        }

        return answer;
    }
}
