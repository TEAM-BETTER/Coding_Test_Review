import java.util.Stack;

/**
 * 예전에 풀어봤던 문제입니다 , 저희 처음 마종현강사님 과 알고리즘 풀다가 빗물 담는 문제였는데요
 * 거기서 몇개 찾아보다가 히스토그램이 라는 문제를 풀었는데 정확하게 이문제와 동일합니다.
 * 히스토그램 검색하시면 보다 다양한 풀이가 있으니 참고해주세요
 * 스택 풀이법 이 생각났으나,분할 재귀로 풀고 싶었는데 실패했습니다. ㅎㅎ
 *
 * 막대의 인덱스를 순서대로 스택에 push 할 때 push 하려는 막대의 높이가 스택의 top 인덱스의
 * 막대 높이보다 크거나 같다면 계속해서 스택을 쌓습니다. 그러다가 push 하려는 막대의 높이가
 * 스택의 top 인덱스의 막대 높이보다 작을 경우 스택의 top 인덱스의 막대 높이가 push 하려는
 * 막대의 높이보다 작아질 때까지 while 문을 도는데, while 문 안에서는
 * 스택을 하나씩 pop 하면서 구할 수 있는 직사각형의 최대 넓이를 구하게 됩니다.
 */
class Problem2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        s.solution(new int[] { 5, 2, 1, 3, 4, 2, 5 });
    }
}

class Solution2 {
    public int solution(int[] height) {
        Stack<Integer> stack = new Stack<>(); // 스택으로 height 인덱스를 관리할껍니다.
        int max = 0;

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] > height[i]) {
                int idx = stack.pop(); // 계산용 높이 인덱스
                // 스택이 비어있으면 지금까지 계속 높은 값만 들어온거기 떄문에 i 까지 계산해줍니다.
                // 아니라면 현재 스택의 마지막 들어간 애랑 현재 인덱스 빼주고
                // -1 이거 안써서 디버깅 돌렸습니다. ㅎㅎ
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, width * height[idx]);
            }
            stack.push(i);
        }
        // 이렇게 계산하더라도 stack 에 값이 남아있을수 있습니다. 그거 처리해줍니다.
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int width = stack.isEmpty() ? height.length : height.length - stack.peek() - 1;
            max = Math.max(max, width * height[idx]);
        }
        return max;
    }
}