/*
  문제를 보고 음.. 각 숫자와 매치되는 모양이 있으니까 그대로 배열에 담아서
  그냥 바로 사용해주면 되겠구나 했습니다.
 */
class Solution {
    public String[] solution(int n) {
        // 순서대로 0 ~ 9의 형상이 담긴 2차원 String 배열입니다.
        String[][] numbers = {
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
        String number = Integer.toString(n);
        String[] answer = new String[5];

        // 전광판은 5줄로 이루어진다고 했으니 5만큼 반복합니다.
        for (int i = 0; i < 5; i++) {
            // 정답 문자열이 담길 String 변수
            String encode = "";
            // j는 입력받은 숫자의 길이만큼 반복합니다. (ex: 123이면 3만큼)
            for (int j = 0; j < number.length(); j++) {
                // 입력받은 숫자 문자열의 j번째 문자를 가져와서 int형으로 변환합니다.
                int target = (number.charAt(j) - 48);
                if (j != 0) encode += " ";
                // target번째 배열의 i번째 문자열을 데려와서 더합니다.
                encode += numbers[target][i];
            }
            // 위에서 만든 문자열을 배열에 할당합니다.
            answer[i] = encode;
        }
        return answer;
    }
}
