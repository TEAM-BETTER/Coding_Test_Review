/*
* 16점 코드입니다. 1번에서 시간을 너무 많이 썼네요 ㅠㅠ
* 코드는 간단하게 각 조건을 체크합니다.
* */
import java.util.*;

class Solution {
	public boolean solution(String s) {
		String specialChars = "!@#$%^&*()";			// 특수문자 조건을 확인하기 위해서 String::contains를 씁니다.
		if (s.length() < 6 || s.length() > 20)		// 길이 조건
			return false;

		boolean includeSmall = false;
		boolean includeLarge = false;
		boolean includeNumbers = false;
		boolean includeSpecial = false;
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i);
			if (c >= 'A' && c <= 'Z')				// 대문자 조건 판별
				includeLarge = true;
			if (c >= 'a' && c <= 'z')				// 소문자
				includeSmall = true;
			if (c >= '0' && c <= '9')				// 숫자
				includeNumbers = true;
			if (specialChars.contains((char) c + ""))	// 특수문자
				includeSpecial = true;
		}
		if (!includeLarge || !includeSmall || !includeNumbers || !includeSpecial)
			return false;

		Map<Character, Integer> map = new HashMap<Character, Integer>();	 // 중복되는 문자를 찾기위한 map
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
			if (i <= s.length() - 3) {		//연속된 문자를 판별
				char first = Character.toLowerCase(s.charAt(i));
				char second = Character.toLowerCase(s.charAt(i + 1));
				char third = Character.toLowerCase(s.charAt(i + 2));		// 거꾸로 연속되는 걸 생각 못했네요 ㅠㅠ
				if (first == second - 1 && second == third - 1)
					return false;
			} else if (map.get(s.charAt(i)) >= 3 && !specialChars.contains(s.charAt(i) + ""))	// 중복되는 문자 판별
				return false;
		}
		return true;
	}
}