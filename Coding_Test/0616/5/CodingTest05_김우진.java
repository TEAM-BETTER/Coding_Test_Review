package CodingTest4;

/**
 * 1. buildings의 0번 1번 인덱스값 만큼 빌딩의 넓이만큼 좌표값이 됨
 * 2. buildings의 2번 인덱스 값은 빌딩의 높이
 * 3. 좌표값에서 가장 왼쪽과 가장 오른쪽값을 기준을 둠
 * 4. 키포인트의 개수를 모르므로 일단 temp 배열의 크기를 좌표 범위만큼 지정
 * 5. 해당 범위 내 각 좌표마다 가장 높은 높이를 maxHeights 배열에 저장
 * 6. 제일 처음 키포인트와 마지막 키포인트는 고정
 * 제일 처음 키포인트: 제일 왼쪽 좌표의 가장 높은 높이가 첫 번쨰 키 포인트
 * 제일 마지막 키포인트: 제일 오른쪽 좌표와 높이 0이 마지막 키포인트
 * 7. 두 번째부터 마지막에서 두 번쨰 키포인트는 아래와 같이 구함
 * 제일 왼쪽에서 두 번쨰 좌표부터 마지막에서 두 번째 좌표까지 순회하면서
 * 직전 키포인트의 높이를 저장한 pastHeight 변수와 다음 좌표의 높이를 비교
 * pastHeight 값이 다음 좌표의 높이와 같으면 pass
 * pastHeight 값이 다음 좌표의 높이보다 작을 경우 다음 좌표와 다음 좌표의 높이가 키포인트
 * pastHeigth 값이 다음 좌표의 높이보다 클 경우 현재 좌표와 다음 좌표의 높이가 키포인트
 * 8. 6, 7번 과정을 통해 키포인트를 모두 구했고 개수는 idx
 * 따라서, answer 배열의 크기를 idx로 지정하고 temp 값들을 answer 배열로 옮기고 return
 */
class CodingTest05_김우진 {

    public static int[][] solution(int[][] buildings) {
        int minLeft = Integer.MAX_VALUE;
        int maxRight = 0;

        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];

            minLeft = Math.min(minLeft, left);
            maxRight = Math.max(maxRight, right);
        }

        int[][] temp = new int[maxRight - minLeft + 1][2];
        int[] maxHeights = new int[maxRight + 1];

        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];

            for (int i = left; i <= right; i++) {
                maxHeights[i] = Math.max(maxHeights[i], height);
            }
        }

        int idx = 0;

        /**
         * 제일 왼쪽 좌표의 가장 높은 높이가 첫 번쨰 키 포인트
         */
        temp[idx][0] = minLeft;
        temp[idx][1] = maxHeights[minLeft];
        int pastHeight = maxHeights[minLeft];
        idx++;

        /**
         * 직전 키포인트의 높이를 기준으로 아래와 같이 처리
         * i) 직전 키포인트보다 좌표의 높이가 높을 경우 다음 좌표와 다음 높이를 키포인트로 지정
         * ii) 직전 키포인트보다 좌표의 높이가 낮을 경우 현재 좌표와 다음 높이를 키포인트로 지정
         */
        for (int i = minLeft; i < maxRight; i++) {
            if (pastHeight == maxHeights[i + 1]) {
                continue;
            }
            if (pastHeight < maxHeights[i + 1]) {
                temp[idx][0] = i + 1;
            } else if (pastHeight > maxHeights[i + 1]) {
                temp[idx][0] = i;
            }

            temp[idx][1] = maxHeights[i + 1];
            idx++;
            pastHeight = maxHeights[i + 1];
        }

        /**
         * 마지막 키포인트는 가장 오른쪽 좌표와 0 고정
         */
        temp[idx][0] = maxRight;
        temp[idx][1] = 0;

        /**
         * 키포인트의 개수만큼만 배열을 지정해야하므로
         */
        int[][] answer = new int[idx + 1][2];

        for (int i = 0; i <= idx; i++) {
            answer[i][0] = temp[i][0];
            answer[i][1] = temp[i][1];
        }

        return answer;
    }
}