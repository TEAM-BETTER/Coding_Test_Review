/*
20점
전에 리트코드에서 맨해튼 거리 관련 문제를 본 기억이 있어서 겨우 풀었습니다!
전형적인 크루스칼 알고리즘 문제라고 파악해서 find, union메서드, parents[] 배열을 이용했습니다.
우선순위큐를 이용해서 모든 점에 대해 [p1의 idx, p2의 idx, 두 점 사이 거리]를 하나씩 넣고 거리를 기준으로
오름차순 정렬이 되도록 합니다.
마지막에 (points의 개수 - 1)번 만큼 반복문을 돌려서 모든 점이 연결될 수 있도록 구현했습니다.
*/

import java.util.*;
class Test4 {
    public static int solution(int[] x, int[] y) {

        // x, y배열을 points 로 바꾼다.
        int[][] points = new int[x.length][2];
        for(int i = 0;i < x.length; ++i){
            points[i][0] = x[i];
            points[i][1] = y[i];
        }

        if (points == null || points.length <= 1)
            return 0;

        // 우선순위 큐를 만들고 거리가 작은 것부터 나오도록 한다.
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                return array1[2] - array2[2];
            }
        });
        int length = points.length;	// 점의 개수

        for (int i = 0; i < length; i++) {
            int[] point1 = points[i];

            for (int j = i + 1; j < length; j++) {
                int[] point2 = points[j];

                int distance = manhattanDistance(point1, point2);
                priorityQueue.offer(new int[]{i, j, distance});
           }
        }
        int[] parents = new int[length];

        // 부모 노드 초기화 (아직 엣지가 없으니 자기 자신이 최상위 부모 노드이다.)
        for (int i = 0; i < length; i++){
            parents[i] = i;
        }
        int minCost = 0;	// 최소 비용
        int size = length;
        while (size > 1) {
            int[] array = priorityQueue.poll();	// 우선순위에 있는 원소 중에서 가장 거리가 짧은 원소를 뽑는다.
            int index1 = array[0];	 // 첫 번째 점의 idx
            int index2 = array[1];	 // 두 번째 점의 idx
            int distance = array[2]; // 맨해튼 거리

            if (find(parents, index1) != find(parents, index2)) {	// 부모 노드가 같아질 때까지 union
                union(parents, index1, index2);
                minCost += distance;
                size--;
            }
        }
        return minCost;
    }
    // 맨해튼 거리 구하는 메서드
    public static int manhattanDistance(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }

    // 부모 노드를 이어주는 union - 크루스칼
    public static void union(int[] parents, int index1, int index2) {
        parents[find(parents, index1)] = find(parents, index2);
    }

    // index 노드의 최상위 부모 노드를 반환하는 find - 크루스칼
    public static int find(int[] parents, int index) {
        while (parents[index] != index) {
            parents[index] = parents[parents[index]];
            index = parents[index];
        }
        return index;
    }

    public static void main(String[] args) {

        int[] x = {0, 0, 3, 3, 6};
        int[] y = {0, 3, 1, 4, 3};
        System.out.println(solution(x, y)); // 14
    }
}
