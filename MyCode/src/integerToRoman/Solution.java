package integerToRoman;

/*Римские цифры представлены семью различными символами: I, V, X, L, C, D и M.
Символ       Значение
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
Например, число 2 записывается как II в римской системе счисления, просто две единицы сложены вместе.
Число 12 записывается как XII, что просто означает X + II. Число 27 записывается как XXVII,
что означает XX + V + II.
Римские цифры обычно записываются от большего к меньшему слева направо.
Однако, цифра для числа четыре не записывается как IIII. Вместо этого число четыре записывается как IV.
Поскольку единица находится перед пятеркой, мы вычитаем ее, получая четыре.
Тот же принцип применяется к числу девять, которое записывается как IX.
Существует шесть случаев, когда используется вычитание:
I может быть помещена перед V (5) и X (10), чтобы получить 4 и 9.
X может быть помещена перед L (50) и C (100), чтобы получить 40 и 90.
C может быть помещена перед D (500) и M (1000), чтобы получить 400 и 900.
Дано целое число, необходимо преобразовать его в римскую систему счисления.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public Solution() {
        System.out.println(intToRoman(3000));
    }

    public String intToRoman(int num) {
        String[][]roomNumbers=new String[][]{
                {"I","II","III","IV","V","VI","VII","VIII","IX","X"},
                {"X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C"},
                {"C","CC","CCC","CD","D","DC","DCC","DCCC","CM","M"},
                {"M","MM","MMM"}};
        String roman="";
        int[] bit=new int[]{-1,-1,-1,-1};
        int temp=num;
        int count=0;
        int bitness=0;//разрядность
        while (temp>=1){
            bit[count]=temp%10;
            temp/=10;
            count++;
        }
        for (int i = 0; i < bit.length; i++) {
            if (bit[i] >= 0) {
                bitness++;
            } else {
                break;
            }
        }
        count=bitness-1;
        StringBuilder builder=new StringBuilder(roman);
        String ch="";
        while (count>=0){
            if(bit[count]>0){
                ch=roomNumbers[count][bit[count]-1];
                builder.append(ch);
            }
            count--;
        }
        roman=builder.toString();
        return roman;
    }
}
