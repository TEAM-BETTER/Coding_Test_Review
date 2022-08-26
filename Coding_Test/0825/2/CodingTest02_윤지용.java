/*
양의 정수가 담긴 문자열 s
k개 제거해서 가장 작은 수 만들기
제거했을때 맨 앞이 0이면 0 제거

0 < s.length <= 10000

삭제 우선순위
1. 앞에 0만 남게할 수 있다면 우선순위로 지우기
(다른 숫자는 자리수 -1, 0만 남기게 되면 자리수 -2)

2. 앞에 0만 남게 못한다면 0~0 블록 사이에서는 큰 수부터 지우기

즉,
1) 처음 ~ 처음0 사이 모든걸 지울 수 있으면 그걸 지우는게 우선
2) 그 다음에는 다음 0(혹은 끝까지) 중에서 앞자리에서 큰수부터 지움

- 아이디어
포인터 2개로 앞에서부터 체크하면서 지워감

***
총점 16 / 20입니다.
역시 엣지케이스 찾기가 어려운데, 이거는 로직이 맞는지조차 확신이 안섭니다..

 */


public class CodingTest02 {
    public static String solution(String s, int k) {
        //예외처리
        if(k >= s.length()) {
            return "0";
        }
        // 루프 시작 전 전체 숫자개수랑 k값 비교구간
        int numberCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != '0') {
                numberCnt++;
            }
        }
        // 숫자 전체를 다 지울 수 있으면 0 리턴
        if(k >= numberCnt) {
            return "0";
        }


        StringBuffer sb = new StringBuffer(s);

        int left = 0;
        int right = 0;

        while(k > 0) {
            // 0 버리고 체크하는 구간
            for (int i = 0; i < sb.length(); i++) {
                if(sb.charAt(i) == '0') {
                    sb.deleteCharAt(i);
                    i--;
                    continue;
                } else {
                    break;
                }
            }
            if(k >= sb.length()) {
                return "0";
            }
            // 0 버리고 체크하는 구간 끝

            // 오른쪽 포인터 0까지 이동
            while (right < sb.length() && sb.charAt(right) != '0') {
                right++;
            }

            // 0 사이 숫자가 지울 수 있는 개수(k)보다 더 많으면 지우기
            if (right - left <= k) {
                sb.delete(left, right);
                k = k - (right - left);
                right = left;
            } else { // 적으면 9부터 차례대로 지워나가기
                for (int i = 9; i >= 0 ; i--) {
                    int idx = left;
                    while(k > 0 && idx < sb.length() && idx < right)  {
                        if (Integer.parseInt(String.valueOf(sb.charAt(idx))) == i) {
                            sb.deleteCharAt(idx);
                            k--;
                            if(k == 0) {
                                break;
                            }
                        }
                        idx++;
                    }
                }
            }
        }

        // 버릴 0 한번더 체크
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) == '0') {
                sb.deleteCharAt(i);
                continue;
            } else {
                break;
            }
        }

        String answer = sb.toString();
        return answer;
    }


    public static void main(String[] args) {
        String s = "01031051";
        int k = 2;
        System.out.println(solution(s, k));
    }
}
