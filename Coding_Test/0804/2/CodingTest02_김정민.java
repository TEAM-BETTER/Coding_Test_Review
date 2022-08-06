import java.util.ArrayList;
import java.util.Collections;

/*
* 시간초과가 나서 다르게 해결을 해 보려고 했는데,
* 1 3 4번에 붙잡혀서 결국 시도도 못해봤습니다
* */
class Solution {
    public int[] solution(int n) {
        ArrayList<String> list = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            list.add(i+"");
        }

        Collections.sort(list);

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = Integer.parseInt(list.get(i));
        }

        return answer;
    }
}