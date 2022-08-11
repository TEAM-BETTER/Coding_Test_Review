/**
 * 시간안에 풀지못하고 종료후 새로 구현했습니다. 너무화나서 끝나고 새로 구현해봤습니다. 될지는 모르겠네요.
 * int 배열을 생성해서 그배열 안에 계속 업데이트 해주는 겁니다.
 * int 배열을 두개로 만들어서도 해봤는데 처리하기가 힘들고 복잡해져서 그냥 for 문안에 새로 만들어서 업데이트 해주었습니다.
 * 예시 15223
 * 0 1 2 3 4 5 6 7 8 9
 * 1번 실행 1 2 1 1
 * 2번실행 4 2 1 1
 * 이런 느낌을 가져가고 싶었는데 결국 끝나고 구현 했네요 ... 혹시 문제될 부분 있으면 알려주세요
 * 토요일날 제출해보 겠습니다.
 */

class Solution {
    public int solution(int n, int num) {
        int[] nums = new int[10];
        char[] arr = String.valueOf(num).toCharArray();
        for (int i = 0; i < arr.length; i++) {
            nums[arr[i] - '0']++;
        }

        for (int i = 0; i < n - 1; i++) {
            int[] noob = new int[10]; // 배열 업데이트 해줄 친구 새로이 선언
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] != 0) {
                    noob[j]++;
                    noob[nums[j]]++;
                }
            }
            nums = noob;
        }
        StringBuilder answer = new StringBuilder(); // 그냥 스트링 했었는데 인텔리가 바꿔줬네요
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                answer.append(i).append(nums[i]);
            }
        }
        return (int) Long.parseLong(answer.toString()) % 10004;
    }
}