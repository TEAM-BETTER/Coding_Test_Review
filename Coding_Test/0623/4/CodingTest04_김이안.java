import java.util.Arrays;
/*
이분탐색을 이용한 방식입니다.
 */
class Solution {
    public int solution(int N, int[] branches) {
        int max = Arrays.stream(branches).max().getAsInt();     //나뭇가지 배열의 최대 값을 max값으로 정했습니다.
        int min = 1;
        int mid = 0;
        if(branches == null || branches.length == 0 || Arrays.stream(branches).sum() < N) {     // 배열의 모든 합이 N보다 작을 경우 -1 리턴
            return -1;
        }
        while(min < max){
            mid = (max + min)/2;
            int count = 0;
            for (int i = 0; i < branches.length; i++) {
                count += (branches[i] / mid);       // 배열의 값을 mid값(길이)로 나누어 갯수를 카운트 해줍니다.
            }
            if(count < N) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }
        return min-1;
    }
}