import java.util.*;

/**
 * 트리를 만드는게 너무나 어려웠던 문제입니다...
 * 0~가능한 숫자 까지 2중배열 을 만들어서 트리는 무조건 좌우로 밖에 못가니깐
 * -1 로 모든 배열을 초기화 해줍니다.
 * 이후 각각 left right 를 트리 2중 배열에 넣어줍니다.
 * left {0,1},{1,5},{2,3}
 * right {0,2},{3,4}
 * 0 | 1 | 2 | 3 | 4 | 5 |
 * 1,2 | 5,-1| 3,-1| -1,4| -1,-1| -1,-1|
 * 이렇게 만들고 안으로 while 을 이용해 q에 넣고 레벨 오더 순회를 진행해 역순으로 반환을 했지만
 * 테케만 통과되고 다실패했네여 ...
 */

class Solution {
    public int[] solution(int N, int[][] left, int[][] right) {
        int[][] tree = new int[N + 1][2]; // 2중배열
        for (int i = 0; i < tree.length; i++) {
            Arrays.fill(tree[i], -1);
        }
        for (int i = 0; i < left.length; i++) {
            tree[left[i][0]][0] = left[i][1];
        }
        for (int i = 0; i < right.length; i++) {
            tree[right[i][0]][1] = right[i][1];
        }

        Queue<Integer> q = new LinkedList<>(); // 레벨 오더 트리 순회할 q
        q.offer(0); // Head 는 무조건 0
        List<ArrayList<Integer>> list = new ArrayList<>();

        while (!q.isEmpty()) {
            int n = q.size();
            ArrayList<Integer> holy = new ArrayList<>();
            // 현재 레벨을 진행 되는 순서 대로 담을 배열
            for (int i = 0; i < n; i++) {
                int cur = q.poll();
                holy.add(cur); // 현재레벨 값을 추가해 주는부분
                if (tree[cur][1] != -1) { // 우측
                    q.add(tree[cur][1]);
                }
                if (tree[cur][0] != -1) { // 좌측
                    q.add(tree[cur][0]);
                }
            }
            list.add(holy); // 현재 레벨을 리스트에 추가
        }
        // 답으로 변환시키는 부분.
        ArrayList<Integer> an = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(list.size() - 1 - i).size(); j++) {
                an.add(list.get(list.size() - 1 - i).get(j));
            }
        }

        return an.stream().mapToInt(Integer::intValue).toArray();
    }
}
