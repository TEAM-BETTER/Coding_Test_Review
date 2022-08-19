package CodingTest12;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. isAloneA 메서드로 'a' 문자가 단독인지 체크
 *
 * 2. 문자열 s가 "a"가 될 때 까지 while 반복
 *
 * 3. s.charAt(i) 가 'a' 단독이면 temp 에 'a' 넣어주고 양 옆 문자도 'a'로 변환
 *      단독이 아니면 'a' 한번만 temp 에 넣어주고 cnt 로 몇 번 반복하는지 체크
 *      cnt + i 로 반복되는 a 값 만큼 index 건너뛰기
 *
 * 4. 3번으로 문자열 s 연산 끝났으면 temp 에 쌓아둔 문자들 s 에 담고
 *      연산 한번 끝났으면 answer++, 새로운 s로 3번 연산 반복
 */

public class CodingTest1_김우진 {

    static char A = 'a';

    static boolean isAloneA(int idx, String s) {
        // 왼쪽 문자가 존재하고 왼쪽 문자가 a면 단독 아님
        if (idx > 0 && s.charAt(idx - 1) == A) {
            return false;
        }

        // 오른쪽 문자가 존재하고 오른쪽 문자가 a면 단독 아님
        if (idx < s.length() - 1 && s.charAt(idx + 1) == A) {
            return false;
        }

        // 위 두 조건에 해당하지 않으면 단독임
        return true;
    }

    public static int solution(String s) {
        int answer = 0;

        // 문자열 s가 "a"가 될 때까지 반복
        while (!s.equals("a")) {

            List<Character> temp = new ArrayList<>();

            for (int i = 0; i < s.length(); i++) {

                // i 번째 인덱스가 a가 아니면 바로 temp 리스트에 추가
                if (s.charAt(i) != A) {
                    temp.add(s.charAt(i));

                    continue;
                }

                 // 단독 a일 경우, 왼쪽이 존재하면 왼쪽을 a로 치환 -> temp 에 a 추가
                 // 오른쪽이 존재하면 A 추가 (i + 1번째 문자에 대해서도 처리를 했으므로 i를 1 증가시킨다)
                if (isAloneA(i, s)) {
                    if (temp.size() > 0) {
                        temp.set(temp.size() - 1, A);
                    }

                    temp.add(A);

                    if (i != s.length() - 1) {
                        temp.add(A);

                        i++;
                    }

                    continue;
                }

                // 단독 A가 아닌 경우 a 추가 후 cnt 체크
                temp.add(A);
                int cnt = 0;

                while (i + cnt < s.length() && s.charAt(i + cnt) == A) {
                    cnt++;
                }

                // 다음 인덱스는 현재 인덱스 기준 처음으로 a가 아닌 곳으로 위치해야함
                i += cnt == 0 ? 0 : cnt - 1;
            }

            s = "";

            for (Character c : temp) {
                s += c;
            }

            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "azbacefbaaaa";

        System.out.println(solution(s));
    }
}