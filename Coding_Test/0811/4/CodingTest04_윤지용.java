/*
아이디어
슬라이딩 윈도우라 기존에 값을 가지고 가야함.
슬라이딩 윈도우 안에 숫자가 있는만큼
배열에 카운트를 하고
(k / 2) + 1 개 만큼 센 위치의 숫자값 리턴 (처음)
 */

// 정확성 2점, 효율성 2점, 나머지 런타임 에러.
// 배열 안에 값이 정수라서 음수가 있을수도 있고, 배열크기를 가늠할수가 없는게 큰 문제인것 같습니다.
// 부끄러운 코드지만 ㅋㅋ 아이디어 공유를 위해 올려봅니다 ㅎㅎ

public class CodingTest04 {

    public static int[] solution(int[] arr, int k) {
        int[] answer = new int[arr.length - k + 1];
        int[] cntArr = new int[10000000];
        int target = k / 2 + 1; // 중앙값 인덱스
        int idx = 0;
        int answerIdx = 0;
        int middleIdx = 0;

        // 맨 초반 세팅
        for (int j = 0; j < k; j++) {
            cntArr[arr[idx++]]++;
        }

        for (int i = 0; i < answer.length; i++) {
            // 중앙값 찾는 부분
            int cnt = 0;
            while (cnt < target) {
                for (int j = 0; j < 10000000; j++) {
                    if (cntArr[j] != 0) {
                        cnt += cntArr[j];
                        if (cnt >= target) {
                            middleIdx = j;
                            answer[answerIdx++] = middleIdx;
                            break;
                        }
                    }
                }
            }
            if (idx < arr.length) {
                // 나가는거 빼기
                int minus = cntArr[arr[idx - k]]--;
                // 추가되는거 넣기
                int plus = cntArr[arr[idx]]++;
                idx++;
            }
        }

        /*
        if(minus == plus) {
            answer[answerIdx++] = answer[answerIdx - 1];
        } else if (minus > plus) { // 뺀거보다 작은게 들어오면
            while(cntArr[middleIdx] != 0) {
            middleIdx--;
        }
         */

        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        int k = 5;
        int[] arr = {1, 1, 1, 1, 1, 1, 1};
        solution(arr, k);
    }
}
