/*
* 18점 답안입니다!
* 5초 정도 남기고 제출 했는데 1번케이스가 런타임에러 났네요 ㅠㅠ
* 첫 번째 전구를 키는 경우(first 배열)와 키지 않는 경우(status 배열)로
* 나누어서 풀이했습니다. 만약 두가지 모두 불가능하면 -1을 출력합니다!
* 백준에 전구와 스위치 문제와 비슷하네요
* https://www.acmicpc.net/problem/2138
* */
class Solution {
    public int solution(int[] status) {
        int N = status.length;

        int[] first = status.clone();       // 첫번째 전구를 키는 경우의 배열
        first[0] = first[0] == 1 ? 0 : 1;
        first[1] = first[1] == 1 ? 0 : 1;

        int answer1 = 1;                    // first 배열의 답
        int answer2 = 0;                    // status 배열의 답

        for(int i=1; i<N; i++) {
            if(first[i-1] != 1) {
                first[i-1] = first[i-1] == 1 ? 0 : 1;       // 지금 보니까 first[i-1] = 1로 하면 되겠네요
                first[i] = first[i] == 1 ? 0 : 1;
                answer1++;
                if(i != N-1) {
                    first[i+1] = first[i+1] == 1 ? 0 : 1;
                }
            }
            if(status[i-1] != 1) {
                status[i-1] = status[i-1] == 1 ? 0 : 1;
                status[i] = status[i] == 1 ? 0 : 1;
                answer2++;
                if(i != N-1) {
                    status[i+1] = status[i+1] == 1 ? 0 : 1;
                }
            }
        }

        if(first[N-1] != 1) answer1 = Integer.MAX_VALUE;        // 마지막 인덱스가 1이 아닐 경우
        if(status[N-1] != 1) answer2 = Integer.MAX_VALUE;

        int answer = Math.min(answer1, answer2);                // 두 경우 모두 가능하다면 더 작은 값
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}