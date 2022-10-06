package CodingTest19;

import java.util.ArrayList;
import java.util.List;

public class CodingTest1_김우진 {

    /**
     * 두 문자열 길이 비교 후 다르면 false
     * 문자열 변환 전 param0, param1 같으면 true;
     *
     * param0의 첫 번째 문자와 param1이 같은 문자를 가질 때 해당 인덱스 값을 List에 저장
     * -> 저장된 문자 없으면 맞는 문자가 없으므로 false 리턴
     *
     * list 에 저장 된 idx 값을 기준으로
     * param0의 0부터 기준 idx 까지의 문자열이 param1의 기준 idx 값부터 문자열 끝까지 문자열과 일치하고,
     * param0의 기준 idx 부터 마지막 문자열까지 param1의 idx 0부터 기준 idx 까지 문자열이 일치하면 true 리턴
     *
     */

    public static boolean solution(String param0, String param1) {
        if (param0.length() != param1.length()) {
            return false;
        }

        if (param0.equals(param1)) {
            return true;
        }

        char c = param0.charAt(0);
        List<Integer> idxes = new ArrayList<>();

        for (int i = 0; i < param1.length(); i++) {
            if (param1.charAt(i) == c) {
                idxes.add(i);
            }
        }

        if (idxes.isEmpty()) {
            return false;
        }

        for (int idx : idxes) {
            if (param0.substring(0, param0.length() - idx).equals(param1.substring(idx))
                && param0.substring(param0.length() - idx).equals(param1.substring(0, idx))) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "cdeab";
        String t = "abcde";

        System.out.println(solution(s, t));
    }
}