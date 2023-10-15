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

        int[] height = createArray(4);
        System.out.println(maxArea(height));
    }

    public int maxArea(int[] height) {
        int max=0;
        int length= height.length;
        if(length<2){
            max=length>0?height[0]*1:max;
            return max;
        }
        int[][]points=new int[height.length][2];
        for(int i=0;i<height.length;i++){
            points[i][0]=i;
            points[i][1]=height[i];
        }
        List<int[]> pointList = Arrays.asList(points);
        pointList.sort(Comparator.comparingInt(point -> -point[1]));
        points = pointList.toArray(new int[pointList.size()][]);
        int temp=0;
        int []point=points[0];
        for(int i= 1;i<length;i++){
            if(point[1]>points[i][1]){
                temp=Math.abs(points[i][1]*(point[0]-points[i][0]));
            }else {
                temp=Math.abs(point[1]*(point[0]-points[i][0]));
            }
            max=temp>max?temp:max;
        }
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
