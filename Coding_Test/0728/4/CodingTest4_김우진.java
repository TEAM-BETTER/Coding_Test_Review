package CodingTest10;

/**
 * 1. for문을 통해 i값이 param0[i]값이 될 때 까지 반복 할 수 있게 한다.
 * 2. idx는 param0dl의 index변수
 * 3. for문으로 첫 시작점을 잡고 그 이후 반복문을 통해 마지막 index에 도착 할 수 있을지 확인
 *      만약 idx값이 param0.length보다 커지면 answer = true;
 *      만약 0을 만나면 더 이동할 수 없기 때문에 break;
 */
public class CodingTest4_김우진 {

    public static boolean solution(int[] param0) {
        boolean answer = false;
        int N = param0.length;

        for (int i = 0; i < param0[i]; i++) {

            int idx = 0;

            while (true) {
                idx += param0[idx+i];

                if (idx > N) {
                    answer = true;
                    break;
                }

                if (param0[idx+i] == 0) {
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] num = {2,3,5,2,0,2,1,1,0,0,4};
        System.out.println(solution(num));
    }
}
