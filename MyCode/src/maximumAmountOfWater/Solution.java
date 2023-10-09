package maximumAmountOfWater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Вам дан целочисленный массив height длиной n. Нарисованы n вертикальных линий так,
 * что две конечные точки i-й линии имеют координаты (i, 0) и (i, height[i]).
 *
 * Найдите две линии, которые вместе с осью x образуют контейнер так, чтобы этот
 * контейнер мог содержать максимальное количество воды.
 *
 * Верните максимальное количество воды, которое может вместить контейнер.
 *
 * Обратите внимание, что нельзя наклонять контейнер.
 */

public class Solution {

    private int[] height;

    public Solution() {

        height = createArray(10);
        System.out.println(maxArea(height));
    }

    public int maxArea(int[] height) {
        int max = 0;
        
        return max;
    }

    public int[]createArray(int size){
        List<Integer>list=new ArrayList<>();
        Random random=new Random();
        for(int i=0;i<size;i++){
            list.add(random.nextInt(1,25));
        }
        return Arrays.stream(list.toArray(new Integer[list.size()])).mapToInt(Integer::intValue).toArray();
    }


//    public int maxArea(int[] height) {
//        int max = 0;
//        int temp=0;
//        int length= height.length;
//        for(int i=0;i<length;i++){
//            for(int j=0;j<length;j++){
//                temp=height[i]<=height[j]?
//                        height[i]*Math.abs(i-j):
//                        height[j]*Math.abs(i-j);
//                max=temp>max?temp:max;
//            }
//        }
//        return max;
//    }


}
