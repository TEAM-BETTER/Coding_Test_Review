public class CodingTest01_윤지용 {
    public boolean solution(String s, String t) {
        // 길이가 다르면
        if (s.length() != t.length()) {
            return false; // 아니네
        }

        // 알파벳 숫자만큼 배열 만들기
        char[] sc = new char[26];
        char[] tc = new char[26];

        // 알파벳 해당하는 배열인덱스에 1씩 더하기
        for (int i = 0; i < s.length(); i++) {
            sc[s.charAt(i) - 97] += 1;
            tc[t.charAt(i) - 97] += 1;
        }

        // 더한 값이 다르면
        for (int i = 0; i < s.length(); i++) {
            if (sc[i] != tc[i]) {
                return false; // 아니네
            }
        }
        return true; // 맞네
    }
}
