/*
* 16점 코드입니다 배열 정렬 후 투 포인터로 풀었습니다
* for 반복문으로 기준 값을 잡고 left, right 인덱스를 옮기면서 가까운 값을 찾습니다.
* */
import java.util.*;
class Solution {
    public int solution(int[] arr, int target) {
        Arrays.sort(arr);   // 오름차순 정렬
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == target) return sum;
                else if (sum > target) right--;
                else left++;
                if (Math.abs(sum - target) < Math.abs(answer - target)) {       // 가까운 값을 찾기위한 절대값 비교
                    answer = sum;
                }
            }
        }
        return answer;
    }
}