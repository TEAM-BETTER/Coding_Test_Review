
/** 프로그래머스 4번 문제 */
// 위 아래 좌 우 에 따른 방향 이동과 거리를 구하는 문제 입니다.
/**
 * 헤쉬 셋을 이용해 중복된 내용을 처리하는것을 기본으로 잡고 시작했습니다.
 * 시도해본것
 *  1. 각 좌표별로 기록을 남겨서 헤쉬셋에 추가
 *  => 에러 (0,1) => (0.2), (1,1)=>(0,1) 은 다른 케이스인데 같은 케이스로 취급해서 카운팅이 안됨
 *  2. 각 좌표가 아닌 이동 시작점 과 이동 끝점을 모두 기록해서 헤쉬셋에 추가
 *  => (0,1) => (1,0) , (1,0) => (0,1) 모두 카운트해 에러가 발생 
 *  => 이 에러에서 아이디어를 도출 이동 을 등록할때, 시작점 끝점 , 끝점 시작점 모두 등록해서 /2 나누자.
 */
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int solution(String dirs) {
        HashSet<String> result = new HashSet<String>();
        // 이동 좌표들을 담을 셋
        // - [][] 이중 배열을 안한이유, 처리하기 번거로워서 그냥 이중배열을 스트링으로 변환 시켜서 등록.
        int[] current = { 0, 0 }; // 현재 시작점 은 0,0 을 선언해줌
        int idx = 0; // 현재 인덱스 즉 받아올 방향 들에 대한 카운트수
        char[] dir = dirs.toCharArray();
        while (idx < dir.length) { // 받아온 모든 방향을 소진한다면 반복문 종료
            int[][] moved = new int[2][2]; // [시작점][이동점]
            moved[0][0] = current[0];
            moved[0][1] = current[1]; // 시작점 등록
            switch (dir[idx]) { // 이동에 따른 좌표 연산
                case 'U':
                    current[1] = Math.min(5, current[1] + 1);
                    break;
                case 'L':
                    current[0] = Math.max(-5, current[0] - 1);
                    break;
                case 'R':
                    current[0] = Math.min(5, current[0] + 1);
                    break;
                default:
                    current[1] = Math.max(-5, current[1] - 1);
            }
            moved[1][0] = current[0];
            moved[1][1] = current[1]; // 이동점 등록

            if (moved[0][0] == moved[1][0] && moved[0][1] == moved[1][1]) {
                idx++; // 단 시작점 과 이동점이 5를 초과하는경우 똑같음 그경우를 예외처리 해주기 위해 추가.
                continue;
            }
            // 위에서 언급한 시작점,이동점 이동점,시작점 모두 문자 형태로 바꿔 등록;
            result.add(Arrays.toString(moved[0]) + Arrays.toString(moved[1]));
            result.add(Arrays.toString(moved[1]) + Arrays.toString(moved[0]));
            idx++;
        }
        return result.size() / 2; // 이동점 시작점,시작점 이동점 모두 등록되어있으니 /2
    }
}