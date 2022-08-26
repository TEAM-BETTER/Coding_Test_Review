package codiingTest.codingTest13.p5;


import java.util.Arrays;

// 구현하다가 욕나온 문제
// 이거 하다가 2번문제를 못풀었네요...
// 이 문제도 시간이 부족해서 완벽하게 점수를 받지는 못하였습니다.
public class Solution {
    // 테트리스의 블록별 기본형과 변형 형태는 코드로 주어집니다.
    static int[][][][] TETRIS_BLOCK = new int[8][][][];

    static {
        int[][][] BLOCK;
        BLOCK = new int[][][]{
                {
                        {0, 0, 0, 0},
                        {0, 1, 1, 1},
                        {0, 0, 0, 1}
                },
                {
                        {0, 0, 1},
                        {0, 0, 1},
                        {0, 1, 1}
                },
                {
                        {0, 0, 0, 0},
                        {0, 1, 0, 0},
                        {0, 1, 1, 1}
                },
                {
                        {0, 1, 1},
                        {0, 1, 0},
                        {0, 1, 0}
                }
        };
        TETRIS_BLOCK[1] = BLOCK;

        BLOCK = new int[][][]{
                {
                        {0, 0, 0, 0},
                        {0, 1, 1, 1},
                        {0, 1, 0, 0}
                },
                {
                        {0, 1, 1},
                        {0, 0, 1},
                        {0, 0, 1}
                },
                {
                        {0, 0, 0, 0},
                        {0, 0, 0, 1},
                        {0, 1, 1, 1}
                },
                {
                        {0, 1, 0},
                        {0, 1, 0},
                        {0, 1, 1}
                }
        };
        TETRIS_BLOCK[2] = BLOCK;

        BLOCK = new int[][][]{
                {
                        {0, 0, 1, 0},
                        {0, 1, 1, 1}
                },
                {
                        {0, 0, 1, 0},
                        {0, 0, 1, 1},
                        {0, 0, 1, 0}
                },
                {
                        {0, 0, 0, 0},
                        {0, 1, 1, 1},
                        {0, 0, 1, 0}
                },
                {
                        {0, 0, 1},
                        {0, 1, 1},
                        {0, 0, 1}
                }
        };
        TETRIS_BLOCK[3] = BLOCK;

        BLOCK = new int[][][]{
                {
                        {0, 0, 1},
                        {0, 1, 1},
                        {0, 1, 0}
                },
                {
                        {0, 0, 0},
                        {1, 1, 0},
                        {0, 1, 1}
                }
        };
        TETRIS_BLOCK[4] = BLOCK;

        BLOCK = new int[][][]{
                {
                        {0, 1, 0},
                        {0, 1, 1},
                        {0, 0, 1}
                },
                {
                        {0, 0, 0},
                        {0, 1, 1},
                        {1, 1, 0}
                }
        };
        TETRIS_BLOCK[5] = BLOCK;

        BLOCK = new int[][][]{
                {
                        {0, 0, 1},
                        {0, 0, 1},
                        {0, 0, 1},
                        {0, 0, 1}
                },
                {
                        {0, 0, 0, 0},
                        {1, 1, 1, 1}
                }
        };
        TETRIS_BLOCK[6] = BLOCK;

        BLOCK = new int[][][]{
                {
                        {0, 1, 1},
                        {0, 1, 1}
                }
        };
        TETRIS_BLOCK[7] = BLOCK;
    }

    // 스테틱 변수를 많이 사용하였습니다. 함수에 매개변수를 넘겨주는 메모리 값을 줄이기 위함????
    // 메모리 값을 줄여주는지 잘 모르겠네요
    public static int[][] map;
    public static int[][] block;
    public static int x;
    public static int y;
    public static int answer;

