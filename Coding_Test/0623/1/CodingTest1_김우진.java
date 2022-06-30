package CodingTest5;
class CodingTest1_김우진 {
    /**
     * getVisited 함수로 주어진 문자열 안에 해당 알파벳이 있는지 체크
     * 함수는 주어진 String의 각 알파벳을 인덱스로 변환
     * 소문자만 주어지므로 -'a'를 통해 visited[idx]값에 해당알파벳이 있으면 ++;
     * 주어진 String을 해당함수를 통해 몇개의 알파벳으로 만들어졌는지
     * 각 배열에 담아서 세어둡니다.
     * visited 배열안의 체크된 알파벳 갯수와 일치하면 true, 불일치면 false;
     */
    public static int[] getVisited(String s) {
        int[] visited = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';

            visited[idx]++;
        }

        return visited;
    }

    public static boolean solution(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] sVisited = getVisited(s);
        int[] tVisited = getVisited(t);

        for (int i = 0; i < 26; i++) {
            if (sVisited[i] != tVisited[i]) {
                return false;
            }
        }

        return true;
    }
}