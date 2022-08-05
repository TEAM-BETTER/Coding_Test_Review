/*
  처음 이 문제를 읽었을 때 이미 시간이 상당히 흫러가있었고
  2번 문제의 배신 아닌 배신으로 집중력이 흐트러져서 문제가
  뇌에 들어오지 않더라고요. 그러다가 음.. 하나 하나 다 체크를 해야하나
  했는데 시간 초과가 뜰 수도 있을 것 같다는 느낌이 강하게 들었습니다.
  그러다가 dp를 이용하기로 했는데 dp도 시간 초과가 떴지 뭔가요!
  ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ
  저는 다시 문제에게 배신을 당해버렸습니다..
  12점이었습니다..

 */

import java.util.*;
class Solution {
    public boolean solution(String s, String[] words) {
      // contains 함수를 사용하기 위해서 set에 넣습니다.
        HashSet<String> set = new HashSet<>(Arrays.asList(words));

        // 가능하면 true, 불가능하면 false를 반환하라길래 boolean 배열을
        // 이용했습니다.
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        /*
          s를 잘라내면서 해당 단어가 words에 있는지 체크하고 sub(j, i)
          dp[j]는 i번째 문자로 끝나는 각 부분 문자열에 대해
          확인해줍니다. 둘 다 true면 dp[i]도 true입니다!

         */
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
