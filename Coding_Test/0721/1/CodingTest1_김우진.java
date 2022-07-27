package CodingTest9;

import java.util.*;

/**
 * class Node (to, weight)
 * 1. 2중 ArrayList 를 만든다 배열의 길이는 N+1
 * 2. 2중 for문을 돌며 friend 와 time 배열의 데이터를 graph list에 넣어준다
 * 3. dist배열의 길이는 N만큼, i번째 친구가 거짓말을 믿기까지 걸리는 시간을 더해서 넣어줄 배열
 * 4. 초기 dist배열의 데이터는 Integer.MAX_VALUE로 셋팅
 * 5. 0번 친구부터 시작하므로 dist[0]번은 0으로 초기화
 * 6. PriorityQueue로 weight를 오름차순으로 정렬 후, pq에 0, 0 을 초기값으로 셋팅
 * 7. pq에 남은 데이터가 없을 때 까지 반복
 * 8. pq에 있는 데이터를 poll하고 curNode에 데이터값을 넣고
 *  graph의 curNode와 같은 to를 가진 데이터를 확인, 확인하는 데이터는 adjNode
 *  만약 dist에 저장 된 weight값보다 curNode.weight + adjNode.weight값이 작으면
 *  curNode.weight + adjNode.weight를 저장해줌 // 배열을 돌면서 최소값으로 업데이트
 * 9. answer값은 저장 된 배열 중 가장 큰 수가 정답이 됨 = 모든 친구들이 다 믿는 시간
 *      만약 배열 중 한 구간이라도 초기값이 존재한다면 다 믿지 못했다 => -1을 리턴
 *
 */

public class CodingTest1_김우진 {
    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static int solution(int N, int[][] friend, int[][] time) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < friend[i].length; j++) {
                graph.get(i).add(new Node(friend[i][j], time[i][j]));
            }
        }

        int[] dist = new int[N];

        for (int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        dist[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (dist[curNode.to] < curNode.weight) {
                continue;
            }

            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                if (dist[adjNode.to] > curNode.weight + adjNode.weight) {
                    dist[adjNode.to] = curNode.weight + adjNode.weight;

                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}