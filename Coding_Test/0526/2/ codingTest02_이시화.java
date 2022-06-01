import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;


// names 의 중복된 원소룰 Set 을 이용하여 제거합니다. 그 후 nCr 의 순열 함수를 실행하여 경우의 수를 구합니다.
public class Solution {
    public static int solution(String[] names) {
        int answer = 1;


        Set<String> arr = new HashSet<>(Arrays.asList(names));     // 중복된 배열을 제거할 Set 배열에 names 배열을 한번에 다 넣습니다.

        int size = arr.size();                                     // 그 후 Set 배열의 갯수는 중복되지 안은 사람의 숫자입니다.
        answer = nCr(size, 4);                                  // 밑에 만들어둔 nCr 순열을 구하는 함수를 이용해 계산합니다.

        return answer;
    }

    public static int nCr(int n, int c) {                           // nCr 을 구하는 함수를 구현하였습니다.
        int result = 1;

        if (n == 0) {                                               // n 이 0 이면 1을 리턴합니다. 0! = 1 이기 떄문입니다.
            return 1;
        }

        for (int i = n; i > n - c; i--) {                           // n!/(n-c)! 을 계산한 for 반복문 입니다
            result *= i;
        }

        for (int i = 1; i <= c; i++) {                              // c! 을 나누어주는 for 반복문 입니다.
            result /= i;
        }

        return result;
    }
}
