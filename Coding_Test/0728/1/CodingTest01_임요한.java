import java.util.Arrays;

// 단순하게 각 숫자마다 문자열 행을 만들고 출력했습니다. (이 방법 말고는 안 떠오르네요)
// num메서드의 if문 최적화는 하지 않았습니다.

class CodingTest01_임요한 {
    public String[] solution(int n) {
        String[] answer = new String[5];
        Arrays.fill(answer, "");
        String str = String.valueOf(n);
        String[] strs = str.split("");

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (j == strs.length - 1) {
                    answer[i] = answer[i].concat(num(Integer.parseInt(strs[j]), i));
                } else {
                    answer[i] = answer[i].concat(num(Integer.parseInt(strs[j]), i)) + " ";
                }
            }
        }
        return answer;
    }

    public String num(int n, int idx) {
        String row0 = "", row1 = "", row2 = "", row3 = "", row4 = "";
        if (n == 0 || (n >= 5 && n <= 9)) {
            row0 = "#####";
            if (n == 5 || n == 6 || n == 8 || n == 9) {
                row2 = "#####";
                if (n == 5) {
                    row1 = "#----";
                    row3 = "----#";
                    row4 = "#####";
                } else if (n == 6) {
                    row1 = "#----";
                    row3 = "#---#";
                    row4 = "#####";
                } else if (n == 8) {
                    row1 = "#---#";
                    row3 = "#---#";
                    row4 = "#####";
                } else {
                    row1 = "#---#";
                    row3 = "----#";
                    row4 = "----#";
                }
            } else if (n == 7) {
                row1 = "----#";
                row2 = "----#";
                row3 = "----#";
                row4 = "----#";
            } else {
                row1 = "#---#";
                row2 = "#---#";
                row3 = "#---#";
                row4 = "#####";
            }
        } else if (n == 1) {
            row0 = "--#--";
            row1 = "--#--";
            row2 = "--#--";
            row3 = "--#--";
            row4 = "--#--";
        } else if (n == 2) {
            row0 = "####";
            row1 = "---#";
            row2 = "####";
            row3 = "#---";
            row4 = "####";
        } else if (n == 3) {
            row0 = "####";
            row1 = "---#";
            row2 = "####";
            row3 = "---#";
            row4 = "####";
        } else {
            row0 = "#---#";
            row1 = "#---#";
            row2 = "#####";
            row3 = "----#";
            row4 = "----#";
        }


        if (idx == 0) {
            return row0;
        } else if (idx == 1) {
            return row1;
        } else if (idx == 2) {
            return row2;
        } else if (idx == 3) {
            return row3;
        } else {
            return row4;
        }
    }
}