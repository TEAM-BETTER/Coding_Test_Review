public class codingTest03_조영진 {
    // 노트에다가 막 그림그려봤더니 웬걸 피보나치랑 비슷하지 뭡니까!? 그래서 재귀로 짰습니다.
    public static int solution(int N) {
        if(N < 2){
            return 1;
        }
        return solution(N-2) + solution(N-1);
    }
}
