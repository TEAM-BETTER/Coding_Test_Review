class Solution {
    public int solution(int n, int m) {
        int answer = 0;
        for (int i = n; i <= m; i++) {
          /*
          뒤집어서 같으면 회문이고 아니면 회문이 아니기 때문에
          StringBuilder를 이용해 i값을 revese시키고 기존 i와 비교
          */
            String str = new StringBuilder(Integer.toString(i)).reverse().toString();
            if (str.equals(Integer.toString(i))) answer++;
        }
        return answer;
    }
}
