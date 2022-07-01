public class codingTest02_윤지용 {
    public static int[] solution(String[] words, String[] queries) {
        // 별표는 한개라는 것을 가지고 문제를 풀었습니다.
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            if(queries[i].substring(0,1).equals("*")) { // 뒤가 일치
                int endcnt = 0;
                String endstr = queries[i].substring(1); // 별 뒤에 문자 추출
                for (int j = 0; j < words.length; j++) {
                    if(words[j].endsWith(endstr)) { // 추출한 문자로 끝나는 단어가 있으면
                        endcnt++; // 정답카운트 +1개
                    }
                    answer[i] = endcnt;
                }
            } else { // 앞이 일치
                int frontcnt = 0;
                String frontstr = queries[i].substring(0, queries[i].length()-1); // 별 앞에 문자 추출
                for (int j = 0; j < words.length; j++) {
                    if(words[j].startsWith(frontstr)) { // 추출한 문자로 시작하는 단어가 있으면
                        frontcnt++; // 정답카운트 +1개
                    }
                    answer[i] = frontcnt;
                }
            }
        }
        return answer;
    }
}
