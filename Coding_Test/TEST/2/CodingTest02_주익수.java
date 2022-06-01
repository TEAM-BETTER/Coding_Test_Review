/**
 * 금일 프로그래머스 2번 문제
 * 문제가 기억이 안나요...
 * 숫자 거꾸로해도 똑같은 숫자 인 경우 숫자를 세는거 같은데..
 */

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList();
        int count = 0;
        int j = 0;

        for (int i = 0; i < arr.length; ) {
            for (j = i + 1; j < arr.length; j++) {
                if (i > 0) {
                    if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1])
                        break;
                }
                if (arr[i] == arr[j])
                    continue;
                break;
            }

            answer.add(arr[i]);
            i = j;

        }

        return answer.stream().mapToInt(x -> Integer.valueOf(x)).toArray();
    }
}