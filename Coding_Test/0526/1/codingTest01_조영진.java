public class codingTest01_조영진 {
    public static int solution(int n) {
        int answer = n-2; // n 미만의 수이기 때문에 n 제외, 1도 당연히 아니기 때문에 제외
        int count = 0; // 소수가 아닌 수를 카운팅할 변수 선언
        if(n <= 2){ // n이 2 이하면 어차피 소수가 존재하지 않기에 제외
            return 0;
        }
        for(int i = 2; i < n; i++){ // 분자, answer에서 1을 제외했기 때문에 2부터 시작
            for(int k = 2; k <= n / 2; k++){ // 분모, 1로는 모든 수가 나누어 떨어지니 2부터 시작, n/2를 초과하면 애초에 나누어 떨어질 수 없기에 n / 2까지 설정,
                if(i > k && i % k == 0){ // 분자가 분모보다 크고, 나누어 떨어지면 해당 수는 소수가 아니므로,
                    count++; // 카운팅
                    break;
                }
            }
        }
        answer -= count; //처음에 설정했던 answer에서 소수가 아닌 수의 갯수를 뺌

        return answer; //리턴!
    }
}
