package CodingTest2;

import java.util.ArrayList;
import java.util.List;

class CodingTest02_김우진 {

    /**
     *         1. 조건 상 주어진 a, b의 배열이 없으면 0 으로 반환
     *         2. 주어진 배열의 길이를 보고 자릿수를 알아냄
     *         3. 더 작은 자릿수를 기준으로 연산을 함
     *         4. 배열의 끝 부분부터 더함,
     *         만약 sum이 10보다 커서 자릿수가 넘어가게되면
     *         add 변수로 다음 연산때 1을 더해주면서 자릿수 처리를 함
     *         5. 두 배열의 연산이 끝나고 아직 남은 배열이 있다면
     *         남은 숫자를 더해나감
     *         6. 맨 마지막 연산에서 자릿값올림이 발생하면
     *         남은 add는 그대로 list에 반영해줌
     *         7. 연산을 하면서 끝자리부터 결과값이 들어갔으므로
     *         answer 리스트에는 다시 반대로 배열값을 넣어줌
     * @param a
     * @param b
     * @return
     */
    public static int[] solution(int[] a, int[] b) {
        int[] answer = {};

        if (a.length == 0 && b.length == 0) {
            return answer;
        }

        int aLength = a.length;
        int bLength = b.length;
        List<Integer> list = new ArrayList<>();
        int add = 0;

        for (int i = 0; i < Math.min(a.length, b.length); i++) {
            int sum = a[aLength - i - 1] + b[b.length - i - 1] + add;
            add = 0;

            if (sum >= 10) {
                add++;
                sum -= 10;
            }
            list.add(sum);
        }

        if (a.length > b.length) {
            for (int i = b.length; i < a.length; i++) {
                int sum = a[aLength - i - 1] + add;
                add = 0;

                if (sum >= 10) {
                    add++;
                    sum -= 10;
                }
                list.add(sum);
            }
        } else if (b.length > a.length) {
            for (int i = a.length; i < b.length; i++) {
                int sum = b[b.length - i - 1] + add;
                add = 0;

                if (sum >= 10) {
                    add++;
                    sum -= 10;
                }
                list.add(sum);
            }
        }

        if (add != 0) {
            list.add(add);
        }

        answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(list.size() - i - 1);
        }

        return answer;
    }
}
