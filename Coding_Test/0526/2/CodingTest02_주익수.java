import java.util.*;

class Solution {
    public int solution(String[] names) {
        int answer = 0;

        int[] factorial = {0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800}; //팩토리얼 0-10까지

        HashSet<String> hashSet = new HashSet<>(Arrays.asList(names)); //중복 데이터 제거를 위한 과정
        String[] duplicatedArr = hashSet.toArray(new String[0]);
        System.out.println(duplicatedArr.length);

        return P(duplicatedArr.length, 4) / factorial[4]; //조합 공식 nCr 반환
    }

    public int P(int n, int count) { //확률과 통계에서 순열 구현
        int answer = 1;
        while(count > 0) {
            answer *= n;
            n--;
            count--;
        }
        return answer;
    }

}