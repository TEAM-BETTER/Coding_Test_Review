import java.util.ArrayList;
import java.util.Comparator;
// 효율성이 8/10점이 나옴...
public class CodingTest01_윤지용 {
    public static int solution(int[] numbers) {
        int answer = 0;

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            arr.add(numbers[i]);
        }
        arr.sort(Comparator.naturalOrder()); // 배열을 리스트로 옮겨서 정렬.

        for (int i = 0; i < arr.size(); i++) { // 리스트 돌면서 다음 수하고 1차이가 나는게 아니면 멈추고 출력
            if (arr.get(i + 1) - arr.get(i) != 1) {
                answer = arr.get(i) + 1;
                break;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 4, 5, 2, 6, 7, 2, 8}));

    }
}
