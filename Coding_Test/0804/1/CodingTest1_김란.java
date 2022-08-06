
/*

1. n번 숫자 세고 말하기 - 20점
처음에 맞게 풀었다 생각했는데 테스트케이스만 통과하고 0점이라서 포기할 뻔 했습니다 ㅎㅎ
테스트로 가능한 큰 숫자들 넣어보니까 반환값이 int 범위 넘을 수 있다는 걸
알고 long으로 바꾸니까 바로 통과되네요!
change(str)을 str에 저장하는 while문을 n번 돌려서 풀었습니다.

 */

import java.util.HashMap;
import java.util.Map;
public class CodingTest1_김란 {
    public static int solution(int n, int num) {
        String str =  String.valueOf(num);
        while(n > 0){
            str = change(str);  // n번 반복한다.
            System.out.println(str);
            --n;
        }

        long res = Long.parseLong(str);
        return (int) (res % 10004);
    }

    public static String change(String s){
        // 숫자를 문자열로 받아서 map에 각 데이터의 개수를 카운트해서 넣는다.

        Map<Integer, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            int n = Integer.parseInt(c + "");
            map.put(n, map.getOrDefault(n , 0) + 1);    // 각 숫자를 카운트
        }
        String ans = "";
        for(int key : map.keySet()){
            ans += String.valueOf(key);             // key
            ans += String.valueOf(map.get(key));    // value
        }
        return  ans;
    }

    public static void main(String[] args) {

        System.out.println(solution(3, 54223));   // 5451
        System.out.println(solution(3, 100240));
        System.out.println(solution(3, 987653));
    }
}
