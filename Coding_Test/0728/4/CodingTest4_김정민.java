import java.util.Stack;

// DFS를 이용해서 탈출 할 수 있다면 true를 반환하자고 생각 했습니다!
class Solution {
    public boolean solution(int[] param0) {
        int endIndex = param0.length - 1;
        boolean[] vis = new boolean[param0.length]; // 방문여부를 체크하는 배열!

        Stack<Integer> stack = new Stack<>();
        stack.add(0); // 0 번부터 시작!
        vis[0] = true;

        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            int value = param0[cur];

            for (int next = cur + 1; next <= cur + value; next++) {
                // next가 endIndex가 커질 수 있다면 이미 next에 도달 할 수 있기 때문에 필요가 없을거 같긴 하네요 ㅠ  잘은 몰르겠습니다!
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

        return false;
    }
}