package CodingTest7;

/**
 * 1. 과반수가 성립한다는 조건이 있음
 * 2. 반복문으로 배열 안의 요소를 하나씩 확인
 * 3. 배열의 맨 처음 값은 첫 값이기 때문에 cnt = 0부터 시작
 * 4. 맨 처음 vote의 값이 answer가 되고
 *      answer값을 기준으로 answer값이면 cnt ++, 아니면 cnt --
 * 5. 만약 answer 값이 0이되면 그 다음 vote에 해당하는 값을
 *      다시 answer값에 넣고 4번 반복
 * 6. 4-5번을 반복해서 마지막까지 남는 값이 과반수인 answer
 *
 */
public class CodingTest2_김우진 {
    public static int solution(int[] votes) {
        int answer = 0;
        int cnt = 0;

        for (int vote : votes) {
            if (cnt == 0) {
                answer = vote;
            }

            if (answer == vote) {
                cnt++;
            } else {
                cnt--;
            }
        }
        return answer;
    }
}
