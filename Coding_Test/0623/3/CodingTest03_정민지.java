class Solution {
    public int solution(int[] arr) {
      int max = arr.length;
      int left = 0, right = max - 1;
      int answer = -1;

      // 만약에 뒤에서 탐색하는데 right > right - 1일 경우
      // 앞에서부터 뒤로 증가, 뒤에서부터 앞으로 감소하는 형태라서 return -1;
      // 문제 조건 상 peek가 있을 경우 arr[right] < arr[right - 1] 형태임.
      // 뒤에서부터 감소하는 형태일 경우 right 사전 처리
      if (arr[right] > arr[right - 1]) return -1;
      // 둘이 겹칠 때까지
      while (left <= right) {
        // 앞에서부터 증가하는 형태가 아니게 되면 break; 이 경우 peek 값이 됨.
        if (!(arr[left] < arr[left + 1])) {
          answer = left;
          break;
        }
        // 역시 뒤에서부터 증가하는 형태가 아니게 되면 break; 이 경우에도 peek 값이 됨.
        if (!(arr[right - 1] > arr[right])) {
          answer = right;
          break;
        }
        // 조건문에서 걸리지 않았으면 계속 증감소.
        left++;
        right--;
      }
      // left가 0이면 시작부터 값이 이상해서 바로 끝났다는 뜻이기에 -1
      return left == 0 ? -1 : answer;
    }
}
