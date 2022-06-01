import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String[] names) {
        // names에서 중복을 제거하기위해 set을 이용
        Set<String> set = new HashSet<>();
        Collections.addAll(set, names);

        int n = set.size();
        // n개중 4개를 뽑는 식
        return n * (n - 1) * (n - 2) * (n - 3) / 24;
    }
}