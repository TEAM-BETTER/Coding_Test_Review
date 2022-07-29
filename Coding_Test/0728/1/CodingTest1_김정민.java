import java.util.ArrayList;
import java.util.Arrays;
/*
*  문제를 보고 전광판을 배열에 잘 저장한 다음 인덱스를 잘 조작해서 결과를 만들자고 생각 했습니다.!
* */
class Solution {
    public String[] solution(int n) {
        String[] numbers = {
                "#####", "--#--", "####", "####", "#---#", "#####", "#####", "#####", "#####", "#####", // <-- 1
                "#---#", "--#--", "---#", "---#", "#---#", "#----", "#----", "----#", "#---#", "#---#", // <-- 2
                "#---#", "--#--", "####", "####", "#####", "#####", "#####", "----#", "#####", "#####", // <-- 3
                "#---#", "--#--", "#---", "---#", "----#", "----#", "#---#", "----#", "#---#", "----#", // <-- 4
                "#####", "--#--", "####", "####", "----#", "#####", "#####", "----#", "#####", "----#"  // <-- 5
        };

        String strN = n + ""; // n을 문자열로 저장해서 앞자리 부터 읽기 위함

        ArrayList<String> list = new ArrayList<>(); // ex n: 123 -> list ["1", "2" , "3"]

        for (char c : strN.toCharArray()) {
            list.add(c + "");
        }

        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (String elem: list) {
                int idx = elem.charAt(0)-'0';
                answer.add(numbers[idx + i * 10]); // numbers의 값을 위에서 아래로 읽어 answer에 저장 했습니다
            }
        }

        // 정답 형식에 맞춰서 출력!
        int step = answer.size() / 5;

        ArrayList<String> ret = new ArrayList<>();

        for (int i = 0; i < answer.size(); i += step) {
            String temp = answer.get(i);
            for (int j = i + 1; j < i + step; j++) {
                temp = temp + " " + answer.get(j);
            }
            ret.add(temp);
        }

        return ret.toArray(new String[0]);
    }
}