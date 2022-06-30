/*
이번에 배운 이분탐색 방법을 재귀함수로 쓰는 방법입니다.
 */
class Solution {
    public static int peakIdx(int[] nums, int left, int right) {    //피크 값의 인덱스를 찾는 함수
        int mid = (left + right) / 2;
        if(mid == 0 || mid == nums.length-1){   // 첫 인덱스 혹은 마지막 인덱스일 경우 피크 값이 없으므로 -1 리턴
            return -1;
        }
        if (nums[mid - 1] <= nums[mid] &&  nums[mid + 1] <= nums[mid]) {    // 피크 값일 경우의 인덱스 리턴
            return mid;
        }

        if (mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
            return peakIdx(nums, left, mid - 1);
        }

        return peakIdx(nums, mid + 1, right);
    }
    public int solution(int[] arr) {
        if (arr == null || arr.length == 0) {   // 예외처리
            return -1;
        }

        int index = peakIdx(arr, 0, arr.length - 1);
        return index;
    }
}