package CodingTest15;

/**
 * 조건  1 : s의 길이는 6이상 20 이하
 * 		2 : 최소하나 이상의 영문자 소문자, 대문자, 숫자, 특수문자
 * 		3 : 똑같은 문자 3번 반복 X
 * 		4 : 세번 이상 연속된 숫자, 영문자 X (대 소문자 구분 없음)
 * checkLength : 1번 조건 체크
 * isSpecial : 문제에서 주어졌던 specialCharacters 가 아니면 False;
 * checkAtLeastOnce : 2번 조건 체크
 * checkConsecutive: 3, 4번 조건 체크
 *
 * 만약 모든 조건 체크를 통과하면 true, 아니면 false 리턴
 *
 */

public class CodingTest1_김우진 {
	static char[] specialCharacters = {'!', '@', '#', '$', '%', '^', '&', '(',
		')'};

	//길이 조건 체크
	static boolean checkLength(String s) {
		return s.length() >= 6 && s.length() <= 20;
	}

	// 조건에서 제시한 특수문자 맞는지 체크
	static boolean isSpecial(char c) {
		for (char sc : specialCharacters) {
			if (sc == c) {
				return true;
			}
		}
		return false;
	}

	// 조건에서 제시한 문자 하나 이상인지 체크
	static boolean checkAtLeastOnce(String s) {
		int lowerCnt = 0;
		int upperCnt = 0;
		int numberCnt = 0;
		int specialCnt = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c >= 'a' && c <= 'z') {
				lowerCnt++;
			} else if (c >= 'A' && c <= 'Z') {
				upperCnt++;
			} else if (c >= '0' && c <= '9') {
				numberCnt++;
			} else if (isSpecial(c)) {
				specialCnt++;
			}
		}

		return lowerCnt > 0
			&& upperCnt > 0
			&& numberCnt > 0
			&& specialCnt > 0;
	}

	// 3글자 동일한지, 연속하는지 체크
	static boolean checkConsecutive(String s) {
		for (int i = 0; i < s.length() - 2; i++) {
			char a = s.charAt(i);
			char b = s.charAt(i + 1);
			char c = s.charAt(i + 2);

			if (a == b && b == c) {
				return false;
			}

			if (b == a + 1 && c == a + 2) {
				return false;
			}

			if (a == b + 1 && a == c + 2) {
				return false;
			}
		}

		return true;
	}

	public static boolean solution(String s) {
		if (!checkLength(s)) {
			return false;
		}

		if (!checkAtLeastOnce(s)) {
			return false;
		}

		if (!checkConsecutive(s.toLowerCase())) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		String s = "Pas$W0rd!234";
		System.out.println(solution(s));
	}
}