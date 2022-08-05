/*
  마지막 모의고사 다들 고생하셨습니당..!
  처음에 문제를 잠시 보고 음.. 어떻게 풀지 하다가
  그냥 진짜 세고 붙이고를 반복하면 되려나 하고 문제 풀이를 시작했습니다.
  근데 풀고 기본 케이스가 통과하길래 아 됐당 이러고 제출을 눌렀더니
  대부분의 케이스에서 런타임 에러가 뜨지 모에요..
  그래서 처음에 엥... 모야.. 에엥... 이러고 뇌정지 상태로 멍 때리다가
  아 설마 int의 범위를 벗어났나~~ 이러고 잠시 신이 났었거든요.
  근데 long으로 변경을 했는데 굉장히 이상한 값들이 도출되기 시작했습니다.
  그렇게 잠시 미지의 세계로 여행을 떠나버려서 한참 에러의 바다에서 힘겹게 헤엄치다
  아.. String으로 변환해서 풀건디 왜 int랑 long으로 받아서
  데이터가 이상하게 변환되게 만들었징..? 하고 String으로 변경하니
  통과했습니당..~ ㅎㅎ 이때 이미 1시간이 지나갔습니다.. ㅎㅎ 
 */
class Solution {
    public long solution(int n, int num) {
        String numStr = Integer.toString(num);
        long answer = 0;
        // n만큼 변환을 (숫자 세기) 진행하니까 for문을 돌려줍니다.
        // 세는 건 함수로 따로 뺐습니다.
        for (int i = 0; i < n; i++) {
            numStr = numCount(numStr);
        }
        // 최종적으로 반복문에서 변환이 끝난 숫자를 long으로 변환 후 10004로 나누어
        // 반환하겠습니다.
        answer = Long.parseLong(numStr) % 10004;

        return answer;
    }

// 숫자를 세어주는 함수입니다.
    public String numCount(String num) {
      // 숫자 배열 친구인데 해당 숫자가 얼마나 나왔는지에 대한 정보를 가지고 있습니다.
        int[] visit = new int[11];
        // 해당 숫자들 중 가장 작은 수와 가장 큰 수를 담아줄 예정입니다.
        // 이 친구들은 마지막 붙이기 for문을 위해 준비된 아이들이에오.
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // 이 answer 친구는 반환값을 담을 변수입니다.
        String answer = "";

        // for문을 num의 길이만큼 도는데 한 글자씩 문자를 가져와서
        // -'0'을 통해 정수로 변환시키고 이 값을 idx 값으로 사용하여
        // visit 배열의 idx번째를 ++하여 해당 숫자가 얼마나 나왔는지 체크합니다.
        // 이 과정 중에서 겸사 겸사 min, max 값을 같이 구합니다.
        for (int i = 0; i < num.length(); i++) {
            int idx = num.charAt(i) - '0';
            min = Math.min(idx, min);
            max = Math.max(idx, max);
            visit[idx]++;
        }

        // 위에서 구한 min값부터 max값까지 도는데
        // 숫자 i가 몇 번 나왔는지 visit[i]에서 가지고 있는 상태이죠.
        // 만약 0이면 나온 적이 없다는 뜻이니 넘기고
        // 있다면 answer += i + visit[i]를 해줍니다.
        for (int i = min; i <= max; i++) {
            if (visit[i] == 0) continue;
            answer += i + "" + visit[i];
        }

        return answer;
    }
}
