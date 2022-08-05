
/**
 * 처음에 String 이랑 int 스트림으로 했더니 14점이 나와서 이렇게 다시 풀어보니 16점 받았네요 .. 
 * 각 숫자별로 map 에 불리해서 그걸 다시 컬렉션으로 이용해서 이어붙여줄 생각을 했습니다.
 */

import java.util.*;

class Solution2 {
    public int[] solution(int n) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<Integer, ArrayList<String>> map = new HashMap<>();
        // map 안에 1~9까지 숫자를 넣어줍니다.
        for (int i = 1; i < 10; i++) {
            map.put(i, new ArrayList<>());
        }
        int left = 1; // 자꾸 타임아웃나서 반으로 줄여서 반복문할생각으로 이렇게 했습니다. 대차게 실패
        int right = n;
        if (right % 2 != 0) {
            String s = Integer.toString((left + right) / 2);
            ArrayList<String> target = map.get(s.charAt(0) - '0');
            target.add(s);
        }
        while (left < right) {
            String s = Integer.toString(left++);
            String s2 = Integer.toString(right--);
            ArrayList<String> target = map.get(s.charAt(0) - '0');
            ArrayList<String> target2 = map.get(s2.charAt(0) - '0');
            target.add(s);
            target2.add(s2);
        }
        for (int i = 1; i < 10; i++) { // 이어붙여줄 부분 map 에서 1부터 순차적으로 꺼내 정렬후 붙여줍니다.
            ArrayList<String> target = map.get(i);
            Collections.sort(target); // 아마 이부분 떄문에 안되는걸까요?
            for (int j = 0; j < target.size(); j++) { // 여기가 문제일까요 .. ㅠ
                answer.add(Integer.parseInt(target.get(j)));
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
