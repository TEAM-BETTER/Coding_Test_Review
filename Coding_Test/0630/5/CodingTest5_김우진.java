package CodingTest6;

/**
 * 1. scores의 0번째와 length의 마지막 값은 1로 고정
 * 2. scores 배열을 하나씩 체크해서 i-1번의 점수와 i번의 점수를 비교
 * 3. 한번은 오른쪽 인덱스 값과 비교해서 toRight배열에 받을 수 있는 초콜릿갯수를 넣어줌
 * 한번은 왼쪽 인덱스 값과 비교해서 toLeft배열에 받을 수 있는 초콜릿갯수를 넣어줌
 * 4. toRight의 경우 만약 i보다 i-1번의 점수가 높으면, 최소 한개 이상의 초콜릿을 받아야 하기때문에 i는 1이 됨
 * i-1의 점수가 높다면 i는 i-1이 받았던 초콜렛보다 +1개를 더 받게됨
 * 5. toLeft의 경우 역순으로 배열을 돌면서 i+1값과 i값을 비교해서 초콜릿을 나눠줌
 * 6. 두 배열이 완성되면 answer배열에 두 배열을 비교해서, 더 많이 초콜릿을 받는 값을 해당 index에 넣어줌
 */

public class CodingTest5_김우진 {

    public int[] solution(int[] scores) {

        int len = scores.length;
        int[] toRight = new int[len];
        int[] toLeft = new int[len];
        int[] answer = new int[len];

        toRight[0] = 1;
        toLeft[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            if (scores[i - 1] >= scores[i]) {
                toRight[i] = 1;
            } else {
                toRight[i] = toRight[i - 1] + 1;
            }
        }

        for (int i = len - 2; i >= 0; i--) {
            if (scores[i + 1] >= scores[i]) {
                toLeft[i] = 1;
            } else {
                toLeft[i] = toLeft[i + 1] + 1;
            }
        }

        for (int i = 0; i < len; i++) {
            answer[i] = Math.max(toRight[i], toLeft[i]);
        }

        return answer;
    }
}