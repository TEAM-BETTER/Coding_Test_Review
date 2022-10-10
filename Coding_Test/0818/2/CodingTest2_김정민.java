import java.util.*;

/*
* 시간초과가 나서 12점 짜리 코드입니다 ㅠ
* set을 이용해서 중복을 제거한 합을 구한후 target에 가장 가까운 원소를 찾으려고 시도했습니다.
* */
class Solution {
    public int solution(int[] arr, int target) {
        int answer = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;

        int[] newArr = removeDuplicatedElement(arr);
        ArrayList<Integer> sums = makeSums(newArr);
        Collections.sort(sums);

        // 문제에 조건에 맞는 값을 찾는다.
        for (Integer elem: sums) {
            int diff = Math.abs(target - elem);
            if (diff < minDiff) {
                minDiff = diff;
                answer = elem;
            }
        }

        return answer;
    }

    // 3중 for 문을 이용해서 중복을 제거한 합을 구한다.
    public ArrayList<Integer> makeSums(int[] newArr) {
        Set<Integer> sums = new HashSet<>();
        for (int i = 0; i < newArr.length-2; i++) {
            for (int j = i+1; j < newArr.length-1; j++) {
                for (int k = j+1; k < newArr.length; k++) {
                    sums.add(newArr[i] + newArr[j] + newArr[k]);
                }
            }
        }

        return new ArrayList<>(sums);
    }

    // set을 이용해 숫자 중복 제거
    public int[] removeDuplicatedElement(int[] arr) {
        int[] ret;

        Set<Integer> set = new HashSet<>();
        for (int elem: arr) {
            set.add(elem);
        }

        ret = new int[set.size()];

        ArrayList<Integer> list = new ArrayList<>(set);
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }

        return ret;
    }
}