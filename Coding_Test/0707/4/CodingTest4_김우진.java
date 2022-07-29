package CodingTest7;
import java.util.*;

public class CodingTest4_김우진 {
    /**
     * 1. 주어진 숫자를 가능한 모든 케이스로 쪼갬
     *  만약 int범위를 넘으면 길이를 늘리는 의미가 없으므로 더 이상 늘리지 않음
     * 2. listsize가 3이 될 때 까지는 쪼갠 숫자를 list에 무조건 넣어줌
     * listsize가 3이 되면 list.get(n)=list.get(n-1)+list.get(n-2)가 성립하는지 확인해보고
     * 성립할 때만 재귀함수를 다시 호출 (가지치기)
     * 3. idx값이 nums의 길이 만큼 확인 했으면 주어진 문자열을 다 나눈 것이므로 다시 피보나치 조건에 맞는지 체크
     * 4. 피보나치 조건에 적합하면 해당 값을 answerlist에 옮겨줌 (주어진 케이스에서 피보나치 수열이 성립하는 케이스가 최대 1개라고 가정)
     * 5. answerlist값 리턴
     *
     */
    public static List<Integer> answerList = new ArrayList<>();

    public static void func(int idx, List<Integer> list, String nums) {
        /**
         * 조건에 부합하면 answerList 업데이트
         */
        if (idx >= nums.length()) {
            if (list.size() >= 3) {
                boolean isFibonacci = true;

                for (int i = 2; i < list.size(); i++) {
                    int f1 = list.get(i - 2);
                    int f2 = list.get(i - 1);

                    if (list.get(i) != f1 + f2) {
                        isFibonacci = false;
                        break;
                    }
                }

                if (isFibonacci) {
                    answerList.addAll(list);
                }
            }

            return;
        }

        for (int len = 1; len < Math.min(nums.length(), nums.length() - idx + 1); len++) {
            String num = nums.substring(idx, idx + len);

            try {
                Integer.parseInt(num);
            } catch (Exception e) {
                break;
            }

            int listSize = list.size();

            if (listSize < 3
                    || list.get(listSize - 2) + list.get(listSize - 1) == Integer.parseInt(num)) {
                list.add(Integer.parseInt(num));
                func(idx + len, list, nums);
                list.remove(list.size() - 1);
            }

            if (num.equals("0")) {
                break;
            }
        }
    }

    public static int[] solution(String nums) {
        List<Integer> list = new ArrayList<>();

        func(0, list, nums);

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String nums = "1501515304575";

        int[] answer = solution(nums);
        System.out.print("ANSWER: ");
        for (int a : answer) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
