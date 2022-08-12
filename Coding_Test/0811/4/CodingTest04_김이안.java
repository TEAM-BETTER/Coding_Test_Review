/*
* 효율성 생각안하고 그냥 푼 문제입니다 ㅋㅋㅋㅋ 그래서 16점 코드입니다!
* 탐색한 슬라이딩 윈도우를 정렬하고 그중에 중간 인덱스를 answer 배열에 저장합니다.
* */
import java.util.*;
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[arr.length-k+1];
        for (int i = 0; i <= arr.length - k; i++) {
            int[] window = new int[k];      // 슬라이딩 윈도우
            for (int j = 0; j < k; j++) {
                window[j] = arr[i+j];       // 슬라이딩 윈도우 범위에 해당하는 값들을 저장합니다.
            }
            Arrays.sort(window);            // 오름차순 정렬 후 가운데 인덱스가 중간값입니다!
            answer[i] = window[k/2];        // 중간값 저장
        }
        return answer;
    }
}