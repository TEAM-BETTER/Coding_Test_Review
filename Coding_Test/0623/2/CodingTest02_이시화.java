import java.util.Arrays;

// 합병 정렬을 조금만 변환하면 가능
// 사전적 순서로 정렬을 위해 String[] 배열 필요
// String 비교 메소드 compareTo 사용
public class Solution {
    public static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] arr = new String[numbers.length];      // numbers 배열을 String[] 배열로 저장하는 곳
        String[] tmp = new String[numbers.length];      // merge sort 시 필요한 새로운 배열

        for (int i = 0; i < arr.length; i++) {          // numbers 배열 String[] 배열에 넣어줌
            arr[i] = String.valueOf(numbers[i]);
        }

        mergeSort(arr, tmp, 0, numbers.length - 1); // merge sort 는 강의에서 배운 코드 그대로 사용

        for (String s : tmp) {                          // tmp 에 정렬된 순서대로 정답에 추가
            answer.append(s);
        }

        return answer.toString();
    }

    public static void mergeSort(String[] arr, String[] tmp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, tmp, left, mid);
            mergeSort(arr, tmp, mid + 1, right);
            merge(arr, tmp, left, right, mid);
        }
    }

    public static void merge(String[] arr, String[] tmp, int left, int right, int mid) {
        int p = left;
        int q = mid + 1;
        int idx = p;

        while (p <= mid || q <= right) {
            if (p <= mid && q <= right) {
                String a = arr[p] + arr[q];             // 바뀐 부분
                String b = arr[q] + arr[p];             // 두개의 인자를 합치는 순서만 바꿔서 누가 더 사전적 정렬이 앞서는지 판단하기 위함
                if (a.compareTo(b) > 0) {               // compareTo a 가 더 앞쪽이면 양수, a가 더 뒤면 음수 , 같으면 0 반환
                    tmp[idx++] = arr[p++];
                } else {
                    tmp[idx++] = arr[q++];
                }
            } else if (p <= mid) {
                tmp[idx++] = arr[p++];
            } else {
                tmp[idx++] = arr[q++];
            }
        }

        if (right + 1 - left >= 0) System.arraycopy(tmp, left, arr, left, right + 1 - left);
    }

    public static void main(String[] args) {
        int[] a = new int[]{9, 99, 98, 1, 12};
        System.out.println(solution(a));
//        String q = "1";
//        String w = "2";
//        String qw = q + w;
//        String wq = w + q;
//        System.out.println(qw + "  " + wq);
//        System.out.println(qw.compareTo(wq));

    }
}

