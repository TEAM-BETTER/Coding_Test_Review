import java.util.*;
/* 연속해서 나타난 숫자를 제거하는 문제, set은 중복되는 모든 값을 제거하기 때문에 list */
public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList <Integer> list = new ArrayList<Integer>();
        /* 배열의 가장 첫 번째 값을 먼저 삽입하여 기준을 만듬*/
        list.add(arr[0]);
        /* 이미 삽입된 arr[0]을 제외하고 1부터 루프를 돌기 시작함 */
        for (int i = 1; i < arr.length; i++) {
          /*
          list의 가장 마지막 값과 현재 루프를 돌면서 가져온 arr 배열의
          i번째 값이 같으면 연속되어 나타난 값이기에 같지 않을 때에만 삽입 (add)
          */
            if (list.get(list.size() - 1) != arr[i]) list.add(arr[i]);
        }
        /* 반환값은 int 배열으로 넘어가야 하기 때문에 list를 int[]로 변환 */
        return list.stream().mapToInt(num -> num).toArray();
    }
}
