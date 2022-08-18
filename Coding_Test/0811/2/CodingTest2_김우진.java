package CodingTest12;

import java.util.Arrays;
import java.util.Stack;

/**
 * 1. 직사각형이 우상향하면 stack 에 height 의 index 값을 쌓아줍니다.
 *      stack.peek값 보다, 다음 울타리의 높이가 낮아지면 width를 구합니다.
 *
 * 2. addZero 는 배열의 가장 마지막에 0을 넣어주는 메서드입니다.
 *      -> 만약 마지막 값이 우상향이라면 while문을 돌지 않고, stack에 값을 넣고 끝나기 때문에
 *          0을 넣어주어 마지막 값까지 계산합니다.
 *
 * 3. answer값은 새로 갱신한 넓이와 이전의 max값과 비교해서 계속 max값 업데이트
 */

public class CodingTest2_김우진 {

    static int[] addZero(int[] heights) {
        heights = Arrays.copyOf(heights, heights.length + 1);
        heights[heights.length - 1] = 0;

        return heights;
    }

    public static int solution(int[] heights) {
        heights = addZero(heights);
        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        /**
         * stack이 비어있지 않고, heights[i]값보다 heights[stack.peek]값이 더 크다면 높이가 낮아진 것
         *      해당되지 않으면 높이가 높아진 것 -> stack에 i 를 쌓아줌
         *
         * 높이가 낮아지는 시점에 stack 값 꺼내 높이값 구하고,
         *      방금 꺼낸 stack 값으로 인해 stack 비었으면 i를 너비값으로,
         *      안비었으면 현재 인덱스에서 stack.peek + 1 을 너비값으로 함
         *      -> stack이 빌 때 까지 반복함
         *      -> stack에 쌓인 값은 계속 높아질 때 마다 쌓았기 때문에,
         *      stack값을 pop하면서 높이는 내려가고 너비가 길어짐
         *
         * 위 계산으로 구한 높이 * 너비 의 값과 직전까지 구했던 최대 넓이값 비교해서 큰 값으로 업데이트
         */
        for (int i = 0; i < heights.length; i++) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                int idx = stack.pop();
                int width = stack.empty() ? i : (i - (stack.peek() + 1));

                answer = Math.max(answer, heights[idx] * width);
            }

            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] heights = {5, 2, 1, 3, 4, 2, 5};

        System.out.println(solution(heights));
    }
}