import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();

        // 첫번째값은 중복이 될 가능성이 없으므로 무조건 넣는다.
        list.add(arr[0]);
        // 두번째 값부터 현재 인덱스와 이전 인덱스의 값을 비교하여 같으면 넘어간다.
        // 다르다면 연속해서 중복이 아니므로 값을 넣어준다.
        for(int i = 1; i < arr.length; i++) {
            if (arr[i-1] == arr[i]) continue;
            list.add(arr[i]);
        }

        // ArrayList를 반환 형식에 맞게 int 배열로 바꿔준다.
        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}