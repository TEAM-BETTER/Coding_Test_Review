/*
*  앞자리에 있는 숫자를 뒤에 있는 숫자중 가장 큰 숫자로 바꿔주면 된다고 생각하고 풀이 했습니다.
*  가장 큰 숫자는 가장 작은 자리 수 부터 탐색을 진행 했습니다.
* */
class Solution {
    public int solution(int num) {
        char[] numArray = (num + "").toCharArray();

        for (int i = 0; i < numArray.length-1; i++) {
            int targetIndex = findMaxIndexFromStart(numArray, i);
            // 바꿀수 있는 숫자를 찾은경우 바꾸고 탐색을 종료합니다.
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
    // start보다 index가 크면서 가장 큰 숫자의 인덱스를 반환 해주는 함수 입니다.
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