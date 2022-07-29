// 시험당일 1시간, 토요일 2시간 동안 풀어도 14점을 못넘겠네요.. ㅠㅠ
// 각 아이템의 범위를 구합니다.
// 그 범위 들을 가지고 two pointer 를 실행합니다.

import java.util.*;

public class CodingTest03_박귀우 {
    public int solution(String[] ingredients, String[] items) {
        // 식재료 와 아이템 수가 같다면 그 갯수만큼 리턴하는걸 추가했다면 더 좋겠다 싶네요...
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            if (!map.containsKey(items[i])) {
                map.put(items[i], new ArrayList<>());
            }
            map.get(items[i]).add(i);
        } // 모든 아이템을 map 에 넣습니다.
        ArrayList<Integer> filtered = new ArrayList<>();
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < ingredients.length; i++) { // 재료를 돌면서 filter 에 모두 넣어주고, cnt 각 식재료 로 갯수를 세줍니다.
            ArrayList<Integer> list = map.get(ingredients[i]);
            cnt.put(ingredients[i], list.size());
            for (int j = 0; j < list.size(); j++) {
                filtered.add(list.get(j));
            }
        }
        Collections.sort(filtered); // 정렬을 실행해서 좌우로 실행한다면, 현재 필터링 된 재료 인덱스를 가지고 실행됩니다.

        int left = 0;
        int right = filtered.size() - 1;

        boolean leftMove = true; // while 반복문을 탈출하기위해 이렇게 2개 설정을 했습니다.
        boolean rightMove = true;

        while (leftMove || rightMove) {
            if (rightMove) { // 오른쪽 부터 줄여 나갑니다.
                String target = items[filtered.get(right)];
                if (cnt.get(target) > 1) { // 현재 가지고 있는 개수가 1개 이상이라면 옆으로 갈수 있으니 줄여주면서 옮겨줍니다.
                    cnt.put(target, cnt.get(target) - 1);
                    right--;
                } else {
                    rightMove = false; // 아니라면 false 로 지정해 움직임을 멈춥니다.
                }
            }
            if (leftMove) {
                String target = items[filtered.get(left)]; // right 와 동일합니다.
                if (cnt.get(target) > 1) {
                    cnt.put(target, cnt.get(target) - 1);
                    left++;
                } else {
                    leftMove = false;
                }
            }
        }

        return filtered.get(right) - filtered.get(left) + 1;
    }
}