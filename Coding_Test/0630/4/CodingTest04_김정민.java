import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = {};
        ArrayList<Integer> temp = new ArrayList<>(); // 구간별 최대 값을 임시로 담아 둘 리스트
        int st = 0;
        int end = st + k - 1;
        int maxIndex = 0; // 매 이동시마다 최대 값이 범위에서 제외 되지 않았다면 재활용 할 수 있으므로 최대 값의 인덱스를 추적했습니다.

        // 첫번째 구간의 최대 인덱스 찾기
        for (int i = 1; i <= end; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }

        temp.add(arr[maxIndex]);
        st++;
        end++;

        while (st <= arr.length - k) {
            // 만일 이전 구간의 최대 값이 구간에서 벗어난다면 최대 값을 재활용 할 수 없기 때문에 최대 값을 구해줍니다.
            if (maxIndex < st) {
                maxIndex = st;
                for (int i = st + 1; i <= end; i++) {
                    if (arr[i] >= arr[maxIndex]) {
                        maxIndex = i;
                    }
                }
            }else {
                // 이전 구간의 최대 값이 구간에 포함 된다면 최대값과 새로추가된 끝 부분만 비교를 해주면 됩니다.
                if (arr[end] >= arr[maxIndex]) {
                    maxIndex = end;
                }
            }
            temp.add(arr[maxIndex]);
            st++;
            end++;
        }

        // List를 정답 형식에 맞게 변환하는 코드 넘어가셔도 됩니다.
        // List를 쉽게 원시타입 배열로 바꾸는 방법을 어디서 봤던거 같은데 은근히 손히 안가네요 ㅠ
        answer = new int[temp.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = temp.get(i);
        }

        return answer;
    }
}