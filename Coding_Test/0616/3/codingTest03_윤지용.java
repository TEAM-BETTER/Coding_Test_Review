import java.util.ArrayList;

public class codingTest03_윤지용 {
    public static ArrayList<String[]> solution(String[] words, String[] queries) {
        ArrayList<String[]> answer = new ArrayList<>();
        int cnt = 0;
        int[] qleng = new int[queries.length]; // 각 문자 길이를 담은 배열

        for (int i = 0; i < queries.length; i++) {
            qleng[i] = queries[i].length(); // 길이 담고
            queries[i] = queries[i].replaceAll("\\?", ""); // 물음표 없애기
        }
        // 여기도 1번문제와 마찬가지로, 정답 형태를 맞추기 위해 중간에 string배열을 사용했습니다.
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            arr.clear();
            cnt = 0;
            for (int j = 0; j < words.length; j++) {
                // 만약 단어의 1) 길이가 같고 2) 물음표를 제거한 문자로 시작하면
                if(words[j].length()==qleng[i] && words[j].startsWith(queries[i])) {
                    arr.add(words[j]);
                    cnt++;
                }
            }
            String[] tmp = new String[cnt];
            for (int j = 0; j < arr.size(); j++) {
                tmp[j] = arr.get(j);
            }
            answer.add(tmp);
        }
        return answer;
    }
}
