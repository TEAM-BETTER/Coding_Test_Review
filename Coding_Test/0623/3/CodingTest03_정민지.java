// ㅠㅠ 이 부분은 다른 분들 코드를 열심히 정독하여 수정하겠습니다..ㅠㅠ
// 첫 조건문에서 없을 경우를 바로 쳐내다보니 효율성 4번은 빠르게 통과가 가능하지만
// 효율성 2,3번은 전혀 통과하지 못하는 코드입니다.
class Solution {
    public int solution(int[] arr) {
        int i = 0;
        int max = arr.length;
        // 길이만큼 도는데 피크가 없을 경우 단조증가하거나 감소한다고 했으므로
        // arr[i]보다 arr[i + 1]이 크지 않을 경우 arr[i - 1] < arr[i] > arr[i + 1]
        // 위의 값이 성립하여 피크 값을 찾게 됨.
        // 피크 값이 없을 경우 i 값은 0 또는 (처음부터 실행되지 못한 경우)
        // length - 1이 나오기 때문에 그럴 경우 -1, 아닐 경우 i 반환

        // 만약에 뒤에서 탐색하는데 right > right - 1일 경우
        // 앞에서부터 뒤로 증가, 뒤에서부터 앞으로 감소하는 형태라서 return -1;
        // 문제 조건 상 peek가 있을 경우 arr[right] < arr[right - 1] 형태임.
        // 뒤에서부터 감소하는 형태일 경우 right 사전 처리
        if (arr[max - 1] > arr[max - 2]) return -1;
        while (i < max && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == arr.length - 1 || i == 0) return -1;
        return i;
    }
}
