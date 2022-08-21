
/**
 * 16점 짜리 코드입니다.
 * 엄청 코드가 더러워서 설명이 매우 부끄럽네요
 * 1. 공백을 제거해주기
 * 2. 반복문을 통해 숫자의 시작점 부터 끝점 까지 이어붙입니다.
 * 3. 0 의 값 들을 통합해 필터링을 해주고
 * 4. string 의 길이에 따라 parse 를 정해줍니다.
 */

import java.util.*;

class Solution {
    public int solution(String s) {
        s = s.trim(); // 공백제거
        char[] arr = s.toCharArray(); // 숫자가 길어질수 있어 arr 로 선언
        int idx = 0; // while 문 내의 인덱스 관리 를 위해 선언
        String answer = "";

        boolean isMinus = false; // + - 기록 용 변수
        boolean isPlus = false;

        while (idx < arr.length) { // for loop 은 마지막 까지 돌아야 합니다.
            if (arr[idx] == ' ') { // 공백이 있다면 재낍니다.
                idx++;
                continue;
            }
            // + - 값 정리
            if (arr[idx] == '-') { // -값 업데이트
                if (isPlus)
                    isPlus = false; // plus 값 업데이트
                isMinus = true;
            }
            if (arr[idx] == '+') {
                if (isMinus)
                    isMinus = false;
                isPlus = true;
            }
            // 숫자가 나온다면 for loop 을 이용해 숫자 끝까지 가기
            if ('0' <= arr[idx] && arr[idx] <= '9') {
                for (int i = idx; i < arr.length; i++) {
                    if ('0' <= arr[i] && arr[i] <= '9') {
                        answer += arr[i];
                        idx = i; // 모두 같은 숫자인경우 를 위해 이렇게 업데이트
                    } else {
                        idx = arr.length;
                        break;
                    }
                }
            }
            idx++;
        }

        if (answer.length() == 0)
            return 0;

        // 앞자리 숫자가 0인경우를 위해 제거
        if (answer.charAt(0) == '0') {
            int cnt = 0;
            while (cnt < answer.length()) {
                if (answer.charAt(cnt) != '0') {
                    break;
                }
                cnt++;
            }
            answer = answer.substring(cnt);
        }
        // 0을 제거 이후에 남은게 없다면 리턴
        if (answer.length() == 0)
            return 0;

        if (answer.length() > 10) { // 10 은 int 의 최고자릿수 와 같다 이거보다 크다면 맥스 미니멈 으로 리턴
            if (isMinus)
                return Integer.MIN_VALUE;
            if (isPlus)
                return Integer.MAX_VALUE;
        } else if (answer.length() == 10) { // 길이가 같다면 long 을 이용해 구분
            long ans = isMinus ? Long.parseLong(answer) * -1 : Long.parseLong(answer);
            if (ans > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            else if (ans < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            else
                return (int) ans;
        } else { // 위에 두조건이아니라면 int 범위안
            return isMinus ? Integer.valueOf(answer) * -1 : Integer.valueOf(answer);
        }
        // 이거없으면 에러나여
        return 1;
    }
}