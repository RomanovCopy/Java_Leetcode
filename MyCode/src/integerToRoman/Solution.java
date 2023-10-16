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

    int[]multiPliers;
    String[]roomNumbers;
    HashMap<Integer,String>numbers;
    public Solution() {
        multiPliers=new int[]{1,2,3,4,5,6,7,8,9,10,50,100,500,1000};
        roomNumbers=new String[]{"I","II","III","IV","V","VI","VII","VIII","IX","X","L","C","D","M"};
        numbers=new HashMap<>();
        for(int i=0;i<multiPliers.length;i++){
            numbers.put(multiPliers[i],roomNumbers[i]);
        }
        System.out.println(intToRoman(90));
    }

    public String intToRoman(int num) {
        String roman="";
        int temp=num;
        int val=0;
        for(int i=multiPliers.length-1;i>=0;i--){
            val=temp/multiPliers[i];
            if(val>0){
                roman+=numberToString(val,multiPliers[i]);
                temp-=multiPliers[i]*val;
            }
        }
        return roman;
    }

    private String numberToString(int number, int multiplier){
        String val="";
        int index=Arrays.binarySearch(multiPliers, multiplier);
        while (number>0){
            val+=numbers.get(multiplier);
            number--;
        }
        if(index==3||index==8){
            val="I"+roomNumbers[index+1];
        }
        return val;
    }

}
