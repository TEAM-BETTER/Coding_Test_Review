import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers); //오름차순으로 정렬
        int firstNumber = numbers[0]; //초기 숫자 설정
        for (int i = 0; i < numbers.length; i++) { //배열의 사이즈만큼 증가하는 반복문
            if (numbers[i] != firstNumber + i) { //i번째 배열의 값은 초기 숫자(정렬 후 0번 인덱스의 값)에 i를 더한 값이어햐므로
                answer = firstNumber + i; //조건문이 실패했을 경우, 초기 숫자에 i를 더한 값이 존재하지 않으므로 해당 값 리턴
                break;
            }
        }
        return answer;
    }
}