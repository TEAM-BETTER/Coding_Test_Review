// Trie 를 이용해서 풀어야 했지만 풀이법이 막막해서 그냥 for 문돌리면서 찾았습니다. 
// 예외케이스가 적기도 하고, 시간도 뭔가 널널 한거 같지만 효율성 1개 통과 못했습니다.
// for 2번에 startswith 메서드 까지 사용해서 o(n^2 이상이 되지않을까 싶습니다.)

public class CodingTest01_박귀우 {
    public String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        String[][] answer = new String[problems.length][];
        for (int j = 0; j < problems.length; j++) {
            List<String> result = new ArrayList<>(); // 추가가 편리하도록 result list를 따로 만들었습니다.
            for (int i = 0; i < lyrics.length; i++) {
                if (lyrics[i].startsWith(problems[j])) { // startsWith 를 이용해 가사 의 시작점을 찾고 맞다면 결과에 추가해주었습니다.
                    result.add(titles[i]);
                }
            }
            if (result.size() < 1) { // 주어진 예시에는 만약 가사시작점이 없더라도 하나는 무조건 반환하도록 되어 있어 이렇게 구분해주었습니다.
                answer[j] = new String[] {};
            } else {
                answer[j] = result.toArray(new String[0]);
            }
        }
        return answer;
    }
}