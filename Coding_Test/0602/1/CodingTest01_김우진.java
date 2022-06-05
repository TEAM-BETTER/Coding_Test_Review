package CodingTest2;

/**
 *     1. 먼저 기준범위에 있는 수만큼의 boolean 배열을 만든다
 *     2. boolean 배열의 범위 안에 있는 numbers 는 true로 변환해서 boolean의 인덱스 값으로 촘촘이의 배열 숫자를 구별함
 *     3. 다시 전체 배열을 순회하면서 boolean startChk 가 2번에서 true로 바뀐 촘촘이의 배열 숫자를 만나면 true로 바꿔줌
 *     4. 바꾸는 도중에 false로 남아있는 숫자를 만나면 그 숫자가 촘촘이의 배열 중간에 있지만 배열이 아닌 가장 작은수가 됨
 *     5. 가장 먼저 나오는 수가 가장 작은 수로 해당 수를 찾으면 종료
 *     6. 답 리턴
 */
public class CodingTest01_김우진 {

    public static int MAX = 100000 + 1;

    public int solution(int[] numbers) {

        boolean numCHK [] = new boolean [MAX];

        for (int i = 0; i < numbers.length; i++) {
            numCHK[numbers[i]] = true;
        }

        boolean startChk = false;
        int answer = MAX;

        for (int i = 0; i < MAX; i++) {
            if (numCHK[i] == true) {
                startChk = true;
            } else {
                if (startChk) {
                    answer = i;
                    break;
                }
            }
        }

        return answer;
    }
}
