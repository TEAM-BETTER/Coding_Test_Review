/*
 문제 전략
  1. names 배열의 중복값을 HashSet에 담으므로서 제거
  2. 4명의 당첨자는 순서가 없는 표시이므로 조합을 이용 n= 해시셋의 사이즈와 r= 문제에서 요구한 값 4 를 Combination.
*/

import java.util.HashSet;

public class Solution2 {

    public int solution(String[] names) {
        // 값을 담기 전 초기화 (이것 나중에 선언해도 될거같은데 항상 먼저 선언하게 되더군요. 보통 이렇게들 하시죠?)
        int answer = 0;

        // HashSet은 중복을 제거하는 자료구조이기 때문에 names배열의 값을 모두 HashSet으로 이주시키고 사이즈를 n값으로 지정했습니다.
        HashSet<String> entries = new HashSet<String>();
        for (int i = 0; i < names.length; i++) {
            entries.add(names[i]);
        }
        int n = entries.size(); // 얘도 n값을 미리 초기화해두고 적는게 나을까요? 아니면 이게 맞는걸까요?


        // 중복제거처리된 값의 사이즈가 확인되었으므로 조합
        int pResult = 1;
        for (int i = n; i >= n - 4 + 1 ; i--) {
            pResult *= i;
        }

        int fResult = 1;
        for (int i = 1; i <= 4; i++) {
            fResult *= i;
        }

        answer = pResult / fResult;
        return answer;
    }
}
