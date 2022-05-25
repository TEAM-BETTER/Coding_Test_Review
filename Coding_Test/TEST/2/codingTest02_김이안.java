import java.util.ArrayList;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] == arr[i]){
                arr[i-1] = -1;
            }
        }   // 배열 arr에서 전인덱스와 현인덱스가 같으면 전인덱스의 값을 -1로 초기화
        for(int num : arr){
            if(num == -1) continue;
            list.add(num);
        }   // -1인 인덱스를 제외한 값을 리스트에 추가
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}