class Solution {
    public int solution(int n, int m) {
        int answer = 0;

        for (int i = n; i < m; i++) {
            // 1 ~ 9 까지는 대칭비교할 숫자가 없기 때문에 모두 포함되어 추가합니다.
            if (i < 10) {
                answer += 1;
            } else {
                // 10이상부터 대칭 확인
                String temp = Integer.toString(i); // int 타입을 String으로 변환 @숫자양쪽의 접근하기 위함.
                int left = 0;
                int right = temp.length() - 1;
                boolean isMatch = true;
   
                // ex) 현재 수의 대칭되는 위치에 있는 수들을 비교 ex) 11 -> 1, 1  1001 -> 1, 1 비교 0, 0 비교
                while (left < right) {
                    // 1011 -> 1, 1 비교 조건을 만족하지 않기에 else문 실행, 실행 후 0, 1을 비교 일치하지 않는 조건을 만족 if문 실행
                    if (temp.charAt(left) != temp.charAt(right)) {
                        isMatch = false;
                        break;
                    } else { // 왼쪽을 오른쪽으로 한칸 이동, 오른쪽을 왼쪽으로 한칸이동
                        left++;
                        right--;
                    }
                }

                // 수의 대칭되는 위치에 있는 수들이 모드 같을 때, 값을 증가시킨다.
                if (isMatch) {
                    answer += 1;
                }
            }
        }

        return answer;
    }
}