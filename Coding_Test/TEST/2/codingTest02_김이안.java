import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] == arr[i]){
                arr[i-1] = -1;
            }
        }
        for(int num : arr){
            if(num == -1) continue;
            list.add(num);
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}