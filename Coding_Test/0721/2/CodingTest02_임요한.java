import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;


class Node {
    int to;
    int price;
    int count;

    public Node(int to, int price, int count) {
        this.to = to;
        this.price = price;
        this.count = count;
    }
}

class CodingTest02_임요한 {
    public int solution(int N, int[][] flight, int a, int b, int k) {
        ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < flight.length; i++) {
            list.get(flight[i][0]).add(new Node(flight[i][1], flight[i][2], 0));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.price - y.price);
        pq.offer(new Node(a, 0, 0));


        int[] dist = new int[N];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[a] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (curNode.count <= k && curNode.to == b) {
                return curNode.price;
            // 현재 노드가 b면서 count가 k 이하면 바로 리턴. (우선순위 큐 특성상 이 조건을 만족하는 price가 최상단에 있으므로)
            }
            if (curNode.count > k) {
                continue;
            }

            for (int i = 0; i < list.get(curNode.to).size(); i++) {
                Node adjNode = list.get(curNode.to).get(i);
                if (dist[adjNode.to] > curNode.price + adjNode.price) {
                    dist[adjNode.to] = curNode.price + adjNode.price;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to], curNode.count + 1));
                }
            }

        }
        return -1;
    }


    public static void main(String[] args) {
        int N = 4;
        int[][] flight = {{0,1,1}, {1,2,20}, {1,0,8}, {2,0,1}, {0,2,3}};
        int a = 1;
        int b = 3;
        int k = 2;

        System.out.println(new CodingTest02_임요한().solution(N, flight, a, b, k));
    }
}