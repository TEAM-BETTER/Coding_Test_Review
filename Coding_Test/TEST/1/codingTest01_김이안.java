import java.util.stream.IntStream;

class Solution {
    public int solution(int n, int m) {
        int answer = (int) IntStream.range(n,m+1).  // N~M까지 수를 range 함수를 이용해 추가
                mapToObj(String::valueOf).          // String 자료형으로 변환
                filter(num -> num.equals(new StringBuffer(num).reverse().toString())).  // 문자열과 뒤집은 문자열이 같지 않는 데이터를 필터
                count();

        return answer;
    }
}