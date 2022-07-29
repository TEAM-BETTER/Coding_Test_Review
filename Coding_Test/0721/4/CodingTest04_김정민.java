import java.util.ArrayList;
import java.util.Collections;

/*
*  각 점에서 다른 점으로 가는 모든 간선을 구한 후
*  크루스칼 알고리즘을 이용하여 최소신장 트리를 찾는다.
* */
class Solution {
    int[] parent;

    // 크루스칼 알고리즘에 사용될 find
    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
    // 크루스칼 알고리즘에 사용될 union
    public void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                parent[y] = x;
            }else {
                parent[x] = y;
            }
        }
    }

    public int solution(int[] x, int[] y) {
        parent = new int[x.length];
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < x.length; i++) {
            points.add(new Point(i, x[i], y[i]));
            parent[i] = i;
        }

        ArrayList<Edge> edges = new ArrayList<>();
        // 모든 간선을 만들어준다.
        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = i + 1; j < points.size(); j++) {
                Point p1 = points.get(i);
                Point p2 = points.get(j);
                int cost = menhatan(p1.x, p2.x, p1.y, p2.y);
                edges.add(new Edge(p1, p2, cost));
            }
        }

        Collections.sort(edges);
        int cnt = 0;
        int ans = 0;
        // 크루스칼 알고리즘
        for (Edge edge: edges) {
            if (find(edge.p1.idx) == find(edge.p2.idx)) continue;
            union(edge.p1.idx, edge.p2.idx);
            ans += edge.cost;
            cnt++;

            if (cnt == x.length-1) break;
        }

        return ans;
    }
    // menhatan 거리를 구하는 함수
    public int menhatan(int x1, int x2, int y1, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    class Point {
        int idx;
        int x;
        int y;

        public Point(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }

    class Edge implements Comparable<Edge> {
        Point p1;
        Point p2;
        int cost;

        public Edge(Point p1, Point p2, int cost) {
            this.p1 = p1;
            this.p2 = p2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int x[] = {0, 0, 3, 3, 6};
        int y[] = {0, 3, 1, 4, 3};
        int test = solution.solution(x, y);
        System.out.println(test);
    }
}