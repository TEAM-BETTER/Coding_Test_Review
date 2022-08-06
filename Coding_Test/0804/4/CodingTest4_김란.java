/*
4. 카지노 교환원 - 12점 (효율성만 통과)

전에 정렬 파트에서 공부한대로 풀었습니다.
그런데 제가 푼 방법은 최소 개수를 구할 수 있도록 최적화 시키는 게 아니라
단순히 나눠서 몫만 cnt에 더해줬기 때문에 정확성을 통과하지 못했습니다.
다이나믹 프로그래밍에 약해서 최적화를 못 시켰네요ㅜㅜ

 */

import java.util.HashMap;

public class CodingTest4_김란 {

    int min = Integer.MAX_VALUE;
    int c = 0;

    public  static int solution(int money, int[] chips) {

        int cnt = 0;
        HashMap<Integer, Integer> result = new HashMap<>(); // <얼마 짜리 동전, 동전 개수> 이렇게 넣는다.

        for(int i = 0; i < chips.length;++i){
            if(money < chips[i]){       // 몫이 0인 경우는 패스
                continue;
            }
            int Q =  money / chips[i];  // 단순히 몫을 더해준다.
            result.put(chips[i], result.getOrDefault(chips[i], 0) + Q);
//            System.out.println(chips[i] + " " + result.get(chips[i]));
            money %= chips[i];  // 넣고 난 다음, 남은 돈 업데이트
            cnt += Q;
        }
        return cnt;
    }

    public static void main(String[] args) {

        int[] chips = {1100, 500, 200, 150, 25};
        System.out.println(solution(3000, chips));  // 5

        chips = new int[]{1400, 1200, 80, 45, 22, 10};
        System.out.println(solution(5000, chips));  // 4

    }
}
