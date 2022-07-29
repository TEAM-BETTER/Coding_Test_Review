class Solution {
    public int solution(int N, int[][] trust) {
        int answer = 0;

        //입력 받은 이차원 배열의 값 비교를 위해 for문으로 돌면서 list에 저장
        for (int i = 0; i < trust.length; i++) {
            int[] list = trust[i];
            for (int j = 0; j < list.length; j++) {

                // 비교된 값 중에 N과 같으면 N을 되돌려주고 아니면 -1 리턴
                if (list[j] == N) {
                    answer = N;
                } else {
                    answer = -1;
                }
            }
        }

        return answer;
    }
}