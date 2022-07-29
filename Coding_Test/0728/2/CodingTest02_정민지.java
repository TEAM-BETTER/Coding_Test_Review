/*
    딱 한 번 교환하는 문제이니 최대값을 찾고
    그 최대값을 앞에서부터 탐색하고 뒤에서도 적절한 위치를 탐색해서
    적절한 위치에 넣어주면 교환이 성공적으로 되지 않을까 생각했습니다.
*/
import java.util.Arrays;
import java.util.stream.Stream;
class Solution {
    public int solution(int num) {
        int answer = 0;
        // 접근이 쉽도록 정수를 정수 배열 형태로 변환합니다.
        int[] digit = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        // 해당 배열의 가장 큰 수를 가져옵니다. (ex. 12353 => max = 5)
        int max = Arrays.stream(digit).max().getAsInt();

        int st = 0, en = digit.length - 1;

        // max와 digit[st]의 값이 같다면 굳이 교환할 필요가 없습니다.
        // 따라서 그렇지 않을 때까지 계속 뒤로 이동합니다.
        while (st < digit.length && max == digit[st]) st++;

        // max와 digit[en]의 값이 같지 않다면 계속 앞으로 이동합니다.
        while (en >= 0 && max != digit[en]) en--;

        // 만약 st와 en이 범위를 벗어났거나 st와 en이 같다면 바로 num을 반환합니다.
        if (st >= digit.length || en < 0 || st == en) return num;

        // st와 en의 숫자를 바꿔줍니다.
        int temp = digit[st];
        digit[st] = digit[en];
        digit[en] = temp;

        // 정수 배열을 다시 정수 형태로 변환합니다. 혹시.. 정수 배열 정수로 바꾸는
        // 간단하고 깔끔한 방법 아시는 분 계시다면 알려주세요..! 이게 너무 신경 쓰였습니다.
        for (int d: digit) {
            answer *= 10;
            answer += d;
        }

        // 변경한 값과 처음 입력받은 값을 비교해 더 큰 값을 반환합니다.
        return Math.max(answer, num);
    }
}
