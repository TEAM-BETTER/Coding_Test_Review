
/**
 * 못풀고 return true 제출해서 16점 받은 문제입니다. 끝나고 화나서 이렇게 작성 했는데 될지는 모르겠네요.
 * map 을 이용해 주어진 word 의 첫 말들을 분류해줍니다.
 * 그 map 으로 분류된 word 와 s 의 인덱스를 가지고 만약 마지막 까지 도달할수 있는 경우가 발생한다면 true 리턴해준다는 
 * 느낌으로 작성했습니다.
 */

import java.util.*;

class Solution3 {
    Map<Character, ArrayList<String>> map = new HashMap<>();
    String s;

    public boolean solution(String s, String[] words) {
        this.s = s;
        for (String x : words) {
            char t = x.charAt(0);
            if (!map.containsKey(t)) {
                map.put(t, new ArrayList<>());
            }
            ArrayList<String> list = map.get(t);
            list.add(x);
        }
        if (!map.containsKey(s.charAt(0))) {
            return false;
        }
        // 분류된 상태에서 만약 첫번쨰 케릭터가 map 에 없다면 그단어는 시작조차할수 없기떄문에 바로 false 리턴해줍니다.
        ArrayList<String> list = map.get(s.charAt(0));
        for (int i = 0; i < list.size(); i++) { // 첫번쨰 시작하는 케릭터로 루프
            if (helper(list.get(i).length())) { // 재귀
                return true;
            }
        }
        return false;
    }

    public boolean helper(int idx) {
        if (idx == s.length()) { // 인덱스가 현재 렝스와 같다면 true 를 리턴해줍니다.
            return true;
        }
        if (!map.containsKey(s.charAt(idx))) {
            return false;
        }
        ArrayList<String> list = map.get(s.charAt(idx));
        for (int i = 0; i < list.size(); i++) {
            // 인덱스가 넘어간다면 넘겨줍니다. false 리턴해야하나요 애매한 부분입니다.
            if (idx + list.get(i).length() > s.length())
                continue;
            // 함수를 실행해서 true 값이 반환된다면 true를 리턴해줍니다.
            if (helper(idx + list.get(i).length())) {
                return true;
            }
            ;
        }
        // 모든 size 를 돌아도 리턴이 안된다면 false 를 리턴해줍니다.
        return false;
    }
}
