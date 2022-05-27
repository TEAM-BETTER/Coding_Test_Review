import java.util.*;

class Solution {
    public int solution(String[] names) {
        int answer = 0;

        int[] factorial = {0, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};

        HashSet<String> hashSet = new HashSet<>(Arrays.asList(names));

        String[] duplicatedArr = hashSet.toArray(new String[0]);

        System.out.println(duplicatedArr.length);

        return facto(duplicatedArr.length, 4) / factorial[4];
    }

    public int facto(int n, int count) {
        int answer = 1;
        while(count > 0) {
            answer *= n;
            n--;
            count--;
        }
        return answer;
    }

}