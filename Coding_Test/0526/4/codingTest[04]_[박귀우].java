class Solution_Fb {
    // FeedBack 에 따라 조금 개선해 보았습니다.
    public int solution(int n, int i, int j) {
        return checkWhere(n, 1, n * n, i, j);
    }

    public boolean isTop(int size, int i) {
        if (i < size / 2) {
            return true;
        }
        return false;
    }

    public boolean isLeft(int size, int k) {
        if (k < size / 2) {
            return true;
        }
        return false;
    }

    public int checkWhere(int size, int start, int end, int i, int k) {
        // 각각 사이즈는 배열의 사이즈 즉 size*size 를 의미
        // start,end 는 각각 그 배열의 시작점 과 끝을 의미
        // i,k 얻고자 하는 좌표
        if (size == 2) { // 사이즈가 2라면 총 [2][2] 사이지의 배열 일경우 아래와 같이 처리
            int[][] answer = new int[2][2];
            answer[0][1] = end - 3;
            answer[0][0] = end - 2;
            answer[1][0] = end - 1;
            answer[1][1] = end;
            return answer[i][k];
        }

        boolean top = isTop(size, i);
        boolean bottom = !top;
        boolean left = isLeft(size, k);
        boolean right = !left;

        int nextEnd = (end - start + 1) / 4; // 사분면의 정확한 지점이 확정될시 사이즈를 줄이고 시작점과 끝점 변경
        if (top && right) {// 1사 분면 "시작점 동일 끝점 은 시작점에 4분면의 끝점-1" -1인이유는 1부터 시작하기떄문에
            return checkWhere(size / 2, start, start + nextEnd - 1, i, k - (size / 2));
        } else if (top && left) {// 2사분 면 "시작점 은 사분면 의 첫번째 시작점을 더해준값"
            return checkWhere(size / 2, start + nextEnd, start + 2 * nextEnd - 1, i, k);
        } else if (bottom && left) {// 3사 분면
            return checkWhere(size / 2, start + 2 * nextEnd, start + 3 * nextEnd - 1, i - (size / 2), k);
        } else { // 4사 분면
            return checkWhere(size / 2, start + 3 * nextEnd, start + 4 * nextEnd - 1, i - (size / 2),
                    k - (size / 2));
        }
    }

    class ShortForm_Sol {
        // 확실히 코드길이가 적어도 문제를 해결했던거여서 그런지 읽기가 조금 더 편안하네요.
        public int solution(int n, int i, int j) {
            return recur(n, 1, n * n, i, j);
        }

        public int recur(int size, int start, int end, int i, int j) {
            if (size == 2) {
                int[][] result = new int[2][2];
                result[1][1] = end;
                result[1][0] = end - 1;
                result[0][0] = end - 2;
                result[0][1] = end - 3;
                return result[i][j];
            }
            int mid = size / 2;
            int nextEnd = (end - start + 1) / 4;
            if (i < mid && j >= mid) {
                return recur(mid, start, start + nextEnd - 1, i, j - mid);
            } else if (i < mid && j < mid) {
                return recur(mid, start + nextEnd, start + 2 * nextEnd - 1, i, j);
            } else if (i >= mid && j < mid) {
                return recur(mid, start + 2 * nextEnd, start + 3 * nextEnd - 1, i - mid, j);
            } else {
                return recur(mid, start + 3 * nextEnd, start + 4 * nextEnd - 1, i - mid, j - mid);
            }
        }
    }

    class Previous_Sol {
        public int solution(int n, int i, int j) {
            return checkWhere(n, 1, n * n, i, j);
        }

        public boolean isTop(int size, int i) {
            if (i < size / 2) {
                return true;
            }
            return false;
        }

        public boolean isLeft(int size, int k) {
            if (k < size / 2) {
                return true;
            }
            return false;
        }

        public int checkWhere(int size, int start, int end, int i, int k) {
            if (size == 2) {
                int[][] answer = new int[2][2];
                answer[0][1] = end - 3;
                answer[0][0] = end - 2;
                answer[1][0] = end - 1;
                answer[1][1] = end;
                return answer[i][k];
            }

            boolean top = isTop(size, i);
            boolean bottom = top == true ? false : true;
            boolean left = isLeft(size, k);
            boolean right = left == true ? false : true;

            int nextEnd = (end - start + 1) / 4;
            if (top && right) {
                return checkWhere(size / 2, start, start + nextEnd - 1, i, k - (size / 2));
            } else if (top && left) {
                return checkWhere(size / 2, start + nextEnd, start + 2 * nextEnd - 1, i, k);
            } else if (bottom && left) {
                return checkWhere(size / 2, start + 2 * nextEnd, start + 3 * nextEnd - 1, i - (size / 2), k);
            } else {
                return checkWhere(size / 2, start + 3 * nextEnd, start + 4 * nextEnd - 1, i - (size / 2),
                        k - (size / 2));
            }
        }
    }
}