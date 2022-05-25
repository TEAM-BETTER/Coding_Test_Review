import java.util.LinkedHashSet;
class Solution {
    public int solution(String dirs) {
      // 좌표 x, y 선언
        int x = 0;
        int y = 0;
        LinkedHashSet<String> move = new LinkedHashSet<String>();
        // String dirs를 char형의 배열로 변환하여 foreach문으로 순회하며 문자를 하나씩 가져옴
        for (char d : dirs.toCharArray()) {
          // 좌표 x, y의 이전값, 하단 조건문에 따라 x, y값이 변환되기 때문에 선
            int x2 = x;
            int y2 = y;
            /*
              가져온 문자가 UDRL 중 어느 것과 같은지 비교
              abs(5)를 넘어가면 범위를 벗어나기 때문에 조건을 걸고
              조건 안에 들어오는 좌표 값을 ++하거나 --;
              위로 올라가면 y좌표가 증가, 아래로 내려가면 y좌표가 감소 (UD)
              오른쪽으로 가면 x좌표가 증가, 왼쪽으로 가면 x좌표가 감소 (RL)
             */
            if (d == 'U' && y < 5) y++;
            else if (d == 'D' && y > -5) y--;
            else if (d == 'R' && x < 5) x++;
            else if (d == 'L' && x > -5) x--;
            /*
              현재 이동한 좌표 x,y와 이전에 있었던 x2,y2 좌표를
              String으로 만들고 (point, point2)
              그 둘을 이용해 point + point2와 point2 + point를 만듬.
              ex: (1, 6) -> (0, 6)과 (0, 6) -> (1, 6)은 이미 지나간 길
              =>  따라서 현재 좌표 + 이전 좌표의 값과
                  이전 좌표 + 현재 좌표의 값을 비교
             */
            String point = x + "" + y;
            String point2 = x2 + "" + y2;
            String visit = point + point2;
            String visit2= point2 + point;

            /*
              visit와 visit2가 같지 않으면 visit, visit2를 모두 삽입함
              + set을 이용했기 때문에 기본적으로 visit의 중복 값과
              visit2의 중복 값은 자동으로 패싱 처리되어 삽입되지 않음
             */
            if (!visit.equals(visit2)) {
                move.add(visit);
                move.add(visit2);
            }
        }
        /*
          조건문 내에서 한 번에 두개씩의 경로를 삽입했기 때문에
          size의 /2가 처음 지나온 길의 수가 됨
        */
        return move.size() / 2;
    }
}
