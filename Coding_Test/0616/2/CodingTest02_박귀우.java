// 단어의 시작 과 끝을 찾는 방법인데 regex 이용해서 패턴 매칭하려다가 실패해서 아래와 같이 구현했습니다.
// 키포인트인 * 이 어디에 위치했는지 찾아 그것을 이용해 문자를 자르고 찾는 방식을 적용했습니다.
// 이또한 범위가 작아 통과한 코드 같습니다. 트라이를 이용하면 보다 빠른 결과물을 얻을수 있을꺼 같습니다.

public class CodingTest02_박귀우 {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int result = 0; // 몇개를 찾았는지 숫자를 세줍니다.
            int starIdx = queries[i].indexOf('*'); // * 의 인덱스를 찾아 * 이 없는 스트링으로 예쁘게 다듬어줍니다.
            String withOutStar = starIdx == 0 ? queries[i].substring(1)
                    : queries[i].substring(0, queries[i].length() - 1);
            for (String word : words) {
                // 다듬은 스트링을 이용해 * 의 인덱스를 이용해 문자열을 찾습니다.
                if (starIdx == 0) {
                    if (word.endsWith(withOutStar)) {
                        result++;
                    }
                } else {
                    if (word.startsWith(withOutStar)) {
                        result++;
                    }
                }
            }
            answer[i] = result;
        }
        return answer;
    }
}
