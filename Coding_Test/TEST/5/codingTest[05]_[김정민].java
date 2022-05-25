class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;

        //각 리그 별로 숫자가 짝수인 사람과 홀수인 사람이 경기를 하게 됨
        //각 리그에 번호를 매기면
        // 홀수인 사람은 / 2 + 1 한 번호가
        // 짝수인 사람은 / 2 한 번호가 동일함을 이용
        while(true) {
            int nextA = (a % 2 == 0) ? a / 2 : a / 2 + 1; // nextA는 다음 번호인 동시에 그룹 번호임
            int nextB = (b % 2 == 0) ? b / 2 : b / 2 + 1;

            // 그룹번호가 같으면 끝
            if(nextA == nextB) break;
            a = nextA;
            b = nextB;
            answer++;
        }

        return answer;
    }
}