    public static int solution(int[] blocks, String commands) {
        answer = 0;
        map = new int[18][14];          // 테트리스 맵 -> 세로 15, 가로 10 -> 블럭 모양의 양쪽과 아래쪽 공백값을 위해 세로 3칸, 좌우 2칸씩 추가
        // 아래로 3칸 추가인 이유는 블럭모양이 아래에서 최대 3칸까지 공백인 부분이 있기 때문
        // 좌우로 2칸씩 추가인 이유는 블럭모양이 좌우로 초대 두칸씩 공백인 부분이 있어서
        int shapeNum = 0;               // 블럭의 모양이 변하는 값을 알려주는 변수 ex) TETRIS_BLOCK[1] 은 4가지 모양이 있으므로 0 ~ 3 까지 숫자로 구분
        int blockNum = 0;               // 현재 blocks 의 몇번째 index 가 움직이고 있는지 확인할 변수
        x = 0;                          // 처음 블럭이 내려오기 시작하는 좌표값
        y = 2;

        for (int i = 0; i < commands.length(); i++) { // 커멘드를 하나씩 보기 위함 for 문
            char c = commands.charAt(i);

            switch (c) {                              // 커맨드 u, d, l, r 별로 구현

                case 'u':           // u 커멘드
                    shapeNum++;     // 블럭 모양 변경
                    shapeNum %= TETRIS_BLOCK[blocks[blockNum]].length; // u 커멘드가 많이 눌려졌을 경우를 방지하기 위함
                    // ex) TETRIS_BLOCK[1] 의 모양은 4가지 이므로 index 값이 0~3 이다. 그러무로 shapeNum 의 값은 0~3 범위로 넘어간다면
                    // 그 값을 TETRIS_BLOCK[1]의 length 인 4 로 나눈 나머지 값으로 arrayOutOfBoundsException 을 방지
                    break;

                case 'l':           // l 커멘드
                    y--;            // 좌우 좌표값을 좌로 옮기기 위해 --
                    if (y < 0) {    // 왼쪽의 벽을 만났을 떄 더이상 감소하지 않기 위함
                        y = 0;
                    }
                    break;
                case 'r':           // r 커맨드
                    y++;            // 좌우 좌표값을 좌로 옮기기 위해 ++
                    if (y > 9) {    // 왼쪽의 벽을 만났을 떄 더이상 증가하지 않기 위함
                        y = 9;
                    }
                    break;

                case 'd':           // d 커멘드 작동 방식
                    block = TETRIS_BLOCK[blocks[blockNum]][shapeNum]; // 현재 블럭의 모양
                    // blocks[blockNum] = 현재 블럭의 모양을 나타냄 -> TETRIS_BLOCK[?] 선택
                    // shapeNum 은 위에서 선택된 블럭의 모양이 어떻게 변경 되었는지 결정 TETRIS_BLOCK[][?] 선택

                    // 블럭을 내리기 전 겹치는 블럭이 있는지 확인
                    if (failCheck()) {          // 실패 체크 현재 블럭의 모양과 겹치는 부분에 블럭이 있다면 게임 오버
                        return answer;          // 현재 점수 반환
                    }

                    // 블럭을 내릴때 어디까지 내려야 하는지 확인
                    while (!failCheck()) {      // 이제 블럭과 map 의 1 이 만날때까지 한칸씩 내리면서 확인
                        x++;                    // 실패하지 않았다면 계속 세로값을 내리면서 확인
                    }
                    x--;                        // 실패한다면 그 위쪽까지가 내려올 수 있는 최대 범위이므로 세로 좌표값 하나 이전으로 돌림

                    addMapToBlock();            // 현재 좌표값에 block 의 1을 map 의 1에 더해줌
                    mapPrint();                 // 문제 풀이중 잘 되고 있는지 확인하기 위해 map 을 출력하는 함수

                    // 꽉찬 라인이 있어 제거하고 점수를 올릴지 확인
                    for (int j = 14; j >= 0; j--) {     // 맨 아래 가로라인부터 확인 하여 최적화 적용
                        int zeroCount = 0;              // 현재 가로 라인에 비어있곳 (0 인 부분) 이 몇개인지 확인

                        for (int k = 2; k < 12; k++) {  // 가로범위 2 ~ 11 까지 확인
                            if (map[j][k] == 0) {       // 0 인 부분을 카운트
                                zeroCount++;
                            }
                        }

                        if (zeroCount == 0) {           // 0 인 부분이 하나도 없다면 꽉찬 라인
                            removeFullLineAndAddPoint(j);   // 꽉찬 라인 지우고 점수 더하고 없어진 줄 위쪽을 아래로 내림
                        }

                        if (zeroCount == 10) {          // 모두 0이라면 그 위는 없으므로 for 문 탈출 (최적화)
                            break;
                        }
                    }

                    // 모든 d 코멘드 끝나고 다음 커맨드를 위한 값 셋팅
                    blockNum++;                     // blocks 의 다음 index 를 보기 위한++
                    shapeNum = 0;                   // block 의 초기 모양 0 를 위해 0으로 초기화
                    x = 0;                          // 블럭이 처음 나오는 좌측 상단을 위한 좌표값 (0,2) 초기화
                    y = 2;
                    break;
            }
        }

        return answer;                              // 게임 오버 되지 않고 모든 커맨드를 수행 하였을 때 점수 출력
    }

