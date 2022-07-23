package CodingTest9;

import java.util.*;

/**
 * 1. init 메서드는 parents, size배열을 초기값으로 초기화해줌
 *      parents 는 배열 i에 데이터 i값으로, size는 1로
 * 2. findParent 는 서로 연결된 데이터를 확인해주는 메서드
 * 3. 먼저 infected 베열을 오름차순 정렬 (문제 조건: 단, 정답이 여럿인 경우 더 작은 인덱스를 출력하시오.)
 *      infected[i]번째를 치료한다면 그 외 감염자들의 수를 체크함
 * 4. graph[y][x] == 1 이라면 연관 된 사람이 있다
 *      -> findParent 메서드로 parents배열에 서로 연관이 있다 groupX의 값을 groupY idx 값으로 넣어둠
 *      -> size 배열은 groupX 의 값을 groupY의 값을 더해서 업데이트
 * 5. set 배열로 확인 된 감염자가 겹치지 않게 감염자 수를  체크하기 위함
 *      -> infected 배열 돌면서 치료된 사람 제외, 감염자 중 감염시킬 수 있는 인원 체크
 * 6. 감염시킬 수 있는 인원이 적게 체크되면 answer 업데이트
 * 7. answer = 감염을 최소화 할 수 있는 감염자의 index값
 *
 */
public class CodingTest3_김우진 {

    public static int[] parents;

    public static int[] size;

    public static void init(int N) {
        parents = new int[N];
        size = new int[N];

        for (int i = 0; i < N; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public static int findParent(int idx) {
        if (parents[idx] == idx) {
            return idx;
        }

        return parents[idx] = findParent(parents[idx]);
    }

    public static int solution(int N, int[][] graph, int[] infected) {
        if (N == 1) {
            return infected[0];
        }

        Arrays.sort(infected);
        int maxInfected = Integer.MAX_VALUE;
        int answer = 0;

        // 한명씩 치료하면서 확인해봐야함
        for (int i = 0; i < infected.length; i++) {
            init(N);
            int cured = infected[i];

            /**
             * 전처리를 하여 치료된 사람을 제외한 감염자들에 대해 그룹 형성
             */
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    if (y == cured || x == cured) {
                        continue;
                    }

                    if (graph[y][x] == 1) {
                        int groupY = findParent(y);
                        int groupX = findParent(x);

                        if (groupY == groupX) {
                            continue;
                        }

                        parents[groupY] = groupX;
                        size[groupY] += size[groupX];
                    }
                }
            }

            Set<Integer> set = new HashSet<>();
            int total = 0;

            /**
             * 치료자를 제외한 감염자들에 의해 감염된 총 인원 파악
             */
            for (int infect : infected) {
                if (infect == cured) {
                    continue;
                }

                int idx = findParent(infect);
                int infectedByIdx = size[idx];

                if (set.contains(idx) == false) {
                    set.add(idx);
                    total += infectedByIdx;
                }
            }

            /**
             * 현재 감염된 인원이 그 전보다 적을 경우 업데이트
             */
            if (maxInfected > total) {
                maxInfected = total;

                answer = cured;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int N = 3;
        int[][] graph = {{1,1,0},{1,1,0},{0,0,1}};
        int[] infected = {0, 2};

        System.out.println(solution(N, graph,infected));
    }

}