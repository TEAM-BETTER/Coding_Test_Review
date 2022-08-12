import java.util.*;
class Solution {
    public int solution(int n, int num) {
        int curN = 1;
        char[] numChars = Integer.toString(num).toCharArray();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < numChars.length; i++) {
            map.put(numChars[i],map.getOrDefault(numChars[i],0)+1);
        }
        while (curN < n){
            Map<Character,Integer> curMap = new HashMap<Character,Integer>();
            StringBuffer sb = new StringBuffer();
            for (char c : map.keySet()) {
                sb.append(c).append(map.get(c));
            }
            for (int i = 0; i < sb.length(); i++) {
                curMap.put(sb.toString().charAt(i), curMap.getOrDefault(sb.toString().charAt(i),0)+1);
            }
            curN++;
            map = curMap;
        }
        StringBuffer sb = new StringBuffer();
        for (char c : map.keySet()) {
            sb.append(c).append(map.get(c));
        }

        return (int) (Long.parseLong(sb.toString())%10004);
    }
}