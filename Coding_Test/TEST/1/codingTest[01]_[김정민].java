class Solution {
    public int solution(int n, int m) {
        int answer = 0;

        for(int i = n; i <= m; i++) {
            //String Buffer의 reverse를 이용하여 문자열을 완전히 뒤집는다.
            String num = i + "";
            String reverse = new StringBuffer(num).reverse().toString();
            // reverse == num이면 회문 숫자 이므로 count 해준다.
            if(num.equals(reverse)) answer++;
        }

        return answer;
    }
}