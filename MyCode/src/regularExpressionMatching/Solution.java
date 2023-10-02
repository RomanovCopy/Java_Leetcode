package regularExpressionMatching;

/* Учитывая входную строку s и шаблон p, реализуйте сопоставление регулярных выражений с
 * поддержкой символов '.' и '*', где:
 *
 * '.' Соответствует любому одиночному символу.
 * '*' Соответствует нулю или более предшествующим элементам.
 * Сопоставление должно охватывать всю входную строку (не частичное сопоставление).*/


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public Solution() {

        String s = "romanov";
        String p = "*v";
        boolean result = isMatch(s, p);
        Pattern pattern=Pattern.compile(p);
        Matcher matcher=pattern.matcher(s);
        System.out.println("Сопоставление: " + result+" "+(matcher.find()?
                matcher.group():"") );

    }

    public boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Исходные значения для пустых строк
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }

        // Заполнение таблицы DP
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (sc == pc || pc == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                }
            }
        }

        return dp[m][n];
    }
}
