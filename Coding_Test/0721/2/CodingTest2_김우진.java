package CodingTest9;

import java.util.*;

/**
 * 전형적인 다익스트라
 * Class Node (to, weight, cnt)
 * 1. 2중 ArrayList를 사용하여 1차 ArrayList는 N+1만큼 배열의 크기를 만들어준다.
 * 2. 다음 ArrayList에 flight 배열에서 받은 to, weight와 cnt 변수를 별도로 0으로 잡아 넣어준다.
 * 3. dist 배열은 weight의 최소값을 계속 저장해 줄 배열,
 *      모든 배열의 기본값을 1000000으로 세팅하고 start가 되는 a 값은 0으로 잡아준다.
 * 4. PriorityQueue를 통해 weight 의 오름차순으로 정렬
 * 5. start가 되는 a값을 pq에 넣고, pq 배열에 남는 데이터가 없을때 까지 반복
 * 6. pq배열에 넣어둔 초기값을 poll로 제거하고, curNode로 만듬
 * 7. curNode의 cnt가 k보다 크면 조건 성립 불가, continue;
 * 8. curNode에서 to까지의 비용이 dist배열에 저장해 둔 weight값 보다 현재 curNode의 weight가 크면 continue;
 * 9. graph의 to가 현재 curNode와 동일한 데이터가 있다면 adjNode로 지정하고 반복문을 통해
 *      dist배열에 저장 된 weight값과 현재 curNode의 weight + adjNode 의 weight값을 비교한다.
 *      새로 더한 값이 더 작은 값이면 dist배열에 weight값 업데이트하고
 *      새로 adjNode를 pq에 넣고 adjNode 다음으로 갈 노선을 찾아본다.
 * 10. 7-9를 반복하여 k값을 넘지 않고, 더 적은 비용이 드는 루트를 탐색
 * 11. dist값에 저장 된 데이터를 토대로 목적지 b 에 저장 된 dist[b]값을 answer로 지정 후 리턴
 *      만약dist[b]값이 초기값 100000과 동일하다면 루트를 찾지 못한 것으로 -1리턴
 *
 */
public class CodingTest2_김우진 {
    static class Node {
        int to;
        int weight;
        int cnt;

        public Node(int to, int weight, int cnt) {
            this.to = to;
            this.weight = weight;
            this.cnt = cnt;
        }
    }

    public static int solution(int N, int[][] flight, int a, int b, int k) {
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < flight.length; i++) {
            graph.get(flight[i][0]).add(new Node(flight[i][1], flight[i][2], 0));
        }
        int[] dist = new int[N];

        for (int i = 0; i < N; i++) {
            dist[i] = 1000000;
        }

        dist[a] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        pq.offer(new Node(a, 0, 1));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (curNode.cnt > k) {
                continue;
            }

            if (dist[curNode.to] < curNode.weight) {
                continue;
            }

            for (int i = 0; i < graph.get(curNode.to).size(); i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                if (dist[adjNode.to] > curNode.weight + adjNode.weight) {
                    dist[adjNode.to] = curNode.weight + adjNode.weight;

                    pq.offer(new Node(adjNode.to, dist[adjNode.to], curNode.cnt + 1));
                }
            }
            answer = dist[b];
        }
        return answer == 1000000 ? -1 : answer;
    }

    public static void main(String[] args) {
        int N = 4;
        int [][] flight = {{0, 2, 1}, {1, 3, 20}, {1, 0, 8}, {2, 3, 1}, {0, 3, 3}};
        int a = 1;
        int b = 3;
        int k = 2;
        System.out.println(solution(N, flight, a, b, k));
    }

}