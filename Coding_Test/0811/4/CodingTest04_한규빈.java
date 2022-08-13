package CodingTest4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 슬라이딩 윈도우를 이용하여 문제를 품
 */
public class CodingTest4_한규빈 {
    public static int[] solution(int[] arr, int k) {
        int[] answer = new int[arr.length - k + 1];

        // k개의 숫자를 담을 리스트
        List<Integer> list = new ArrayList<>();

        // 처음에 k개의 숫자를 리스트에 넣고 시작
        for (int i = 0; i < k; i++) {
            list.add(arr[i]);
        }

        // 정렬 후 answer[0] 에 중간 값을 담아 줌
        Collections.sort(list);
        answer[0] = list.get(k / 2);

        // 위에서 0 ~ k - 1까지의 숫자를 담고 시작하였기때문에 1부터 시작
        for (int i = 1; i < arr.length - k + 1; i++) {
            // 두개의 포인터를 하나씩 이동시키면서 슬라이딩 윈도우 시작
            int p1 = i;
            int p2 = k + i - 1;

            // arr의 값이 [6, 4, 2, 4, 10, 15, 16, 15, 17] 일 때
            // 처음에 list에는 [6, 4, 2]가 들어가고 정렬 후 데이터가 [2, 4, 6] 으로 바뀐다
            // 여기서 맨 앞의 인덱스를 삭제하게되면 원하는 값이 나오지 않기 때문에
            // 인덱스를 이용하여 list의 원소를 지우면 안되고 값을 이용하여 원소를 지워줘야
            // 구하려는 중앙값을 정확하게 구할 수 있기 때문에 Integer.valueOf를 이용함
            // 이렇게 값으로 원소 하나를 지워주고 add를 통해 맨뒤에 원소를 삽입 후 재 정렬해 list의 중앙값을 찾아 answer에 넣어 줌
            list.remove(Integer.valueOf(arr[p1 - 1]));
            list.add(arr[p2]);
            Collections.sort(list);
            answer[i] = list.get(k / 2);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 4, 10, 15, 16, 15, 17};
        int k = 5;
        System.out.println(solution(arr, k));

    }
}
