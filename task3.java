package HW3;
// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class task3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();
        List<Integer> rand = fillRandom(n);
        System.out.println("Array with all numbers: ");
        for(int k : rand){
            System.out.println(k);
        }
        statistics(rand);
        statistics2(rand);
        sc.close();
    }

    public static List<Integer> fillRandom(int size){
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < size; i++){
            res.add(new Random().nextInt(100));
        }
        return res;
    }

    public static void statistics(List<Integer> arr){//нахождение с помощью лямба выражений
        arr.stream().max(Comparator.comparing(i -> i)).ifPresent(max -> System.out.println("Max number: "+ max));
        arr.stream().min(Comparator.comparing(i -> i)).ifPresent(min -> System.out.println("Min number: " + min));
        arr.stream().mapToInt(i -> i).average().ifPresent(avg -> System.out.println("Average number : " + avg));
    }

    public static void statistics2(List<Integer> arr){
        int max = Integer.MIN_VALUE;
        for(int j : arr){
            max = (j > max) ? j : max;
        }
        System.out.println("Max number is " + max);
        int min = Integer.MAX_VALUE;
        for(int k : arr){
            min = ( k < min) ? k : min;
        }
        System.out.println("Min number is " + min);
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        System.out.println("Average number is " + (sum/arr.size()));



    }



}
