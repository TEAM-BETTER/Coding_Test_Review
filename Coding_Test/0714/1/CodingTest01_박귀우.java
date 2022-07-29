import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] start, int[] end, int[] price) {
        List<Schdule> schdule = IntStream.range(0, start.length).boxed()
                .map(i -> new Schdule(start[i], end[i], price[i]))
                .sorted()
                .collect(Collectors.toList());
        int[] dp = new int[Arrays.stream(end).max().getAsInt()];

        for (Schdule s : schdule) {
            for (int j = s.end; j < dp.length; j++) {
                dp[j] = Math.max(dp[s.start] + s.price, dp[j]);
            }
        }
        return dp[dp.length - 1];
    }

    class Schdule implements Comparable<Schdule> {
        int start;
        int end;
        int price;

        Schdule(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }

        @Override
        public int compareTo(Schdule o) {
            return this.end - o.end;
        }
    }
}
