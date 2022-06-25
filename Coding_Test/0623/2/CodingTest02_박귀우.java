import java.util.Arrays;
import java.util.Comparator;

// 그려보다 보니 0 이 들어간 수가 문제가 되어 어떻게 해결해줄까 하다가 문자 앞뒤로 더해서 비교해주기로 했습니다. 

public class CodingTest02_박귀우 {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];

        for (int i = 0; i < nums.length; i++)
            nums[i] = numbers[i] + "";

        // 지난번 에는 클래스를 만들어서 해주었지만 굳이 다른거 작성할 필요가 없어 이렇게 안에다가 바로구현했습니다.
        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        // 범위가 1만밖에 안되서 그냥 + 했는데 ,빌더나 버퍼 쓰는게 더 좋아보이네요....
        String ans = "";
        for (int i = 0; i < numbers.length; i++)
            ans += nums[i];

        return ans.charAt(0) == '0' ? "0" : ans;
    }
}