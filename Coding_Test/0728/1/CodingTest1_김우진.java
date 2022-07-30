package CodingTest10;

import java.util.ArrayList;

/**
 * 1. 문제에서 주어졌던 #과 -로 이루어진 이차원 배열 numbers 에 넣는다.
 *      -> numbers[0][i]는 0번 기호, numbers[1][i]는 1번 기호, ...
 * 2. 반복문을 통해 answer[i]에 빈 String 을 넣어준다.
 *      -> 5번 반복의 이유는 한 숫자당 다섯 줄로 이루어져 있기 때문
 * 3. 주어진 n을 숫자를 모듈러 연산을 통해 각 list에 하나씩 넣어준다.
 *      -> 주어진 n을 한 자리 숫자씩 끊어서 list에 넣어준다.
 * 4. 이중 포문을 사용해서 list.size만큼 한 글자마다 numbers에
 *      해당하는 문자열을 찾아 answer 배열에 차례로 문자열을 더해준다.
 *      문자열을 더해줄 때 마다 " "을 넣어주어 구분을 둔다.
 *      단 맨 마지막 list의 맨 마지막 숫자에는 빈칸을 넣지 않는다.
 *
 ***** 추가사항: n이 0만 있는 경우 빈칸으로 출력되는 것을 확인하여
 *          n == 0 의 경우 출력해주도록 따로 만들었습니다.
 */

public class CodingTest1_김우진 {
    public static String[][] numbers = {
            {"#####", "#---#", "#---#", "#---#", "#####"},
            {"--#--", "--#--", "--#--", "--#--", "--#--"},
            {"####", "---#", "####", "#---", "####"},
            {"####", "---#", "####", "---#", "####"},
            {"#---#", "#---#", "#####", "----#", "----#"},
            {"#####", "#----", "#####", "----#", "#####"},
            {"#####", "#----", "#####", "#---#", "#####"},
            {"#####", "----#", "----#", "----#", "----#"},
            {"#####", "#---#", "#####", "#---#", "#####"},
            {"#####", "#---#", "#####", "----#", "----#"}
    };

    public static String[] solution(int n) {
        String[] answer = new String[5];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            answer[i] = "";
        }

        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }

        if(n == 0) {
            for (int i = 0; i < 5; i++) {
                answer[i] += numbers[0][i];
            }
            return answer;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = 0; j < 5; j++) {
                answer[j] += numbers[list.get(i)][j];

                if (i != 0) {
                    answer[j] += " ";
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] answer = solution(0);

        for (String a : answer) {
            System.out.println(a);
        }
    }
}
