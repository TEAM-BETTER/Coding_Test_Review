package codiingTest.codingTest10.p4;

// 그리디 문제, 쉬움, 강의에 똑같은 문제 출제
// 갈수 있는 가장 큰 위치를 기록하며 모든 param0를 돌면 해답이 나옴
public class Solution {
    public boolean solution(int[] param0) {
        int len = param0.length;
        int position = 0;                       // 갈수 있는 위치를 저장하기 위한 변수

        for (int i = 0; i < len; i++) {         // param0 를 모두 돌아보는 for 문
            if (position < i) {                 // 갈수 있는 가장 큰 위치보다 현재 위치가 크지 않다면 더이상 앞으로 나갈 수 없다는 뜻이므로
                return false;                   // 맨 끝 배열에 도달 할 수 없음
            } else if (i + param0[i] >= len) {  // 현재 index 값이 position 에 기록 된 값 보다 작다면 현재 index 에서 갈 수 있는 가장 큰 위치 계산
                return true;                    // 그 위치가 맨 끝 index 보다 크다면 끝에 도달 할 수 있음.
            }

            position = Math.max(position, i + param0[i]);   // 위 두개 모두 다 아니라면 position 값을 갈 수 있는 가장 큰 위치로 갱신
        }

        return true;
    }
}

