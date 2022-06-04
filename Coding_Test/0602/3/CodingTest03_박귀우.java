// 각각의 { } 들의 인덱스를 가져와 계산해야겠다는 컨셉을 잡았습니다.
// 마무리하고 보니 테스트케이스 2개 밖에 통과를 못하더군요..ㅠㅠ 화나서 꺼버렸습니다...

public class CodingTest03_박귀우 {
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
