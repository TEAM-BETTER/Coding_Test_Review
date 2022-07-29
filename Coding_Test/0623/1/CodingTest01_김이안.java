import java.util.Arrays;
/*
각 문자열을 정렬해서 비교하는 방식입니다.
 */
class Solution {
    public boolean solution(String s, String t) {
        if(s == null || t == null){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        //예외처리 입니다. 예외처리를 안하면 감점이 있었던걸로 기억하네요
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        char[] tArr = t.toCharArray();
        Arrays.sort(tArr);
        // 각 문자열 정렬
        if(new String(sArr).equals(new String(tArr))){ // 정렬된 문자열을 equals 함수로 비교합니다.
            return true;
        }else return false;
    }
}