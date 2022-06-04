/**
 * 숫자의 범위를 잘못알고 구현하다가 뭔가 이상해서 다시봤을때 이미 너무많은 코드를 작성해서 돌이킬수 없었어요..ㅠ
 * 멘탈이 터져버려서 쉽게 풀수 있는건데 바보처럼 풀었습니다.
 */

class CodingTest01_박귀우 {
    public int solution(int[] numbers) {
        if (numbers.length < 3) { // 3이하의 작은 케이스를 걸러주는 구간입니다.
            int cur = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                if (cur + 1 != numbers[i]) {
                    cur = cur + 1;
                    break;
                }
            }
            return cur;
        }
        Arrays.sort(numbers);
        int left = 1;
        int right = numbers.length - 2; // 2칸아래로 잡아서 스위칭 시켜줄려고 했습니다. -1 은 마지막이기 떄문에.
        int target = Integer.MAX_VALUE; // 가장 큰값 으로 초기화했습니다. 이것보다는 무조건 작을테니깐요.

        while (left < right) { // 좌우로 이동해가면서 값을 찾습니다.
            int leftVal = Integer.MAX_VALUE;
            int rightVal = Integer.MAX_VALUE;
            if (numbers[left - 1] + 1 != numbers[left]) {
                leftVal = numbers[left - 1] + 1;
            } else if (numbers[right] + 1 != numbers[right + 1]) {
                rightVal = numbers[right] + 1;
            }
            left++; // 연산이 끝난이후에는 각각 하나씩 증가시켜줍니다.
            right--;
            int max = Math.min(leftVal, rightVal); // 작은값을 맥스로 가져가고
            target = target > max ? max : target; // 진행중인 작은값과 현재 작은값을 비교 해서 업데이트 합니다.
        }
        return target;
    }
}