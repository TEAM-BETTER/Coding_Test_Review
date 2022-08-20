/*
2번 - 20점
예전에 비슷한 문제를 풀었던 기억이 있습니다.
처음에 어떻게 로직을 짜야하나 막막했지만 max 값을 매번 업데이트해주는 문제 유형이 떠올라서 풀 수 있었습니다.
주어진 heights[i]중 하나는 가능한 최대 넓이를 구하기 위해 쓰이는 직사각형의 높이가 될 것입니다.
따라서, 반복문에서 현재 높이 heights[i]를 직사각형의 높이라고 가정하고, 그 때 가능한 최대 넓이 구하도록 합니다.
반복문이 끝날 때마다 현재 가능한 직사각형의 넓이와 이전에 나온 max를 비교해서 더 큰 값을 저장하도록 구현했습니다.
 */

public class CodingTest2_김란 {
    public  static int solution(int[] heights) {
        int max = 0;

        for(int i = 0; i < heights.length; ++i){
            int sideLength = 1;          // 직사각형의 밑변의 길이는 적어도 1이상이다.
            int currHeight = heights[i]; // 현재 높이 = heights[i]일 때, 가능한 최대 넓이 max를 구한다.

            if(heights[i]== 0){    // 문제의 조건을 보고나서 이 부분 추가하니까 2점인가 오르네요!
                continue;
            }

            // 밑변의 길이  (현재 높이가 직사각형 높이가 되기 위해서는 양쪽의 높이가 현재보다 크거나 같아야한다.)
            for(int j = i - 1; j >= 0; --j){
                if(heights[j] < currHeight ){
                    break;
                }
                ++sideLength;
            }
            for(int j = i + 1; j < heights.length; ++j){
                if(heights[j] < currHeight ){
                    break;
                }
                ++sideLength;
            }
            max = Math.max (max, currHeight * sideLength);  // (현재 높이 * 가능한 최대한의 밑변의 길이)
//            System.out.println("i = " + i + " sideLength = " + sideLength);
//            System.out.println("i = " + i + " MAX = " + max);
        }
        return max;
    }

    public static void main(String[] args) {

        int[] arr = {5, 2, 1, 3, 4, 2, 5};  // 8
        System.out.println(solution(arr));

        arr = new int[]{3, 4, 5, 6, 5, 4, 3, 2, 1};
        System.out.println(solution(arr));
    }
}
