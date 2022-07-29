import java.util.*;

/**
 * 0~9 까지 숫자 만들어서 풀었습니다.
 * 4점 까여서 보니 ... 숫자 4가 5줄이 아니라 4줄로 작성했더라고요....😭
 */

class Solution {
    Map<Integer, String[]> map = new HashMap<>();

    public void init() {
        String[] st = new String[5];
        st[0] = "#####";
        st[1] = "#---#";
        st[2] = "#---#";
        st[3] = "#---#";
        st[4] = "#####";
        map.put(0, st);

        st = new String[5];
        st[0] = "--#--";
        st[1] = "--#--";
        st[2] = "--#--";
        st[3] = "--#--";
        st[4] = "--#--";
        map.put(1, st);

        st = new String[5];
        st[0] = "####";
        st[1] = "---#";
        st[2] = "####";
        st[3] = "#---";
        st[4] = "####";
        map.put(2, st);

        st = new String[5];
        st[0] = "####";
        st[1] = "---#";
        st[2] = "####";
        st[3] = "---#";
        st[4] = "####";
        map.put(3, st);

        st = new String[5];
        st[0] = "#--#";
        st[1] = "#--#";
        st[2] = "####";
        st[3] = "---#";
        st[4] = "---#";
        map.put(4, st);

        st = new String[5];
        st[0] = "#####";
        st[1] = "#----";
        st[2] = "#####";
        st[3] = "----#";
        st[4] = "#####";
        map.put(5, st);

        st = new String[5];
        st[0] = "#####";
        st[1] = "#----";
        st[2] = "#####";
        st[3] = "#---#";
        st[4] = "#####";
        map.put(6, st);

        st = new String[5];
        st[0] = "#####";
        st[1] = "----#";
        st[2] = "----#";
        st[3] = "----#";
        st[4] = "----#";
        map.put(7, st);

        st = new String[5];
        st[0] = "#####";
        st[1] = "#---#";
        st[2] = "#####";
        st[3] = "#---#";
        st[4] = "#####";
        map.put(8, st);

        st = new String[5];
        st[0] = "#####";
        st[1] = "#---#";
        st[2] = "#####";
        st[3] = "----#";
        st[4] = "----#";
        map.put(9, st);
    }

    public String[] solution(int n) {
        init();
        String num = Integer.toString(n); // 숫자 자릿수 계산 귀찮아서 string으로 변환
        String[] answer = { "", "", "", "", "" };
        for (int i = 0; i < num.length(); i++) {
            String[] rs = map.get(num.charAt(i) - '0');
            for (int j = 0; j < answer.length; j++) {
                if (i == num.length() - 1) {
                    answer[j] += rs[j];
                } else {
                    answer[j] += rs[j] + " ";
                }
            }
        }
        // System.out.println(Arrays.toString(answer));
        return answer;
    }
}
