package CodingTest3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *      1. trust 2차원 배열을 visited map에 재배치
 *      trust[i] index 0번을 key값으로 배치 ->모든 주민 번호,
 *      index 1번을 value인 set에 추가
 *      value값을 set으로 받으면서 중복없이 여러값을 받을 수 있게 함 -> 해당 주민이 믿는 사람의 값
 *
 *      2. N까지 주민들 중에 value 값이 없는 사람을 찾음 -> 아무도 믿지않는 것으로 판사후보
 *      key값과 value값이 동일값이 될 수는 없으니 continue;
 *      만약 후보가 2명 이상이면 false
 *
 *      3. 후보로 정해진 key값이 모든 value값에 포함되어있는지 chk
 *      value하나에라도 빠져있으면 false
 *
 *      4. 위의 조건을 충족하는 숫자를 리턴
 *
 */
public class CodingTest01_김우진 {
    public static int solution(int N, int[][] trust) {
        Map<Integer, Set<Integer>> visited = new HashMap<>();

        // visited map 초기화
        for (int i = 1; i <= N; i++) {
            visited.put(i, new HashSet<>());
        }

        for (int i = 0; i < trust.length; i++) {
            int from = trust[i][0];
            int to = trust[i][1];

            visited.get(from).add(to);
        }

        int candidate = -1;
        int nonTrustCnt = 0;

        /**
         * 아무도 안 믿는 사람 뽑기
         */
        for (int i = 1; i <= N; i++) {
            boolean trustPeople = false;

            for (int j = 1; j <= N; j++) {
                // 동일 인물은 제외
                if (i == j) {
                    continue;
                }

                /**
                 * i가 j를 믿으면
                 * i가 누군가를 믿는 것이므로 trustPeople = true
                 * 후보에서 탈락
                 */
                if (visited.get(i).contains(j)) {
                    trustPeople = true;

                    break;
                }
            }

            /**
             * 아무도 안 믿는 사람이면 후보에 추가
             * 후보가 2명 이상인 것을 체크하기 위해 nonTrustCnt 변수가 존재
             */
            if (trustPeople == false) {
                candidate = i;
                nonTrustCnt++;
            }
        }

        /**
         * 아무도 안 믿는 사람이 1명 아니면 -1
         */
        if (nonTrustCnt != 1) {
            return -1;
        }

        /**
         * 후보가 한명이면 이 후보를 마을 사람들이 다 믿는지 체크
         */
        for (int i = 1; i <= N; i++) {
            if (i == candidate) {
                continue;
            }

            // 한명이라도 후보를 안 믿으면 -1 반환
            if (visited.get(i).contains(candidate) == false) {
                return -1;
            }
        }
        return candidate;
    }
}