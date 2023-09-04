import java.lang.Long;

public class Solution {

    public Solution() {
        System.out.println(reverse(9646324351));
    }

    public int reverse(int x) {
        long rev = 0;
        while (x != 0){
            rev = rev*10+(x%10);
            x = x/ 10;
        }
        if(rev>Math.pow(2,31) || rev<Math.pow(-2,31)) return 0;
        return (int)rev;
    }


}
