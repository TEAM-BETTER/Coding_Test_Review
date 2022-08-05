import java.util.ArrayList;
import java.util.Stack;

public class CodingTest01_윤지용 {
    public static ArrayList<String> solution(int n) {
        ArrayList<String> answer = new ArrayList<>();
        // 숫자 자체를 인덱스로 사용하기 위해서 이차원 배열을 생각해보았습니다.
        String[][] str = {
                {"#####", "#---#", "#---#", "#---#", "#####"},
                {"--#--", "--#--", "--#--", "--#--", "--#--"},
                {"####", "---#", "####", "#---", "####"},
                {"####", "---#", "####", "---#", "####"},
                {"#---#", "#---#", "#####", "----#", "----#"},
                {"#####", "#----", "#####", "----#", "#####"},
                {"#####", "#----", "#####", "#---#", "#####"},
                {"#####", "----#", "----#", "----#", "----#"},
                {"#####", "#---#", "#####", "#---#", "#####"},
                {"#####", "#---#", "#####", "----#", "----#"},
                {" ", " ", " ", " ", " "}
        };

        // 자리수 순서에 맞게 list로 변환
        Stack<Integer> stack = new Stack<>();
        while (n > 0) {
            int cur = n % 10;
            stack.push(cur);
            n = n / 10;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while (!stack.isEmpty()) {
            arr.add(stack.pop());
        }


        String answer1 = "";
        for (int i = 0; i < 5; i++) {
            answer1 = "";
            for (int j = 0; j < arr.size(); j++) {
                if (j == arr.size() - 1) {
                    answer1 += str[arr.get(j)][i];
                } else {
                    answer1 += str[arr.get(j)][i];
                    answer1 += " ";
                }
            }
            answer.add(answer1);
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(132);
    }
}
