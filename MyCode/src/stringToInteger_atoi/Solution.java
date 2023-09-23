package stringToInteger_atoi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {

    List<Character>numbers;

    public Solution() {
        numbers = new ArrayList<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', '-'));
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        System.out.println(myAtoi(line));
    }

    public int myAtoi(String s) {
        int max=(int)Math.pow(2, 32);
        int min=max*-1;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            var c=s.charAt(i);
            if(numbers.contains(c)){
                sb.append(c);
            }
        }
        String str = sb.toString();
        return Integer.parseInt(str);
    }


}