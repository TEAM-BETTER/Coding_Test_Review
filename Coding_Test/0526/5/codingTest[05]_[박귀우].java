import java.util.*;

class Solution {
    // public static void main(String[] args) {
    // System.out.println(solution(10, 3, 4, new int[] { 3, 3, 4 }));
    // }
    // 정민님 의 코드 가 저는 강사님의 코드보다 더 좋은것 같아서 벤치마킹 해왔습니다.
    /**
     * 정민님의 코드를 보아도 이해가 안가서 개인적으로 dm 드리고 받았던 내용 첨부할게요.
     * - 정민님 답변 -
     * 음 이게 그림으로 설명 드리는게 제일 좋기는 한데 일단은 말로 설명 드려 보겠습니다.
     * 일단 저 풀이를 생각하게 된 경로는 다음과 같은 생각의 흐름으로 하게 되었어요!
     * 학생수의 총합 <= 교실 수용인원수의 총합
     * 학생수의 총합 = 교실 수용인원수의 총합인 경우 / 학생수의 총합 < 교실 수용인원수의 총합인 경우로 케이스를 나눴습니다.
     * 학생수의 총합 = 교실 수용인원수의 총합인 경우는 문제에 해답이 나와 있었고 그래서 다음 경우만 해결하면 문제를 해결 할 수 있다고 생각
     * 했습니다.
     * 문제의 조건을 살펴보면 각 반에 들어간 인원수를 각각 a1, a2, a3라고 했을때 a1 + a2 + a3 = N인 식을 만들 수
     * 있었습니다.
     * 그래서 a1 a2 a3를 일반적인 값으로 고정을 시켜 놓고 문제를 풀어보니 학생수의 총합 = 교실 수용인원수의 총합인 경우와 문제를 푸는
     * 방식이 동일함을 찾았습니다.
     * 그래서 a1 a2 a3의 조합을 찾는 방식으로 3중 for문을 이용하여 a1 + a2 + a3 = N인 조합을 모두 만들어서 조합을 구하여
     * 문제를 해결한 것 입니다.
     * 이떄 a1 + a2 + a3 = N인 경우를 찾아내는 과정이 이해가 안 가신다면 https://j1w2k3.tistory.com/744 이
     * 글을 참고 하시면 더 이해하기 쉬우실 거에요!
     * 여기 자연수의 분할에서는 1 + 1 + 3 = 1 + 3 + 1이 같은 경우 이지만 지금은 각 반이 다른 번호로 구분이 되어 있기 때문에
     * 다른 경우로 개수를 세 주셔야 합니다
     * (1 1 3) (1 3 1) (3 1 1) 모두 다른 경우입니다!
     */
    // 모든 풀이과정은 정민님과 똑같고 단지 좀더 편안하게 보기 위해서 아래와 같이 함수로 나눠놨습니다.
    ArrayList<ArrayList<Integer>> totalClassOfStd;

    public long solution(int N, int M, int K, int[] capacity) {
        long answer = 0;
        int[] caps = new int[3];

        for (int i = 0; i < capacity.length; i++) {
            caps[i] = capacity[i];
        }
        for (int i = capacity.length; i < 3; i++) {
            caps[i] = 0;
        }
        // 케이스를 찾아와서 즉각적으로 계산해서 더해버려
        totalClassOfStd = getCasesStudents(caps, N);
        answer = getAllCasesOfStudents(0, N);
        return answer * perm(K, M);
    }

    public ArrayList<ArrayList<Integer>> getCasesStudents(int[] caps, int totalStudents) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= caps[0]; i++) {
            for (int j = 0; j <= caps[1]; j++) {
                for (int k = 0; k <= caps[2]; k++) {
                    if (i + j + k == totalStudents) {
                        ArrayList<Integer> classOfStd = new ArrayList<>();
                        classOfStd.add(i);
                        classOfStd.add(j);
                        classOfStd.add(k);
                        result.add(classOfStd);
                    }
                }
            }
        }
        return result;
    }

    public int getAllCasesOfStudents(int answer, int totalStudent) {
        for (ArrayList<Integer> classOfStd : totalClassOfStd) {
            int firstClassStd = classOfStd.get(0);
            int secondClassStd = classOfStd.get(1);
            int thirdClassStd = classOfStd.get(2);

            long firstCase = comb(totalStudent, firstClassStd);
            long secondCase = comb(totalStudent - firstClassStd, secondClassStd);
            long thirdCase = comb(totalStudent - firstClassStd - secondClassStd, thirdClassStd);
            answer += firstCase * secondCase * thirdCase;
        }
        return answer;
    }

    public long comb(int n, int r) {
        long top = 1;
        long bottom = 1;
        for (int i = 0; i < r; i++) {
            top *= n - i;
            bottom *= i + 1;
        }
        return top / bottom;
    }

    public long perm(int n, int r) {
        long result = 1;
        for (int i = 0; i < r; i++) {
            result *= n - i;
        }
        return result;
    }
}
