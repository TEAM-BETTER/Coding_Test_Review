import java.util.ArrayList;

public class codingTest01_윤지용 {
    public static ArrayList<String[]> solution(String[] titles, String[] lyrics, String[] problems) {
        /*
        문제에서, 정답 출력을 맞추기 위해 고생을 많이 했습니다.
        제 로직은
        1) arr 리스트에 정답 제목을 받음
        2) tmp 스트링 배열 만들어서 arr을 옮김
        3) tmp 스트링 배열을 answer 정답 리스트에 옮김
        4) arr, cnt 초기화
        tmp 스트링배열 없이 arr을 바로 answer에 담으면 얕은 복제가 되어 arr을 클리어할때 값이 다 없어지더군요...
        혹시 이런 방법 말고 다른 좋은 방법을 아신다면 말씀해주시면 감사하겠습니다!!
         */
        ArrayList<String[]> answer = new ArrayList<>();
        ArrayList<String> arr = new ArrayList<>(); // answer에 담기 전에 for문에서 받을 리스트
        int cnt = 0; // 정답 출력에 필요한 String[] 배열 사이즈를 위한 변수

        for (int i = 0; i < problems.length; i++) {
            arr.clear(); // 배열 초기화
            cnt = 0; // 사이즈 초기화
            // 가사 배열 요소가 문제 배열 요소로 시작하면
            for (int j = 0; j < lyrics.length; j++) {
                if(lyrics[j].startsWith(problems[i])) {
                    arr.add(titles[j]); // 제목 추가
                    cnt++; // 배열사이즈 +1
                }
            }
            String[] tmp = new String[cnt]; // 정답배열에 담기 위한 변수
            for (int j = 0; j < arr.size(); j++) {
                tmp[j] = arr.get(j); //
            }
            answer.add(tmp);
        }
        return answer;
    }
}
