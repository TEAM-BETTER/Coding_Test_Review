package CodingTest13;

/**
 * 1. command 길이와 blocks 길이가 다르므로 command를 기준으로 for문 돌림
 *      blockIdx: blocks 배열 내 몇 번째 인덱스
 *      dir: 현재 블록의 방향
 *      xDiff: x좌표 기준 왼/오 몇 칸 움직였는지 저장 (왼쪽이면 -, 오른쪽이면 +)
 *      curBlock: 현재 시점 블록 모양과 방향을 나타내는 배열
 * 2. 명령어에 따라 분기 처리
 *      l: 현재 블록을 왼쪽으로 움직일 수 있으면 왼쪽으로 이동 (canMove 메서드를 통해 확인)
 *      r: 현재 블록을 오른쪽으로 움직일 수 있으면 오른쪽으로 이동 (canMove 메서드를 통해 확인)
 *      u: 현재 블록을 시계방향을 회전 시킴
 *          dir을 1 증가시키는데 360도 회전하는 케이스를 고려하여 모듈러 연산도 같이 진행
 *      d: isGameOver 메서드를 통해 테트리스트 게임이 종료됐는지 확인
 *          종료됐으면 answer 반환
 *
 *          종료가 안되었을 경우 현재 블록을 board에 배치 (placeBlock 메서드)
 *          이 후 지울 수 있는 라인이 있는지 확인 (isStraightLine 메서드)
 *              지울 수 있는 라인이 있다면 answer를 1 증가 시키고 board 재배치 (removeLine 메서드)
*
 *          blocks의 다음 인덱스로 이동하기 위해 blockIdx++
 *          초기에 기본 방향이여야하므로 dir = 0
 *          x좌표 변동 초기화 위해 xDiff = 0
 * 3. for문 다 돌았을 경우 answer 반환
 *
 * printBoard는 디버깅용 메서드이므로 무시
 */
public class CodingTest5_김우진 {

    static final int HEIGHT = 15;

    static final int WIDTH = 10;

    static int answer = 0;

    static int[][] board = new int[HEIGHT][WIDTH];

    // 테트리스의 블록별 기본형과 변형 형태는 코드로 주어집니다.
    static int[][][][] TETRIS_BLOCK = new int[8][][][];

    static {
        int[][][] BLOCK;
        BLOCK = new int[][][]{{{0, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 0, 0, 1}},
                {{0, 0, 1},
                        {0, 0, 1},
                        {0, 1, 1}},
                {{0, 0, 0, 0},
                        {0, 1, 0, 0},
                        {0, 1, 1, 1}},
                {{0, 1, 1},
                        {0, 1, 0},
                        {0, 1, 0}}};
        TETRIS_BLOCK[1] = BLOCK;

        BLOCK = new int[][][]{{{0, 0, 0, 0},
                {0, 1, 1, 1},
                {0, 1, 0, 0}},
                {{0, 1, 1},
                        {0, 0, 1},
                        {0, 0, 1}},
                {{0, 0, 0, 0},
                        {0, 0, 0, 1},
                        {0, 1, 1, 1}},
                {{0, 1, 0},
                        {0, 1, 0},
                        {0, 1, 1}}};
        TETRIS_BLOCK[2] = BLOCK;

        BLOCK = new int[][][]{{{0, 0, 1, 0},
                {0, 1, 1, 1}},
                {{0, 0, 1, 0},
                        {0, 0, 1, 1},
                        {0, 0, 1, 0}},
                {{0, 0, 0, 0},
                        {0, 1, 1, 1},
                        {0, 0, 1, 0}},
                {{0, 0, 1},
                        {0, 1, 1},
                        {0, 0, 1}}};
        TETRIS_BLOCK[3] = BLOCK;

        BLOCK = new int[][][]{{{0, 0, 1},
                {0, 1, 1},
                {0, 1, 0}},
                {{0, 0, 0},
                        {1, 1, 0},
                        {0, 1, 1}}};
        TETRIS_BLOCK[4] = BLOCK;

        BLOCK = new int[][][]{{{0, 1, 0},
                {0, 1, 1},
                {0, 0, 1}},
                {{0, 0, 0},
                        {0, 1, 1},
                        {1, 1, 0}}};
        TETRIS_BLOCK[5] = BLOCK;

        BLOCK = new int[][][]{{{0, 0, 1},
                {0, 0, 1},
                {0, 0, 1},
                {0, 0, 1}},
                {{0, 0, 0, 0},
                        {1, 1, 1, 1}}};
        TETRIS_BLOCK[6] = BLOCK;

        BLOCK = new int[][][]{{{0, 1, 1},
                {0, 1, 1}}};
        TETRIS_BLOCK[7] = BLOCK;

    }

