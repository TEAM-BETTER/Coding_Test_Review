import java.util.ArrayList;

class Solution {
    public long solution(int N, int M, int K, int[] capacity) {
        long answer = 0;
        int[] myCapacity = new int[3];
        ArrayList<ArrayList<Integer>> partitions = new ArrayList<>();
        // capacity에 있는 모든 값을 myCapacity로 복사
        for(int i = 0; i < capacity.length; i++) {
            myCapacity[i] = capacity[i];
        }
        // capacity의 길이가 3보다 작을 경우 남은 부분을 0으로 채워줌
        for(int i = capacity.length; i < 3; i++) {
            myCapacity[i] = 0;
        }

        // myCapacity[a, b, c] 인 상태에서 i + j + k = N인 경우 (0 <= i <= a, 0 <= j <= b, 0 <= k <= c)를 찾는다.
        // a + b + c >= N이기 때문에 무조건 결과가 나온다.
        // 예를들면 N은 5인 경우
        // [1,1,3], [1,2,2] [1,3,1], [3,1,1] [3,2] 이런식으로
        // a + b + c = N인 모든 경우의수를 partitions에 담는다.
        for(int i = 0; i <= myCapacity[0]; i++) {
            for(int j = 0; j <= myCapacity[1]; j++) {
                for(int k = 0; k <= myCapacity[2]; k++) {
                    if (i + j + k == N) {
                        ArrayList<Integer> partition = new ArrayList<>();
                        partition.add(i);
                        partition.add(j);
                        partition.add(k);
                        partitions.add(partition);
                    }
                }
            }
        }

        for(ArrayList<Integer> partition : partitions) {
            int first = partition.get(0); // 각 교실에 들어갈 학생의 수
            int second = partition.get(1);
            int third = partition.get(2);

            // 조합으로 각 경우에수에 대한 학생이 들어갈 수를 더해서 구한다.
            answer += combination(N, first) * combination(N - first, second) * combination(N - first - second, third);
        }
        // 모든 조합에 대하여 감독관이 들어갈 수를 곱해주면 정답
        return answer * permutation(K, M);
    }

    public static long combination(int n, int r) {
        if(n == r || r == 0)
            return 1L;
        else
            return combination(n - 1, r - 1) + combination(n - 1, r);
    }

    public static long permutation(int n, int r) {
        long ret = 1;
        for(int i = n; i >= n -r + 1; i--) {
            ret *= i;
        }
        return ret;
    }
}