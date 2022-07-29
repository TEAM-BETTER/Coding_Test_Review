package CodingTest3;

import java.util.*;
import java.util.stream.Collectors;

/**
 *      1. 조합할 수 있는 숫자값 numbers를 set에 넣어줌
 *      2. target값과 numbers의 숫자가 일치하는지 확인 -> 1가지 수로 target값이 나오는 지 chk
 *      3. 그 이후부터는 2가지 수에서 100까지 수까지 반복문으로 조합
 *      4. 숫자를 i개 썼을 때, 연산을 토대로 나올 수 있는 값 set에 저장
 *      -> 투 포인터 기법을 이용하여 숫자 (i - j)개, 숫자 i개로 나올 수 있는 결과 값들끼리 연산을 하여 set에 저장
 *      -> 이 때 해당 Target값이 없으면 숫자 i + 1개 썼을때 조합으로 넘어감
 *      -> 조합할 수 있는 숫자 수를 늘리면서 target값을 찾아감
 *      -> target값을 발견하면 해당 i 값을 반환
 *      5. 숫자수가 100이 넘어가도록 target값을 찾지 못하면 -1반환
 *
 */

public class CodingTest02_김우진 {

    public static int solution(int[] numbers, int target) {
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        /**
         * numbers 배열 내 있는 숫자를 set에 넣어줌
         */
        Set<Integer> set = Arrays.stream(numbers).
                boxed().collect(Collectors.toSet());
//        for (int number : numbers) {
//            set.add(number);
//        }

        /**
         * 배열에 있는 숫자들을 그대로 넣었으므로 숫자 하나를 이용한거
         */
        visited.put(1, set);

        /**
         * target이 현재 set 내에 있으면 숫자 하나로 표현 가능
         */
        if (set.contains(target)) {
            return 1;
        }

        /**
         * 숫자 100개 내 표현 가능한지 확인해보자
         */
        for (int i = 2; i <= 100; i++) {
            /**
             * 숫자 i개를 썼을 때 구한 숫자를 넣어줄 set 초기화
             */
            set = new HashSet<>();

            /**
             * 투포인터
             * set1: 숫자 1개 ~ 숫자 i / 2개 사용
             * set2: 숫자 i - 1개 ~ 숫자 i / 2개 사용
             * 즉 set1과 set2에 대해 더하기 혹은 곱하기 연산을 하면 숫자 i개를 사용한 것과 같은 효과
             * ex) (i - 1) + 1 = (i - 2) + 2 = (i - 3) + 3 ... = (i - i / 2) + i / 2 = i개
             */
            for (int j = 1; j <= i / 2; j++) {
                Set<Integer> firstHalfSet = visited.get(j);
                Set<Integer> restOfSet = visited.get(i - j);

                for (int x: firstHalfSet) {
                    for (int y: restOfSet) {
                        int addVal = x + y;
                        int multVal = x * y;

                        /**
                         * 숫자 i개를 썼을 때 나오는 값이 target이라면 i를 반환
                         */
                        if (addVal == target || multVal == target) {
                            return i;
                        }

                        /**
                         * 숫자 i개를 썼을 떄 값들을 새로운 set에 넣어줌
                         */
                        if (addVal < target) {
                            set.add(addVal);
                        }

                        if (multVal < target) {
                            set.add(multVal);
                        }
                    }
                }
            }

            /**
             * 숫자 i개 썼을 떄 나오는 값들을 set에 저장했으므로
             * visited 맵에 key: i, value: set을 넣어줌
             */
            visited.put(i, set);
        }

        /**
         * 숫자를 100개까지 썼는데도 답이 안 나오므로 -1 반환
         */
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 1};
        System.out.println(solution(numbers, 610382));
    }
}