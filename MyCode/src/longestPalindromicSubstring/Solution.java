package longestPalindromicSubstring;

public class Solution {


    //Этот код имеет линейную сложность O(n^2), где n - длина входной строки s.

    public Solution(String s){
        System.out.println( longestPalindrome(s));
    }

    int maxLen = 0;//для отслеживания максимальной длины палиндрома
    int lo = 0;//для отслеживания начального индекса палиндрома
    public String longestPalindrome(String s) {
        char[] input = s.toCharArray();//входная строка s в массив символов input
        if (s.length() < 2) {
            return s;//Если длина строки s меньше 2, возвращается исходная строка s
        }
        //Для каждого индекса i в массиве input вызывается метод expandPalindrome() дважды:
        // с j и k равными i (для палиндромов с нечетной длиной) и
        // с j равным i и k равным i+1 (для палиндромов с четной длиной).
        for (int i = 0; i < input.length; i++) {
            expandPalindrome(input, i, i);
            expandPalindrome(input, i, i + 1);
        }
        return s.substring(lo, lo + maxLen);
    }

    //Метод расширяет палиндром, проверяя символы влево и вправо от j и k.
    // Если найден палиндром большей длины, обновляются значения maxLen и lo.
    public void expandPalindrome(char[] s, int j, int k) {
        while(j >= 0 && k < s.length && s[j] == s[k]) {
            j--;
            k++;
        }
        if(maxLen < k - j - 1) {
            maxLen = k - j - 1;
            lo = j+1;
        }
    }
}
