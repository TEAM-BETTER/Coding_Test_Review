import java.util.*;
/*
 * 이 친구는 문제랑 예제도 잘 기억이 안 나네요. ㅠㅠ
 * 역시 제출을 제대로 하지 못해서 정확히 모르겠지만
 * 제 생각에 이 친구는 아예 시작부터 잘못된 풀이인 것 같습니다. ㅎㅎ..
 * 사실 문제를 완벽하게 이해하지 못한 것 같기도 해요.. ㅠㅠ
 * 근데 풀어보고 싶어도 문제와 예제가 제대로 기억나지 않아서요.
 * 혹시 알고 계시는 분들 신랄하게 지적해주시면 감사하겠습니다..
 * 저는 바보입니다.. ㅠㅠㅠㅠ
 */
public class Solution {
  public static int solution(int delay, int capacity, int[] times) {
    Deque deque = new ArrayDeque();
    int answer = 0, time = 0;
    // times의 length가 들어온 편지..?의 수이니 그만큼 반복
    for (int i = 0; i < times.length; i++) {
      // 만약에 데크의 size와 해당 힙의 용량 제한이 같으면 메세지가 캔슬되니 ++
      // 그게 아니라면 times[i]를 삽입
      if (deque.size() == capacity) answer++;
      else deque.addLast(times[i]);
      // 시간은 계속 흘러가고 있기 때문에 time은 계속 더해줌
      time += times[i];
      // deque가 비어있지 않으면서 현재 흘러간 시간이 하나가 처리될 delay보다 크다면
      if (!deque.isEmpty() && time >= delay) {
        // 시간은 시간을 delay로 나눈 나머지로 새로 넣어주고
          time = time % delay;
          // deque의 먼저 들어온 요소 하나를 삭제
          deque.pollFirst();
      }
      // 근데 이제 생각해보니까 delay가 times의 요소보다 작다면..? 잉..ㅠㅠㅠㅠ
      // 토요일에 다시 차근 차근 풀어보겠습니다... ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ
      // 그래도 푸신 분들 제 생각의 어디부터가 잘못되었는가.. 글렀는가..
      // 지적을 부탁드려요..!!
      // 혹은 코드에서 뭔가 빼먹은 처리를 알려주세요!!
      // 그것도 아니면 어떻게 접근하셨는지 알려주세요!!!
    }
    return answer;
  }
}
