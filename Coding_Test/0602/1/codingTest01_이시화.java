public class Solution {
    public static int solution(int[] numbers) {
        int answer = 0;
        boolean[] isChecked = new boolean[100001];      //sort는 생각보다 많은 시간을 잡아먹기 떄문에 sort를 하지 않고 정렬하기 위한 배열
        // isChecked 배열의 index는 nubers 배열의 숫자, true 이면 숫자가 있다는 뜻
        for (int number : numbers) {                    // numbers 의 숫자가 있는지 없는지 isChecked 배열에 체크
            isChecked[number] = true;
        }

        boolean isBlocked = false;                      // isChecked 배열 중간에 빠진 숫자가 있는지 없는지 체크하는 boolean
        for (int i = 0; i < isChecked.length; i++) {    // isChecked 배열 순회하면서 숫자 체크
            if (isChecked[i]) {                         // 숫자가 시작되면 isBlocked 을 true 로 바꾸고 구멍이 뚤릴 때 체크
                isBlocked = true;
            } else {
                if (isBlocked) {
                    answer = i;                         // 연속된 숫자가 시작되었고 중간에 숫자가 빈다면 isBlocked 가 ture 이면 구멍 뚫린것이므로 return
                    return answer;
                }
            }
        }


        return answer;
    }
}
