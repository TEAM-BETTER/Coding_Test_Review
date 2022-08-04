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
 * 강사님 강의 듣고.. dfs 하니깐 이렇게 쉽네여....
 * 저는 visit 배열 만들기싫어서 전 노드를 업데이트 해주었습니다.
 */

class Solution {
    int[][] tree;
    List<Integer> answer;

    public int[] solution(int N, int[][] left, int[][] right) {
        tree = new int[N][2]; // 2중배열
        for (int i = 0; i < tree.length; i++) {
            Arrays.fill(tree[i], -1);
        }
        for (int i = 0; i < left.length; i++) {
            tree[left[i][0]][0] = left[i][1];
        }
        for (int i = 0; i < right.length; i++) {
            tree[right[i][0]][1] = right[i][1];
        }
        while (tree[0][0] != -1 || tree[0][1] != -1) { // 이 while 부분이 없으면 현재 리프 노드 찾고 함수 종료됩니다.
            helper(0, 0);
        }
        answer.add(0);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public void helper(int cur, int prev) { // 강사님 dfs 와 다를바 없고 단지 visit 배열만 없네요 ㅎㅎ..
        if (tree[cur][0] == -1 && tree[cur][1] == -1) {
            if (tree[prev][0] == cur)
                tree[prev][0] = -1;
            else
                tree[prev][1] = -1;
            answer.add(cur);
            return;
        }

        if (tree[cur][1] >= 0)
            helper(tree[cur][1], cur);
        if (tree[cur][0] >= 0)
            helper(tree[cur][0], cur);
    }
}