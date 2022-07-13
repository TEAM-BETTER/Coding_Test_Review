import java.util.HashMap;

public class CodingTest02_임요한{
    public int solution(int[] votes) {

        int answer = Integer.MIN_VALUE;
        double majority = votes.length / 2.0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < votes.length; i++) {
            map.put(votes[i], map.getOrDefault(votes[i], 0) + 1);

            if (map.get(votes[i]) > answer && map.get(votes[i]) > majority) {
                answer = votes[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] vote = {1,2,1,3,1,5,1,7,1,8,1,4,1,6,1};
//        int[] vote = {4,3,2,3,3,3,3,1,2,2,3};
//        int[] vote = {10};
        System.out.println(new CodingTest02_임요한().solution(vote));
    }
}