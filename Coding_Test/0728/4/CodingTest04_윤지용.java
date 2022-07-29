/*
아이디어는,
{3, 4, 1, 1, 0, 3} 일때
{f, f, f, f, f, t} 로 해놓고,
             ^ 여기부터 인덱스 앞으로 가면서
             숫자배열의 숫자만큼 for문 돌려서 그 안에 true가 있으면
             해당 인덱스도 true로 바꾸고 앞으로 앞으로
             return 0번 인덱스가 true면 가능, false면 불가능
 */
public class CodingTest04_윤지용 {
    static boolean[] possible; //숫자 배열에 해당하는 boolean 배열

    public static boolean solution(int[] param0) {
        possible = new boolean[param0.length];
        possible[param0.length - 1] = true; // 마지막 숫자 위치 true
        // 역추적
        int idx = param0.length - 2; // 마지막 숫자 앞부터 시작

        while(idx >= 0) { // 인덱스 0까지
            int times = param0[idx];
            for (int i = 0; i <= times; i++) {
                if(possible[idx + i] == true) {
                    possible[idx] = true;
                    break; // 이거 안하니까 런타임 났습니다.
                }
            }
            idx--;
        }
        return possible[0];
    }

    public static void main(String[] args) {
        int[] param0 = {3,4,1,1,0,3};
        System.out.println(solution(param0));

    }
}