import java.util.HashMap;
import java.util.Set;

public class CodingTest01_박귀우 {
    public static void main(String[] args) {
        int N = 3;
        int[][] trust = { { 1, 3 }, { 2, 3 } };
        sol(3, trust);
    }

    public static int sol(int N, int[][] trust) {
        int result = -1;
        // 해쉬맵을 만들어서 다 0 으로 집어넣고
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= trust.length; i++) {
            map.put(i, 0);
        }
        // trust 분해해서 업데이트 해주고 누구믿는지
        for (int i = 0; i < trust.length; i++) {
            map.put(trust[i][0], trust[i][1]);
        }
        // 가장작은값이 0 이아니라면 판사가 없습니다.
        int minVal = map.values().stream().min((x1, x2) -> x1 - x2).get();
        if (minVal != 0)
            return result;
        Set<Integer> keys = map.keySet();
        for (int key : keys) {
            if (map.get(key) == 0) {
                result = key;
                break;
            }
        }
        return result;
    }
}