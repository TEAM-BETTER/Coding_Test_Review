// 어썌신 크리드가 생각나네요 주말에 한번 플레이 해야겠습니다.
/**
 * 문제를 읽어 보면 원형으로 이루어진 성 인데 이걸 손으로 그려보니 
 * 2개의 경우의수가 존재하는걸 알아냈습니다.
 * 처음에서 시작해서 마지막을 포함안하거나
 * 두번쨰 에서 시작해서 마지막을 포함하거나.
 */

class Solution {
    public int solution(int N, int[] rewards) {
        int len = rewards.length;
        if(len == 1) return rewards[0]; 
        return Math.max(kill(0,len-2,rewards),kill(1,len-1,rewards));
    }
    //start 시작할 인덱스,end 마지막 인덱스
    public int kill(int start,int end,int[] rewards){
        //한칸 앞을 제외한 앞에 2개를 픽합니다
        //앞에 2 개를 미리만들어서 dp 계산에 차질없이 더해줍니다.
        int dp[] = new int[rewards.length+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = rewards[start];
        for (int i = 3; i < dp.length; i++) {//앞에 2개를 채웠으니 3부터 시작합니다.
            dp[i] = rewards[start+i-2] + Math.max(dp[i-2],dp[i-3]);
        }
        return Math.max(dp[dp.length-1],dp[dp.length-2]);
    }
}
