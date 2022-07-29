public class CodingTest04_윤지용 {
    public long solution(int N, int[] branches) {

        long totalLeng = 0; // 총 더한 길이
        for (int i = 0; i < branches.length; i++) {
            totalLeng += branches[i];
        }

        long left = 1; // 최소로 짧은 길이
        long right = totalLeng / N; // 최대로 긴 길이
        long answer = -1; // 아닐경우 -1로 출력
        // 이진탐색 시작
        while (left <= right) {
            long mid = (left + right) / 2;

            int cnt = 0; // 만들어진 개수 세기
            for (int i = 0; i < branches.length; i++) {
                cnt += (int)(branches[i] / mid);
            }
            // 필요한 개수보다 많거나 같으면
            if (cnt >= N) {
                left = mid + 1; // 더 크게 잘라야 함 (혹은 더 크게 자를 수도?)
            } else {
                right = mid - 1; // 더 작게 잘라야 함
            }
            // 정답 업데이트
            if (cnt >= N) {
                answer = mid;
            }
        }
        return answer;
    }
}
