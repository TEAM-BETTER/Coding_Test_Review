// 각각의 { } 들의 인덱스를 가져와 계산해야겠다는 컨셉을 잡았습니다.
// 마무리하고 보니 테스트케이스 2개 밖에 통과를 못하더군요..ㅠㅠ 화나서 꺼버렸습니다...

public class CodingTest03_박귀우 {
    public static void main(String[] args) {
        String ex = "6{a2{b4{c}d}e}f";
        String exAns = "abccccdbccccdeabccccdbccccdeabccccdbccccdeabccccdbccccdeabccccdbccccdeabccccdbccccdef";
        ex = "ab3{cd2{ef4{ge}hi}jk}lm";
        exAns = "abcdefgegegegehiefgegegegehijkcdefgegegegehiefgegegegehijkcdefgegegegehiefgegegegehijklm";
        ex = "ab3{cd2{ef4{ge}hi}jk}lm5{qw3{we}}";
        exAns = "abcdefgegegegehiefgegegegehijkcdefgegegegehiefgegegegehijkcdefgegegegehiefgegegegehijklmqwweweweqwweweweqwweweweqwweweweqwwewewe";
        ex = "ab3{cd2{ef4{ge}hi}jk}lm5{qw3{we}}5{z}2{ahr}";
        exAns = "abcdefgegegegehiefgegegegehijkcdefgegegegehiefgegegegehijkcdefgegegegehiefgegegegehijklmqwweweweqwweweweqwweweweqwweweweqwwewewezzzzzahrahr";
        Feedback_Sol f = new Feedback_Sol();
        System.out.println(f.feedback_sol(ex));
        System.out.println(exAns);
        // System.out.println(f.recur(ex));
    }

    static class Feedback_Sol {
        /** 민지님이 작성하신 것으로 대체 했습니다. 완벽하네요 */
        String feedback_sol(String code) {
            StringBuilder sb = new StringBuilder(code);
            while (code.contains("{") && code.contains("}")) {
                int leftIdx = getLeftBracket(code, '{');
                int rightIdx = findBracket(code, leftIdx, '}');
                String change = code.substring(leftIdx + 1, rightIdx).repeat(code.charAt(leftIdx - 1) - '0');
                sb.replace(leftIdx - 1, rightIdx + 1, change);
                code = sb.toString();
            }
            return code;
        }

        int getLeftBracket(String code, char target) {
            // int cur = -1;
            // while (code.indexOf(target, cur + 1) != -1) {
            // cur = code.indexOf(target, cur + 1);
            // }
            // 생각해보니 뒤에서 앞으로가면서 찾으면 그게 마지막 인덱스 입니다.
            for (int i = code.length() - 1; i >= 0; i--) {
                if (code.charAt(i) == '{') {
                    return i;
                }
            }

            return -1;
        }

        int findBracket(String s, int cur, char target) {
            return s.indexOf(target, cur);
        }

        /**
         * 강사님과 다르게 i 를 변수로 넘김
         */
        int idx = 0;

        String recur(String code) {
            StringBuilder sb = new StringBuilder();
            int num = 0;
            while (idx < code.length()) {
                if (Character.isDigit(code.charAt(idx))) {
                    num = code.charAt(idx) - '0';
                    idx++;
                } else if (code.charAt(idx) == '{') {
                    idx++;
                    String temp = recur(code);
                    sb.append(temp.repeat(num));
                } else if (code.charAt(idx) == '}') {
                    idx++;
                    break;
                } else {
                    sb.append(code.charAt(idx));
                    idx++;
                }
            }
            return sb.toString();
        }
    }

    class Previous_sol {
        public String solution(String code) {
            StringBuilder sb = new StringBuilder(code);
            while (true) {
                int leftIdx = getLeftBracket(code, '{'); // 가장 마지막 { 를 찾아옵니다.
                int rightIdx = findBracket(code, 0, '}');
                if (leftIdx == -1 || rightIdx == -1) { // 범위가 벗어난다면 반복문을 종료합니다.
                    break;
                }
                String change = code.substring(leftIdx + 1, rightIdx).repeat(code.charAt(leftIdx - 1) - '0');
                // 찾은 브라켓의 인덱스를 활용해 현재 문장을 대체합니다.
                sb.replace(leftIdx - 1, rightIdx + 1, change);
                code = sb.toString();
            }
            return code;
        }

        int getLeftBracket(String code, char target) {
            int cur = code.indexOf(target);
            int nCur = code.indexOf('}');
            int nextCur = findBracket(code, cur + 1, target);
            // 만약 } 의 인덱스와 { 인덱스 사이 { 한개 더있다면 { 의 가장 마지막을 찾기위해 추가 반복문을 활용했습니다.
            if (nextCur < nCur && cur < nCur && nextCur != -1) {
                while (true) {
                    int newCur = findBracket(code, cur + 1, target);
                    if (newCur == -1) {
                        break;
                    } else {
                        cur = newCur;
                    }
                }
            }
            return cur;
        }

        public int findBracket(String s, int cur, char target) {
            return s.indexOf(target, cur);
        }
    }
}
