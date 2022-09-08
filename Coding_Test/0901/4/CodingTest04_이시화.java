package codiingTest.codingTest15.p4;

import java.util.Arrays;

// divided 의 최대공약수를 구한 후
// 최대공약수의 약수가 Divide 에 포함되어 있으면 그 숫자 보다 작은 숫자를 지운 갯수를 리턴
// 최대 공약수는 유클리드 호제법을 사용
public class Solution {
    public int solution(int[] numsDivide, int[] numsDivided) {
        int answer = 0;
        int gcd = gcd(numsDivided[0], numsDivided[1]);      // 최대공약수 구하는 부분
        for (int i = 2; i < numsDivided.length; i++) {
            gcd = gcd(gcd, numsDivided[i]);
            if (gcd == 1) {
                break;
            }
        }

        Arrays.sort(numsDivide);                            // Divide 의 가장 작은 부분부터 비교하기 위해 정렬
        for (int i = 0; i < numsDivide.length; i++) {       // Divide 배열을 돌면서 최대 공약수의 약수가 있는지 확인
            if (numsDivide[i] == gcd || gcd % numsDivide[i] == 0) { // 약수가 있다면 이전 인덱스를 모두 지워야 하므로 인덱스 반환
                return i;
            }
            if (numsDivide[i] > gcd) {                      // 최대공약수 보다 커진다면 나눌 수 있는 수가 없는 것으로 -1 리턴
                return -1;
            }
        }

        return answer;
    }

    int gcd(int x, int y) {                                 // 유클리드 호제법 최대 공약수 구하는 메소드
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}