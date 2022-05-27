import java.util.HashSet;

public class codingTest02_조영진 {
    public static int solution(String[] names) {
        int tot = 0;
        int answer = 0;
        HashSet<String> set = new HashSet<>(); // 해시셋 선언

        for(int i = 0; i < names.length; i++){
            while(set.add(names[i])){ // 해시셋은 값의 중복을 허용하지 않으므로, names를 돌면서 요소들을 추가함. 추가가 되면
                tot++; // 카운팅
            }
        }

        int totP = 1; // 순열 연산을 위한 초기값 선언
        for(int i = tot; i >= tot-3; i--){ // permutation
            totP *= i;
        }
        answer = totP / (4 * 3 * 2); // 문제에서 명확하게 4명을 뽑으라고 했으므로, 굳이 팩토리얼은 구현하지 않고 4*3*2로 하드코딩
        return answer; // 리턴!
    }
}
