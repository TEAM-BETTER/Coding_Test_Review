import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static int[][] solution(int[][] buildings) {
        int[][] answer;

        int[] map = new int[10001];             // buildings 를 기록할 배열 (idx 는 위치 배열의 값은 height)
        int maxRight = 0;                       // 10001 까지 모두 탐색하면 효율성 떨어지니까 가장 오른쪽 배열을 기록하기 위한 변수

        for (int[] building : buildings) {      // buildings 를 기록하는 for 문 또한 maxRight 구함
            int left = building[0];
            int right = building[1];
            int height = building[2];
            maxRight = Math.max(right, maxRight);
            for (int j = left; j <= right; j++) {   // 실루엣만 기록하므로 기록된 값보다 높은 값일 때만 저장
                map[j] = Math.max(map[j], height);

            }
        }

        for (int i = 0; i <= maxRight; i++) {         // 실루엣 세로로 돌려서 출력 해보는 코드, map 에 잘 입력 되었는 지 확인 용도
            StringBuilder hh = new StringBuilder();
            for (int j = 0; j < map[i]; j++) {
                hh.append("=");
            }
            System.out.println(i + " " + hh + " ");
        }


        ArrayList<int[]> a = new ArrayList<>();         // 정답 기록할 배열
        int preh = 0;                                   // 이전 높이 기록
        for (int i = 0; i <= maxRight; i++) {           // maxRight 까지 돌면서 height 가 변하는 지점 기록
                                                        // height 가 높아질 때, 낮아질 때 나누어서 구현 // 변화된 그 지점의 idx 를 얻기 위함
            if (preh < map[i]) {                        // height 가 높아질 때는 올라간 꼭대기 지점이므로 다른 계산 없이 바로 저장
                a.add(new int[]{i, map[i]});
                preh = map[i];                          // 이전 높이를 변경해줌
            } else if (preh > map[i]) {                 // height 가 낮아질 때는 바로 그 지점을 보면 낮아 진 뒤 idx + 1 지점에서 기록됨
                a.add(new int[]{i - 1, map[i]});        // 그래서 기록된 부분의 idx 를 -1 해서 기록
                preh = map[i];
            }
        }

        a.add(new int[]{maxRight, 0});                  // 맨 마지막 부분은 height 가 0 으로 떨어짐으로 따로 더해줌
                                                        // maxRight + 1 까지 돌면 기록되지만 maxRight 10000 이 되면
                                                        // map 의 ArrayOutOfIndexException 발생, 그래서 따로 더해줌
        answer = new int[a.size()][];
        for (int i = 0; i < a.size(); i++) {            // return 할 배열에 넣어줌
            answer[i] = a.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] a = {{1, 8, 4}, {2, 4, 10}, {3, 5, 6}, {10, 12, 6}};
        System.out.println(Arrays.deepToString(solution(a)));
    }
}