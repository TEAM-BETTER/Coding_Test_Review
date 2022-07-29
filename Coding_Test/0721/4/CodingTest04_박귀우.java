import java.util.*;

//릿코드에서 비슷한 문제를 풀었습니다.(소모임 할떄 들고간 문제네요)
//https://leetcode.com/problems/min-cost-to-connect-all-points/
//포인트 를 가지고 거리로 환산해서  mst 했습니다.

class Solution {
    public int solution(int[] x, int[] y) {
        int[][] points = new int[x.length][2]; // xy 그냥 펼쳐놓으니깐 계산하는게 어려워 다시 묶어주었습니다.
        for (int i = 0; i < x.length; i++) {
            points[i] = new int[] { x[i], y[i] };
        }
        int n = points.length, ans = 0;
        HashSet<Integer> mst = new HashSet<>(); // 방문여부 체크를 위해 set 의 사이즈를 이용할 계획이였습니다.
        mst.add(0);
        int[] dist = new int[n];
        for (int i = 1; i < n; i++)
            dist[i] = findDist(points, 0, i);
        while (mst.size() != n) {
            int next = -1;
            for (int i = 0; i < n; i++) {
                if (mst.contains(i))
                    continue;
                // for 를 이용해 돌리면서 최소길이를 찾는다면 i를 업데이트
                if (next == -1 || dist[next] > dist[i])
                    next = i;
            }
            mst.add(next);
            ans += dist[next];
            // 다시 n 만큼 확인
            for (int i = 0; i < n; i++) {
                if (!mst.contains(i)) {
                    dist[i] = Math.min(dist[i], findDist(points, i, next));
                }
            }
        }
        return ans;
    }

    public int findDist(int[][] points, int a, int b) {
        return Math.abs(points[a][0] - points[b][0]) + Math.abs(points[a][1] - points[b][1]);
    }
}