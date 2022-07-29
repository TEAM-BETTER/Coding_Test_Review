/*
16점

처음에 for문 인덱스를 뒤 에서부터 시작했다가 오류가 많이 났습니다.
너무 헷갈리길래 0부터 반복문이 돌아가도록 수정하고 나서는 가독성이 생겨서 풀 수 있었습니다.
그리고 char[] 를 내림차순 정렬할 수 있다고 굳게 믿고 메서드를 찾는데도 시간을 낭비했습니다.
다행히 인덱스를 뒤집으니까 꼭 정렬할 필요는 없었습니다.
4점을 깎였는데 어느 부분 때문에 틀렸는지 잘 모르겠습니다~ 의견 부탁드립니다!

 */

import java.util.Arrays;

public class Test2 {

    public static int solution(int num){
        int answer = 0;
        String str = String.valueOf(num);
        char[] sorted= str.toCharArray();           // 오름차순 정렬 예정
        char[] original = str.toCharArray();        // 원래 숫자 그대로
        Arrays.sort(sorted);                        // 가장 큰 값이 맨 뒤에 있다.

        // num을 반환하면 되는 상황, 즉 바꾸지 않았을 때 가장 큰 경우
        // 이 부분 코드를 추가하니까 8점인가? 오름
        boolean b = false;
        for(int i = 0; i < sorted.length / 2; ++i){
            if (i == sorted.length / 2 - 1) {
                return num;
            }
            if(sorted[str.length() - 1 - i] != original[i]){
//                    b = false;            // 다시 보니까 필요없는 코드
                    break;
            }
        }

        for(int i = 0; i <= str.length() / 2; ++i){ // i는 original 기준 인덱스
            int rearIdx = str.length() - 1 - i;     // rearIdx는 i의 반대 편 인덱스

            if(original[i] != sorted[rearIdx]){
            // 가능한 가장 큰 수 가 아닌 숫자가 i 자리에 있는 경우
            // sorted[rearIdx]의 데이터를 앞으로 땡겨와야하는 상황

                // 여기는 맨 뒤에서부터 반복문을 돌릴 필요가 있다. => 가장 큰 수
                // sorted[rearIdx]가 original배열의 몇 번째 위치에 있는지 찾기
                for(int j = str.length() - 1; j >= str.length() / 2; --j){ // j는 sorted 기준 idx
                    if(sorted[rearIdx] == original[j]){     // 이 두 값을 서로 바꿔야 한다.
                        int idx = j;                         // 이건 필요 없어 보인다
                        char tmp = original[idx];
                        original[idx] = original[i];
                        original[i] = tmp;
                        String ans = String.valueOf(original);
                        return Integer.parseInt(ans);
                    }
                }
            }
        }
            return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(43824));
        System.out.println(solution(14235));
        System.out.println(solution(98244949));
        System.out.println(solution(10));
        System.out.println(solution(1000000));
    }
}
