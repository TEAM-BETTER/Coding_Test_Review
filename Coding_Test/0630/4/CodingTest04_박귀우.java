
// 슬라이딩 윈도우 처럼 구할려고 했습니다.
// 움직일떄 마다 좌우 이동하며 값을 빼주고 더해준다는 아이디어 였습니다.
// 테스트 당시 stream 을 이용해서 답을 제출했는데 18점이고 오늘 그냥 forloop 으로 답을 제출하니 20점 나왔습니다.
import java.util.*;

public class CodingTest04_박귀우 {
    public int[] solution(int[] arr, int k) {
        List<Integer> answer = new ArrayList<>();

        int maxValue = 0; // 현재 범위 안에 들은 가장 높은수를 가져옵니다.
        for (int i = 0; i < k; i++) {
            maxValue = Math.max(arr[i], maxValue);
        }
        answer.add(maxValue); // 답에 추가를 해주고

        for (int i = k; i < arr.length; i++) {
            if (arr[i] >= maxValue) { // 더해주는 수가 최대수 와 같거나 크다면 ? 업데이트 해주고 진행합니다.
                maxValue = Math.max(arr[i], maxValue);
            } else if (arr[i - k] == maxValue) { // 빠지는 수가 최대수와 같다면 ? 새로운 맥스 밸류로 업데이트 해줍니다.
                int nMax = 0;
                for (int j = i - k + 1; j < i + 1; j++) {
                    nMax = Math.max(arr[j], nMax);
                }
                maxValue = nMax;
            }
            answer.add(maxValue); // 업데이트 된 최고값을 답에 더해줍니다.
        }
        int[] nArr = new int[answer.size()]; // 이부분을 스트림으로 이용했더니 효율성 한개가 실패했습니다. ㅠ
        for (int i = 0; i < answer.size(); i++) {
            nArr[i] = answer.get(i);
        }
        return nArr;
    }
}