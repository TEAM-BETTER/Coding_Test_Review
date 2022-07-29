import java.io.IOException;
import java.util.*;

class CodingTest02_박귀우 {
    public static void main(String[] args) throws IOException {
        int[] arr = { 2, 53, 21, 35, 38, 65, 66, 43, 31, 93, 16, 22, 52, 3, 37, 78, 30, 90, 84, 97, 69, 63, 1, 98, 76,
                13, 32, 41, 68, 15, 55, 27, 82, 33, 91, 79, 12, 42, 36, 25, 86, 60, 45, 85, 96, 8, 9, 49, 44, 40, 20,
                11, 18, 58, 71, 95, 26, 23, 88 };
        int target = 1812;
        System.out.println(sol(arr, target));
    }

    public static int sol(int[] arr, int n) {
        Set<Integer> firstSet = new HashSet<>();
        firstSet.addAll(Arrays.stream(arr).boxed().toList());
        if (firstSet.contains(n))
            return 1;
        return recur(firstSet, arr, 1, n);
    }

    // 재귀로 풀수있을꺼 같았지만 시간부족으로 시험종료하고나서 구현했습니다.
    // 현재 세트 안에서 답이 있는경우 리턴 없다면 새로 계산된 셋을 넘겨주는 식으로 생각했습니다.
    /**
     * @param arr    탐색을 해줄 set
     * @param basic  기본 베이스 array
     * @param depth  현재 몇번의 수행이 되었는지 계산해줄 depth
     * @param target 찾고자 하는 값
     * @return
     */
    public static int recur(Set<Integer> arr, int[] basic, int depth, int target) {
        Set<Integer> result = new HashSet<>();
        // 새로운 셋을 다음 재귀로 넘겨주기위해 위와같이 선언했습니다.
        for (int num : arr) {
            for (int i = 0; i < basic.length; i++) {
                int sum = num + basic[i]; // 더한경우
                int multi = num * basic[i]; // 곱한경우
                if (sum == target || multi == target) {
                    result.add(sum);
                    result.add(multi);
                    break;
                }
                // 타겟보다 넘친다면 굳이 추가할필요없어서 버렸습니다.
                if (sum < target) {
                    result.add(sum);
                }
                if (multi < target) {
                    result.add(multi);
                }
            }
        }
        // 만약 추가된 상태라면 현재 뎁스에 +1
        if (result.contains(target)) {
            return depth + 1;
        } else {
            // 아니라면 만들어진 새로운 세트를 넘겨줍니다.
            return recur(result, basic, depth + 1, target);
        }
    }
}
