class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while(a!=b){
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
