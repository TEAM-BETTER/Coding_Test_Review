import java.util.Arrays;
//  20점
public class Test3 {

    /*
    비슷한 유형을 풀었었는데 2번에서 멘탈이 나가는 바람에 4점인가 받고 끝나 아쉬웠습니다.
    다시 아래처럼 풀어보니까 20점이 나오네요.
    강사님과 비슷한 방식으로 풀었습니다.
     */


    public static int solution(int N, int[] rewards) {

        int[] maxArr = new int[N];  // 인덱스가 i일 떄 기준으로 가능한 최댓값을 저장한다.
        int result = 0;

        // 첫번째 데이터~ N - 1번째 데이터끼리만 비교한다.
        maxArr[0] = rewards[0];
        maxArr[1] = Math.max(rewards[0], rewards[1]);
        for(int i = 2; i < N - 1; ++i){
            maxArr[i] = Math.max(maxArr[i - 2] + rewards[i],   maxArr[i - 1]);
            // 현재 값을 더하거나 안 하거나 두 가지 경우 뿐이다.
        }
        result = maxArr[N - 2]; // 맨 뒤에 있는 게 가장 큰 값이다.

        // 두 번째 ~ 마지막 데이터끼리 비교
        maxArr[0] = 0;
        maxArr[1] = rewards[1];
        for(int i = 2; i < N; ++i){
            maxArr[i] = Math.max(maxArr[i - 2] + rewards[i], maxArr[i - 1]);
        }
        result =  Math.max(result, maxArr[N - 1]);
        return  result;
    }


    public static void main(String[] args) {
        int [] reward = {5, 10, 5, 7, 5, 9};        //  5  10  10  17  17 26
        System.out.println(solution(6, reward));    // 26

        reward = new int[]{1, 1, 10, 1, 1, 1, 10, 1, 1, 10};
        System.out.println(solution(10, reward));    // 31

        reward = new int[]{1, 2, 3, 1, 4, 4,    1, 23, 25, 32, 10};
        System.out.println(solution(11, reward));
    }
}
