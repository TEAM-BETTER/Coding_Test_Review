class Solution {
    int length = -1;// 초기 길이값
    int cur = 0;
    int ret = -1; // 재귀함수에서 값을 누적시켜가면서 반환하고 싶었는데 좌표를 찾고 나서도 계속 재귀가 진행되어 일단 여기에 둠

    public int solution(int n, int i, int j) {

        length = n;
        solve(n/2, 0, length - 1,i, j);
        solve(n/2, 0, length - 1 - (n/2), i, j);
        solve(n/2, 0 + (n/2), length - 1 - (n/2), i,j);
        solve(n/2, 0 + (n/2), length - 1, i, j);

        return ret;
    }

    // n은 재귀식 사각형의 길이 x 탐색시작 행,y는 탐색 시작 열 ,i 행, j 열 찾을 좌표
    public void solve(int n, int x, int y, int i, int j) {
        if (x < 0 || x >= length || y < 0 || y >= length) return; // 원래 사각형에서 밖으로 나가면 종료
        if (!((x <= i && i <= x + n - 1) && (y - n + 1<= j && j <= y))) { // 찾을 좌표가 탐색할 영역에 없다면 모든 영역을 순회 한 것으로 치고 사각형의 크기만큼 더해줌
            cur += n * n;
            return;
        }
        if (x == i && y == j) {
            ret = ++cur; // 찾을 좌표를 찾은 경우
            return;
        }
        if (n == 1) {
            ++cur; // n = 1인 경우 세주고 넘어감
            return;
        }


        //1 ㄷ의 첫 번째 영역
        if (ret != -1) return; // 이미 답이 구해졌다면 재귀하지 않고 넘어간다
        solve(n/2, x, y, i, j);
        //2 ㄷ의 두 번째 영역
        if (ret != -1) return;
        solve(n/2, x, y-(n/2), i, j);
        //3 ㄷ의 세 번째 영역
        if (ret != -1) return;
        solve(n/2, x+(n/2),y-(n/2), i, j);
        //4 ㄷ의 네 번째 영역
        if (ret != -1) return;
        solve(n/2, x+(n/2), y, i, j);
    }
}