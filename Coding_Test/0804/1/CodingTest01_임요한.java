// num에 들어있는 각 숫자마다의 갯수를 key, value 값으로 map에 담아 풀었습니다.
// map에 담긴 key와 value값을 차례로 String으로 나열해 리턴했습니다.

import java.util.HashMap;
import java.util.Map;

class CodingTest01_임요한 {
    public long solution(int n, int num) {
        String answer = "";
        String strNum = String.valueOf(num);

        for (int i = 0; i < n; i++) {
            char[] arr = strNum.toCharArray();

            Map<Integer, Integer> map = new HashMap<>();

            for (char c : arr) {
                map.put(c - '0', map.getOrDefault(c - '0', 0) + 1);
            }

            answer = "";
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                answer += String.valueOf(entry.getKey()) + String.valueOf(entry.getValue());
            }

            strNum = answer;
        }

        return Long.parseLong(answer) % 10004;
    }
}