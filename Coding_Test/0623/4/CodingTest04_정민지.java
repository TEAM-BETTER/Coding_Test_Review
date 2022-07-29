import java.util.*;
// 지팡이라고 생각해서 주석을 달았는데 지팡이가 아니었네욥..
class Solution {
    public int solution(int N, int[] branches) {
      // 데이터 정렬
      Arrays.sort(branches);
      // 최소 1부터
      int left = 1;
      // 데이터로 들어온 값 중 최대값까지
      int right = branches[branches.length - 1];
      int answer = -1;
      // left와 right가 겹치기 전까지
      while (left <= right) {
          int count = 0;
          // 현재 길이 최소와 최대의 중간 값을 구함. 이걸로 판단합니다.
          int mid = left + (right - left) / 2;
          // 각 branch를 mid로 나누어 count에 + (해당 값으로 지팡이를 만들었을 때 나오는 총 수량을 구함)
          for(int i = 0; i < branches.length; i++) {
              count += branches[i] / mid;
          }
          // 만약에 지팡이 수량이 바라고 있는 N보다 크거나 같게 만들어졌을 경우
          // answer = 해당 값을 넣어주고 만들 길이를 늘려야 하기 때문에 left = mid + 1을 해줌
          // 그게 아니라면 만들 길이를 줄여야 하기 때문에 right - 1을 해줌
          if (count >= N) {
              answer = mid;
              left = mid + 1;
          } else right = mid - 1;
      }
      // 만약에 count >= N 조건문에 한 번도 걸리지 않고 나왔을 경우
      // 만들 수 없다는 뜻이기 때문에 answer의 초기화 값인 -1이 반환
      // 그게 아니라면 정상적으로 값이 반환됨.
      return answer;
    }
}
