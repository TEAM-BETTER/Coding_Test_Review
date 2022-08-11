package CodingTest11;

/**
 * 1. digit = 주어진 num의 charAt(i)
 *      -> count배열은 해당 숫자의 갯수를 체크 할 배열
 *      digit 값 마다 count[digit]++로 숫자 카운트
 *
 * 2. num의 숫자들을 모두 배열에 카운트 했으면
 *      index값과 해당 index의 count 된 값을 String에 더해줌
 *      -> 1-2 번 은 n번 만큼 반복합니다.
 *
 * 3. 마지막으로 MOD로 나눈 값을 리턴합니다.
 *
 * **) int 형으로 풀었더니 런타임에러가 나서 long 으로 형변환을 해주니 올패스했습니다.
 */

public class CodingTest1_김우진 {
    static int MOD = 10004;

    public static int solution(int n, int num) {
        String s = String.valueOf(num);

        for (int i = 0; i < n; i++) {
            int[] count = new int[10];

            for (int j = 0; j < s.length(); j++) {
                Long digit = Long.valueOf(Integer.parseInt(s.charAt(j) + ""));

                count[Math.toIntExact(digit)]++;
            }

            String temp = "";

            for (int j = 0; j < 10; j++) {
                if (count[j] == 0) {
                    continue;
                }

                temp += String.valueOf(j);
                temp += String.valueOf(count[j]);
            }
            s = temp;
        }

        return (int) (Long.parseLong(s) % MOD);
    }

    public static void main(String[] args) {
        int n = 3;
        int num = 54223;
        System.out.println(solution(n, num));
    }
}