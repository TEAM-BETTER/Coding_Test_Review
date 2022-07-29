class Solution {
    public boolean solution(int[] param0) {
        int last = param0.length-1;     // 마지막 인덱스
        for (int i = last-1; i >= 0 ; i--) {    // 마지막 - 1 인덱스 부터 0까지
            int sum = param0[i] + i;    // 인덱스 + 해당 인덱스의 값
            if(sum >= last){            // sum이 last보다 더 크면 last까지 갈 수 있기 때문에
                last = i;               // last 인덱스를 i로 바꿔줍니다
            }
        }
        if(last == 0) return true;      // last가 0일 경우에만 마지막 인덱스에 도착할 수 있습니다.
        return false;
    }
}