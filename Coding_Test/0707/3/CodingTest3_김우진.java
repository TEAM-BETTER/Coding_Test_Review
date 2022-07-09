package CodingTest7;
import java.util.*;

public class CodingTest3_김우진 {
    /**
     * 1. 주어진 숫자를 가능한 모든 케이스로 쪼갬
     * 2. 쪼갤 때 IP의 각 8bit를 10진수 기준 최소 1자리 ~ 최대 3자리로 쪼갤 수 있음
     *      쪼갠 숫자가 255 이하인지 확인하고 해당 숫자와 '.'을 붙인 상태로 재귀함수 재호출
     *      첫 번째 자리가 0일 경우 leading zero를 허용하지 않으므로 0.만 추가 가능
     * 3. idx == 문자열 s 내 인덱스, dotCnt == 현재까지 만든 ip 주소의 . 갯수, ip == 현재까지 만들어진 ip 주소
     *      현재 우리는 ip에 숫자를 추가할 때마다 뒤에 '.'을 붙이고 있음
     *      따라서 .이 4개를 초과하면 가능한 ip가 아니므로 기저사례로 dotCnt가 4개를 초과하는지 확인
     *      idx가 문자열 끝 즉, 주어진 s의 구성요소를 모두 ip에 포함한 상태에서 '.'이 4개라면 가능한 ip임
     *      원래 ip는 마지막 .을 포함하지 않으므로 ips에 추가할 때는 마지막 .을 제거한 상태로 추가해줌
     * 4. 3번에서 ip들을 String[] 배열로 변환한 뒤 반환
     */
    public static List<String> ips = new ArrayList<>();

    public static void makeValidIp(int idx, int dotCnt, String ip, String s) {
        if (dotCnt > 4) {
            return;
        }

        if (idx >= s.length()) {
            if (dotCnt == 4) {
                ips.add(ip.substring(0, ip.length() - 1));
            }
            return;
        }

        String temp = "";

        for (int i = idx; i < Math.min(idx + 3, s.length()); i++) {
            temp += s.charAt(i);

            if (Integer.parseInt(temp) <= 255) {
                makeValidIp(idx + temp.length(), dotCnt + 1, ip + temp + ".", s);
            }

            if (s.charAt(idx) == '0') {
                break;
            }
        }
    }

    public static String[] solution(String s) {
        makeValidIp(0, 0, "", s);

        String[] answer = new String[ips.size()];
        int idx = 0;

        for (String ip : ips) {
            answer[idx++] = ip;
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "16819501";

        String[] answer = solution(s);

        for (String a : answer) {
            System.out.println("answer: " + a);
        }
    }
}