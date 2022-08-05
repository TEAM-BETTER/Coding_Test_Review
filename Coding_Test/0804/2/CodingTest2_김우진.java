package CodingTest11;

/**
 * 처음에 배열 정렬식으로 풀었더니 시간초과가 나서 재귀로 다시 풀었습니다.
 *
 * 1. func 메서드는 solution에서 주어진 i값을 기준으로 가장 앞자리는 숫자는 그대로 두되,
 *      10씩 곱하여 수의 자릿수를 늘리고, i를 더하여 한자리수를 늘려서 n보다 작은 num 의 수를 구합니다.
 *      배열 answer에 구해진 num을 차례대로 넣습니다.
 *
 * 2. solution 의 for 문을 통해 1부터 9까지 앞자리에 해당하는 값을
 *      func 메서드를 통해 n보다 작은 값을 answer에 더해줍니다.
 *
 */

public class CodingTest2_김우진 {

    static int idx = 0;

    static int[] answer;

    static void func(int num, int n) {
        if (num > n) {
            return;
        }

        answer[idx++] = num;

        for (int i = 0; i < 10; i++) {
            func(num * 10 + i, n);
        }
    }

    public static int[] solution(int n) {
        answer = new int[n];

        for (int i = 1; i < 10; i++) {
            func(i, n);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] answer = solution(15);

        for (int a : answer) {
            System.out.println(a);
        }
    }
}
