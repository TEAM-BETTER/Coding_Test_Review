package CodingTest8;

/**
 * 코딩 테스트 당시 20점
 *
 * 1. 문제조건1: 인접한 성은 침입할 수 없다
 *      -> 첫번째 성 부터 도는지, 두번째 성 부터 도는지 체크한다
 *      -> 세번째 성 부터 도는것은 첫번째 성 부터 도는것과 일치하기 때문에 패스
 *      -> arr1은 첫번째 성부터, arr2는 두번째 성부터 도는것으로 하고 배열 시작
 * 2. arr1은 첫번째 성부터 돌기 때문에 arr1[0] = reward[0]과 같은 값
 *      -> 첫번째 성을 침입한 상태이기 때문에 두 번째 성은 침입할 수 없이 reward가 따로 없다.
 *      때문에 arr1[1]에서는 첫번째 성의  reward[0]를 그대로 유지한다. 때문에 arr1[0] = arr1[1] = rewards[0];
 *      arr2은 첫번째 성부터 돌기 때문에 arr2[1] = reward[1]과 같은 값
 *
 * 3. 1번 성과 2번성은 각 배열의 시작을 전처리했기 때문에 2부터 배열 시작
 * 4. 인접한 집을 털 수 없다는 점화식은 다음과 같다
 *      -> arr[i] = max(i번째 집 + (i - 2) 번째 집, (i - 1) 번째 집)
 * 5. 반복문을 돌며 각각의 배열 안에 성을 털어 얻은 rewards값을 더해두고
 *      가장 두 배열의 마지막 index값과 비교하여 더 큰 값을 리턴한다
 *
 */
public class CodingTest3_김우진 {

    public static int solution(int N, int[] rewards) {

        int[] arr1 = new int[rewards.length];
        int[] arr2 = new int[rewards.length];

        arr1[0] = arr1[1] = rewards[0];
        arr2[1] = rewards[1];

        for (int i = 2; i < rewards.length; i++) {
            arr1[i] = Math.max(arr1[i-1], rewards[i] + arr1[i-2]);
            arr2[i] = Math.max(arr2[i-1], rewards[i] + arr2[i-2]);
        }
        return Math.max(arr1[rewards.length-2], arr2[rewards.length-1]);
    }

    public static void main(String[] args) {
        int N = 6;
        int [] reward = {5, 10, 5, 7, 5, 9};
        System.out.println(solution(N, reward));
    }
}