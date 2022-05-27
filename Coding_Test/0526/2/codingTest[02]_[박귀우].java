import java.util.*;

class Solution2 {
    public int solution(String[] names) {
        return getNums(names);
    }
    public int getNums(String[] s){
        HashSet<String> set = new HashSet<String>();
        set.addAll(List.of(s));
        long topFactorial = 1;
        int botFactorial = 24;
        for (int i = set.size(); i> set.size()-4; i--) {
            topFactorial = (topFactorial * i);
        }
        return (int) (topFactorial/botFactorial);
    }
}