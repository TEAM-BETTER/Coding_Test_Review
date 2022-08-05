/*
  정확성 10점, 효율성 0점으로 말아먹은 친구이고요.
  ㅎㅎ... 저는 이 문제를 보고 그냥 string 상태에서
  정렬을 시키면 바로 답이 나오지 않나? 아스키 기준으로 정렬하니까.
  하는 생각을 했습니다. 왜냐면 js에서 sort 함수를 그냥 사용하면
  이 문제에 나오는 것처럼 1 10 2 20 이런 식으로 아스키 코드 기준으로
  정렬이 되니까요.. 하지만 이거슨 저의 착각이었습니다. 시간이 초과되는 것이었죠.
  지금 생각해보면 아.. 음.. 우선 순위 큐를 사용했어야 했나..?
  하는 착각일지 아닐지 모를 아이디어가 떠오르는데 (왠지 아닐 것 같슴다..)
  당시에는 어엉..? 이거 그럼 어떤 방법을 써야 효율성 통과를
  할 수 있는거지..? 하는데 시간이 째깍째각 흘러가서
  아아...음... 일단 넘어간당..! 이러고 다음 문제로 넘어갔다가
  영영 효율성 통과를 못한 친구입니다. 안타까운 일입니다..
  제일 쉽다고 생각했는데 제 착각이더라고요.
 */
import java.util.Arrays;
class Solution {
    public int[] solution(int n) {
        String[] number = new String[n];
        int[] answer = new int[n];
        number[0] = "";

        // String으로 변환하는 과정입니다.
        for (int i = 1; i <= n; i++) {
            number[i - 1] = i + "";
        }

        Arrays.sort(number);

        // 다시 int로 변환하는 과정입니다.
        for (int i = 0; i < number.length; i++) {
            answer[i] = Integer.parseInt(number[i]);
        }

        return answer;
    }
}
