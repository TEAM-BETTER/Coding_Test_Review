
public class Practice1 {
    public static void solution(int num) {
        int numlist = 0;
        boolean isMinus = false;

        if(num < 0) {
            isMinus = true;
            num = num * -1;
        }

        while (num > 0){
            int r = num % 10;
            num = num/10;

            numlist = numlist * 10 + r;
        }

        System.out.println(isMinus ? numlist * -1 : numlist);
    }

    public static void main(String[] args) {
        // Test code
        solution(12345);
        solution(-12345);
        solution(100);
        solution(0);
    }
}
