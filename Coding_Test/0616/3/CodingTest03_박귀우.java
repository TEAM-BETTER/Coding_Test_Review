// ? 는 반드시 한개 이상 존재한다는 부분에서 영감을 받아 코드를 작성했습니다.

public class CodingTest03 {
    public String[][] solution(String[] words, String[] queries) {
        String[][] answer = new String[queries.length][];
        for (int i = 0; i < queries.length; i++) {
            List<String> result = new ArrayList<>();
            int qCnt = questionCnt(queries[i]);
            // 인덱스에서 ? 의 갯수만큼 뺴준것이 순수 텍스트만 있는 것입니다.
            String findText = queries[i].substring(0, queries[i].length() - qCnt);
            // 최종길이 또한 같아야 하기에 이렇게 따로 변수로 지정해줍니다.
            int totalLength = findText.length() + qCnt;
            for (int j = 0; j < words.length; j++) {
                if (words[j].startsWith(findText) && words[j].length() == totalLength) {
                    result.add(words[j]);
                }
            }
            answer[i] = result.toArray(new String[0]);
        }
        return answer;
    }

    // 물을표 를 세는 함수입니다.
    public int questionCnt(String querie) {
        int result = 0;
        for (int i = 0; i < querie.length(); i++) {
            if (querie.charAt(i) == '?')
                result++;
        }
        return result;
    }
}
