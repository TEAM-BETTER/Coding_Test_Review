import java.util.*;

/**
 * 예전 저희 투포인터인가? 그문제 풀떄 해설 강사님이 넌지시 한번 해보라고 했던 문제입니다.
 * 중간값을 구하라고.... 그떄 투포인터 문제 풀다가 릿코드에서 풀어본 문제입니다.
 * https://leetcode.com/problems/sliding-window-median/
 * 물론 풀이는 실패하고 그떄 디스커스 보던거 그냥 달달 외웠는데 이렇게 써먹네여..
 * 
 * 풀이 의 개괄적 구조는 pq 를 두개를 운용합니다. 하나는 작은순으로 , 높은순으로 해서
 * 주어지는 갯수의 슬라이딩 윈도우만큼 갯수를 유지하면서
 * 가운데 값을 계산해주는 방법입니다.
 */

class Problem4 {
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        int[] nums = {
                197, -1, 176, 83, 139, -76, 157, 9, 13, 47, 148, 8, 68, 124, -64, 30, -2, -18, -55, 127, 175, 87, -2,
                141, 66, 22, 106, 116, 6, -68, 120, 139, 55, 8, -44, 68, 36, 102, 94, 17, 116, -61, 107, 114, -97, 137,
                10, 173, -52, 76, -89, 89, 84, -96, 34, 188, -22, -83, 121, -8, 42, -67, -23, 107, 85, 191, 143, -15,
                155, 161, 59, -8, 171, -97, -57, -67, -84, 194, 77, 173, 126, -40, 135, -29, -9, 2, 180, 128, -29, -59,
                -24, 59, 72, 92, -66, -70, 180, 181, 79, 137
        };
        s.solution(new int[] { 4, 2, 6, 4, 2, 3 }, 3);
    }
}

class Solution4 {
    Queue<Integer> minQ = new PriorityQueue<>(); // 작은값이 먼저나오고
    Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder()); // 큰값이 먼저나옴

    public int[] solution(int[] arr, int k) {
        int[] res = new int[arr.length - k + 1];

        for (int i = 0; i < arr.length; i++) {
            hi(arr[i]);
            if (i >= k - 1) {
                res[i - k + 1] = getMedian();
                bye(arr[i - k + 1]);
            }
        }
        return res;
    }

    void hi(int n) {
        maxQ.add(n);
        minQ.add(maxQ.poll());
        // 사이즈 를 조절해줍니다.
        if (minQ.size() > maxQ.size())
            maxQ.add(minQ.poll());
    }

    void bye(int n) {
        // maxQ 가 현재 값보다 크다면 ? maxQ안 어딘가에 있습니다.
        // 그게 아니라면 minQ 에 있는것입니다.
        if (maxQ.peek() >= n) {
            maxQ.remove(n);
        } else {
            minQ.remove(n);
        }
        // 제거된 숫자에 따라 사이즈를 재조정합니다.
        // 두개의 길이가 같다면 ? 그냥 넘어갑니다.
        if (minQ.size() > maxQ.size())
            maxQ.add(minQ.poll());
        if (maxQ.size() > minQ.size())
            minQ.add(maxQ.poll());
    }

    int getMedian() {
        // 두개의 길이가 같다면 각자 하나씩 봅아서 더해서 나눠줍니당
        if (minQ.size() == maxQ.size())
            return (minQ.peek() + maxQ.peek()) / 2;
        else // maxQ에 먼저 더하는 구조 이기떄문에 위의 경우가 아니라면 maxQ 값을 반환합니다.
            return maxQ.peek();
    }

}
