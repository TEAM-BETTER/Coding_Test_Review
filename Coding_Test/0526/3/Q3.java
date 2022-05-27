class Q3 {
    public int solution(int N) {
        int answer = 0;
        int [] a1 = new int[100];
        a1[1] = 1;
        a1[2] = 2; // 첫번째, 두번째 값은 정해져있습니다.
        for (int i = 3; i <= N; i++) {
            a1[i] = a1[i-1]+a1[i-2]; // 점화식으로 변경해 풀었습니다.
        }
        answer = a1[N];
        return answer;
    }
}