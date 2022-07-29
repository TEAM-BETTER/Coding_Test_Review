// 계수 정렬로 쉽게 풀이 가능
public class Solution {
    public boolean solution(String s, String t) {
        if (s.length() != t.length()) {             // 예외 상황 s, t 길이가 다르면 false 바로 반환 (효율성 테스트 케이스 5번)
            return false;
        }

        int[] arr = new int[26];                    // 알파벳 소문자만 나오므로 알파벳 갯수만큼 26개 배열 생성

        for (int i = 0; i < s.length(); i++) {      // s 문자 알파벳을 한글자씩 char 형태로 바꾸어 arr 배열에 해당 알파벳 index 증가
            arr[s.charAt(i) - 'a']++;               // 'a' 가 index 0 부터 들어가게 됨
        }                                           // ex ) arr[0] => 'a'의 갯수, arr[1] => 'b'의 갯수, arr[2] => 'c'의 갯수

        for (int i = 0; i < t.length(); i++) {      // t 문자 알파벳을 한글자씩  char 형태로 바꾸어 arr 배열에 해당 알파벳 index 감소
            arr[t.charAt(i) - 'a']--;
        }

        for (int j : arr) {                         // arr 배열을 다 확인해서 0이 아닌 값이 있으면 일치하지 않음으로 false 반환
            if (j != 0) {
                return false;
            }
        }
        return true;                                // for 문 돌고 나서 false 가 없으면 일치하므로 ture 반환
    }
}