// 1번문제랑 비슷하게 직접 읽어와서 같아야 하는 부분끼리만 비교했습니다.
// *가 없는 부분끼리 일치하면 카운트 해주는 방식으로 코드를 작성했습니다.
class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int ans = 0;
            String query = queries[i];
            //시작 부분 검색인 경우
            if (query.charAt(0) != '*'){
                String queryStr = query.substring(0,query.length() - 1); //일치해야 하는 부분 "ABC*" -> "ABC"
                for(String word: words) {
                    if(queryStr.length() <= word.length() && word.substring(0, queryStr.length()).equals(queryStr)) {
                        ans++;
                    }
                }
            }else{
                //끝 부분 검색인경우
                String queryStr = query.substring(1); //일치해야 하는 부분 "*ABC" -> "ABC"
                for(String word: words) {
                    int startIndex = word.length() - queryStr.length();
                    if(startIndex >= 0) {
                        if(word.substring(startIndex).equals(queryStr)){ // 뒤에 부분이 일치하면 카운트
                            ans++;
                        }
                    }

                }
            }
            answer[i] = ans;
        }

        return answer;
    }
}