package stringToInteger_atoi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {


    public Solution() {
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        System.out.println(myAtoi(line));
    }

    public int myAtoi(String s) {
        s=s.trim();
        List<Character>numbers=new ArrayList<>
                (Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        int start=0;
        boolean isPos=true;
        try{
            if(s.charAt(0)=='+'||s.charAt(0)=='-'){
                start+=1;
                isPos=s.charAt(0)!='-';
            }
        }catch (IndexOutOfBoundsException e){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=start;i<s.length();i++){
            var c=s.charAt(i);
            if(numbers.contains(c)){
                sb.append(c);
                var temp=Long.parseLong(sb.toString());
                temp*=isPos?1:-1;
                if(temp>max){
                    return max;
                }
                else if(temp<min) {
                    return min;
                }
            }else{
                break;
            }
        }
        long res=0;
        try{
            String str = sb.toString();
            res=Long.parseLong(str);
        }catch (NumberFormatException e){
                res=0;
        }
        if (res > max || res<min) {
            res=isPos?max:min;
        }
        if(!isPos){
            res*=-1;
        }
        return (int)res;
    }


}