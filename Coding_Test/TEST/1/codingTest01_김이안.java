import java.util.stream.IntStream;

class Solution {
    public int solution(int n, int m) {
        int answer = (int) IntStream.range(n,m+1).mapToObj(String::valueOf).filter(num -> num.equals(new StringBuffer(num).reverse().toString())).count();

        return answer;
    }
}