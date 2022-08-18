/**
 * ㅎㅎ.... 좀더 도전해봐도 모르겠네요 애는 답을 보고 업데이트 하겠습니다.
 * 
 */

class Solution {
    public int solution(int[] status) {
        int cnt = 0;
        for (int i = 0; i < status.length; i++) {
            if (status[i] == 1)
                cnt++;
        }
        if (cnt == status.length)
            return 0;
        if (cnt == status.length - 1 && status[status.length - 1] == 0)
            return 1;
        return -1;
    }
}