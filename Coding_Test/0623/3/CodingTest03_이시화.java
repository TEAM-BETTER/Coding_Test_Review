// 이분탐색으로 쉽게 가능
// 일반 for 문으로 풀 수 있지만 시간적으로 많이 걸림
// 이분 탐색 시간 복잡도 O(logN)
// for 문 시간 복잡도 O(N)
// peek 값이 없으면 오름차순 정렬이거나 내림차순 정렬이라는 설명이 있어서 쉬웠음
public class Solution {
    public int solution(int[] arr) {
        int left = 1;                           // peek index 가 가능한 가장 작은 수
        int right = arr.length - 2;             // peel index 가 가능한 가장 큰 수

        while (left <= right) {                 // 이분탐색 시작   ([/] [mid] [\]) 인 mid 값 찾기
            int mid = (left + right) / 2;       // mid 값을 기준으로 mid 값 양 쪽 index 와 비교햐여 크기에 따라 left, right 값 조정

            if (arr[mid] > arr[mid - 1]) {      // mid - 1 값이 mid 값 보다 작을 때 ([/] [mid] [?])
                if (arr[mid] > arr[mid + 1]) {  // mid + 1 값이 mid 값 보다 클 때   ([/] [mid] [\]) 정답 반환!!
                    return mid;
                } else {                        // ([/] [mid] [/]) 이므로 오름차순 부분, left 값 mid + 1 로 변환
                    left = mid + 1;
                }
            } else if (arr[mid] > arr[mid + 1]) {// ([\] [mid] [\]) 이므로 내림차순 부분, right 값 mid - 1 로 변환
                right = mid - 1;
            }
        }
        return -1;                              // while 문을 다 돌았음에도 반환 되지 않으면 peek 값이 없으므로 -1 반환
    }
}
