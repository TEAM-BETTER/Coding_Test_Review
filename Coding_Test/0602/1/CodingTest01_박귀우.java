import java.util.Arrays;

public class CodingTest01_박귀우 {
    public static void main(String[] args) {
        int[] ex01 = { 9, 4, 2, 3, 7, 5 };
        int[] ex02 = { 1, 3 };
        Feedback_Sol f = new Feedback_Sol();
        System.out.println(f.feedback_Sol(ex02));
    }

    /**
     * 기존에 쓸데 없이 길게 작성한 이분탐색 부분을 지우고 for문 2번을 이용해 찾는 방법 으로 변경
     */
    static class Feedback_Sol {
        public int feedback_Sol(int[] arr) {
            // 시화님 의 배열 로 숫자 일치시켜 정렬 하는것이 인상적이여서 보고 따라했습니다.
            int[] numChecker = new int[10001];
            int minVal = Integer.MAX_VALUE; // 가장 큰값 및 작은값으로 초기화
            int maxVal = Integer.MIN_VALUE;

            for (int i = 0; i < arr.length; i++) { // for문을 돌며 검색
                numChecker[arr[i]] = arr[i];
                if (arr[i] < minVal)
                    minVal = arr[i];
                if (arr[i] > maxVal)
                    maxVal = arr[i];
            }
            for (int i = minVal; i <= maxVal; i++) {
                if (numChecker[i] == 0) {
                    return i;
                }
            }
            return -1; // 강사님이 언급하신 마무리 처리 해주는부분 추가했습니다.
        }
    }

    class Previous_sol {
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
}