import java.util.*;
/*
    케이스 하나를 통과 못해서 16점 코드입니다.
    릿코드의 Cheapest Flights Within K Stops 문제와 비슷하지만 k를 사용하는 방법이 다릅니다.
    https://leetcode.com/problems/cheapest-flights-within-k-stops/
*/
class Solution {
    public static class Node {
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static class City {
        /*
            city = 현재 정점
            distFromSrc = a 에서 부터 간선 개수
            costFromSrc = a 에서 부터 weight 총합
        */
        int city, distFromSrc, costFromSrc;

        City(int city, int distFromSrc, int cost) {
            this.city = city;
            this.distFromSrc = distFromSrc;
            this.costFromSrc = cost;
        }
    }
    public int solution(int N, int[][] flight, int a, int b, int k) {

        if (N <= 0 || flight == null || flight.length == 0)
            return -1;

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] curFlight : flight) {
            graph.get(curFlight[0]).add(new Node(curFlight[1], curFlight[2]));  // { from ( to, weight) }
        }

        PriorityQueue<City> queue = new PriorityQueue<>((x, y) -> x.costFromSrc - y.costFromSrc);   // Node가 아니라 City 클래스를 사용합니다. weight 총합 오름차순으로 정렬됩니다.
        queue.offer(new City(a, 0, 0));     // a부터 시작, 현재 간선총합 0, weight 총합 0

        while (!queue.isEmpty()) {
            City top = queue.poll();

            if (top.city == b && top.distFromSrc <= k) {    // 간선 수가 k개 이하이고 현재 정점이 b일 경우 리턴 weight 총합 리턴
                return top.costFromSrc;
            }
            // 간선 총합이 k개 이상일 경우 continue 처리를 해주면 더 빠를텐데 테스트 볼때 생각을 못했네요

            ArrayList<Node> neighbors = graph.get(top.city);
            for (Node neighbor : neighbors) {
                queue.offer(new City(neighbor.to, top.distFromSrc + 1, top.costFromSrc + neighbor.weight));
            }

        }
        return -1;
    }
}