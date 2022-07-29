package ch04.codingTest8.p1;


// 그리디에서 나왔떤 문제와 비슷했지만 가격이라는 다른 변수가 붙은 문제
// 그리디처럼 풀면 답이 나오지 않았습니다
// 시험이 끝나고 나서 생각해보니 냅색 문제 처럼 풀이하면 될것 같습니다
// 냅색의 배낭의 무개를 시간으로 바꾼다면 비슷하게 풀 수 있을 것 같습니다.
public class Solution {

    private static class Consulting {
        int start;
        int end;
        int price;

        public Consulting(int start, int end, int price) {
            this.start = start;
            this.end = end;
            this.price = price;
        }
    }

    public static int solution(int[] start, int[] end, int[] price) {
        int answer = 0;
        Consulting[] consultings = new Consulting[start.length];
        for (int i = 0; i < start.length; i++) {
            consultings[i] = new Consulting(start[i], end[i], price[i]);
        }


        return answer;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 5, 10, 6, 5};
        int[] b = new int[]{5, 6, 12, 9, 12};
        int[] c = new int[]{10, 40, 30, 20, 50};
        System.out.println(solution(a, b, c));

        a = new int[]{1, 2, 5, 1, 4, 11};
        b = new int[]{10, 9, 6, 3, 9, 15};
        c = new int[]{50, 20, 50, 20, 80, 40};
//        System.out.println(solution(a, b, c));
    }
}