package CodingTest6;
/**
 * 1. ingredientSet에 ingredient를 set으로 넣고
 *  curRangeIngredients2Cnt에 item를 map으로 item과 0으로 셋팅
 *  -> curRangeIngredients: 현재 구간 내 포함된 재료의 종류 (ingredients에 속한 재료 개수만 카운팅)
 *  -> curRangeIngredients2cnt: 현재 구간 내 포함된 재료의 개수를 트래킹하기 위한 Map
 * 2. 투포인터를 사용하고 0번째는 탐색을 위해 전처리를 해줌
 * 3. ingredientSet에 0번째 item이 있으면 탐색용 set에 item 1개 있다고 넣어줌
 * 4. end를 이동하면서 그 이후도 ingredientSet에 N번째 item이 있으면 set에 item넣어줌
 * 5. ingredient가 모두 포함되었을때 end 이동멈추고 범위와 answer를 비교하여 더 짧은 쪽을 answer 업데이트
 *    이후에 start 이동하면서 answer값을 줄일 수 있는지 item 다시 탐색
 * 6. 중복으로 겹쳤던 item은 map에 갯수를 빼면서 item은 살아있고 갯수만 줄었으면 curRangeIngredients에서 제거 X
 *    -> 0이 되면 curRangeIngredients에서 제거
 * 7. 해당 루틴 반복하면서 모든 ingredient가 포함된 answer값을 리턴;
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CodingTest3_김우진 {

    public static int solution(String[] ingredients, String[] items) {
        Set<String> ingredientSet = new HashSet<>();

        for (String ingredient : ingredients) {
            ingredientSet.add(ingredient);
        }

        int start = 0, end = 0;
        int answer = items.length;

        /**
         * curRangeIngredients: 현재 구간 내 포함된 재료의 종류 (ingredients에 속한 재료 개수만 카운팅)
         * curRangeIngredients2cnt: 현재 구간 내 포함된 재료의 개수를 트래킹하기 위한 Map
         */
        Set<String> curRangeIngredients = new HashSet<>();
        Map<String, Integer> curRangeIngredients2Cnt = new HashMap<>();

        /**
         * 개수를 꺼낼 때 NullPointerException 발생을 방지하기 위해
         * 일단 items에 속한 재료들 모두 개수 0으로 초기화
         */
        for (String item : items) {
            curRangeIngredients2Cnt.put(item, 0);
        }

        /**
         * start, end 모두 0이므로
         * items의 0번째 재료가 필요한 재료에 속하는지 확인하고
         * 필요한 재료라면 curRangeIngredients에 추가
         * 그리고 curRangeIngredients2Cnt 업데이트
         */
        if (ingredientSet.contains(items[0])) {
            curRangeIngredients.add(items[0]);
            curRangeIngredients2Cnt.put(items[0], 1); // 현재 items[0] 재료가 한개 있다
        }

        /**
         * 투 포인터 진행
         * i) 현재 구간 내 필요한 재료 개수와 필요한 재료 개수가 동일할 경우
         * a. answer 업데이트
         * b. 구간을 좁히기 위해 start를 1 증가시킬 것이므로 items[start] 재료 개수 업데이트
         * b2. 재료 개수가 0일 경우 curRangeIngredients에서 제거
         *
         * ii) 현재 구간 내 필요한 재료 개수가 필요한 재료 개수보다 적을 경우
         * a. 구간을 넓혀야하므로 end 1 증가시킴 (end 범위 체크)
         * b. items[end] 재료 개수 업데이트
         */
        while (start <= end && end < items.length) {
            if (ingredientSet.size() == curRangeIngredients.size()) {
                answer = Math.min(answer, end - start + 1);

                int cnt = curRangeIngredients2Cnt.get(items[start]);

                if (cnt > 0) {
                    cnt--;

                    curRangeIngredients2Cnt.put(items[start], cnt);

                    if (cnt == 0) {
                        curRangeIngredients.remove(items[start]);
                    }
                }

                start++;
            } else if (ingredientSet.size() > curRangeIngredients.size()) {
                end++;

                if (end >= items.length) {
                    break;
                }

                if (ingredientSet.contains(items[end])) {
                    curRangeIngredients.add(items[end]);

                    int cnt = curRangeIngredients2Cnt.get(items[end]);
                    curRangeIngredients2Cnt.put(items[end], cnt + 1);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] ingredients = {"생닭", "인삼", "소주", "대추"};
        String[] items = {"물", "인삼", "커피", "생닭", "소주", "사탕", "생닭", "대추", "쌀"};

        System.out.println(solution(ingredients, items));
    }
}