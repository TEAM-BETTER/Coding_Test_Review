/*
  효율성에서 6점이 깍여서 총점 14점인 코드입니다. ㅠㅠ
  아마 뭔가 처리가 하나 덜 된 것 같습니다.. ㅠㅠ
 */
import java.util.*;
class Solution {
    public int[] solution(int[] start, int[] time) {
        int[] order = new int[start.length];
        int answer = 0, end = 0, idx = 0, count = 0;
        int[][] works = new int[start.length][3];
        /*
          우선 편의상 데이터들을 이차원 배열 공간에 전부 넣어줍니다.
          순서는 0번째 인덱스는 해당 작업이 들어온 시간, 1번째 인덱스는 해당 작업의 작업 시간
          2번째 인덱스는 해당 작업의 인덱스 번호입니다.
         */
        for (int i = 0; i < start.length; i++) {
            works[i][0] = start[i];
            works[i][1] = time[i];
            works[i][2] = i;
        }
        // 들어온 시간 순으로 정렬을 해줍니다.
        Arrays.sort(works, (x, y) -> x[0] - y[0]);
        // 작업 시간이 같을 경우 인덱스 순으로, 같지 않을 경우 작업 시간을 기준으
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);
        // works.length 만큼 반복
        while (count < works.length) {
          // pq에 삽입, idx가 works.length보다 작고 해당
          // works[i]의 시작 시간보다 end가 더 크거나 같은 경우에만
            while (idx < works.length && works[idx][0] <= end) {
                pq.add(works[idx++]);
            }
            if (pq.isEmpty()) {
                end = works[idx][0];
            } else {
              // 그렇지 않다면 꺼내서 order[count번째 인덱스]에 인덱스를 넣어주고
              // end에 작업 시간을 더해주고 count를 하나 증가시켜줍니다.
                int[] work = pq.poll();
                order[count] = work[2];
                end += work[1];
                count++;
            }
        }
        return order;
    }
}
