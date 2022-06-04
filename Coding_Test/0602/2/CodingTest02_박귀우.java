/**
 * 효율성 2개를 통과하지못한 코드입니다.
 * 배열의 역으로 해서 하나씩 스택의집어넣고 나중에 더해주는 생각을 했습니다.
 */
class CodingTest02_박귀우 {
    public int[] solution(int[] a, int[] b) {
        if (a.length < b.length) { // a와 b 모두 다양한 길이로 주어질수 있기때문에 그중 가장 긴값을 항상 a 로 지정합니다.
            int[] tmp = a;
            a = b;
            b = a;
        }
        Stack<Integer> list = new Stack<>(); // 스택을 써보고 싶었습니다.
        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }
        int cur = b.length - 1; // 현재의 포지션 을 위해 작성했습니다, a,b 의 길이가 다르기 때문에 이와같이 작성했습니다.
        int upper = 0; // 더해서 10 이넘어간다면 체크하기위해 넣어뒀습니다.
        for (int i = list.size() - 1; i >= 0; i--) { // 지금와서 생각해보니 굳이 끝까지 for 를 돌필요가 없었네요.
            if (cur > -1) {
                int sum = b[cur] + upper + list.get(i);
                upper = 0;
                if (sum > 9) {
                    list.set(i, sum - 10);
                    upper++;
                } else {
                    list.set(i, sum);
                }
                cur--;
            } else if (upper != 0) { // cur을 통해 b의 자릿수가 다 더해지고 그 이후 값 처리입니다.
                int sum = list.get(i) + upper;
                upper = 0;
                if (sum > 9) {
                    list.set(i, sum - 10);
                    upper++;
                } else {
                    list.set(i, sum);
                }
            }
        }
        int[] result = list.stream().mapToInt(x -> x).toArray();
        if (upper != 0) { // 위의 연산을 모두 거친이후에도 0 이 남아 있다면 더해주는 구간입니다.
            int[] newResult = new int[result.length + 1];
            System.arraycopy(result, 0, newResult, 1, result.length);
            newResult[0] = 1;
            result = newResult;
        }
        return result;
    }
}