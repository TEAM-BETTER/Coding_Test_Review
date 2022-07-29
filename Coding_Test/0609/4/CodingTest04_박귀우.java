/**
 * 정확성 2개 밖에 통과 못한 코드입니다.
 * 서로 가까이 가기위해서 이동을 실시했습니다.
 */

public class CodingTest04_박귀우 {
    public int solution(int x1, int y1, int x2, int y2) {
        int answer = 0;
        while (true) {
            if (x1 == x2 && y1 == y2) {
                break;
            }
            // x거리,y거리중 어떤것이 제일 먼지 판별을 위해 거리 지정
            int xDistance = Math.abs(x1 - x2);
            int yDistance = Math.abs(y1 - y2);
            if (xDistance == 1 && yDistance == 1) {
                answer++;
                break;
            }
            if (yDistance > xDistance) {
                // 만약 y거리가 더 멀다면 y1,y2 중 큰쪽이 아래로 작은쪽이 위로 그에 따른 x축변화 추가
                answer++;
                if (y1 > y2) {
                    y1 -= 1;
                    y2 += 1;
                    if (x2 > x1) {
                        x2 -= 1;
                    } else {
                        x2 += 1;
                    }
                } else {
                    y1 += 1;
                    y2 -= 1;
                    if (x2 > x1) {
                        x2 -= 1;
                    } else {
                        x2 += 1;
                    }
                }
            } else {
                // x의 거리가 y보다 크다면
                answer++;
                if (x1 > x2) {
                    x1 -= 1;
                    x2 += 1;
                    if (y2 > y1) {
                        y2 -= 1;
                    } else {
                        y2 += 1;
                    }
                } else {
                    x1 += 1;
                    x2 -= 1;
                    if (y2 > y1) {
                        y2 -= 1;
                    } else {
                        y2 += 1;
                    }
                }
            }
        }
        return answer;
    }
}
