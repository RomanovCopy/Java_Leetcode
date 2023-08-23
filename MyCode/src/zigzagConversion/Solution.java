package zigzagConversion;


public class Solution {

    String text="PAYPALISHIRING";
    Integer lines = 3;

    public Solution(){
        System.out.println(convert(text, lines));
    }

    public String convert(String s, int numRows) {
        var chars=s.toCharArray();
        int length=chars.length;
        int runner=0;
        int anchor=1;
        int step=numRows+numRows-2;
        while (anchor<s.length()){

        }

        return res;
    }

}
