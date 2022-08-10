package CodingTest11;

import java.util.Arrays;

/**
 * 냅색 알고리즘
 *
 * 1. list 배열은 money가 되기 위해 필요한 칩의 갯수를 카운트
 *      -> list의 index값은 money가 됩니다.
 *
 * 2. 반복문을 chip의 종류 만큼 돌며, 해당 money가 되기 위해 chip이 몇 개가 필요한지 카운트
 *
 *      -> 최소 칩 갯수를 구하기 위해 Math.min 사용
 *      -> ex) chip[0] = 1100;
 *      list[1100] = Math.min(list[1100 - 1100] + 1 , 10001);
 *      list[2200] = Math.min(list[1100] = 1, 10001); ...
 *
 * 3. 모든 반복문을 돌아 list[money] 값 리턴
 *      -> 만약 초기값 그대로 10001이 나왔다면 해당 money에 알맞게 환전 불가능
 */

public class CodingTest4_김우진 {

    public static int solution(int money, int[] chips) {

        int[] list = new int[money + 1];
        Arrays.fill(list, 10000 + 1);
        list[0] = 0;

        for (int i = 0; i < chips.length; i++) {
            for (int j = chips[i]; j <= money; j++) {
                list[j] = Math.min(list[j - chips[i]] + 1, list[j]);
            }
        }

        return list[money];
    }

    public static void main(String[] args) {
        int money = 3000;
        int[] chips = {1100, 500, 200, 150, 25};

        System.out.println(solution(money, chips));
    }
}