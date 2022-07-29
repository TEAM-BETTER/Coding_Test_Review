package ch03.codingTest.p3;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<Ameba>[] amebaTimeList;             // idx 가 분을 나타내는 ameba 의 상태를 저장하는 배열
                                                                // 이 배열은 2차원 배열과 비슷합니다.
                                                                // {{new ArrayList}. {new ArrayList}. {new ArrayList}}
                                                                // 이런 구조 입니다!!

    private static class Ameba {                                // 아메바 를 나타네는 class
        int time;                                               // 아메바가 생성되고나서 얼마나 시간이 지났는지 기록
        boolean split;                                          // 분열이 가능한 상태인지 알려주는 boolean

        public Ameba(int time, boolean split) {                 // 생성자
            this.time = time;
            this.split = split;
        }
    }

    public static int solution(int delay, int N) {
        int answer = 0;
        amebaTimeList = new ArrayList[N + 1];                   // amebaTimeList 배열 초기화
        for (int i = 0; i < N + 1; i++) {
            amebaTimeList[i] = new ArrayList<>();               // 각각의 idx 마다 ArrayList 초기화 ( 이거 없으면 NullPointException!! )
        }

        amebaTimeList[0].add(new Ameba(0, true));    // 첫 아메바 넣어줌
        for (int i = 0; i < amebaTimeList.length - 1; i++) {    // 매 분마다 분열하므로 1분씩 지날때마다 연산을 해줌!!(이 방법은 delay 가 정수 임을 가정하고 푼것)
            culAmebaCount(delay, N, i);                         // 마지막 시간인 N 분에서는 분열을 하면 안되니까 N - 1 까지만 연산
        }


        for (ArrayList<Ameba> amebas : amebaTimeList) {         // amebaTimeList 에 들어있는 아메바 갯수를 모두 더하면 정담 완성!!!
            answer += amebas.size();
        }

        return answer;
    }

    public static void culAmebaCount(int delay, int N, int cur) {           // 매 분마다 결과를 계산하는 연산
        for (int i = 0; i < amebaTimeList[cur].size(); i++) {               // amebaTimeList 의 cur idx 에 ArrayList 의 모든 인자를 확인 해보는 for 문
            Ameba nowAmeba = amebaTimeList[cur].get(i);                     // ArrayList 인자를 하나 꺼내어 놓고 사용
                                                                            // 이거 없으면 "amebaTimeList[cur].get(i)" 이 문항을 계속 써줘야함
            int nowAmebaTime = nowAmeba.time;                               // nowAmeba.time 이렇게 사용하면 사용할 때 마다 함수 연산이므로 변수로 빼놓음 위 변수 nowAmeba 와 같음

            if (nowAmeba.split) {                                           // 분열 가능한 아메바

                amebaTimeList[cur + 1].add(new Ameba(0, true));  // 분열 가능한 아메바 하나 추가!
                amebaTimeList[cur + 1].add(new Ameba(0, false)); // 불가능한 아메바 하나 추가!!

            } else {                                                        // 불가능한 아메바
                if (nowAmebaTime >= delay) {                                // 불가능한 아메바라도 delay 가 지났는지 확인 지났으면 위와 같이 분열
                    amebaTimeList[cur + 1].add(new Ameba(nowAmebaTime - delay, true));
                    amebaTimeList[cur + 1].add(new Ameba(nowAmebaTime - delay, false));
                } else {                                                    // 안지났으면 아메바 시간을 + 1 해주고 다음 배열에 추가
                    amebaTimeList[cur + 1].add(new Ameba(nowAmebaTime + 1, false));
                    amebaTimeList[cur].remove(nowAmeba);                    // 나중에 총 배열 사이즈로 아메바 갯수를 측정할거라 분열 못한 것은 지워줌
                    i--;                                                    // 현재 확인한 아메바를 지웠으니 현재 아메바 보다 위에있는 인자들의 idx 가 줄어듬
                                                                            // 그것을 맞춰주기 위해 다음 idx 검사를 +1 하지 않고 넘어가기 위한 i 값 감소
                }
            }
        }
    }
}