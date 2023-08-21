package longestPalindromicSubstring;

public class Solution {

    public Solution(String s){
        longestPalindrome(s);
    }

    public String longestPalindrome(String s) {
        String max="";
        if(s.length()<3){
            return max;
        }
        for(int l=0;l<s.length()-2;l++){
            for(int p=s.length()-1;p>l/2;p--){
                var s1=s.substring(l,p);
                if(s1.length()>max.length()) {
                    if (isPalindrom(s1) && s1.length() > max.length()) {
                        max = s1;
                    }
                }
            }
        }
        return max;
    }

    private boolean isPalindrom(String palindrom){
        boolean res=false;
        for(int l=0; l<(int)palindrom.length()/2;l++){
            for(int p=palindrom.length()-1;p>(int)palindrom.length()/2;p--){
                res = palindrom.charAt(l)==palindrom.charAt(p);
                if(!res)
                    return false;
            }
        }
        return res;
    }

}
