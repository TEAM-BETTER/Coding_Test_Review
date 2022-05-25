// Practice
// 1, 2, 3, 4 를 이용하여 세자리 자연수를 만드는 방법 (순서 O, 중복 x)의 각 결과를 출력하시오
// 연습용
// 푸쉬가 될까? ㅠㅠ


public class testingTest01_박세원 {
    void permutation(int[] arr, int depth, int n, int r) { // 이함수 전혀 이해안간다 prac2도 이해 안가서 같이봐야할듯
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    void swap(int[] arr, int depth, int idx) {
        int tmp = arr[depth];
        arr[depth] = arr[idx];
        arr[idx] = tmp;
    }

    public static void main(String[] args) {
//      Test code
        int[] arr = {1, 2, 3, 4};

        testingTest01_박세원 p = new testingTest01_박세원();
        p.permutation(arr, 0, 4, 3);
    }
}
