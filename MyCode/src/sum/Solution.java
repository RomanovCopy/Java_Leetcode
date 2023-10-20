package sum;

/*Для данного целочисленного массива nums вернуть все тройки [nums[i], nums[j], nums[k]],
такие, что i ≠ j, i ≠ k, j ≠ k и nums[i] + nums[j] + nums[k] == 0.

Обратите внимание, что набор решений не должен содержать дублирующиеся тройки.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Solution {

    public Solution() {
//        System.out.println(threeSum(generate(30)));
        System.out.println(threeSum(new int[]{0,3,0,1,1,-1,-5,-5,3,-3,-3,0}));

    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                for (int k = 0; k < nums.length; k++) {
                    if (i == k || j == k) continue;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        boolean eq = false;
                        for (var lst : list) {
                            if (lst.get(0).equals(l.get(0)) && lst.get(1).equals(l.get(1)) && lst.get(2).equals(l.get(2))) {
                                eq = true;
                                break;
                            }
                        }
                        if (!eq) list.add(l);
                        l = new ArrayList<>();
                    }
                }
            }
        }
        return list;
    }


    /**
     * генератор массива заданного размера
     * @param number размер
     * @return требуемый массив
     */
    private int[] generate(int number){
        Random random=new Random();
        int[]array=new int[number];
        for(int i=0;i<number;i++){
            array[i]=random.nextInt(-10,10);
        }
        return array;
    }

}
