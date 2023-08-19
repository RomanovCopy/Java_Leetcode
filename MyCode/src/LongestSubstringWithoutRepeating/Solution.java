package LongestSubstringWithoutRepeating;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public Solution(){
        lengthOfLongestSubstring("abcdeffghijklmnopqrstuvwxyzz");
    }

    public int lengthOfLongestSubstring(String s) {
        int length=0;
        List<String> substrings=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

        }

        System.out.println("Найдены подстроки: ");
        for(String str:substrings){
            length=str.length()>length?str.length():length;
        }
        return length;
    }
}
