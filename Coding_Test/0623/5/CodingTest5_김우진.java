package CodingTest5;

public class CodingTest5_김우진 {
    /**
     * 이진탐색을 위해 M개의 치킨을 만들기 위해
     * (튀기는 시간 + 청소시간) * 만들어야하는 치킨갯수를 통해
     * 가장 오래걸리는 시간을 구합니다.
     * 닭을 N번 튀겼을 때 세척은 N - 1번, 튀기는 횟수는 N번
     * 따라서, mid값에 세척하는 시간을 더한 뒤 해당 값을 (튀긴 시간 + 세척 시간)으로 나눈 값들을 cnt에 더해줌
     * -> cnt: 시간이 mid일 때 튀길 수 있는 최대 치킨 수
     * 만약 cnt가 M마리 이상이면 최대시간을 하향시키고
     * cnt가 M마리 미만이면 최소 시간을 상향하여 최적의 시간을 구한다
     *
     */

    public static int solution(int N, int M, int[] fry, int[] clean) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < fry.length; i++) {
            right = Math.max(right, (fry[i] + clean[i]) * M);
        }

        int answer = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;

            for (int i = 0; i < fry.length; i++) {
                cnt += (mid + clean[i]) / (fry[i] + clean[i]);
            }

            if (cnt >= M) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
