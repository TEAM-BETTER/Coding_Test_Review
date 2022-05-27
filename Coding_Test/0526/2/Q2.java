import java.util.Arrays;
import java.util.HashSet;

class Q2 { // 중복 o , 순서 x 조합으로 풀었습니다.
    public int solution(String[] names) {
        int answer = 0;
        HashSet<String> hashset =  new HashSet<>(Arrays.asList(names));
        String[] resultSet = hashset.toArray(new String[0]);


        int n = (int)resultSet.length;
        int r = 4;
        int pResult = 1;
        for (int i = n; i >= n - r + 1 ; i--) {
            pResult *= i;
        }
        int fResult = 1;
        for (int i = r; i >= 1; i--) {
            fResult *= i;
        }
        answer = (pResult/fResult);
        return answer; // 6C4
    }
}