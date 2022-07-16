import java.util.*;

public class CodingTest02_윤성화 {
    public static int solution(int[] amount, int[] value, int[] stomach) {
        int answer = 0; // 먹은 고기의 가치 값
        int max = Integer.MIN_VALUE; // 가장 가치가 높은 고기 값
        int idx = 0; // 가장 가치가 높은 고기 값의 idx
        int sum = 0; // 먹을 수 있는 고기의 총 량
        int getLastIdx = 0;

        for (int i = 0; i < stomach.length; i++) {
            sum += stomach[i];
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int v : value){
            list.add(v);
        }

        for (int i = 0; i < value.length; i++) { // 가장 가치가 높은 고기의 값과 인덱스값
            if (max < value[i]){
                max = value[i];
                idx = i;
            }
        }


        if (amount[idx] % amount.length == amount[idx]){ // 가장 가치가 높은 고기를 나눠먹지 못할 때
            list.remove(idx); // 고기를 뺌
        }else{ // 가치가 높은 고기를 나눠 먹었을 때
            sum -= (amount[idx] / amount.length) * stomach.length; // (가장 가치가 높은 고기의 양 / 사람 수) * 사람수
            answer += list.get(idx) * (amount[idx] / amount.length) * stomach.length; // 먹은만큼 값 증가
            list.remove(idx); // 고기를 뺌
        }

        Collections.sort(list, Collections.reverseOrder()); // 가장 가치가 큰 고기부터 먹기 위해


        for (int i = 0; i < list.size() - 1; i++) { // 마지막 고기 전까지 반복
            if (sum <= 0) { // 더 먹었다면
                getLastIdx = i; // 인덱스 저장해놓기
                break;
            } else {

                Integer[] arr = Arrays.stream(value).boxed().toArray(Integer[]::new);
                int getIdx = Arrays.asList(arr).indexOf(list.get(i));
                answer += list.get(i) * amount[getIdx]; // 먹은 가치 * 먹은 양
                sum -= amount[getIdx]; // 먹은 개수만큼 빼줌
            }
        }

        if (sum > 0) { // 만약 더 먹을 수 있으면
            answer += list.get(list.size() - 1) * sum; // 가장 가치가 낮은 고기를 남은만큼 먹음
        } else if (sum < 0) {
            answer -= value[getLastIdx] * sum * -1; // 마지막으로 먹은 고기를 뱉음(?)
        } else {
            return answer;
        }


        return answer;

    }

    public static void main(String[] args) {
        int[] amount = {7,10,4,5};
        int[] value = {5,4,3,1};
        int[] stomach = {4,6,2,8};
        System.out.println(solution(amount, value, stomach));

    }
}