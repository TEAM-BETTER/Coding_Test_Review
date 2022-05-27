class Solution {
    int[][] map = new int[512][512]; //N의 최댓값이 512이므로
    int count = 1; //1씩 증가시켜 데이터를 넣기위함
    public int solution(int n, int i, int j) {
        int answer = 0;

        recu(n, n, n); //재귀문 사용, 초기 x,y좌표 또한 n,n으로 설정

        answer = map[n-i][n-j]; //시계방향으로 90도 회전시킨 모양이므로 n에서 i, j를 빼줌

        return answer;
    }

    public void recu(int n, int x, int y) {
        if (n == 2) { //n이 최솟값인 2인 경우, 맵을 채우는 로직 실행
            map[x][y] = count++;
            map[x-1][y] = count++;
            map[x-1][y+1] = count++;
            map[x][y+1] = count++;
        }
        else if (n > 2) { //ㄷ모양으로 로직수행
            recu(n/2, n-1, 0);
            recu(n/2, n/2-1, 0);
            recu(n/2, n/2-1, n/2);
            recu(n/2, n-1, n/2);
        }

    }
}