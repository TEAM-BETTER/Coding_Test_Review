import java.util.Arrays;

public class CodingTest05 {

    public static int solution(int N, int[][] edges) {
        int answer = 0;

//        Arrays.sort(edges, (x1, x2) -> {
//            if(x1[0] == x2[0]) {
//                return x1[1] - x2[1];
//            } else {
//                return x1[0] - x2[0];
//            }
//        });

        Arrays.sort(edges, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int[] distanceDP = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            distanceDP[i] = Integer.MAX_VALUE;
        }
        distanceDP[1] = 1;

        for (int[] item : edges) {
            if(distanceDP[item[1]] > distanceDP[item[0]] + 1) {
                distanceDP[item[1]] = distanceDP[item[0]] + 1;
            }
        }

        for (int i = 0; i < distanceDP.length; i++) {
            System.out.println(i + " = " + distanceDP[i]);
        }

        return (distanceDP[N] / 11) + 1;
    }

    public static void main(String[] args) {
        int [][] edges = {{2, 5}, {3, 6}, {4, 7}, {5, 7}, {6, 5}, {6, 8}, {7, 9}, {1, 2}, {1, 3}, {2, 4}, {8, 10}, {9, 10}, {10, 11}, {11, 12}, {12, 13}};
        int N = 13;
        System.out.println(solution(N, edges));
    }
}
