// 중복인원을 제거하고 추첨하는 경우의 수 구하기.

import java.util.ArrayList;
public class CodingTest02_윤지용 {
    class Solution {
        static int fac(int a) { // 재귀로 풀려고 함수를 만들었으나 코테시 런타임오류가 발생하였음...
            int result = 1;
            for (int i = a; i > 0; i--) {
                result =  result * i;
            }
            return result;
        }

        public int solution(String[] names) {
            int answer = 0;
            ArrayList<String> nameList = new ArrayList<>(); // 중복 제거하여 이름 담을 리스트
            for (int i = 0; i < names.length; i++) {
                if(nameList.contains(names[i])) { // 중복이면 아무것도 안하고

                } else { // 중복이 없으면 담고
                    nameList.add(names[i]);
                }
            }
            // combination nCr = n! / (r! * (n-r)!) = n X (n-1) X ... (=r 개수만큼) / r!
            int n = nameList.size();
            int r = 4; // 당첨자 수

            /* 그 전에 제출했던 답안
            answer = fac(n) / fac(r) / fac(n-r);   // nCr 부분
            return answer;
            */

            // 아래는 런타임오류 발생하여 수정한 답안
            int tmp = 1; // 잠시 사용할 변수
            for(int i = 0; i < r; i++) { // 당첨자 수만큼 for문 돌려서
                tmp = tmp * n; // n, n-1.. 순차적으로 곱해줌
                n--;
            }
            answer = tmp/24; // 마지막 4!로 나누어줌.
            return answer;
        }
    }
}
/*
[학습내용]
1) int와 long.
오버플로우가 생각보다 많이 남.
2) 중복 체크는 'set'을 이용할 것.
=> for문으로 하나씩 돌아가면 n번 비교해야함.
n명을 비교하려면 시간복잡도는 O(n^2)가 됨.
 */