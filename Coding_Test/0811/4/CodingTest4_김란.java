/*
4번 - 20점
테스트 볼 때는 16점 받았는데 오늘 다시 풀어서 20점 받았습니다.
순서가 중요하니까 solution() 내에서 sort()하면 안 될거라 잘못 생각했다 깎였습니다.
(처음에 중간값 찾는 메서드를 구현하니까 효율성 테스트 2개를 통과 못해서 방법을 바꿨습니다)
투 포인터 p1, p2를 지정해주고 p1에 해당하는 데이터는 리스트에서 삭제하고 p2에 해당하는 값은 리스트에 새로 추가하는 방식으로 풀었습니다.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
public class CodingTest4_김란  {
    public static int[] solution(int[] arr, int k) {
        int [] answer = new int[arr.length - k + 1];    // 4
       ArrayList<Integer> tmpList = new ArrayList<>();

        // 초깃값을 넣어준다.
        for(int i = 0; i < k; ++i){
            tmpList.add(arr[i]);
        }
        Collections.sort(tmpList);                   // 중간값을 구하는게 목적이므로 정렬해서 순서 바뀌어도 상관없다
        answer[0] = tmpList.get(tmpList.size() / 2); // 중앙값 넣기
//        System.out.println("i = " + 0 + ", tmp = " + Arrays.toString(tmpArr));

        for(int i = 1; i < answer.length; ++i){

            int p1 = i - 1;     // 리스트에서 삭제할 데이터의 인덱스
            int p2 = p1 + k;    // 리스트에 추가할 데이터의 인덱스
            tmpList.remove(Integer.valueOf(arr[p1]));   // 맨 앞의 인덱스가 아닌 '데이터 값'을 매개변수로 넣는다.
            tmpList.add(arr[p2]);
            Collections.sort(tmpList);
            answer[i] = tmpList.get(tmpList.size() / 2); // 중앙값 넣기
//            System.out.println("i = " + i + ", tmpList = " + tmpList);
        }
        return answer;
    }

    public static void main(String[] args) {

        int[] arr= {4, 2, 6, 4, 2, 3};
        System.out.println(Arrays.toString(solution(arr, 3)));  // 4, 4, 4, 3

        arr= new int[]{6, 4, 2, 4, 10, 15, 16, 15, 17};
        System.out.println(Arrays.toString(solution(arr, 5)));  // 4, 4, 10, 15, 15
    }
}