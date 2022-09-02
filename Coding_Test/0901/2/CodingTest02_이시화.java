package codiingTest.codingTest15.p2;


import java.util.Arrays;

// 부릍포스로 하는 방법 말고는 생각이 나질 않습니다.
// 구현하지 않았지만 부르트포스로 구현하게 되면 1000만이
// 넘어가는 for 문을 돌아야 하므로 시간초가과 무조껀 발생할 것같습니다.
public class Solution {
    public int solution(int[] buckets, int m) {
        int answer = 0;
        int len = buckets.length;
        Arrays.sort(buckets);
        int[] interval = new int[len - 1];
        for (int i = 1; i < len; i++) {
            interval[i] = buckets[i - 1] - buckets[i];
        }


        return answer;
    }
}

// 0    0   0   0   0   0   0   0   0   0
// 1                1                   1