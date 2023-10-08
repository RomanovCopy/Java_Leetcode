package maximumAmountOfWater;

import java.util.Arrays;

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

        height = new int[]{1, 2, 1};
        System.out.println(maxArea(height));
    }

    public int maxArea(int[] height) {
        int max = 0;
        int temp=0;
        int length= height.length;
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                temp=height[i]<=height[j]?
                        height[i]*Math.abs(i-j):
                        height[j]*Math.abs(i-j);
                max=temp>max?temp:max;
            }
        }
        return max;
    }


}
