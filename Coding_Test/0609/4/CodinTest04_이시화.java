package ch03.codingTest.p4;

import java.util.PriorityQueue;

public class Solution {
    public static int[] dx1 = {1, 0, -1, 0};                    // (dx1[i], dy1[i]) (dx2[i], dy2[i]) 로 철수와 영희가 이동하는 방향을 나타냄
    public static int[] dy1 = {0, 1, 0, -1};                    //
    public static int[] dx2 = {1, 1, -1, -1};                   // 이렇게 넣으면 길이가 4인 for 문을 돌리면 이동하는 경우를 간단하게 표현가능!
    public static int[] dy2 = {1, -1, 1, -1};

    private static class Node implements Comparable<Node> {     // 현재 두명의 위치를 알려주기 위한 class
        int x1;
        int y1;                                                 // (x1, y1) 철수 위치
        int x2;
        int y2;                                                 // (x2, y2) 영희 위치
        int count;                                              // 움직인 횟수 기록
        int dis;                                                // 철수와 영희 사이의 거리를 기록

        public Node(int x1, int y1, int x2, int y2, int count) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.count = count;
            this.dis = (int) (Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2)); // 피타고라스로 길이 측정 a^2 + b^2 = c^2
                                                                                                // 루트는 없어도 되어서 안함
        }

        @Override
        public int compareTo(Node o) {                          // PriorityQueue 를 위한 메소드 구현
            if (this.dis - o.dis == 0) {
                return this.count - o.count;                    // 이번엔 비교를 두가지 변수로 하였습니다.
            } else {                                            // 첫번쨰로 count 가 가장 작은 것을 뽑아내고
                return this.dis - o.dis;                        // 만약 count 가 같은 값이 많다면 거리가 더 가까운 것을 뽑음
            }
        }

    }

    public static int solution(int x1, int y1, int x2, int y2) {
        int answer = 0;
        Node first = new Node(x1, y1, x2, y2, 0);          // 시작 위치를 기록하여 객체로 만들어 둠
        answer = bfs(first);

        return answer;
    }

    public static int bfs(Node first) {                          //PriorityQueue 를 이용한 bfs
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(first);                                        // 시작위치 넣은 객체를 넣어줌
        while (!queue.isEmpty()) {                              // queue 반복 시작!!!!!!!!!!!
            Node cur = queue.poll();                            // queue 에서 나온 값 저장하는 변수

            if (cur.dis == 1 || cur.dis == 5) {                 // 거리가 십자가로 딱 붙어 있거나 르트 5일경우 한번만 움직이면 겹칠 수 있으므로
                return cur.count + 1;                           // 확인후 count 에 한번 움직이는 값을 더해서 출력
            }
            for (int i = 0; i < 4; i++) {                       // 위에 만들어둔 dx dy 배열을 현재 위치에 이동가능한 16가지의 경우의 수를 간단하게 표현 가능
                for (int j = 0; j < 4; j++) {                   // for 문 두개로 철수가 움직인 경우 마다 영희가 움직이는 4가지를 돌려 보았습니다.
                    int nx1 = cur.x1 + dx1[i];
                    int ny1 = cur.y1 + dy1[i];
                    int nx2 = cur.x2 + dx2[j];
                    int ny2 = cur.y2 + dy2[j];
                    queue.add(new Node(nx1, ny1, nx2, ny2, cur.count + 1));
                }
            }
                                                                // 16가지씩 나오는게 너무 많아서 철수와 영희의 위치를 특정하여
                                                                // 매 경우마다 두가지 경우만 나오는 if else 문을 만들었는데
                                                                // 너무 지저분하고 나오는 결과도 같아서 그냥 위 처럼 간단하게 만들었습니다
                                                                // 만드는데 시간을 너무 많이써서 아까워서 밑에 주석으로 올립니다...
        }

        return -1;                                              // 오류를 확인하기 위한 return 값
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 5, -3));
    }
}


// if (cur.x1 - cur.x2 > 0) {                                                               // 철수가 영희보다 오른쪾에 있을떄
//         if (cur.y1 - cur.y2 > 0) {                                                       // 철수가 영희보다 우측 상단에 있을 때
//         queue.add(new Node(cur.x1 - 1, cur.y1, cur.x2 + 1, cur.y2 + 1, cur.count + 1));
//         queue.add(new Node(cur.x1, cur.y1 - 1, cur.x2 + 1, cur.y2 + 1, cur.count + 1));
//         } else if (cur.y1 - cur.y2 == 0) {                                               // 철수와 영희가 x축과 평행하게 있을 때
//         queue.add(new Node(cur.x1 - 1, cur.y1, cur.x2 + 1, cur.y2 + 1, cur.count + 1));
//         queue.add(new Node(cur.x1 - 1, cur.y1, cur.x2 + 1, cur.y2 - 1, cur.count + 1));
//         } else {                                                                         // 철수가 영희보다 우측 하단에 있을 때
//         queue.add(new Node(cur.x1 - 1, cur.y1, cur.x2 + 1, cur.y2 - 1, cur.count + 1));
//         queue.add(new Node(cur.x1, cur.y1 + 1, cur.x2 + 1, cur.y2 - 1, cur.count + 1));
//         }
//         } else if (cur.x1 - cur.x2 == 0) {                                               // 철수와 영희가 y축과 평행하게 있을 때
//         if (cur.y1 - cur.y2 > 0) {                                                       // 철수가 영희보다 수직으로 위에 있을 때
//         queue.add(new Node(cur.x1, cur.y1 - 1, cur.x2 + 1, cur.y2 + 1, cur.count + 1));
//         queue.add(new Node(cur.x1, cur.y1 - 1, cur.x2 - 1, cur.y2 + 1, cur.count + 1));
//         } else {                                                                         // 철수가 영희보다 수직으로 밑에 있을 때
//         queue.add(new Node(cur.x1, cur.y1 + 1, cur.x2 + 1, cur.y2 - 1, cur.count + 1));
//         queue.add(new Node(cur.x1, cur.y1 + 1, cur.x2 - 1, cur.y2 - 1, cur.count + 1));
//         }
//
//         } else {                                                                         // 철수가 영희보다 왼쪽에 있을 때
//         if (cur.y1 - cur.y2 > 0) {                                                       // 철수가 영희보다 죄측 상단에 있을 떄
//         queue.add(new Node(cur.x1 + 1, cur.y1, cur.x2 - 1, cur.y2 + 1, cur.count + 1));
//         queue.add(new Node(cur.x1, cur.y1 - 1, cur.x2 - 1, cur.y2 + 1, cur.count + 1));
//         } else if (cur.y1 - cur.y2 == 0) {                                               // 철수와 영희가 x축과 평행하게 있을 떄
//         queue.add(new Node(cur.x1 + 1, cur.y1, cur.x2 - 1, cur.y2 + 1, cur.count + 1));
//         queue.add(new Node(cur.x1 + 1, cur.y1, cur.x2 - 1, cur.y2 - 1, cur.count + 1));
//         } else {                                                                         // 철수가 영희보다 좌측 하단에 있을 때
//         queue.add(new Node(cur.x1 + 1, cur.y1, cur.x2 - 1, cur.y2 - 1, cur.count + 1));
//         queue.add(new Node(cur.x1, cur.y1 + 1, cur.x2 - 1, cur.y2 - 1, cur.count + 1));
//         }
//         }