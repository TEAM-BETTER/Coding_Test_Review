/*
3번 아메바 문제입니다..

이 친구만 풀었습니다..
나머지 문제들은 10점 미만이라 한번 더 풀어보고 내일 중으로 커밋에 추가하겠습니다..
 */

class Solution {
    public int solution(int delay, int N) {
        int answer = 0;

        int[] arr = new int[50]; //총 분열한 아메바의 갯수를 저장하는 배열입니다.
        int[] donotSplit = new int[50]; //분열하지 않은 아메바의 갯수를 저장하는 배열입니다.

        arr[0] = 1; //처음 아메바는 무조건 한 마리입니다.
        int count = 1; //delay의 값에 따라 분열하지 않는 아메바들을 초기화해주는 범위가 달라지므로 count로 선언해주었습니다.
        donotSplit[0] = 0; //delay가 어떤 값이든 0,1,2번 인덱스의 분열하지 않는 아메바는 0,0,1로 일정합니다.
        donotSplit[1] = 0;
        donotSplit[2] = 1;

        for (int i = 1; i < delay + 1; i++) //1번 인덱스부터 delay값까지 2에서 1씩 증가하는 규칙이 있습니다.
            arr[i] = i + 1;

        for (int i = 2; i < delay + 2; i++) //분열하지 않는 아메바는 2번 인덱스부터 delay 값 + 1까지 2에서 1씩 증가하는 규칙이 있습니다.
            donotSplit[i] = count++;

        /*
        분열하는 총 아메바의 값은 DP를 통해 알아낼 수 있습니다.
        delay가 1인 경우, time = 2일때의 총 아메바 갯수는 time = 1일 때의 아메바 갯수와 time = 0일 때의 아메바 갯수의 합이며
        dleay가 2인 경우, time = 3일때의 총 아메바 갯수는 time = 2일 때의 아메바 갯수와 time = 0일 때의 아메바 갯수의 합입니다.
        그래서 아래와 같은 식이 나옵니다.
        분열하지 않는 아메바의 갯수도 위 공식과 동일합니다.
         */
        for (int i = delay + 1; i <= N; i++)
            arr[i] = arr[i - 1] + arr[i - 1 - delay];

        for (int i = delay + 2; i <= N; i++)
            donotSplit[i] = donotSplit[i - 1] + donotSplit[i - 1 - delay];

        /*
        이름을 지어주어야 하는 아메바의 갯수는 지금까지 분열한 아메바의 갯수 - 지금까지 분열하지 않은 아메바의 갯수들입니다.
         */
        for (int i = 0; i <= N; i++)
            answer += arr[i];

        for (int i = 0; i <= N; i++)
            answer -= donotSplit[i];

        return answer;
    }

}
// 아메바가 싫어졌습니다..