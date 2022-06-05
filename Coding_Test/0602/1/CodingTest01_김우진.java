package CodingTest2;

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