    private static void mapPrint() {
        for (int i = 0; i < 15; i++) {
            for (int k = 0; k < map[0].length; k++) {
                if (k <= 1 || k > 11) {
                    System.out.print(" == ");
                } else {
                    System.out.print(map[i][k]);
                }
            }
            System.out.println();
        }
        System.out.println("==================================================================");
        System.out.println(answer);
        System.out.println();
        System.out.println();
    }

    public static void removeFullLineAndAddPoint(int j) {       // 현재 가로 라인 j 값 매개변수로 받음
        for (int k = j; k > 0; k--) {                           // j 값 부터 1 까지 for 문으로 돌림
            map[k] = map[k - 1].clone();                        // 위쪽 라인을 아래쪽 라인으로 복사
        }
        Arrays.fill(map[0], 0);                             // 맨위 라인을 0으로 초기화
        System.out.println("줄 지움 후 출력========================================");
        answer++;                                               // 없어진 라인 한 줄을 점수로 더해줌
        mapPrint();                                             // map 확인
    }

    public static void addMapToBlock() {
        for (int j = 0; j < block.length; j++) {
            for (int k = 0; k < block[0].length; k++) {
                if (block[j][k] == 1) {
                    map[x + j][y + k] = 1;
                }
            }
        }
    }

    public static boolean failCheck() {                     // 실패 체크 필요한 매개변수 모두 정적 변수로 구현  (실패 = true, 성공 = false)
        for (int i = 0; i < block.length; i++) {            // 현재 block 을 돌면서 그 값이 map 에 적용된 좌표와 확인
            for (int j = 0; j < block[0].length; j++) {
                if (x + i > 17) {                           // 세로 좌표값(x + i)이 18 이상이면 더 이상 내려 갈 수 없음
                    return true;                           // 실패 반환
                }

                if (x + i > 14 && block[i][j] == 1) {      // 세로 좌표값(x + i) 값이 15 이상 17 이하 일떄 블럭 모양이 15 밑으로 내려 왔는지 확인
                    return true;                          // 실패 반환
                }

                if (map[x + i][y + j] == 1 && block[i][j] == 1) { // 현재 좌표 (x + i, y + j) 와 블럭 좌표 (i, j) 값을 비교하여 1이 겹친다면 실패 반환
                    if (y + j < 2) {                              // 블럭의 1인 부분의 가로 좌표값이 0, 1 일 경우 map 밖이므로
                        while (y + j < 2) {                       // 좌표값을 알맞게 수정한 다음 다시 failCheck 시작
                            y++;
                        }
                        return failCheck();
                    }
                    if (y + j > 12) {                              // 블럭의 1인 부분의 가로 좌표값이 0, 1 일 경우 map 밖이므로
                        while (y + j > 12) {                       // 좌표값을 알맞게 수정한 다음 다시 failCheck 시작
                            y--;
                        }
                        return failCheck();
                    }

                    return true;                                  // 위 값에 걸리지 안았다면 블럭과 map 의 1이 겹친것이므로 true 반환
                }
            }
        }
        return false;                                       // 모든 if 문 통과하면 겹친 곳도 범위도 정상이므로 true 반환
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 6, 2, 4, 7, 4, 5, 3};
        String s = "uulduuuldurrrrrdrrurrrrrduulldrrrldrdrlrrruudurrrrd";
        System.out.println(solution(a, s));
    }
}

