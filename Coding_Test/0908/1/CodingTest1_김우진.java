package CodingTest16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CodingTest1_김우진 {

    /**
     * answer 배열에는 배열에서 많이 등장하는 숫자의 순서대로 총 k개를 반환
     *
     * Map 의 key 는 배열에 등장하는 숫자, value 는 몇 번 등장하는지 카운트
     * value 를 기준으로 내림차순 정렬
     *
     * answer 배열에 내림차순 된 key 값을 k개 넣어주고 answer 값 리턴
     */

    public int[] solution(int[] nums, int k) {
        int[] answer = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Entry<Integer, Integer>> list_entries = new ArrayList<Entry<Integer, Integer>>(
            map.entrySet());

        Collections.sort(list_entries, (obj1, obj2) -> {

            return obj2.getValue().compareTo(obj1.getValue());
        });

        for (int i = 0; i < k; i++) {
            answer[i] = list_entries.get(i).getKey();
        }

        return answer;
    }
}
