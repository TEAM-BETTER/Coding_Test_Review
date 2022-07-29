/*

20점
코드 짜면서 이런 방식으로 하는게 맞나 의심하면서 만들었네요.ㅋㅋ
거의 다 풀었을 쯤에는 각 행마다 맨 앞에 null이 같이 출력되서 너무나도 당황스러웠습니다.
그래도 결국 해결되서 다행이네요.
star()라는 메서드를 이용해서 0 ~ 9까지 숫자를 key로 String[]을 값으로 가지는 Map를 만들었습니다.
map만들고 answer[]를 구현하고 나니까 금방 풀렸습니다!

 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Test1 {
    static Map<Integer, String[]> map = new HashMap<>();    // 0 ~ 9 까지 맵을 만든다.
    public static String[] solution(int n) {
        String[] answer = new String[5];

        // map 만들기
        for(int i = 0; i < 10; ++i){
            star(i);
        }

        // n을 한 글자씩 읽어서 바꾸고 이어 붙이고 옆에를 이어 나간다.
        String str = String.valueOf(n);

        for(int i = 0; i < 5; ++i){
            for(int j = 0; j < str.length(); ++j){
                int num = Integer.parseInt(str.charAt(j) + ""); // 한 글자를 읽어서
//                if(map.get(num)[i] == null){
//                    continue;
//                }
                answer[i] += map.get(num)[i];       // 숫자 하나씩 String을 이어나간다.
                if(j == str.length() - 1){          // 마지막은 띄어쓰기 생략
                    continue;
                }
                answer[i] += " ";
            }
        }
        for(int i = 0; i < 5; ++i){      // null이 출력되지 않도록 추가한 부분
            answer[i] = answer[i].substring(4, answer[i].length());
        }
        return answer;
    }
    public static void star(int n){ // 한 자릿수 n에 대해 전광판 만드는 메서드

        // 5 * 5  뛰어쓰기 열은 59개 ? 띄어쓰기 까지?

        // # 5개
        String allStar5 = "#####";
        String allStar4 = "####";

        // # 1개
        String oneRightStar = "---#";   // 4칸
        String oneLeftStar4 = "#---";    // 4칸
        String oneMiddleStar = "--#--";
        String oneLeftStar5 = "#----";
        String oneRightStar5 = "----#";

        // # 2개
        String twoStar5 = "#---#";

        if(n == 0){
            String[] str = { allStar5, twoStar5, twoStar5, twoStar5, allStar5  };
            map.put(n, str);
        }
        if(n == 1){
            String[] str = {oneMiddleStar, oneMiddleStar, oneMiddleStar, oneMiddleStar, oneMiddleStar };
            map.put(n, str);
        }
        // 네 칸
        if(n == 2){
            String[] str = { allStar4, oneRightStar , allStar4,  oneLeftStar4, allStar4 };
            map.put(n, str);
        }
        if(n == 3){
            String[] str = {allStar4,  oneRightStar ,   allStar4,  oneRightStar , allStar4 };
            map.put(n, str);
        }
        if(n == 4){
            String[] str = { twoStar5, twoStar5, allStar5, oneRightStar5, oneRightStar5};
            map.put(n, str);
        }
        if(n == 5){
            String[] str = { allStar5, oneLeftStar5, allStar5, oneRightStar5, allStar5};
            map.put(n, str);
        }
        if(n == 6){
            String[] str = { allStar5, oneLeftStar5, allStar5, twoStar5,  allStar5};
            map.put(n, str);
        }
        if(n == 7){
            String[] str = {allStar5, oneRightStar5, oneRightStar5, oneRightStar5, oneRightStar5  };
            map.put(n, str);
        }

        if(n == 8){
            String[] str = { allStar5,  twoStar5 , allStar5,  twoStar5,  allStar5  };
            map.put(n, str);
        }

        if(n == 9){
            String[] str = { allStar5, twoStar5, allStar5, oneRightStar5, oneRightStar5  };
            map.put(n, str);
        }
    }

    public static void main(String[] args) {

        for( String s: solution(132)){
            System.out.println(s);
        }
        for( String s: solution(1234567890)){
            System.out.println(s);
        }
        for( String s: solution(1)){
            System.out.println(s);
        }
    }
}
