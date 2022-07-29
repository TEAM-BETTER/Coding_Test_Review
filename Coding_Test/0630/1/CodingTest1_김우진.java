package CodingTest6;

/**
 * 1. 투포인터로 p2가 오른쪽으로 한칸씩 이동하면서 옆 수와 비교하여
 * 증가하는지(+), 감소하는지(-) 체크를 한다.
 * int len 변수는 p1과 p2사이의 길이를 체크
 * 2. 만약 증가했다면 다음 수를 비교하도록 p2를 이동하고,
 * 증가로 인해 len 값이 커졌다면 len변수 더 큰 값으로 유지
 * 만약 감소했다면 p1을 p2자리로 옮겨 다시 길이를 체크하게 한다.
 * p1값이 p2값이 되면 len 값은 다시 1부터 시작
 * 3. values의 끝까지 도달해서 모든 값의 증가, 감소를 체크해서
 * 가장 길게 증가되었던 길이값만큼 리턴
 */
public class CodingTest1_김우진 {

    public static int[] solution(int[] values) {
        int[] answer = new int[2];
        int p1 = 0;
        int p2 = 1;
        int len = 0;

        while (p2 < values.length + 1) {
            if (p2 >= values.length) {
                break;
            }

            if (values[p2] > values[p2 - 1]) {
                if (len < p2 - p1) {
                    answer[0] = p1;
                    answer[1] = p2;
                    len = p2 - p1;
                }

                p2++;
            } else {
                p1 = p2;
                p2++;
            }
        }

        return answer;
    }
}
