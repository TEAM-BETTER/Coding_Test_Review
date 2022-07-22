package CodingTest2;

// 정확성 10점, 효율성 10
// 이 문제는 프로그래머스 레벨 3 정수 삼각형 (링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43105) 문제를 풀 때 접근했던 방법이랑 똑같은 방법으로 접근해서 풀었습니다.
// 처음에는 문제에 이미지도 있고 말도 어려워서 문제가 굉장히 어려워 보였는데 깊이 0을 제외한 나머지 깊이에 있는 블록을 제거할 때는 바로 위 배열의 블록들 중 하나가 제거되어야 한다는 것을 보고 비슷한 문제인 거 같아서 후다닥 풀었네요..ㅎ
public class CodingTest02_한규빈 {
    public static int solution(int depth, int n, int[][] blocks) {

        // depth 1부터 시작
        for (int i = 1; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i].length; j++) {
                 if (j == 0) {
                     // index가 시작점 일 때 index가 - 값이 나오지 않도록 예외 처리
                     // [i - 1][j], [i - 1][j + 1] 중 작은 값이랑 현재 위치의 값을 더해서 현재 위치의 값을 업데이트
                     blocks[i][j] = Math.min(blocks[i - 1][j], blocks[i - 1][j + 1]) + blocks[i][j];
                 } else if (j == blocks[i].length - 1) {
                     // index가 끝점 일 때 index 범위가 넘지 않도록 예외 처리
                     // [i - 1][j - 1], [i - 1][j] 중 작은 값이랑 현재 위치의 값을 더해서 현재 위치의 값을 업데이트
                     blocks[i][j] = Math.min(blocks[i - 1][j], blocks[i - 1][j - 1]) + blocks[i][j];
                 } else {
                     // 그 외의 경우
                     // [i - 1][j - 1], [i - 1][j], [i - 1][j + 1] 중 작은 값이랑 현재 위치의 값을 더해서 현재 위치의 값을 업데이트
                     blocks[i][j] = Math.min(blocks[i - 1][j - 1], Math.min(blocks[i - 1][j], blocks[i - 1][j + 1])) + blocks[i][j];
                 }
            }
        }

        // 최종적으로 구하려는 위치의 최소 에너지값을 반환
        return blocks[depth][n];
    }

    public static void main(String[] args) {
        int[][]  blocks = new int[][]{{5, 6, 2, 6}, {1, 6, 4, 9} , {5, 6, 9, 4}, {55, 14, 21 ,14}};
        System.out.println(solution(3, 3, blocks));
    }
}
