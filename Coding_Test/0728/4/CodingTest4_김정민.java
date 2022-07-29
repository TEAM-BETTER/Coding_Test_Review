import java.util.Stack;

/*
*  문제를 보고 DFS라고 생각했습니다.
*  제한시간이 빡빡하다면 통과하기 힘들 수 도 있을거 같아요 ㅠㅠ
* */
class Solution {
    public boolean solution(int[] param0) {
        int endIndex = param0.length - 1;
        boolean[] vis = new boolean[param0.length]; //DFS의 방문여부를 체크하기 위한 배열

        Stack<Integer> stack = new Stack<>();
        stack.add(0); // 시작점 추가
        vis[0] = true;

        //DFS
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            int value = param0[cur];

            //적힌 값만큼 이동할수 있으므로 (cur + 1) ~ (cur + value) 까지 다음 탐색 범위에 추가
            for (int next = cur + 1; next <= cur + value; next++) {
                // 여기에 return true를 해도 괜찮을 것 같아요
                if (next > endIndex) {
                    continue;
                }

                if (vis[next]) continue;

                if (next == endIndex) {
                    return true;
                }

                stack.push(next);
                vis[next] = true;
            }
        }
        // 탐색을 종료 후에도 도달 할수 없다면 false
        return false;
    }
}