import java.util.Arrays;

// 1번 문제와 마찬가지로 Trie 를 사용해야 하지만 statsWith 와 endsWith 를 사용하여 풀이
// 이번 코테에서는 히든 테스트 케이스가 널널하여 점수를 얻을 수 있었지만 만약 시간제한을 빠듯하게 둔다면
// 이 방법으로 풀이하는 것은 시간복잡도에서 많은 감점 생각됨
public class Solution {
    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];                     // 정답을 return 하는 배열

        for (int i = 0; i < queries.length; i++) {                  // queries 를 돌면서 words 에서 탐색하는 for 문
            int count = 0;                                          // 횟수 기록하는 변수
            boolean first = queries[i].startsWith("*");              // * 가 앞에 있는지 뒤에 있는지 기록한 boolean
                                                                    // * 앞에 있으면 false 뒤에 있으면 true
            String q = queries[i].replaceAll("[*]", ""); //  비교 할 때 * 가 있으면 비교하기 힘들어서 제거
            for (String word : words) {
                if (!first && word.startsWith(q)) {                  // * 가 뒤에 있을 때 words 에서 starsWith 로 탐색
                    count++;
                }
                if (first && word.endsWith(q)) {                     // * 가 앞에 있을 때 words 에서 endsWith 로 탐색
                    count++;
                }
            }
            answer[i] = count;                                      // 총 갯수 queries idx 에 맞춰서 기록
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] a = {"a", "b", "aa"};
        String[] b = {"*aa", "bb*", "a*"};
        System.out.println(Arrays.toString(solution(a, b)));
    }
}
