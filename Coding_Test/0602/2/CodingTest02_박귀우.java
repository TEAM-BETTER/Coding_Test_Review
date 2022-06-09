import java.util.Arrays;
import java.util.Stack;

public class CodingTest02_박귀우 {
    public static void main(String[] args) {
        int[] ex01A = { 5, 2, 1, 4, 6 }, ex01B = { 6, 1, 0, 4, 4 };
        int[] ex02A = { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 }, ex02B = { 1 };
        Feedback_Sol f = new Feedback_Sol();
        int result[] = f.feedback_Sol(ex01A, ex01B);
        System.out.println(Arrays.toString(result));
        result = f.feedback_Sol(ex02A, ex02B);
        System.out.println(Arrays.toString(result));
    }

    static class Feedback_Sol {
        public int[] feedback_Sol(int[] a, int[] b) {
            /**
             * 전에 진행했던 길이 에 따라 a,b를 변경하는 방법을 없애고 길이를 변수화 시켜 작성했습니다.
             */
            int maxLen = a.length > b.length ? a.length : b.length;
            int aLenLeft = maxLen - a.length;
            int bLenLeft = maxLen - b.length;

            Stack<Integer> st = new Stack<Integer>();
            int carryVal = 0;
            for (int i = maxLen - 1; i >= 0; i--) {
                /**
                 * 강사님의 나머지 부분 계산하는 것이 인상적이여서 가져와봤습니다.
                 */
                int valA = i - aLenLeft < 0 ? 0 : a[i - aLenLeft];
                int valB = i - bLenLeft < 0 ? 0 : b[i - bLenLeft];
                int sum = valA + valB + carryVal;
                if (sum > 9) {
                    st.push(sum - 10); // 스택을 제대로 활용하기 위해 push 를 이용해 작성합니다.
                    carryVal = 1;
                } else {
                    st.push(sum);
                    carryVal = 0;
                }
            }

            if (carryVal > 0) {
                st.push(1);
            }

            int[] result = new int[st.size()];

            for (int i = 0; i < result.length; i++) {
                result[i] = st.pop(); // 전 솔루션에 없던 팝을 이용해 꺼내 와 배열 에 채워넣는 작업을 진행 했습니다.
            }

            return result;
        }
    }

    class Previous_Sol {
        public int[] solution(int[] a, int[] b) {
            if (a.length < b.length) { // a와 b 모두 다양한 길이로 주어질수 있기때문에 그중 가장 긴값을 항상 a 로 지정합니다.
                int[] tmp = a;
                a = b;
                b = a;
            }
            Stack<Integer> list = new Stack<>();
            for (int i = 0; i < a.length; i++) {
                list.add(a[i]);
            }
            int cur = b.length - 1; // 현재의 포지션 을 위해 작성했습니다, a,b 의 길이가 다르기 때문에 이와같이 작성했습니다.
            int upper = 0; // 더해서 10 이넘어간다면 체크하기위해 넣어뒀습니다.
            for (int i = list.size() - 1; i >= 0; i--) {
                if (cur > -1) {
                    int sum = b[cur] + upper + list.get(i);
                    upper = 0;
                    if (sum > 9) {
                        list.set(i, sum - 10);
                        upper++;
                    } else {
                        list.set(i, sum);
                    }
                    cur--;
                } else if (upper != 0) { // cur을 통해 b의 자릿수가 다 더해지고 그 이후 값 처리입니다.
                    int sum = list.get(i) + upper;
                    upper = 0;
                    if (sum > 9) {
                        list.set(i, sum - 10);
                        upper++;
                    } else {
                        list.set(i, sum);
                    }
                }
            }
            int[] result = list.stream().mapToInt(x -> x).toArray();
            if (upper != 0) { // 위의 연산을 모두 거친이후에도 0 이 남아 있다면 더해주는 구간입니다.
                int[] newResult = new int[result.length + 1];
                System.arraycopy(result, 0, newResult, 1, result.length);
                newResult[0] = 1;
                result = newResult;
            }
            return result;
        }
    }
}