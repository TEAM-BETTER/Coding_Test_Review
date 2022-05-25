import java.util.Scanner;

public class Minirpt02 {
    public static void main(String[] args){
        int input, pay, cashback;
        int totalPoint = 0;
        while(true){
            System.out.println("======메뉴를 선택하세요======");
            System.out.println("1. 결제하기");
            System.out.println("2. 현재까지 쌓인 포인트 보기");
            System.out.println("3. 프로그램 종료");
            System.out.print("입력 : ");
                System.out.print("결제 금액을 입력해주세요. : ");
                pay = getInput();
                cashback = pay < 3000 ? pay/10 - (pay/10)%100 : 300;
                totalPoint += cashback;
                System.out.println(String.format("결제 금액은 %d원이고 캐시백은 %d원입니다.", pay, cashback));
        }
    }
    public static int getInput(){
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }
}
