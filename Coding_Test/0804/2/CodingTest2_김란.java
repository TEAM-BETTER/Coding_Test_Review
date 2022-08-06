/*
2. 사전식 배열 - 18점
이 문제도 분명히 풀었던 문제네요~!
인덱스 + 1을 문자열 배열에 넣고 그 값들을 Arrays.sort() 해주면
사전식 배열이 되도록 간단히 로직을 짰습니다.
깎인 2점은 어디서 깎인건줄 모르겠네요. 조언 부탁드립니다.


 */

import java.util.Arrays;

public class CodingTest2_김란 {

    public static  int[] solution(int n) {

        int[] arr = new int[n];
        String[] sArr = new String[n];

        for(int i = 0; i < n; ++i){
            String s = String.valueOf(i + 1);
            sArr[i] = s;
        }
        Arrays.sort(sArr);  // 빠지면 2점 깎입니다 ㅠㅠㅠ 모르고 깎인채로 제출했어요 ..
        for(int i = 0;i < n; ++i){
            arr[i] = Integer.parseInt(sArr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {

//        solution(15);
        System.out.println(Arrays.toString(solution(15)));
        System.out.println(Arrays.toString(solution(500)));
    }
}
