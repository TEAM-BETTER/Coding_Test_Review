public class Solution {
    public static int solution(int n, int i, int j) {
        int answer = 0;
        int[][] table = new int[n][n];                        // 숫자를 넣을 이차원 테이블 입니다.

        makeT(table, n, 0, n - 1, 1, i, j);    // 테이블에 숫자를 채울 함수입니다.
        answer = table[i][j];                                 // 목표인 좌표 i,j 의 숫자를 찾습니다.

        for (int k = 0; k < n; k++) {                         // 테이블 확인 할수 있는 for 문입니다. 정답과 상관 없습니다.
            for (int l = 0; l < n; l++) {                     // 하지만 효율성 테스트를 확인 해 볼 수 있습니다.
                System.out.printf("%02d ", table[k][l]);       // 22 번째 if 문을 주석처리하고 돌리면 모든 테이블이 채워지지만
            }                                                 // 저 22번째 if 문을 넣음으로써 i,j 가 속한 가장 작은 테이블만 채워집니다.
            System.out.println();                             // 시험 때는 이걸 생각못해서 효율성 테스트를 모두 통과하지 못했습니다.
        }

        return answer;
    }

    // 테이블을 4개씩 쪼개면서 재귀로 돌아가는 함수입니다.
    // 우측 상단을 첫번째, 죄측 상단을 두번쨰, 좌측 하단을 세번째, 우측 하단을 4번째 로 들어갑니다.

    // 함수의 매개변수는
    // 숫자를 기록할 테이블 = table
    // 현재 재귀하는 함수의 사각형 가로세로길이 = n
    // 현재 재귀함수의 숫자가 시작할 사각형 가장 우측 상단 좌표 = x, y
    // x, y 좌표에 들어갈 숫자 nextStart
    // 구하고자 하는 테이블 좌표 = i, j
    public static int makeT(int[][] table, int n, int x, int y, int nextStart, int i, int j) {
        if (x > i || x + n <= i || y < j || y - n >= j) {       // 효율성 테스트를 위한 필요한 테이블만 채우는 방법
            return n * n + nextStart;
        }


        if (n == 2) {                                           // 가장 작은 테이블 단위인 가로세로가 2칸까지 재귀귀 함수가 들어가면
            table[x][y] = nextStart;                            // 우측 상단 숫자 넣기
            table[x][y - 1] = nextStart + 1;                    // 좌측 상단 숫자 넣기
            table[x + 1][y - 1] = nextStart + 2;                // 좌측 하단 숫자 넣기
            table[x + 1][y] = nextStart + 3;                    // 우측 하단 숫자 넣기

            return nextStart + 4;                               // 효율성을 위한 22번째 if 문을 넣고 필요가 없어진 return 값이지만
        }                                                       // 22번 쨰 if 문을 지웠을 시 모든 table 을 기록하기 위해 그냥 둡니다.

        // 가장 작은 n = 2가 아닌 사격형일때 다시 작은 사각형으로 쪼개면서 재귀함수가 들어갑니다.
        // 작은 사각형으로 들어가면서 매개변수인 n 이 길이가 반이 됨으로 나누어주고
        // 그에따른 x, y 좌표를 수정해줍니다. 그리고 다음 nextStart 값이 바뀌므로
        // 매 재귀가 끝날때 마다 함수의 return 값을 nextStart 에 받아줍니다.
        nextStart = makeT(table, n / 2, x, y, nextStart, i, j);                        // 우측 상단
        nextStart = makeT(table, n / 2, x, y - n / 2, nextStart, i, j);             // 좌측 상단
        nextStart = makeT(table, n / 2, x + n / 2, y - n / 2, nextStart, i, j);  // 좌측 하단
        nextStart = makeT(table, n / 2, x + n / 2, y, nextStart, i, j);             // 우측 하단

        return nextStart;
    }
    //        모든 숫자를 출력해 보시려면 22번째 if 문을 주석처리하고 돌리면 나옵니다
//        아니면 타겟으로한 ij가 있는 가장 작은 사각형에 숫자만 나오고 다른 곳은 다 00 으로 출력됩니다
}
