// 가장 앞자리수를 바꿔 줄 수 있다면 정답이라고 생각 했습니다
class Solution {
    public int solution(int num) {
        char[] numArray = (num + "").toCharArray();

        for (int i = 0; i < numArray.length-1; i++) {
            int targetIndex = findMaxIndexFromStart(numArray, i);
            // 교환 할 수 있다면 교환 하고 종료!
            if (targetIndex != i) {
                char temp = numArray[i];
                numArray[i] = numArray[targetIndex];
                numArray[targetIndex] = temp;
                break;
            }
        }

        String ret = "";
        for (int i = 0; i < numArray.length; i++) {
            ret += numArray[i];
        }

        return Integer.parseInt(ret);
    }

    // 끝에서 ~ start + 1까지중 최대 값의 인덱스 반환!
    public int findMaxIndexFromStart(char[] numArray, int start) {
        int value = numArray[start] - '0';
        int ret = start;

        for (int i = numArray.length-1; i > start; i--) {
            if (value < numArray[i] - '0') {
                value = numArray[i] - '0';
                ret = i;
            }
        }

        return ret;
    }
}