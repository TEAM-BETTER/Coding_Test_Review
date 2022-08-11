package codiingTest.codingTest11.p2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 트리 만들기 힘들어서 그냥 메소드 구현 했습니다.
// 풀이는 두가지 입니다. 재귀함수를 이용한 풀이와
// String 으로 변환하여 사전식 정렬을 이용하였습니다.
public class Solution {
    public static List<Integer> list;       // n까지 숫자를 정렬된 상태로 받을 list

    public static int[] solution(int n) {
        list = new ArrayList<>();           // list 초기화
        if (n < 10) {                       // n이 10 미만일때 처리
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
        } else {                            // 10 이상일떄 처리 1을 담고 그 뒤로 담길 수를 재귀함수로 구현
            for (int i = 1; i < 10; i++) {
                list.add(i);
                addNum(i, n);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray(); // list 를 array 로반환
    }

    public static void addNum(int num, int n) { // 숫자 i(1~9) 뒤로 담길 수를 재귀 함수로 구현
        if (num > n) {                          // 담을 숫자가 범위 n 보다 크다면 리턴
            return;
        }
        for (int i = 0; i < 10; i++) {          // 숫자 i *10 + (0~9) 숫자를 list 에 더해줌
            if (num * 10 + i > n) {             // 범위 n 체크
                return;
            }
            list.add(num * 10 + i);             // list 에 num * 10 + i 를 담고
            addNum(num * 10 + i, n);       // 그 뒤에 담길 숫자 탐색
        }

    }

    // 다른 풀이 String 으로 변환하여 sort
    public static int[] solutionList(int n) {
        List<String> arr = new ArrayList<>(); // n까지 숫자를 담을 list
        for (int i = 0; i < n; i++) {         // list 에 숫자 담아줌
            arr.add(String.valueOf(i + 1));
        }
        Collections.sort(arr);                // list 에 String 으로 담겨져 있어 정렬하면 사전식으로 정렬됨

        return arr.stream().mapToInt(Integer::parseInt).toArray();     // int[] 형으로 반환
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(2)));
    }
}











