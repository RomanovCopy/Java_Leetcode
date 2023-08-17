package twoSumm;

//Имеется массив целых чисел и целочисленная цель.
// Найти индексы двух чисел сумма которых равна цели.
//Можно предположить, что каждый ввод будет иметь ровно одно решение,
// и нельзя использовать один и тот же элемент дважды.
//Ответ можно вернуть в любом порядке.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Solution {

    Random random;
    public Solution(){
        random=new Random();
        Scanner scan=new Scanner(System.in);
        var array=createRandomArray(10);
        System.out.println("Сгенерирован массив целых чисел");
        System.out.println(Arrays.toString(array));
        System.out.println("Введите целевое значение");
        var target=scan.nextInt();
        var index=twoSum(array,target);
        if(index.length==2){
            System.out.println("Индексы элементов значения которых удовлетворяют нашим " +
                    "требованиям.");
            System.out.println(Arrays.toString(index));
        }else {
            System.out.println("Ни одна пара значений не удовлетворяют нашим " +
                    "требованиям.");
        }
        scan.close();
    }



    private int[] twoSum(int[] nums, int target) {
        // Создаем HashMap для хранения комплементов каждого числа
        HashMap<Integer, Integer> complementMap = new HashMap<>();

        // Проходим по массиву
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Проверяем, существует ли комплемент в HashMap
            if (complementMap.containsKey(complement)) {
                // Возвращаем индексы двух чисел
                return new int[] {complementMap.get(complement), i};
            }

            // Добавляем текущее число и его индекс в HashMap
            complementMap.put(nums[i], i);
        }

        // Если решение не найдено, возвращаем пустой массив или генерируем исключение
        return new int[0];
    }

    private int[]createRandomArray(int size){
        int[]array=new int[size];
        for(int i=0;i<size;i++){
            array[i]=random.nextInt(100);
        }
        return array;
    }
}
