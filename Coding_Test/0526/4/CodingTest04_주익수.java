class Solution {
    int[][] map = new int[512][512];
    int count = 1;
    public int solution(int n, int i, int j) {
        int answer = 0;

        recu(n, n, n);

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < n; b++) {
                System.out.print(map[a][b] + " ");
            }
            System.out.println();
        }

        answer = map[n-i][n-j];

        return answer;
    }

    public void recu(int n, int x, int y) {
        if (n == 2) {
            map[x][y] = count++;
            map[x-1][y] = count++;
            map[x-1][y+1] = count++;
            map[x][y+1] = count++;
        }
        else if (n > 2) {
            recu(n/2, n-1, 0);
            recu(n/2, n/2-1, 0);
            recu(n/2, n/2-1, n/2);
            recu(n/2, n-1, n/2);
        }

    }
}