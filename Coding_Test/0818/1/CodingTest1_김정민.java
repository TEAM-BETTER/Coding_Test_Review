import java.math.BigDecimal;

/*
* 문제 조건상 Integer값의 범위를 넘어가는 경우가 생길 수 있다고 생각해서
* BigDecimal을 이용했습니다!
* Integer.MAX_VALUE, Integer.MIN_VALUE를 이용해서 클리핑에 들어가는지 확인 후 클리핑 합니다!
* */
class Solution {
    public int solution(String s) {
        s = s.trim(); // 앞 뒤 공백을 잘라줌
        String parsed = parse(s);
        BigDecimal a = new BigDecimal(parsed);

        // 클리핑
        if (a.compareTo(new BigDecimal(Integer.MAX_VALUE)) > 0) {
            return Integer.MAX_VALUE;
        }
        // 클리핑
        if (a.compareTo(new BigDecimal(Integer.MIN_VALUE)) < 0) {
            return Integer.MIN_VALUE;
        }

        return Integer.parseInt(parsed);
    }

    // 문자열 문제 조건에 맞게 파싱
    public String parse(String s) {
        StringBuilder sb = new StringBuilder();

        // s가 trim 이후로 넘어오니까 앞에 부호가 있다면 넣어준다
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            sb.append(s.charAt(0));
        }

        // 숫자가 한번이라도 읽혔는지
        boolean isStart = false;

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            // 처음 숫자를 읽는 경우
            if (!isStart && Character.isDigit(c)) {
                isStart = true;
                sb.append(c);
                continue;
            }
            // 숫자를 안읽었는데 공백이 나오면 무시
            if (!isStart && c == ' ') {
                continue;
            }
            // 숫자를 읽기 시작했는데 숫자가 안나오면 무시
            if (isStart && !Character.isDigit(c)) {
                break;
            }
            sb.append(c);
        }

        return sb.toString();
    }
}