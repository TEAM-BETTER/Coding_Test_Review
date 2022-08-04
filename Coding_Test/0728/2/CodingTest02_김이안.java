import java.util.*;
/*
    저는 완전 탐색으로 풀었는데 그리디 문제였네요....ㅋㅋㅋㅋㅋ
    모든 경우의 수 중에 제일 높은 값을 찾는 로직입니다.
*/
class Solution {
    public int solution(int num) {
        int answer = num;
        char[] nums = Integer.toString(num).toCharArray();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                char[] curNums = swap(nums,i,j);
                answer = Math.max(answer, Integer.parseInt(new String(curNums)));
            }
        }
        return answer;
    }
    public static char[] swap(char[] nums, int i, int j){       // i와 j 인덱스의 값을 바꾸는 메서드
        char[] curNums = Arrays.copyOf(nums, nums.length);
        char tmp = curNums[i];
        curNums[i] = curNums[j];
        curNums[j] = tmp;
        return curNums;
    }
}