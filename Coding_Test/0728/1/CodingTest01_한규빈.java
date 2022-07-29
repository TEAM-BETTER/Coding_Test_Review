package CodingTest1;

import java.util.ArrayList;
import java.util.List;

/**
 * 0 ~ 9 까지의 숫자를 미리 만든 후 진행하였습니다..노가다..
 * 처음에는 굉장히 어려운 문제처럼 느껴졌는데 숫자를 미리 만들고 진행하니 쉬운 문제더군요
 */
public class CodingTest01_한규빈 {

    static List<List<String >> list;
    public static String[] solution(int n) {
        String[] answer = new String[5];
        init();

        String num = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < num.length(); j++) {
                sb.append(list.get(i).get(num.charAt(j) - '0'));
                if (j < num.length() - 1) {
                    sb.append(" ");
                }
            }

            answer[i] = sb.toString();
            sb.setLength(0);
        }

        return answer;
    }

    public static void init() {
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new ArrayList<>());
        }

        list.get(0).add("#####");
        list.get(0).add("--#--");
        list.get(0).add("####");
        list.get(0).add("####");
        list.get(0).add("#---#");
        list.get(0).add("#####");
        list.get(0).add("#####");
        list.get(0).add("#####");
        list.get(0).add("#####");
        list.get(0).add("#####");

        list.get(1).add("#---#");
        list.get(1).add("--#--");
        list.get(1).add("---#");
        list.get(1).add("---#");
        list.get(1).add("#---#");
        list.get(1).add("#----");
        list.get(1).add("#----");
        list.get(1).add("----#");
        list.get(1).add("#---#");
        list.get(1).add("#---#");

        list.get(2).add("#---#");
        list.get(2).add("--#--");
        list.get(2).add("####");
        list.get(2).add("####");
        list.get(2).add("#####");
        list.get(2).add("#####");
        list.get(2).add("#####");
        list.get(2).add("----#");
        list.get(2).add("#####");
        list.get(2).add("#####");

        list.get(3).add("#---#");
        list.get(3).add("--#--");
        list.get(3).add("#---");
        list.get(3).add("---#");
        list.get(3).add("----#");
        list.get(3).add("----#");
        list.get(3).add("#---#");
        list.get(3).add("----#");
        list.get(3).add("#---#");
        list.get(3).add("----#");

        list.get(4).add("#####");
        list.get(4).add("--#--");
        list.get(4).add("####");
        list.get(4).add("####");
        list.get(4).add("----#");
        list.get(4).add("#####");
        list.get(4).add("#####");
        list.get(4).add("----#");
        list.get(4).add("#####");
        list.get(4).add("----#");

    }

    public static void main(String[] args) {
        System.out.println(solution(132));
    }
}
