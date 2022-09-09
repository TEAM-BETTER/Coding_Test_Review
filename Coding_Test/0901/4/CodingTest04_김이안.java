/*
* 수학문제 너무 싫어요..
* 저 수학 못해요..
* */
import java.util.Arrays;
class Solution {

	static int gcd(int x, int y) {
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);
	}

	static int gcdArray(int[] arr, int idx, int length) {		// 주어진 배열의 최대 공약수 찾는 메소드
		if (length == 1)
			return arr[0];
		else if (length == 2)
			return gcd(arr[idx], arr[idx + 1]);
		else
			return gcd(arr[idx], gcdArray(arr, idx + 1, length - 1));
	}

	static int lcm(int a, int b) {	// 약수를 찾기위해 최소공배수 메소드를 만들었습니다.
		return a * b / gcd(a, b);
	}

	public int solution(int[] numsDivide, int[] numsDivided) {
		int answer = 0;
		int gcdNum = gcdArray(numsDivided, 0, numsDivided.length);	// 배열의 최대 공약수 찾기
		int minLcm = Integer.MAX_VALUE;
		for (int i = 0; i < numsDivide.length; i++) {
			if (gcdNum == lcm(gcdNum, numsDivide[i]))		// (최대 공약수, 현재값) 최소 공배수 == 최대 공약수일 시 현재 값이 약수
				minLcm = Math.min(minLcm, numsDivide[i]);	// 제일 작은 약수를 찾습니다.
		}
		if (minLcm == Integer.MAX_VALUE)					// 배열에 약수가 없을 경우
			return -1;
		gcdNum = minLcm;
		for (int i = 0; i < numsDivide.length; i++) {
			if (numsDivide[i] < gcdNum)
				answer++;
		}
		return answer;
	}
}