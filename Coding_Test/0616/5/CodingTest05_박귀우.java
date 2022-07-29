// 좌표에 따른 빌딩 실루엣 기록 이여서 문제를 읽다 보니 중복된 부분이 없다하여 
// hashmap 을 이용할 생각을 했습니다.
// 한개의 케이스를 통과하지 못한 코드입니다.
// 빌딩의 크기만큼 전부 height 를 업데이트 해주면서 최종적으로 height 의 변화가 있다면 출력하는 코드를 작성하였습니다.

public class CodingTest05_박귀우 {
    public int[][] solution(int[][] buildings) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int last = 0; // last 의 x좌표 를 기록하기위해 적어놓았습니다.
        for (int[] building : buildings) {
            int left = building[0];
            int right = building[1];
            int height = building[2];
            for (int i = left; i <= right; i++) {
                // 만약 현재의 키를 가지고 있다면, height 를 큰값과 비교하여 업데이트를 해줍니다.
                // 두번쨰 있는 컨디션은 만약 마지막이라면 0으로 기록해주기위해 추가 컨디션을 넣어주었습니다.
                if (map.containsKey(i) && last != i) {
                    int nHeight = Math.max(map.get(i), height);
                    map.put(i, nHeight);
                } else {
                    // 없다면 그냥 넣어주었습니다.
                    map.put(i, height);
                }
                if (i == right) {
                    // 예시의 코드를 보니 마지막 부분은 항상 0 이되어 그부분을 추가해 주었지만, 이부분에서 오류가 있지 않았나 합니다.
                    map.put(i, 0);
                }
            }
            last = right;
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int currentX = 0;
        int currentY = 0;
        // 현재의 x,y 좌표를 기록하고 만약 다른 높이라면 답에 추가해주는 부분입니다.
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (currentY != m.getValue()) {
                currentY = m.getValue();
                result.add(new ArrayList<>(List.of(m.getKey(), m.getValue())));
            }
        }
        System.out.println(result);
        int[][] answer = new int[result.size()][2];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new int[] { result.get(i).get(0), result.get(i).get(1) };
        }
        return answer;
    }
}
