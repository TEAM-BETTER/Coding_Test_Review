// 해당 코드는 통과하지 못한 코드입니다.
// 기록을 위해 작성해둔 것이니 참고하시면 손해입니다. ㅎㅎ
// 혹시 시간이 남으시는 분께서는, 어디서 오류가 있는지 점검피드백 주시면
// 감사히 받겠습니다 ㅎㅎㅎ

import java.util.HashMap;

public class CodingTest03_윤지용 {
    public static int solution(String[] ingredients, String[] items) {
        int answer = Integer.MAX_VALUE;
        int needs = ingredients.length; // 0이 되면 만족함
        // 필요한 재료 hashmap
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < ingredients.length; i++) {
            hm.put(ingredients[i], hm.getOrDefault(ingredients[i], 0) - 1);
        }

        int left = 0;
        int right = -1;

        while(right < items.length) { // right인덱스 끝까지
            while(needs != 0 && right != items.length - 1) {
                if(right != items.length - 1) { // 갈 곳이 있으면 인덱스 오른쪽으로
                    right++;
                }
                if(hm.containsKey(items[right])) { // 그 값이 재료에 있으면
                    hm.put(items[right], hm.get(items[right]) + 1); // 부족한 재료 하나 추가
                    if(hm.get(items[right]) == 0) { // 만약 그 재료가 0이 되면
                        needs--; // 다 있는거니 needs 하나 빼기
                    }
                }
            }
            // 정답 업데이트 1
            if(needs == 0 && right - left < answer) {
                answer = right - left + 1;
            }

            while(!hm.containsKey(items[left])) { // 필요한 재료에 그 값이 나올때까지
                left++; // left인덱스 옮기기
            }
            // 정답 업데이트 2
            if(needs == 0 && right - left < answer) { // 더 짧은 구간이 생기면
                answer = right - left + 1; // 정답 업데이트
            }
            // 필요한 재료에 그 값이 나오고 그 값이 0보다 크거나 같으면
            if (hm.containsKey(items[left]) && hm.get(items[left]) >= 0) {
                hm.put(items[left], hm.get(items[left]) - 1); // 하나 빼기
                if(hm.get(items[left]) == -1) { // -1이면 완전 없다는 뜻이니
                    needs++; // 필요하다고 표시
                }
                left++;
            }

            if(right == items.length - 1) { // right가 마지막에 도착하면 정답 리턴
                return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
//        String[] ingredients = {"xojb", "pxmu", "zbfcuj", "ugukbmfq", "rwkjkk"};
//        String[] items = {"zbfcuj", "he", "pxmu", "rwkjkk", "cdi", "kzv", "zlh", "ugukbmfq", "zlh", "zbfcuj", "xojb", "he", "xojb", "ugukbmfq", "rwkjkk"};
//        System.out.println(solution(ingredients, items));

        String[] ingredients2 = {"adijkq", "nfrd", "jl", "rrjr", "doir", "gllhb", "p", "tlrgsy", "zqvayruy", "twbrgqrz"};
        String[] items2 = {"lix", "rrjr", "qkltk", "spmeis", "uxlygz", "s", "adijkq", "prfxwv", "mujozb", "s", "zl", "lix", "gllhb", "s", "zsq", "tmgxvom", "eqzignav", "ttxbtpa", "ubgrai", "otcd", "ybchd", "nfrd", "jqwt", "wiz", "sac", "k", "czjuuzmf", "uxlygz", "rovfu", "xvqquxd", "mocv", "codaf", "mq", "jfuenxdn", "n", "ybchd", "iohhyze", "mmf", "ejxwb", "hqqdygdl", "hp", "dzvxeru", "ttxbtpa", "mujozb", "ui", "tqgwikls", "kq", "wnvchm", "lix", "e", "gja", "isdskggf", "p", "mcne", "adijkq", "rrjr", "jvp", "mcne", "doir", "gllhb", "hp", "ubgrai", "mcne", "sgkggk", "jl", "tteuf", "hp", "ke", "zl", "g", "ke", "tlrgsy", "y", "hzsrhktn", "hgwnbcst", "mujozb", "zqvayruy", "tmgxvom", "dmsd", "ylsgye", "czjuuzmf", "codaf", "axdpr", "kr", "p", "ykfxozqq", "t", "twbrgqrz", "gllhb", "vedsn", "wiz", "gja", "d", "exu", "gja", "ejxwb", "exu", "cfq", "sdr", "zk", "jfuenxdn", "tlrgsy", "xvqquxd", "sgkggk", "ubgrai", "jl", "wiz", "tlrgsy", "mq", "nfrd"};
        System.out.println(solution(ingredients2, items2));
    }
}

