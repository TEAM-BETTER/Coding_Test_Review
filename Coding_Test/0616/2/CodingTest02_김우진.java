package CodingTest4;

/**
 * 1. 배열 queries를 돌면서 word에 맞는 것을 체크해줌
 * 2. *이 앞에있으면 prefix : 뒤에서 부터 맞는지 체크함
 * 3. words 배열에서 word를 하나씩 확인함
 *  주어진 word보다 *을 제외한 queries의 길이가 더 길면 false, 비교안함
 *  주어진 word보다 queries의 길이가 더 짧으면 조회 조건 성립 여부 확인
 *  prefix의 경우 비교하는 queries[i]는 *을 뺀 index 1번부터 부분문자열을 만들어 비교 시작
 *  문자열이니까 equals로 맞는지 확인 후 맞지않으면 false 맞으면 match true, cnt ++;
 *  4. 반대로 *이 뒤에 있는 경우 : * 전의 부분문자열을 만들어 비교 시작
 *  5. 비교하는 queries[i]는 index 0번부터 queryLength까지 비교
 *          int queryLength = queries[i].length() - 1;
 *  위와 마찬가지로 문자열이니까 equals로 맞는지 확인 후 맞지않으면 false 맞으면 match true, cnt ++;
 */

class CodingTest02_김우진 {

    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int cnt = 0;
            boolean prefix = true;

            // *가 앞에 있는지 확인
            if (queries[i].charAt(0) != '*') {
                prefix = false;
            }

            for (String word : words) {
                boolean match = true;
                int wordLength = word.length();
                int queryLength = queries[i].length() - 1;

                if (wordLength < queryLength) {
                    continue;
                }

                if (prefix) {
                    String query = queries[i].substring(1);

                    if (!word.substring(wordLength - queryLength, wordLength).equals(query)) {
                        match = false;
                    }
                } else {
                    String query = queries[i].substring(0, queryLength);

                    if (!word.substring(0, queryLength).equals(query)) {
                        match = false;
                    }
                }

                if (match) {
                    cnt++;
                }
            }

            answer[i] = cnt;
        }
        return answer;
    }
}