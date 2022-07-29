import java.util.*;
/*
    이런 문제를 처름 풀어봐서 당황했습니다 ㅋㅋㅋㅋㅋ
    직접 다 쓰는데 뭐 틀린거 있나 검토한 시간이 제일 길었던 것 같네요
*/
class Solution {
    final static String[] zero = new String[]   // 지금 생각해 보니 그냥 String 배열로 만들었으면 편했을텐데...
            {"#####",
                    "#---#",
                    "#---#",
                    "#---#",
                    "#####"};
    final static String[] one = new String[]
            {"--#--",
                    "--#--",
                    "--#--",
                    "--#--",
                    "--#--"};
    final static String[] two = new String[]
            {"####",
                    "---#",
                    "####",
                    "#---",
                    "####"};
    final static String[] three = new String[]
            {"####",
                    "---#",
                    "####",
                    "---#",
                    "####"};
    final static String[] four = new String[]
            {"#---#",
                    "#---#",
                    "#####",
                    "----#",
                    "----#"};
    final static String[] five = new String[]
            {"#####",
                    "#----",
                    "#####",
                    "----#",
                    "#####"};
    final static String[] six = new String[]
            {"#####",
                    "#----",
                    "#####",
                    "#---#",
                    "#####"};
    final static String[] seven = new String[]
            {"#####",
                    "----#",
                    "----#",
                    "----#",
                    "----#"};
    final static String[] eight = new String[]
            {"#####",
                    "#---#",
                    "#####",
                    "#---#",
                    "#####"};
    final static String[] nine = new String[]
            {"#####",
                    "#---#",
                    "#####",
                    "----#",
                    "----#"};
    public String[] solution(int n) {
        String[] answer = new String[5];
        char[] nums = Integer.toString(n).toCharArray();
        for (int i = 0; i < 5; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < nums.length; j++) {
                switch (nums[j]) {      // 배열로 만들었으면 switch 안썼을텐데....
                    case '0':
                        sb.append(zero[i]);
                        break;
                    case '1':
                        sb.append(one[i]);
                        break;
                    case '2':
                        sb.append(two[i]);
                        break;
                    case '3':
                        sb.append(three[i]);
                        break;
                    case '4':
                        sb.append(four[i]);
                        break;
                    case '5':
                        sb.append(five[i]);
                        break;
                    case '6':
                        sb.append(six[i]);
                        break;
                    case '7':
                        sb.append(seven[i]);
                        break;
                    case '8':
                        sb.append(eight[i]);
                        break;
                    case '9':
                        sb.append(nine[i]);
                        break;
                }
                if (j != nums.length - 1) {
                    sb.append(" ");
                }
            }
            answer[i] = sb.toString();
        }
        return answer;
    }
}