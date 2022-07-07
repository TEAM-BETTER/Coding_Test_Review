import java.util.HashMap;
import java.util.Set;

/*
* 포인터를 양끝에 세워두고 재료가 포함되지 않는 길이를 찾기 위해서 계속 줄여가는 방법으로 풀이를 진행 했습니다.
*   lt-->                                                <-- rt
* ["물", "인삼", "커피", "생닭", "소주", "사탕", "생닭", "대추", "쌀"]
* map: lt ~ rt 사이에 포함된 ingredients원소의 원소당 남은 개수
* ex: 생닭 -> 2, 인삼 -> 1, 소주 -> 1, 대추 -> 1
* 정확도 8점입니다.
* */
class Solution {
    public int solution(String[] ingredients, String[] items) {
        int answer = 0;

        //현재 범위에 재료들이 몇개 포함 되어 있는지를 보여줄 자료구조
        HashMap<String, Integer> map = new HashMap<>();

        for (String ingredient : ingredients) {
            map.put(ingredient, 1);
        }

        Set<String> keySet = map.keySet();

        // 전체 길이에서 각 재료가 몇개 있는지 저장
        for (String item: items) {
            if (!keySet.contains(item)) continue;

            map.put(item, map.get(item) + 1);
        }

        int lt = 0;
        int rt = items.length - 1;

        while (true) {
            // lt와 rt가 ingredient에 포함되지 않는 곳에 위치한다면 무조건 길이를 줄일수 있습니다.
            while (!keySet.contains(items[lt])) lt++;
            while (!keySet.contains(items[rt])) rt--;
            // 혹시 몰라서 한 예외처리
            if (lt > rt) break;

            // 일단 정답을 찝습니다.
            answer = rt - lt + 1;

            boolean isMove = false; // 포인터가 더이상 움직이지 않는다면 최소 길이를 찾은 것.

            // lt와 rt에서 현재 선택된 item의 개수가 2보다 크다면 포함이 안되어도 괜찮기 때문에 이동을 시켜 줍니다.
            // 실제 코딩테스트 할 때 메소드로 따로 빼려다가 중복이 많이 안된다고 생각해서 걍 냅뒀습니다
            if (map.get(items[lt]) > 2) {
                map.put(items[lt], map.get(items[lt]) - 1); // 이동시켜 줄 때는 map에 현재 있던것이 하나 줄어들게 되므로 처리
                lt++;
                isMove = true;
            }

            if (map.get(items[rt]) > 2) {
                map.put(items[rt], map.get(items[rt]) - 1);
                rt--;
                isMove = true;
            }

            if (!isMove) break; // 포인터가 한번도 안 움직였다면 최소길이 입니다.
        }

        return answer;
    }
}