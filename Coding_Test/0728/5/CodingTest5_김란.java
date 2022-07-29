/*
20점
다행히 지난 주 내용을 복습한 덕분에 쉽게 풀 수 있었습니다.
전형적인 다익스트라 유형인데 최단 거리가 아닌 idx를 반환한다는 점만 달랐습니다.
그래서 무한대가 아닌 가장 데이터를 찾아서 인덱스를 저장하도록 로직을 짰습니다.
전에 수업을 들으며 이해가 안 가서 구현하는 방법을 통째로 외웠더니 강사님 풀이와 거의 비슷하네요ㅎㅎ
 */
import java.util.ArrayList;

// 최단 거리
public class Test5 {
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static int solution(int v, int[][] data) {
        int infinite =  Integer.MAX_VALUE;

        ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
        for(int i = 0;i < v + 1; ++i){
            graph.add(new ArrayList<>());
        }

        for(int i = 0;i < data.length; ++i){
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
        }

        int[] dist = new int[v + 1];    // 0번 노드부터 i번 노드까지 가는 거리

        for(int i = 1; i < v + 1; ++i){
            dist[i] = infinite;            // 거리 배열을 초기화한다.
        }
        dist[0] = 0;         // 시작하는 위치는 0

        boolean[] visited = new boolean[v +  1];
        for(int i = 0; i < v; ++i){
            int minDis = infinite;
            int curIdx = 0;
            for(int j = 1; j < v + 1; ++j){
                if(!visited[j] && dist[j] < minDis){   // 방문한 적이 없으면서 최단 거리인 곳을 선택한다.
                    minDis = dist[j];
                    curIdx = j;
                }
            }
            visited[curIdx] = true;

            for(int j = 0; j < graph.get(curIdx).size(); ++j){
                Node adjNode = graph.get(curIdx).get(j);
                if(dist[adjNode.to] > dist[curIdx] + adjNode.weight){
                    dist[adjNode.to] = dist[curIdx] + adjNode.weight;   // 최단 거리로 업데이트
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int idx = -1;
        for(int i = 1;i < v + 1; ++i){
            if(dist[i] != infinite && dist[i] > max){  // 최댓값 인덱스 찾기
                    max = dist[i];
                    idx = i;
           }
        }
       return idx;
    }

    public static void main(String[] args) {

        int[][] edge = {{0, 1, 5}, {0, 2, 7}, {1, 3, 10}, {3, 4, 8}, {2, 4, 9}, {4, 2, 1}};
        System.out.println(solution(5, edge));   // 4
    }
}