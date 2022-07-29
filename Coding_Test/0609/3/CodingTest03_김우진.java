package CodingTest3;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class CodingTest03_김우진 {

    /**
     * Ameba class
     * name: 아메바 이름
     * splitAfterDelay: delay분간 휴식 후 분열하는지 여부
     * timePass: 몇 분 쉬었는지 체크하는 변수
     *
     *      1. 첫번째 아메바를 큐에 넣어줌
     *      2. 초기아메바는 바로 분열 가능, 이름+1
     *      3. 반복문 시작 -->>
     *      4. 시간흐름에 따라 아메바분열(== pop) 과 함께 아메바 분열조건 체크
     *      만약 분열 가능한 아메바의 경우 아메바 2개 생성 +이름 +2 (1마리는 분열 못하는 + 쿨타임넣어서 // 한마리는 바로 분열 가능한)
     *      분열 불가능한 아메바의 경우 -> 분열 불가능아메바 1마리 그대로 시간차감 후 넣어줌
     *      5. 주어진 시간까지 새로 생성된(=이름을 부여받은)아메바 수 return
     *
     */
    public static class Ameba {

        private int name;

        private boolean splitAfterDelay;

        private int timePass;

        public Ameba(int name, boolean splitAfterDelay, int timePass) {
            this.name = name;
            this.splitAfterDelay = splitAfterDelay;
            this.timePass = timePass;
        }

        public boolean getSplitAfterDelay() {
            return this.splitAfterDelay;
        }

        public int getTimePass() {
            return this.timePass;
        }
    }

    public static int solution(int delay, int N) {
        int name = 0;
        Set<Integer> names = new HashSet<>();

        // 일단 첫 번째 아메바 큐에 넣어줌
        Queue<Ameba> q = new LinkedList<>();
        q.add(new Ameba(name, false, 0));
        names.add(name++);
        int cnt = 1; // 해당 분에 몇 개의 아메바를 꺼낼지 체크하는 변수

        for (int time = 0; time < N; time++) {
            int tempCnt = 0; // 해당 분에 몇 개의 아메바를 꺼낼지 체크하는 변수를 업데이트하기 위한 임시 변수

            for (int i = 0; i < cnt; i++) {
                Ameba ameba = q.remove(); // 일단 해당 아메바를 큐에서 꺼내고

                /**
                 * 해당 아메바가 바로 분열하거나
                 * delay분이 경과한 휴식하는 아메바일 경우
                 * 분열을 진행하고 새로운 아메바들을 큐에 넣고
                 * names Set에 이름들을 넣어줌
                 */
                if (ameba.getSplitAfterDelay() == false
                        || (ameba.getSplitAfterDelay() && ameba.getTimePass() == 0)) {
                    q.add(new Ameba(name, false, 0));
                    names.add(name++);
                    q.add(new Ameba(name, true, delay));
                    names.add(name++);

                    tempCnt += 2;
                } else {
                    /**
                     * 휴식하는 아메바일 경우 분을 차감한 상태로 다시 넣어줌
                     * 새로운 이름 아니므로 names에 추가 X
                     */
                    q.add(new Ameba(name, true, ameba.getTimePass() - 1));

                    tempCnt++;
                }
            }
            cnt = tempCnt; // cnt 변수 업데이트
        }
        return names.size();
    }
}