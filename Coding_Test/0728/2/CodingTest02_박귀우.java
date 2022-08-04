import java.util.*;

/**
 * 배열 하나를 생성해 각숫자 별로 인덱스를 기록해주어서
 * for 문을 이용해 현재 num 를 0~9 까지 숫자 인덱스로 돌려줍니다.
 * 오로지 1번만 교체 가능함으로
 * 그중 기록된 인덱스 가 i 보다 큰 경우 에 스왑 을 진행해 return 해줍니다.
 */

class Solution {
    public int solution(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        int[] d = new int[10]; // 인덱스 담을 배열
        for (int i = 0; i < digits.length; i++) {
            d[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int k = 9; k > digits[i] - '0'; k--) {
                // 현재 찾고있는 인덱스의 기록된 값보다 큰값이 있는경우 스왑
                if (d[k] > i) {
                    char tmp = digits[i];
                    digits[i] = digits[d[k]];
                    digits[d[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                }
            }
        }
        return num;
    }
}