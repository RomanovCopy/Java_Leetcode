package maximumAmountOfWater;

import java.util.*;

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


    public Solution() {

        int[] height = createArray(100);
        height=new int[] {1,8,6,2,5,4,8,3,7};
//        height=new int[] {1,2,1};

        System.out.println(maxArea(height));
    }


    public int[]createArray(int size){
        List<Integer>list=new ArrayList<>();
        Random random=new Random();
        for(int i=0;i<size;i++){
            list.add(random.nextInt(1,1000));
        }
        return Arrays.stream(list.toArray(new Integer[list.size()])).mapToInt(Integer::intValue).toArray();
    }


    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        int area=0;

        while (left < right) {
            area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }


}
