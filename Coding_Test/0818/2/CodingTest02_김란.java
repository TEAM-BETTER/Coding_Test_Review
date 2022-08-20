/*
2번 - 14점

완전탐색을 이용했더니 역시나 효율성 3개를 통과하지 못했네요ㅎㅎ
중복을 제거하기 위해 세 가지 수의 합을 Set에 넣었습니다.
Map에는 <해당값, 해당값과 target의 차이> 이렇게 key-value를 넣었습니다.
그러고나서 Map의 value 기준으로 정렬하기 위해 새로운 ArrayList에 keySet을 넣고
value 기준 정렬을 구현했습니다.
여기서 어떻게 효율성을 높일 수 있는지 모르겠네요~ 조언 부탁드립니다.

 */

import java.util.*;
public class CodingTest02_김란 {

    public static  int solution(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        if(arr.length == 3){
            return  Arrays.stream(arr).sum();
        }

        Set<Integer> set = new HashSet<>(); //
        Arrays.sort(arr);

        for(int i = 0;i < arr.length; ++i){
            for(int j = 0; j < arr.length; ++j){
                if(i == j){ continue;}
                for(int k = 0;k < arr.length; ++k){
                    if(i == k || j == k){
                        continue;
                    }
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum == target){          // 합이 바로 있는 경우
//                        System.out.println(x + " " + y +" " + z);
                        return sum;
                    }
                    set.add(sum);
                    map.put(sum, Math.abs(sum - target));
                }
            }
        }
//         System.out.println("map = " + map);

        // 정렬하고 나면 차이가 가장 작은 두 개의 데이터가 맨 앞에 저장된다.
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<Integer>() {     // value 기준으로 오름차순 정렬
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });

        // 차이가 같을 때 작은 값을 반환한다.
        if(Math.abs(keySet.get(0) - target) ==  Math.abs(keySet.get(1) - target)){
            return keySet.get(0) < keySet.get(1) ? keySet.get(0) : keySet.get(1);
        }

        // 차이가 다른 경우의 반환값
        return keySet.get(0);
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 10, 12, 15};
        System.out.println(solution(arr, 21));    // 20

        arr = new int[]{-5, 2, 4, 10, 23};
        System.out.println(solution(arr, 15));    // 16
    }
}