    static boolean canMove(boolean left, int diff, int[][] curBlock) {
        for (int y = 0; y < curBlock.length; y++) {
            for (int x = 0; x < curBlock[y].length; x++) {
                if (left == true
                        && curBlock[y][x] == 1
                        && x + diff - 1 < 0) {
                    return false;
                }

                if (left == false
                        && curBlock[y][x] == 1
                        && x + diff + 1 >= WIDTH) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isGameOver(int xDiff, int[][] curBlock) {
        for (int y = 0; y < curBlock.length; y++) {
            for (int x = 0; x < curBlock[y].length; x++) {
                if (curBlock[y][x] == 1
                        && board[y][x + xDiff] == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    static void placeBlock(int xDiff, int[][] curBlock) {
        int yDiff = 0;

        loop:
        while (true) {
            for (int y = 0; y < curBlock.length; y++) {
                for (int x = 0; x < curBlock[y].length; x++) {
                    if (curBlock[y][x] == 1
                            && y + yDiff + 1 >= HEIGHT) {
                        break loop;
                    } else if (curBlock[y][x] == 1
                            && board[y + yDiff + 1][x + xDiff] == 1) {
                        break loop;
                    }
                }
            }

            yDiff++;
        }

        for (int y = 0; y < curBlock.length; y++) {
            for (int x = 0; x < curBlock[y].length; x++) {
                if (curBlock[y][x] == 1) {
                    board[y + yDiff][x + xDiff] = 1;
                }
            }
        }
    }

    static boolean isStraightLine(int y) {
            for (int x = 0; x < WIDTH; x++) {
            if (board[y][x] == 0) {
                return false;
            }
        }

        return true;
    }

    static void removeLine() {
        for (int y = 0; y < HEIGHT; y++) {
            if (isStraightLine(y) == false) {
                continue;
            }

            answer++;

            for (int curY = y; curY > 0; curY--) {
                for (int x = 0; x < WIDTH; x++) {
                    board[curY][x] = board[curY - 1][x];
                }
            }

            for (int x = 0; x < WIDTH; x++) {
                board[0][x] = 0;
            }
        }
    }

    static void printBoard() {
        System.out.println("==============================================================");
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                System.out.print(board[y][x]);
            }

            System.out.println();
        }
        System.out.println("==============================================================");
    }

    public static int solution(int[] blocks, String commands) {
        int blockIdx = 0;
        int dir = 0;
        int xDiff = 0;

        for (int i = 0; i < commands.length(); i++) {
            int[][] curBlock = TETRIS_BLOCK[blocks[blockIdx]][dir];

            switch (commands.charAt(i)) {
                case 'l':
                    if (canMove(true, xDiff, curBlock)) {
                        xDiff--;
                    }

                    break;
                case 'r':
                    if (canMove(false, xDiff, curBlock)) {
                        xDiff++;
                    }

                    break;
                case 'u':
                    dir = (dir + 1) % TETRIS_BLOCK[blocks[blockIdx]].length;

                    break;
                case 'd':
                    if (isGameOver(xDiff, curBlock)) {
                        return answer;
                    }

                    placeBlock(xDiff, curBlock);
                    removeLine();
                    printBoard();

                    blockIdx++;
                    dir = 0;
                    xDiff = 0;

                    break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] blocks = {1, 3, 6, 2, 4, 7, 4, 5, 3};
        String commands = "uulduuuldurrrrrdrrurrrrrduulldrrrldrdrlrrruudurrrrd";

        System.out.println(solution(blocks, commands));
    }
}
