/** 금일 프로그래머스 1번 문제 */
/**
 * 문제가 기억이 안나요...
 * 숫자 거꾸로해도 똑같은 숫자 인 경우 숫자를 세는거 같은데..
 */
class Solution {
  public int solution(int n, int m) {
    int answer = 0;
    for (int i = n; i <= m; i++) {
      if (i <= 9) { // 자연수 1~9 는 모두 1개로 카운트가 되어서 이렇게 처리했습니다.
        answer++;
        continue; // 자연수 한개가 추가 되었다면, 굳이 밑에 까지 갈필요가 없어서 continue 로 다음 for 수행 시켰습니다.
      }
      char[] tar = Integer.toString(i).toCharArray(); // 아래 에 있는 함수를 활용하기위해 배열 문자 로 변환해주었습니다.
      if (checkIsPalindrom(tar)) { // 만약 함수에서 true 를 리턴 한다면, 정답에 한개를 추가해주는 부분 입니다.
        answer++;
      }
    }

    return answer;
  }

  public boolean checkIsPalindrom(char[] tar) {
    for (int i = 0; i < tar.length / 2; i++) { // 만약 숫자가 앞뒤가 똑같은 숫자라면 굳이 끝까지 갈필요없이 반만 검사해 주면 됩니다.
      if (tar[i] != tar[tar.length - 1 - i]) { // tar.length-1-i => 는 뒤쪽 숫자 확인, tar[i] 는 앞쪽 숫자 확인 입니다.
        return false;
      }
    }
    return true;
  }
}