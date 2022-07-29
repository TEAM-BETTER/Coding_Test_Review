package CodingTest5;

public class CodingTest3_김우진 {
    /**
     * 정렬되어 있는 원배열에서 peak값을 찾기 위해 이진탐색을 합니다.
     * peak값은 index-1보다 크고 index + 1보다도 커야한다
     * 만약 중간값이 peak값이 아니라면 index-1보다 큰지 작은지 체크하고
     * 해당값에 따라 탐색범위를 줄여가며 mid값이 peak값이 되도록 계속 이진탐색 반복
     * 만약 찾지못하면 -1값을 리턴합니다.
     */
    public static int solution(int[] arr) {
        int left = 0;
        int right = arr.length;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (mid == 0 || mid == arr.length - 1) {
                break;
            } else if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid - 1] < arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}