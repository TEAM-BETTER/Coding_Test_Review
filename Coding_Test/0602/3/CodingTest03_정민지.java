import java.util.*;

/*
  새로 제출 하기 전 창이 닫혀버려서 이 코드가 확실하지는 않습니다.. ㅜㅜ 토요일에 확인하려고요!
  처음에는 뭔가 stack이나 Deque나 하여튼 이번주 코테 진도 가이드가 그러니까 그런 자료구조를 이용해보자 했는데
  아직 그리 익숙하지 않다보니 제대로 된 로직이 전혀 나오지 않아 중간에 아예 노선을 틀어서
  그냥 제가 가장 익숙하게 잘 쓰는 문자열 함수들을 이용했습니다.

  제가 생각한 풀이 방법은 다음과 같습니다.
  1. 가장 안쪽의 괄호, 또는 가장 뒤에 있는 괄호부터 접근 => 우선 해당 괄호의 시작 idx와 끝 idx를 가져옴.
      끝 부분 idx를 가져올 때는 start idx 뒤의 괄호를 가져와야 하기 때문에 fromIdx를 지정함,
      만약 지정하지 않으면 오류가 발생할 수도 있음.
  2. 괄호 시작 옆에는 항상 repeat될 숫자가 적혀있음. 해당 부분 인덱스는 start - 1로 접근하는데 char - '0'로 int 변환
  3. 그 다음에 괄호 안 문자열에 접근하는데 괄호 부분은 빼고 가야하기 때문에
      start + 1부터 end까지 substring을 통해 잘라와서 repeat만큼 repeat하여 str 변수에 넣음.
  4. 그리고 시작 idx 전까지 잘라낸 문자열과 repeat하여 변환한 문자열, 끝 idx부터 끝까지 잘라낸 문자열을 더함.
  5. 만약 해당 문자열에 {가 있다면 아직 문자열 변환이 완료되지 않은 것이니 사라질 때까지 반복해서 작업

  ex: f2{a3{bc}}z가 넘어오면 우선 가장 안 쪽의 괄호 => "f2{a3" +  => { bc } <= + "}z" { bc } 부분을 가져옴
  "f2{a" + => 3 <= {bc} + "}z" 여기세서 반복될 repeat 부분은 3이기 때문에 bc를 3만큼 반복하여 bcbcbc로 변환
  => 그 결과 f2{abcbcbc}z로 바뀌었음. 여기에서 괄호가 있는지 체크하니 아직 있기 때문에 다시 한 번 반복하여
  "f2" => {abcbcbc} <= z에서 { abcbcbc } 부분을 가져옴, 그리고 반복될 repeat 부분은 2이기 때문에
  abcbcbcabcbcbc로 변환 => 그 결과 fabcbcbcabcbcbcz로 문자열이 변경됐음.
  이후 다시 한 번 해당 문자열에 괄호가 있는지 체크하니 더이상 존재하지 않기 때문에 그대로 변환된 문자열 반환

  혹시 코드나 설명 읽어보시고 이상한 부분이나 잘못된 로직이 있다면 코멘트로 꼭 알려주세요! ㅠㅠ
*/
public class Solution {
    public static String solution(String code) {
    	while (code.contains("{")) {
    		// 가장 내부 괄호 시작
    	   	int start = code.lastIndexOf("{");
    	   	// 가장 내부 괄호 닫힘 부분, start 지점 이후로 잡아줘야 함.
        	int end = code.indexOf("}", start);
        	// 괄호 시작의 바로 앞은 repeat될 숫자
        	int repeat = code.charAt(start - 1) - '0';
        	// repeat만큼 문자열 반복
        	String str = code.substring(start + 1, end).repeat(repeat);
        	// 괄호가 있던 곳전까지 잘라낸 문자열 + 풀어낸 문자열 + 괄호가 닫히던 곳 이후의 문자열
        	code = code.substring(0, start - 1) + str + code.substring(end + 1);
    	}
    	return code;
    }
    public static void main(String[] args) {
//    	String str = "f2{a3{bc}}z";
//    	String str = "f2{a}3{b}";
//    	String str = "f2{a}3{b}2{a3{bc}}z";
    	System.out.println(solution(str));
	}
}
