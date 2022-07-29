package ch03.codingTest.p1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static class Node {                     // 마을 사람을 담을 class
        int num;                                    // 마을 사람 번호
        List<Integer> trustList;                    // 이 사람이 믿는 사람들을 담을 배열

        public Node(int num, List<Integer> trustList) { // 생성자
            this.num = num;
            this.trustList = trustList;
        }

        public void add(Node p) {                   // trustList 에 믿는 사람 넣어주는 메소드   (없어도 되지만 있지만 코드 간결을 위해)
            this.trustList.add(p.num);
        }

    }

    public static int solution(int N, int[][] trust) {
        int answer = -1;
        Node[] listP = new Node[N + 1];                 // 사람들을 배열로 받아서 idx 를 사람 번호로 일치시킴

        for (int i = 1; i < N + 1; i++) {               // 초기 작업 (num 에 번호 넣어주고 trustList 초기화)
            listP[i] = new Node(i, new ArrayList<>());  // 여기서 new ArrayList() 안해주면 NullPointException 나와요!!
        }

        for (int[] ints : trust) {                      // trust 에 있는 믿는사람 을 listP 에 각각 기록
            listP[ints[0]].trustList.add(ints[1]);
        }

        for (int i = 1; i < N + 1; i++) {               // 믿는 사람이 없는 사람이 판사이므로 trustList 의 size 가 0 인 사람을 찾으면 정답!
            if (listP[i].trustList.size() == 0) {
                answer = listP[i].num;
                break;                                  // 시간 절약을 위해 찾으면 for 문 탈출
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3}, {2, 3}};

        System.out.println(solution(3, arr));
    }
}
