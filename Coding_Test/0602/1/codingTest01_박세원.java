/*
 효율성 0점으로 20점중 10점 받은 코드입니다.
 올바른 코드인가 보다는 왜 비효율적이었는지 확인해보고 싶어서 PR올려봅니다.

 시험 당시 전략은
 1. 배열을 오름차순으로 정렬된 ArrayList만들기
 2. min값 추출
 3. min값 +1씩 늘려서 찾고 없으면 +1된 값 반환 break;

 정렬하는게 시간이 많이 소모되죠?
 stream에 컬렉션프레임워크까지 써서 그런건지 효율성이 0점이네요.


 좀더 효율적이려면
 1. 최솟값 for문 한번 돌리고
 2. for문으로 최솟값에 +1시켜서 찾고 없으면 +1된값 반환 break;
 로 진행해서 for문 아래 for문 하면 O(N)으로 끝날것 같아서 20점이 나오지 않을까 생각됩니다만

 진짜 원인이 무엇일지 같이 얘기해보면 좋을것 같아요.

*/


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem1 {
    public int solution(int[] numbers) {
        int answer = 0;

        // 정렬하고 최솟값
        List<Integer> sortedlist = Arrays.stream(numbers)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        int minVal = Collections.min(sortedlist);

        // 값이 있으면 연속된 숫자이므로 최솟값을 1 늘려줌 없으면 그 값이 최대값
        for (int i = 0; i < sortedlist.size(); i++) {
            if(sortedlist.get(i) == minVal){
                minVal++;
            } else {
                answer = minVal;
                break;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        int[] numbers = {9, 4, 2, 3, 7, 5};

        Problem1 test1 = new Problem1();
        System.out.println(test1.solution(numbers));

    }
}
