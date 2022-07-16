import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodingTest04_윤성화 {
    public static int[] solution(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();

        int max = Integer.MIN_VALUE;

        int p1 = 0;
        int p2 = p1 + k - 1; // k 만큼 떨어져 있는 인덱스를 가져오기 위함

        while (p2 < arr.length){
            for (int i = p1; i <= p2; i++) { // 맥스값 구하기
                if (arr[i] > max){
                    max = arr[i];
                }
            }
            list.add(max); // 리스트에 추가
            p1++;
            p2++; // 1칸씩 이동
            max = Integer.MIN_VALUE;
        }
        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;

    }

    public static void main(String[] args) {
        int[] arr = {4,2,6,4,2,3};
        int k = 3;
        System.out.println(solution(arr, k));

    }
}