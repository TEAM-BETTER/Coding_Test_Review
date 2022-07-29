/*
정확성에서 2점 감점된 풀이 입니다!
뭔가 빠트린게 있는데 테스트때 못찾았네요 ㅠㅠㅠ
 */
class Solution {
    public int[] solution(int[] values) {
        if (values.length == 1){
            return new int[]{0,0};
        }
        int[] answer = new int[2];
        long max = Long.MIN_VALUE;
        for (int i = 1; i < values.length; i++) {
            int start = i-1;                    // 구간 시작 인덱스
            while(values[i-1] < values[i]){     // 해당 인덱스의 값이 증가하는지 체크
                if (i == values.length-1) break;
                i++;
            }
            int end = i-1;                      // 구간 끝 인덱스
            if (max < end - start){
                max = end - start;
                answer[0] = start;
                answer[1] = end;
            }
        }
        return answer;
    }
}