class Solution {
    static boolean answer = false;
    public boolean solution(String s, String[] words) {
        rec(s, words);
        return answer;
    }
    public static void rec(String s, String[] words){
        if(s.length() == 0 || answer) {
            answer = true;
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if(s.indexOf(words[i]) == 0)
                rec(s.substring(words[i].length()),words);
        }
        return ;
    }
}