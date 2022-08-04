/**
 * 예전 그리디 파트 부분 강사님 과 풀었던 부분입니다.
 * 동일하게 작성해서 풀었습니다.
 */

class Solution {
    public boolean solution(int[] param0) {
        int idx = 0;
        for (int i = 0; i < param0.length; i++) {
            if (idx < i) {
                return false;
            } else if (idx >= param0.length - 1) {
                return true;
            }
            idx = Math.max(idx, i + param0[i]);
        }
        return true;
    }
}