public class CodingTest04_윤지용 {
    public static int solution(int x11, int y11, int x22, int y22) {
        // 해당 코드는 매 초마다 계산을 해야해서 매우 느립니다...
        // 중간중간 while문을 쓰면 시간을 좀 더 단축시킬 수 있을 것 같습니다만, 코테 후 개선은 하지 않았습니다.
        // 그리고 이 코드는 정확성 8/10, 효율성 8/10이 나온 코드입니다...
        // 어디서 결과가 도출이 안되는지 잘 모르겠습니다..

        // 최단시간이기 때문에 서로에게 가까워지도록 움직여야 한다는 생각으로 접근해보았습니다.
        int answer = 0; // 시간 재는 변수로도 사용

        int x1 = x11;
        int y1 = y11;
        int x2 = x22;
        int y2 = y22;

        // 철수와 영희의 X좌표, Y좌표의 거리
        int absX = Math.abs(x11-x22);
        int absY = Math.abs(y11-y22);

        while(!(absY == 0) || !(absX == 0)) {
            // 매 초마다 거리재기
            absX = Math.abs(x1-x2);
            absY = Math.abs(y1-y2);
            // 종료조건
            // 거리차이가 1이거나(인접), 3일때(철수 1칸, 영희 1칸 이동으로 만날 수 있음) 그 다음턴에 만남
            if(absX+absY==1 || absX+absY==3) {
                if(absX==3 || absY==3) { continue; } // 단, x나 y쪽으로만 3칸 차이면 둘이 한번씩 움직여도 못만남.
                else { return ++answer; }
            }
            // 종료조건이 아니면 철수영희 이동
            // 왼쪽에 있는 사람은 오른쪽으로, 오른쪽에 있는 사람은 왼쪽으로
            // 위쪽에 있는 사람은 아래쪽으로, 아래쪽에 있는 사람은 위쪽으로
            if(y1>=y2) {
                if(x1>=x2) {
                    // if - else 에는 철수만. 세로로 이동할건지, 가로로 이동할건지 선택해야 함
                    if(absY>=absX) { y1--; }
                    else { x1--; }
                    // 영희는 x,y를 한번에 다 움직일 수 있기 때문에
                    y2++; x2++;
                } else {
                    if(absY>=absX) { y1--; }
                    else { x1++; }
                    y2++; x2--;
                }
            } else {
                if(x1>=x2) {
                    if(absY>=absX) { y1++; }
                    else { x1--; }
                    y2--; x2++;
                } else {
                    if(absY>=absX) { y1++; }
                    else { x1++; }
                    y2--; x2--;
                }
            }
            answer++;
        }
        return answer;
    }
}
