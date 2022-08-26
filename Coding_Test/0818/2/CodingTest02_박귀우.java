/**
 * 조합을 이용해서 해결하려고 했지만 효율성 전부 탈락했습니다.
 * 10점 짜리 코드입니다.
 */

import java.util.*;

class Solution {
    int target ;
    int answer ;
    public int totalSum(int[] arr,int i){
        int total = 0;
        for (int j = 0; j < i; j++) {
            total+=arr[j];
        }
        return total;
    }
    public int solution(int[] arr, int target) {
        Arrays.sort(arr); //정렬 을 이용해 가장 작은값 부터 시작
        this.target = Arrays.stream(arr).sum(); // 모든값을 더한 total 값설정
        this.answer = Integer.MAX_VALUE;
        for (int i = 3; i <= arr.length; i++) { //카드는 3장 고정 임으로 3부터 시작
            int totalRs = totalSum(arr,i); // 처음 시작 부분의 합이 타겟보다 크다면 함수종료 뒤에는 찾을 필요가없음
            if(Math.abs(totalRs-target) > Math.abs(target - answer)){
                return answer;
            }
            boolean[] visit = new boolean[arr.length]; //방문배열
            int[] out = new int[i]; //조합 결과값 리턴용 배열
            combination(arr,visit,out,0,0);
        }
        return answer;
    }
    void combination(int[] nums, boolean[] visit, int[] out,int start,int depth){
        //일반 조합구현
        int sum = Arrays.stream(out).sum();
        if(answer == target) return; //답을 찾은경우 조합을 돌필요없이 리턴해준다.
        if(depth == out.length){ //깊이 와 결과값 길이 같다면 리턴
            if(Math.abs(target - sum) < Math.abs(target - answer)){
                answer = sum;
            }else if(Math.abs(target - sum) == Math.abs(target - answer)){
                answer = Math.min(sum,answer);
            }
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(!visit[i]){
                visit[i] = true;
                out[depth] = nums[i];
                combination(nums,visit,out,i+1,depth+1);
                visit[i] = false;
            }
        }
    }
}