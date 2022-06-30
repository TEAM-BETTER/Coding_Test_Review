package CodingTest5;

import java.util.ArrayList;
import java.util.List;

public class CodingTest2_김우진 {

    /**
     * 주어진 배열의 수를 이어붙여 만든 가장 큰 수를 문자열로 출력해야함
     * 때문에 먼저 매개변수로 받은 정수들을 문자열 리스트에 다시 넣어줌
     * 그리고 이어붙여 가장 큰 정수가 되려면 두 문자를 합쳤을때 큰 수가 되게 해야함
     * Comparable 람다표현식을 이용해서 두 문자를 합쳤을때 더 큰 수를 앞에 오도록 정렬해줌
     * 해당 비교정렬을 통해 정리된 문자열들을 answer에 이어붙여주면 답이됨
     */
    public static String solution(int[] numbers) {
        List<String> stringNumbers = new ArrayList<>();

        for (int number : numbers) {
            stringNumbers.add(String.valueOf(number));
        }

        stringNumbers.sort((o1, o2) -> Integer.valueOf(o2 + o1) - Integer.valueOf(o1 + o2));

        StringBuilder answer = new StringBuilder();

        for (String stringNumber : stringNumbers) {
            answer.append(stringNumber);
        }

        return answer.toString();
    }
}
