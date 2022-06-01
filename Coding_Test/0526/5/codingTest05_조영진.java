public class codingTest05_조영진 { // 하다 말았습니다ㅜㅜ 이모양이 되기 전에 4점이었습니다..
    public static long solution(int N, int M, int K, int[] capacity) {
        int diff;
        int temp = 0;
        int mulTemp = 1;
        long answer = 1;
        for(int i = 0; i < capacity.length; i++){
            temp += capacity[i];
        }
        diff = N - temp;
        while(diff != -1){
            for(int i = 0; i <= diff; i++){
                if(N < capacity[i]){
                    mulTemp *= 1;
                    break;
                }
                if(i == 0){
                    mulTemp *= combination(N, capacity[i]-diff);
                    N -= (capacity[i]-diff);
                    break;
                }else{
                    mulTemp *= combination(N, capacity[i]);
                    N -= capacity[0];
                }
            }
            diff--;
        }

        answer *= permutation(K, M);
        return answer;
    }
    public static long permutation(int n, int m){
        long temp = 1;
        for(int i = n; i >= n-m+1; i--){
            if(i == 0){
                return temp;
            }
            temp *= i;
        }
        return temp;
    }
    public static long combination(int n, int m){
        long temp = permutation(n, m);
        long mFact = 1;
        if(n >=m){
            for(int i = 2; i <= m; i++){
                mFact *= i;
            }
        }

        return temp / mFact;
    }
}
