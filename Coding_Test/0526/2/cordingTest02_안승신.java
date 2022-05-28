import java.util.*;

class Solution {
    public int solution(String[] names) {
        int answer = 0;
        HashSet<String> names2 = new HashSet<>(); // set에는 중복이 허용되지 않으므로 중복 제거용 배열 생성

        for (String n : names) { //names의 모든 요소를 꺼냄
            names2.add(n); //set에 넣음 (자동으로 중복이 제거 됨)
        }

        //중복이 제거 되었으니 6C4를 풀면 됨
        int n = names2.size();
        int r = 4;

        int pResult = 1;
        for (int i = n; i >= n - r + 1; i--) {
            pResult *= i;
        }

        int fResult = 1;
        for (int i = 1; i <= r; i++) {
            fResult *= i;
        }

        answer = pResult / fResult;

        return answer;
    }
}