import java.util.ArrayList;
import java.util.Arrays;

/*
*  처음에 문제를 보자마자 numbers 배열을 만들고 인덱스를 잘 조작해서 출력하면 되겠다는 생각으로 접근 했습니다.
* */
class Solution {
    public String[] solution(int n) {
        // 전광판 데이터 입니다.
        // 후에 반복문에서 위에서 아래처럼 읽습니다.
        // 그래서 5번 반복을 돌면서 10씩 더해 접근합니다.
        String[] numbers = {
                "#####", "--#--", "####", "####", "#---#", "#####", "#####", "#####", "#####", "#####", // <--
                "#---#", "--#--", "---#", "---#", "#---#", "#----", "#----", "----#", "#---#", "#---#", // <--
                "#---#", "--#--", "####", "####", "#####", "#####", "#####", "----#", "#####", "#####", // <--
                "#---#", "--#--", "#---", "---#", "----#", "----#", "#---#", "----#", "#---#", "----#", // <--
                "#####", "--#--", "####", "####", "----#", "#####", "#####", "----#", "#####", "----#" // <--
        };

        // 숫자를 큰 자리수 부터 얻어오기 위해 문자열로 변환
        String strN = n + "";
        ArrayList<String> list = new ArrayList<>();

        // 리스트에 큰 자리수 부터 넣어줍니다 ex: n = 123 -> list -> ["1", "2", "3"]
        for (char c : strN.toCharArray()) {
            list.add(c + "");
        }

        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (String elem: list) {
                int idx = elem.charAt(0)-'0'; // 리스트 값을 정수자료형으로 바꿔주기 위해 변환 했습니다.
                answer.add(numbers[idx + i * 10]); // numbers에 데이터 배치 때문에 10씩 더하면서 5번 반복해 줍니다.
            }
        }

        int step = answer.size() / 5;
        ArrayList<String> ret = new ArrayList<>();

        // 정답형식을 맞춰주기 위해서 배열을 변형시켜줍니다.
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