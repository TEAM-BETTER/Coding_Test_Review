import java.io.*;

/**
 * 코테 끝나고 문제 차근차근 읽어보면서 패드에 손코딩 살짝해보니 풀리네요 ...
 * 이런 구현 문제는 시간 압박을 안받으면 풀수 있겠는데 매번 못풀고 넘어가네요 쥬륵..
 * 구현 문제이니 만큼 최대한 의식의 흐름에 맡겨 작성하겠습니다.
 */

/**
 * 주어진 테스트 코드들 과 정답을 확인하는 클래스 입니다. 필요하시면 복붙하셔서 사용하세요
 * 물론 파일 패스는 수정하셔야 합니다.
 * class Main {
 * public static void main(String[] args) throws IOException {
 * Solution s = new Solution();
 * //정확성 1~5 는 다 패스합니다.
 * for (int i = 1; i <= 5; i++) {
 * BufferedReader bf = new BufferedReader(
 * new FileReader("./src/codingTest_week_12/test/problem1/acc_test/" + i +
 * "_i.txt"));
 * String x = bf.readLine().replaceAll("\"", "");
 * bf = new BufferedReader(
 * new FileReader("./src/codingTest_week_12/test/problem1/acc_test/" + i +
 * "_o.txt"));
 * int y = Integer.parseInt(bf.readLine());
 * System.out.println(x + " " + y);
 * isAnswer(i, y, s.solution(x));
 * }
 * }
 * public static void isAnswer(int caseNum, int ans, int ans2) {
 * if (ans == ans2) {
 * System.out.println("Case " + caseNum + ": Pass");
 * } else {
 * System.out.println("Case " + caseNum + ": Fail");
 * }
 * }
 * }
 */
class Solution {
    class isRepeatA { // 밑에서 반환해줄 용도로 사용할 구조체
        int cnt;
        boolean isRepeat;

        isRepeatA(int cnt, boolean isRepeat) {
            this.cnt = cnt;
            this.isRepeat = isRepeat;
        }
    }

    char a = 'a'; // 자주 사용할 느낌이여서 선언

    public int solution(String s) {
        int cnt = 0;
        while (!s.equals(Character.toString(a))) { // a 가 하나 남을떄 까지 계속 문자열 변환
            s = change(s);
            cnt++;
        }
        return cnt;
    }

    public String change(String s) {
        // 처음에는 arr 를 이용해서 하려고 하다 보니 a가연속해서 나온다면 그 총길이가 줄어들더라고요...
        // 그래서 buffer 나 builder 를 이용해서 작업했습니다.
        StringBuffer sb = new StringBuffer();
        int idx = 0; // for 문을 사용하려고 했는데 인덱스 관리가 힘들어서,while 선택
        while (idx < s.length()) {
            if (s.charAt(idx) != a) { // 현재 문자가 a 가아니라면 과감하게 sb에 추가
                sb.append(s.charAt(idx++));
                continue; // 이거 없으면 밑에함수 다실행되여 바보같이 이거 뺴놓고 디버깅하고있었습니다 ㅎㅎ
            }
            if (isLeftOrRight(s, idx)) {
                // index 를 따라가면서 a 가하나인 경우를 체크 하고
                int x = idx - 1; // a가하나라면 그기준 왼쪽
                int x2 = idx + 1; // 오른쪽
                if (x >= 0) {
                    // 왼쪽처리
                    // 음수인 경우 즉 0번쨰 인덱스를 예외처리 해주기 위해 범위를 이용했습니다.
                    // 왼쪽 인경우는 이미 추가된 친구를 바꾸어주야하기떄문이 이렇게 작성
                    sb.setCharAt(sb.length() - 1, a);
                    sb.append(a);
                }
                if (x2 < s.length()) {
                    // 오른쪽처리 이건 뭐 특별할게없죠
                    // sb 추가인데 두줄안하고 "aa" 해되되겠네요 ㅎㅎ...
                    sb.append(a);
                    sb.append(a);
                }
                idx += 2;
            }
            // 여기서 a가 연속으로 나오는 경우를 체크합니다.
            isRepeatA rs = isRepeat(s, idx);
            if (rs.isRepeat) {
                // 클래스안의 isRepeat 이 트루라면 아래 함수를 이용해 a 를 합쳐줍니다.
                sb.append(a);
                idx += rs.cnt;
            }
        }
        return sb.toString();
    }

    public isRepeatA isRepeat(String s, int idx) {
        // 원래 boolean 만 넘겨줄려다가 idx 계산하기 귀찮아서 클래스 만들었습니다.
        int cnt = 0;
        boolean rs = false;
        for (int i = idx; i < s.length(); i++) {
            if (s.charAt(i) != a)
                break;
            else
                cnt++;
        }
        if (cnt > 1)
            rs = true;
        return new isRepeatA(cnt, rs);
    }

    public boolean isLeftOrRight(String s, int idx) {
        // idx 0 인경우 처리
        if (idx == 0 && s.charAt(idx + 1) == a) {
            return false;
        } else if (idx == 0 && s.charAt(idx + 1) != a) {
            return true;
        }
        // idx 끝에인 경우 처리
        if (idx == s.length() - 1 && s.charAt(idx - 1) == a) {
            return false;
        } else if (idx == s.length() - 1 && s.charAt(idx - 1) != a) {
            return true;
        }
        // idx 그외
        if (s.charAt(idx - 1) == a || s.charAt(idx + 1) == a) {
            return false;
        }
        // 위에 다통과 한다면 외로운 아이
        return true;
    }
}