import java.util.Arrays;

class Solution {
    public int solution(int n) {
        return countPrime(n);
    }
    public int countPrime(int n ){
        boolean[] nums = new boolean[n+1]; // 0~n 까지의 소수를 알려줄 배열
        Arrays.fill(nums,true);
        nums[0] = false; 
        nums[1] = false; // 0,1 은 소수가 아니라서 이렇게 제거해주고 2부터 시작합니다.
        for(int i=2;i<=n;i++){
            if(nums[i]){
                for(int j=i+i;j<=n;j+=i){ // 소수 로 시작하는 배수는 소수가 아닙니다.
                    nums[j]=false;
                }
            }
        }
        int result =0;
        for (boolean b:nums) {
            if(b)result++;
        }
        return result; //이렇게 했더니 마지막 5번 케이스가 통과가 안되더라고요 .. ㅠㅠ
    }
}
