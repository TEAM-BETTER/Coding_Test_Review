import java.util.*;

class Solution {
  // return 조합의 개수
    static int getCombi (int n, int r) {
        int nr = 1;
        int dt = 1;
        // 조합 분자 부분, N부터 - R + 1까지 * ex: 10C3 => 10 * 9 * 8
        for (int i = n; i >= n - r + 1; i--) {
          nr *= i;
        }
        // 조합 분모 부분, 1~ N까지 R만큼 * ex: 10C3 => 1 * 2 * 3
        for (int i = 1; i <= r; i++) {
          dt *= i;
        }
        // 분수
        return nr / dt;
    }
    public int solution(String[] names) {
        HashSet<String> nameSet = new HashSet<String>(Arrays.asList(names));
        return getCombi(nameSet.size(), 4);
    }
}
