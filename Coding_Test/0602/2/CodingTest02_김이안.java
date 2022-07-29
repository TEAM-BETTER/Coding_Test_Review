/*
    효율성에서 4점 받은 풀이입니다 ㅠㅠ
    더 깔끔하게 풀 수 있었는데 시간을 너무 많이써서 넘어가버린 문제입니다.


*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
class Solution {
    public static int calc(int[] a, int[] b, int aLen, int bLen, boolean up) {  // up 값은 이전 자릿수에서 10 이상일 시 true 입니다.
        int sum = -1;
        if(aLen < 0 && bLen >= 0) return up ? b[bLen]+1 : b[bLen];  // a의 값이 더 없을때 b의 값만 리턴
        else if(bLen < 0 && aLen >= 0) return up ? a[aLen]+1 : a[aLen]; // b의 값이 더 없을때 b의 값만 리턴
        else if(aLen >= 0 && bLen >= 0) return up ? a[aLen]+b[bLen]+1 : a[aLen]+b[bLen];    // a와 b값 모두 있을때
        else if(aLen < 0 && bLen < 0 && up) return 1;

        return sum; // 위 조건문에 걸리지 않을경우 -1이 리턴됩니다.
    }
    public int[] solution(int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        int aLen = a.length-1;
        int bLen = b.length-1;
        boolean up = false;

        while(true) {
            int sum = calc(a,b,aLen,bLen,up);   // a와 b의 각 인덱스의 값을 더해준다.
            if (sum == -1) break;               // -1일 경우는 모두 더한 경우입니다.
            if(sum < 10){                       // a와 b값을 더했을때 값을 answer리스트에 add해줍니다.
                answer.add(sum);
                up = false;
            }else{
                answer.add(sum-10);             // a와 b값을 더했을때 10 이상이면 up을 true로 바꿔주고 sum-10을 answer에 추가합니다.
                up = true;
            }
            aLen--;
            bLen--;
        }
        Collections.reverse(answer);    // 1의 자릿수 부터 저장이 되어있어서 반전시켜줍니다.
        return answer.stream().mapToInt(i -> i).toArray();
    }
}