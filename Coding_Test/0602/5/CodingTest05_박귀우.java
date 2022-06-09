public class CodingTest05_박귀우 {
    public static void main(String[] args) {
        Feedback_Sol f = new Feedback_Sol();
        int[][] image = {
                { 4, 5, 2, 6, 7 },
                { 5, 4, 2, 4, 6 },
                { 6, 8, 4, 8, 7 },
                { 7, 3, 6, 6, 4 },
                { 5, 0, 4, 1, 5 },
        };
        int[][] rs = f.feedback_Sol(image, 3);
        for (int[] r : rs) {
            for (int x : r) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

    }

    static class Feedback_Sol {
        int n;
        int N;
        int height;
        int width;
        int[][] result;

        public int[][] feedback_Sol(int[][] image, int k) {
            n = (k - 1) / 2 - 1;
            N = k * k;
            height = image.length;
            width = image[0].length;
            result = new int[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    result[i][j] = getValueSUm(image, i, j, k);
                }
            }
            return result;
        }

        public int getValueSUm(int[][] arr, int i, int j, int k) {
            int sum = 0;
            for (int p = (i - n); p < (i - n) + k; p++) {
                for (int q = (j - n); q < (j - n) + k; q++) {
                    sum += getValue(arr, p, q);
                }
            }
            return sum;
        }

        public int getValue(int[][] arr, int i, int j) {
            if (i < 0 || j < 0 || i > height - 1 || j > width - 1) {
                return 0;
            }
            return arr[i][j];
        }

    }
}
