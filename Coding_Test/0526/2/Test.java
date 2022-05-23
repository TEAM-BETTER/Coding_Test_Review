/*
  프로그래머스 레벨 2 => N개의 최소 공배수
 */
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        /* 해당 배열의 가장 큰 수 */
        int max = arr[arr.length - 1];
        int idx = 1;
        while (true) {
          /* max의 배수, idx는 while 문을 돌며 하나씩 ++ */
            int multiple = max * idx;
          /* trigger === true => 숫자 n개의 최소 공배수 */
            boolean trigger = true;
            for (int num : arr) {
              /* % != 0이면 공배수 X */
                if (multiple % num != 0) {
                    trigger = false;
                    break;
                }
            }
            if (trigger) {
                answer = multiple;
                break;
            }
            idx++;
        }
        return answer;
    }
}
