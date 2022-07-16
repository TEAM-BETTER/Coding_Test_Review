import java.util.*;

public class Solution {
    public int[] solution(int[] start, int[] time) {
        Task[] tasks = new Task[start.length];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < start.length; i++) {
            tasks[i] = new Task(i, start[i], time[i]);
        }
        Arrays.sort(tasks, (x, y) -> x.start - y.start); // 배열을 도착시이 짧은 순으로 정렬하여 먼저 도착한 것들 위주로 읽어줌
        PriorityQueue<Task> priorityQueue = new PriorityQueue<>();

        int curTime = 0; // 현재 시간
        int curIndex = 0; // tasks에서 도착해야 할 task를 가르키는 인덱스

        while (true) {
            Task task = null;

            // 현재시간에 큐에 들어가야할 task를 읽어서 우선순위 큐에 넣어주는 코드
            // 급하게짜서 코드 모양이 이쁘지는 않네요 ㅠ
            while (true) {
                if (curIndex < tasks.length) {
                    task = tasks[curIndex];
                    if (task.start <= curTime) {
                        priorityQueue.add(task);
                        curIndex++;
                    }else {
                        break;
                    }
                }else {
                    break;
                }
            }

            // 위에서 큐에 하나도 넣지 못하면 시간이 증가하지 않으므로 +1로 땡겨줬습니다.
            // 지금 생각해보니까 curIndex를 하나 증가시킨 부분의 tasks를 읽어서 그만큼 땡겨주는 것이 더 속도가 좋을거 같아요
            if (priorityQueue.isEmpty()) {
                if (curIndex < tasks.length) {
                    curTime++;
                    continue;
                }
                else break;
            }else {
                Task cur = priorityQueue.poll();
                ans.add(cur.idx);
                curTime += cur.time;
            }
        }

        return ans.stream().mapToInt(x -> (int) x).toArray();
    }
}

class Task implements Comparable<Task>{
    int idx;
    int start; //도착시간
    int time; //처리시간

    public Task(int idx, int start, int time) {
        this.idx = idx;
        this.start = start;
        this.time = time;
    }

    // 우선순위큐 정렬 순서 시간이 짧은 순으로 만약 시간이 같다면 인덱스가 작은 순으로 먼저 나오도록 정의
    @Override
    public int compareTo(Task o) {
        if (this.time == o.time) {
            return this.idx - o.idx;
        }
        return this.time - o.time;
    }
}