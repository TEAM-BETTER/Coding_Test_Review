package ch03.codingTest.p5;

import java.util.PriorityQueue;

public class Solution {
    private static class Player implements Comparable<Player> { // 플레이어의 정보를 기록할 class
        int attack;         // 공격력
        int time;           // 현재 단계까직 걸린 시간
        int bossNum;        // 다음 공략해야할 보스의 번호

        public Player(int attack, int time, int bossNum) {  // 생성자
            this.attack = attack;
            this.time = time;
            this.bossNum = bossNum;
        }

        @Override
        public int compareTo(Player o) {                    // PriorityQueue 를 위한 Comparable Override 메소드 구현
            return this.time - o.time;
        }
    }


    public static int solution(int[] reward, int[] health, int[] optional) { // solution 함수
        return bfs(reward, health, optional);
    }

    public static int bfs(int[] reward, int[] health, int[] optional) { // PriorityQueue 를 사용한 bfs
        PriorityQueue<Player> queue = new PriorityQueue<>();
        queue.add(new Player(1, 0, 0));            // 시작 상태를 queue 에 넣어줌 (공격력 1, 시간 0, 잡을 보스 번호 0
        int finishBossNum = optional.length - 1;                         // 마지막 보스 idx 를 변수로 만듬
        while (!queue.isEmpty()) {                                      // bfs 반복 시작
            Player cur = queue.poll();                                  // queue 에서 하니싹 빼서 확인

            if (cur.bossNum == finishBossNum) {                          // 이번에 잡을 보스 번호가 마지막 보스 일 때
                if (optional[cur.bossNum] == 1) {                       // 선택 보스면 스킵하고 현재 까지 걸리 시간 출력
                    return cur.time;
                } else {                                                // 아니라면 지금 공격력으로 현재 보스 잡는 시간 더해서 출력
                    return cur.time + health[cur.bossNum] / cur.attack + (health[cur.bossNum] % cur.attack == 0 ? 0 : 1);
                    // 보스 잡는 시간 계산 = 보스 체력 / 현재 공격력 + (나누고 남은 나머지가 있으면 한대가 더 필요하므로 나머지 있을시 + 1)
                }
            }

            int nextA = cur.attack + reward[cur.bossNum];               // 현재 공격력 + 이 보스를 잡았을 때 보상
            int nextT = cur.time + health[cur.bossNum] / cur.attack + (health[cur.bossNum] % cur.attack == 0 ? 0 : 1);
            // 현재 시간 + 이 보스를 잡았을 떄 드는 시간
            if (optional[cur.bossNum] == 1) {                           // 선택형 보스 일떄
                queue.add(new Player(nextA, nextT, cur.bossNum + 1));           // 선택형 잡았을 때 queue 에 추가
                queue.add(new Player(cur.attack, cur.time, cur.bossNum + 1));   // 선택형 스킵 했을 때 queue 에 추가
            } else {                                                    // 필수 일 때
                queue.add(new Player(nextA, nextT, cur.bossNum + 1));           // 필수 보스 잡은거 queue 에 추가
            }

        }
        return -1;                                                                       // 오류 확인용 return
    }

    public static void main(String[] args) {
        int[] reward = {4, 2, 2, 0, 3, 5};
        int[] health = {10, 20, 20, 20, 40, 30};
        int[] optional = {1, 0, 1, 0, 0, 0};

        System.out.println(solution(reward, health, optional));
    }
}