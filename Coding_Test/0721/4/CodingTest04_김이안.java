import java.util.*;
/*
    같이 스터디 하시는 분들과 풀었던 문제여서 금방 푼 문제입니다! 땡스 투 귀우님👍👍
    프림 알고리즘입니다!
    leetcode의 Min Cost to Connect All Points 문제입니다.
    https://leetcode.com/problems/min-cost-to-connect-all-points/
    릿코드에서는 x,y 좌표를 vector값으로 주는 것 빼고 동일합니다.
*/
class Solution {
    public int solution(int[] x, int[] y) {
        int[][] points = new int[x.length][2];
        for (int i = 0; i < x.length; i++) {
            points[i] = new int[]{x[i], y[i]};      // x,y 좌표를 편하게 points 배열로 넣어줬습니다.
        }
        int n = points.length;
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int [] {0, 0, 0});
        boolean [] visited = new boolean [n];
        int cost = 0;
        int edges = 0;
        while (!pq.isEmpty() || edges < n - 1) {
            int[] current = pq.poll();
            if (visited[current[1]])
                continue;
            visited[current[1]] = true;
            cost += current[2];
            edges += 1;
            for (int j = 0; j< n; j++) {
                if (!visited[j])
                    pq.add(new int [] {current[1], j, Math.abs(points[current[1]][0] - points[j][0]) + Math.abs(points[current[1]][1] - points[j][1])});
            }
        }
        return cost;
    }
}