import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
class Node {
    int to;
    int time;

    public Node(int to, int time) {
        this.to = to;
        this.time = time;
    }
}
class Solution2 {

    public int solution(int N, int[][] friend, int[][] time) {
        ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < friend.length; i++) {
            for (int j = 0; j < friend[i].length; j++) {
                list.get(i).add(new Node(friend[i][j], time[i][j]));
            }
        }

        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.time - y.time);
        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            for (int i = 0; i < list.get(curNode.to).size(); i++) {
                Node adjNode = list.get(curNode.to).get(i);
                if (dist[adjNode.to] > dist[curNode.to] + adjNode.time) {
                    dist[adjNode.to] = dist[curNode.to] + adjNode.time;
                    pq.offer(new Node(adjNode.to, dist[adjNode.to]));
                }
            }
        }

        boolean isAllFriend = true;

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                isAllFriend = false;
            }
        }

        return isAllFriend  ? Arrays.stream(dist).max().getAsInt() : -1;

    }

    public static void main(String[] args) {
        int N = 5;

        int[][] friend = {{1, 4}, {2, 3}, {4}, {1}, {0, 2}};

        int[][] time = {{5, 2}, {6, 4}, {9}, {1}, {2, 6}};

        System.out.println(new Solution2().solution(N, friend, time));
    }
}