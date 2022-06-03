/*
미제출 문항입니다. 정답을 보장하지 않습니다.
이렇게 복잡한 문제가 아닐거같은데 상당히 길게 작성되었네요.
효율성 검증 해보고싶네요.

 문제전략

 각 배열을 for문으로 더하여 sum과 carry의 리스트를 담아주어 sum과 carry의 최종 연산으로 답을 내기로 함.

 1. 더해주는 값을 기준으로 배열을 맞춰주어야함.
  1) 더해줄 값의 배열 길이를 구함 sumLength 메소드
  2) 배열 길이를 기준으로 자리수가 미진하면 0을 가질수 있도록 정리 arrangeList 메소드

 2. 정리된 배열을 기준으로 for문으로 sum값과 carry 값을 각 리스트에 입력
 3. carry값은 두번째 자리수부터 시작하므로, 마지막 항에 0을 add

 */
import java.util.ArrayList;
import java.util.Arrays;

public class Problem2 {

    //더해진 값의 배열길이 찾기
    public int sumLength(int[] a, int[] b){
        int biggerLength = Math.max(a.length, b.length);
        if(a.length + b.length >= 10){
            return biggerLength + 1;
        } else {
            return biggerLength;
        }
    }

    //배열 길이만큼 더해질 값을 정렬해줌 (더해진 값의 자릿수가 부족분만큼 0을 추가)
    public ArrayList<Integer> arrangeList (int[] arr, int[] refer){
        ArrayList<Integer> arrangeList = new ArrayList<Integer>();

        int sumLength = sumLength(arr, refer);
        if (arr.length < sumLength) {
            for (int i = 0; i < sumLength - arr.length; i++) {
                arrangeList.add(0);
            }
            for (int j : arr) {
                arrangeList.add(j);
            }
        } else {
            for (int j : arr) {
                arrangeList.add(j);
            }
        }
        return arrangeList;
    }

    public int[] solution(int[] a, int[] b) {
        int[] answer = new int[sumLength(a, b)];

        // a 배열과 b배열 더해진값 기준으로 정렬
        ArrayList<Integer> arrangedA = arrangeList(a, b);
        ArrayList<Integer> arrangedB = arrangeList(b, a);

        // sum값 자릿수올려주는 carry값 정답배열을 담아줄
        ArrayList<Integer> sumList = new ArrayList<Integer>();
        ArrayList<Integer> carryList = new ArrayList<Integer>();

        // sum / carry값을 각 리스트에 입력
        for (int i = 0; i < sumLength(a, b); i++) {
            int sum = (arrangedA.get(i) + arrangedB.get(i)) % 10;
            int carry = arrangedA.get(i) + arrangedB.get(i) >= 10 ? 1 : 0;
            sumList.add(sum);
            carryList.add(carry);
        }

        // carryList 자리 올려주기
        carryList.add(0);

        // answer 값에 최종결과 담아주기
        for (int i = 0; i < sumLength(a, b); i++) {
            answer[i] = (sumList.get(i) + carryList.get(i + 1));
        }
        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public static void main(String[] args) {
        Problem2 test = new Problem2();
        int[] a = {5, 2, 1, 4, 6};
        int[] b = {6, 1, 0, 4, 4};


        test.solution(a, b);
    }

}
