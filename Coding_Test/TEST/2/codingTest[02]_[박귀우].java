
/** 금일 프로그래머스 2번 문제 */
import java.util.*;

/**
 * 숫자 배열이 주어지고, 중복된 수가 있다면 제거해서 출력해라.
 * set 을 이용하고 싶었는데 , [1 1 3 3 2 2 1 1] => [1 3 2 1]
 * 이렇게 제약 사항이 걸려서 깔끔하게 포기하고 하나씩 루프를 돌기로 결정했어요.
 */
public class Solution {
    public int[] solution(int[] arr) {
        // 자바는 배열을 한번 정하면 크기를 바꿀수가 없어서 그냥 추가제거가 쉬운 arrayList 를 이용했어요.
        ArrayList<Integer> result = new ArrayList();
        // current 를 -1 로 설정한 이유는 주어지는 값들은 전부 0이상 이였던걸로 기억합니다.
        int current = -1;
        for (int a : arr) {
            if (a != current) { // 현재 값과 루프 돌고 있는 값이 다르다면
                result.add(a); // 값을 추가해주고
                current = a; // 현재값을 업데이트 해줍니다.
            }
        }
        // arraylist 를 그냥 일반 배열로 변환을 위해 stream 을 이용했습니다.
        return result.stream().mapToInt(x -> Integer.valueOf(x)).toArray();
    }
}