import java.util.stream.IntStream;
class Solution {
    public int[] solution(int n) {
        return IntStream.range(1,n+1).mapToObj(String::valueOf).sorted().mapToInt(Integer::parseInt).toArray();
    }
}