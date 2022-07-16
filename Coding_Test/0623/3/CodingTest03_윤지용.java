public class CodingTest03_윤지용 {
    // 문제를 제대로 안읽어서 매우 복잡하게 아래로 피크인 것까지 생각해서 풀었습니다...
    // 나중에 아래로 피크인 것까지 문제가 나오는 것 미리 연습한 셈 치겠습니다...
    public static int solution(int[] arr) {
        int left = 0;
        int right = arr.length-1;

        // 방향(기울기) 설정
        int leftDir = (arr[left] > arr[left+1]) ? -1 : 1;
        int rightDir = (arr[right-1] > arr[right]) ? -1 : 1;

        // 맨 왼쪽이랑 맨 오른쪽이 기울기가 같으면
        if(leftDir == rightDir) {
            return -1; // 피크 없네
        }

        int mid = (left + right) / 2;
        // 이진탐색
        while(left <= right) {
            mid = (left + right) / 2;
            // -1이면 내려가는 중, 1이면 올라가는 중
            leftDir = (arr[left] > arr[left+1]) ? -1 : 1;
            rightDir = (arr[right-1] > arr[right]) ? -1 : 1;
            int midLeftDir = (arr[mid-1] > arr[mid]) ? -1 : 1; // 가운데 좌측방향
            int midRightDir = (arr[mid] > arr[mid+1]) ? -1 : 1; // 가운데 우측방향
            // 가운데 좌우가 방향이 다르면
            if(midLeftDir != midRightDir) {
                return mid; // 여기네
            }

            if(leftDir != midLeftDir) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return -1;
    }

}
