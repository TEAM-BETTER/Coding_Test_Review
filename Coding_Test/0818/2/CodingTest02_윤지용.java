public class CodingTest02 {

    static int answerCandidate = 0;
    static int targetCnt = 3;
    static boolean findTarget = false;
    public static int solution(int[] arr, int target) {
        boolean[] visited = new boolean[arr.length];

        recur(0, target, 0, arr, visited);

        return answerCandidate;
    }

    public static void recur(int depth, int target, int result, int[] arr, boolean[] visited) {
        // 종료조건
        if(depth == targetCnt) { // 숫자 3개면
            if (result == target) {
                answerCandidate = result; // 정답 업데이트
                findTarget = true;
                return;
            } else if (Math.abs(result - target) < Math.abs(answerCandidate - target)) { // 가까우면
                answerCandidate = result; // 정답 업데이트
            } else if (Math.abs(result - target) == Math.abs(answerCandidate - target)) { // 같으면
                if (result < answerCandidate) { // 작으면
                    answerCandidate = result; // 정답 업데이트
                }
            }
            return;
        }

        if(findTarget) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result += arr[i];
                recur(depth + 1, target, result, arr, visited);
                visited[i] = false;
                result -= arr[i];
            }
        }
    }

    public static void main(String[] args) {
        int target = 21;
        int[] arr = {5,2,15,3,10,5};
        System.out.println(solution(arr, target));

    }
}
