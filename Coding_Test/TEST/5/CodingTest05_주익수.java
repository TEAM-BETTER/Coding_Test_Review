/**
 * 금일 프로그래머스 5번 문제
 */

class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;

        while (true) {
            if (Math.abs(a - b) == 1)
                break;
            a = isEvenNumber(a);
            b = isEvenNumber(b);
            answer++;
        }

        return answer;
    }

    public int isEvenNumber(int num) {
        return num % 2 == 0 ? num / 2 : num / 2 + 1;
    }
}