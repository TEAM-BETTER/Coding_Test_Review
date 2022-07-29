//그림으로 그려보면서 아무곳이나 찍어보고 여기 를 기준으로 비교하고 줄여가면 되겠다 싶어
// 이분탐색 으로 구현했습니다.

class CodingTest03_박귀우 {
    public int solution(int[] number) {
        int left = 1;
        int right = number.length - 2;
        int idx = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // peek 는 하나 만 존재하거나 없다고 했으니 바로 브레이크 떄려줍니다.
            if (number[mid - 1] < number[mid] && number[mid] > number[mid + 1]) {
                idx = mid;
                break;
                // 현재 의 미드 값이 왼쪽 보다는 크고 오른쪽 보다 작다 ? 오른쪽으로 증가하는 그래프 이니 왼쪽을 버려줍니다.
            } else if (number[mid - 1] < number[mid] && number[mid + 1] > number[mid]) {
                left = mid + 1;
                // 위와는 반대의 경우이니 오른쪽을 버려줍니다.
            } else {
                right = mid - 1;
            }
        }
        return idx;
    }
}
