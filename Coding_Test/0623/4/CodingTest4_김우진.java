package CodingTest5;

import java.util.Arrays;

class CodingTest4_김우진 {
    /**
     *  이진탐색으로 배열 branches를 N번으로 나눌때 가장 크게 나눌 수 있는 값을 찾습니다.
     *  이진탐색을 하면서 고려해야 할 조건은 N번째로 나눠져야하고, 가장 큰 값을 찾아야합니다
     *  이진탐색을 시작하고 먼저 branches배열을 돌면서 branch들을 mid값으로 나누었을때
     *  몇 개의 branch로 나뉘는지 확인
     *  만약 N보다 같거나 더 크게나왔다면 answer값을 업데이트, 작게 나왔다면 범위를 수정하여 탐색
     *  기저 사례: mid가 0이 될 경우 0으로 나뉘면서 exception이 발생하므로 mid가 0이 될 경우 break
     *  해당 조건을 만족하면서 가장 크게나온 answer값이 답이됩니다.
     */
        public static int solution(int N, int[] branches) {
            Arrays.sort(branches);

            int left = 0;
            int right = branches[branches.length - 1];
            int answer = -1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (mid == 0) {
                    break;
                }

                int cnt = 0;

                for (int branch : branches) {
                    cnt += branch / mid;
                }

                if (cnt >= N) {
                    answer = Math.max(answer, mid);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return answer;
        }
    }