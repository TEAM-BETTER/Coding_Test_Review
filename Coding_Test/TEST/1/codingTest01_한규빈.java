import java.util.ArrayDeque;
import java.util.Deque;

public class codingTest01_한규빈 {

    public static int solution(int n, int m) {
        int answer = 0;
        if(n > m) {
            return 0;
        }
        for (int i = n; i <= m; i++) {
            String[] s = Integer.toString(i).split("");
            if(s.length == 1) {
                answer++;
            } else {
                Deque<String> deque = new ArrayDeque<>();
                for (int j = 0; j < s.length; j++) {
                    deque.push(s[j]);
                }
                boolean checkFlag = true;
                while (!deque.isEmpty()) {
                    String s1 = deque.pollFirst();
                    String s2 = deque.pollLast();
                    if(s1 != null && s2 != null && !s1.equals(s2)) {
                        checkFlag = false;
                        break;
                    }
                }

                if(checkFlag) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
