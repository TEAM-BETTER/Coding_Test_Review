// 시작점 위치에 따라 priority 큐를 만들고
// cpu 처리과정에 따라 Task 내의 startPoint 가 지나면 큐에 넣어주는 방식으로 생각했지만
// 코드를 쓰면서도 제가 뭘 작성하는지 모르겠더라고요 ㅋㅋ..... 
// 저의 생각의 흐름대로 작성할테니 가볍게 읽어주세요 비판 비난 혹은 좋은개선방향 전부 환영입니다 :)

public class CodingTest04_박귀우 {
    // 시작점 의 위치에 따른 구분을 위해 이너클래스 를 하나 생성 했습니다.
    // 테케를 돌려보니 시작점에 따른 정렬된 상태가 아니기에 새로 만들어 주었습니다.
    class SortStart implements Comparator<Task> {
        @Override
        public int compare(Task o1, Task o2) {
            return o1.startPoint - o2.startPoint;
        }
    }

    // 지난번 시화님 이 아메바 푸실때 하신것처럼 하나의 오브젝트에 담을 변수가 많아 따로 클래스 지정했습니다.
    class Task implements Comparable<Task> {
        int num;
        int taken;
        int startPoint;

        Task(int num, int taken, int startPoint) {
            this.num = num;
            this.taken = taken;
            this.startPoint = startPoint;
        }

        @Override
        public int compareTo(Task o) {
            return this.taken - o.taken;
        }
    }

    public int[] solution(int[] start, int[] time) {
        // 정답 배열 담을 리스트
        ArrayList<Integer> answer = new ArrayList<>();
        // 현재의 시간기록을 위해 지정했습니다.
        int timePath = 0;
        Queue<Task> q = new PriorityQueue<>();
        // 이 큐떄문에 오답이 난거 같습니다.
        // 큐생성과 클리어를 cpu 실행중에만 해주어야 할꺼같습니다.
        Task[] task = new Task[time.length];
        for (int i = 0; i < time.length; i++) {
            task[i] = new Task(i, time[i], start[i]);
        }
        Arrays.sort(task, new SortStart()); // 시작 포인트에 따른 분류입니다.
        q.add(task[0]); // 시작 포인트에 따라 하나 추가를 해주고
        int startIdx = 1; // 모든 작업을 순회했는지 체크할 카운터입니다.
        while (!q.isEmpty() && startIdx <= start.length) {
            int size = q.size();
            // 현재 큐에 들어있는 만큼만 poll 을 진행하며 시작합니다.
            for (int j = 0; j < size; j++) {
                Task t = q.poll();
                answer.add(t.num);
                // 여기서 오류가 난거같네요 timepath 에 timeStart 가 추가가 안되 항상 0부터 시작합니다. 최초 q 에 추가할때 time
                // 시작접 업데이트가 필요해보입니다.
                timePath += t.taken;
                // 이 아래 for 루프가 되는 이유가 위에서 시작점에 따른 정렬을 했기때문에 아래와 같은 생각을 해주었습니다.
                // 여기 start length 를 할게 아니라 작업 리스트 들도 하나 만들어서 지워주면서 for루프를 돌아야 할꺼같네요.
                // 여기 for루프는 현재 진행 되는 시간 보다 만약 테스크가 가진 시작점이 작다면 추가를 해줘야하는데 제가 코드 작성을 이상하게 했네요...
                for (int i = startIdx; i < start.length; i++) {
                    if (start[i] < timePath) {
                        q.add(task[startIdx]);
                        startIdx++;
                    }
                }
                // 현재 큐가 비어있지만 startIdx 가 아직 남아 있다면 계속추가를 해주어야 합니다.
                if (q.isEmpty() && startIdx < start.length) {
                    q.add(task[startIdx]);
                    startIdx++;
                }
            }
        }
        return answer.stream().mapToInt(x -> x.intValue()).toArray();
    }
}
