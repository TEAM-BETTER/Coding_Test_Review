package CodingTest7;

/**
 * 1. 먼저 길이가 1 즉 한자리뿐이라면 그 값을 그대로 리턴
 * 2. 구간 내 숫자가 동일하다면 그 값 리턴
 *      아니라면 동일한 크기로 4등분 나누어 1번부터 다시 진행
 *      나누었을 경우 (1사분면, 2사분면, 3사분면, 4사분면)과 같이 출력하기 위해 앞 뒤 괄호 붙여줌
 * 3. 2번 재귀로 반복하면서 결과값 출력
 */
public class CodingTest1_김우진 {

    public static String quadTree(int y, int x, int len, int[][] img) {
        // 길이가 1인 정사각형이면 해당 숫자 반환 (String 타입으로)
        if (len == 1) {
            return String.valueOf(img[y][x]);
        }

        int val = img[y][x];
        boolean allSame = true;

        /**
         * 해당 구간이 전부 같은 숫자인지 확인
         */
        for (int i = y; i < y + len; i++) {
            for (int j = x; j < x + len; j++) {
                if (img[i][j] != val) {
                    allSame = false;
                    break;
                }
            }
            if (allSame == false) {
                break;
            }
        }

        // 같은 숫자이면 해당 숫자 반환
        if (allSame) {
            return String.valueOf(val);
        }

        /**
         * 서로 다른 숫자이면 동일한 크기로 4등분
         * 순서대로 (좌상단 + 우상단 + 좌하단 + 우하단) 출력
         * StringBuilder를 통해 성능 최적화
         */

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(quadTree(y, x, len / 2, img));
        stringBuilder.append(quadTree(y, x + len / 2, len / 2, img));
        stringBuilder.append(quadTree(y + len / 2, x, len / 2, img));
        stringBuilder.append(quadTree(y + len / 2, x + len / 2, len / 2, img));
        stringBuilder.append(")");

        return stringBuilder.toString();
    }


    public static String solution(int[][] img) {
        return quadTree(0, 0, img.length, img);
    }

    public static void main(String[] args) {
        int[][] img = { {0, 0, 0, 0, 1, 1, 1, 1}
                , {0, 0, 0, 0, 1, 1, 1, 1}
                , {0, 0, 0, 0, 1, 1, 1, 1}
                , {0, 0, 0, 0, 1, 1, 1, 1}
                , {1, 1, 1, 1, 0, 0, 1, 1}
                , {1, 1, 1, 1, 0, 0, 1, 1}
                , {1, 1, 1, 1, 1, 1, 0, 0}
                , {1, 1, 1, 1, 1, 1, 0, 0}
        };
        System.out.println(solution(img));
    }
}
