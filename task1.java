package HW3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Реализовать алгоритм сортировки слиянием

public class task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();
        List<Integer> rand = fillRandom(n);
        int[] result = rand.stream().mapToInt(i -> i).toArray();
        for(int i : result){
            System.out.println(i);
        }
        System.out.println("Array after sorting: ");
        mergeSort(result, n);
        for(int h : result){
            System.out.println(h);
        }
        sc.close();
    }

    public static List<Integer> fillRandom(int size){
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < size; i++){
            res.add(new Random().nextInt(100));
        }
        return res;
    }
    public static void mergeSort(int[] arr, int n){
        if(n < 2) return;

        int mid = n / 2;
        int[] left = new int[mid];
        int[] right = new int[n - mid];
        System.arraycopy(arr,0,left,0,mid);//скопировали первую часть исходного массива
        System.arraycopy(arr,mid,right,0,n-mid);// скопировали вторую часть исходного массива 
        mergeSort(left, mid);//делим пополам получившиеся массивы с помощью рекурсии 
        mergeSort(right, n-mid);
        merge(arr,left,right,mid,n-mid);

    }

    public static void merge(int[] arr, int[] left, int[] right,int leftlength, int rightlenght ){ //метод для сбора частей массива в один массив

        int i = 0, j = 0, k = 0;
        while(i < leftlength && j < rightlenght){
            if(left[i] <= right[j]){
                arr[k++] = left[i++];
            }else arr[k++] = right[j++];
        }
        while(i < leftlength){// добавляем циклы для занесения последнего элемента массива 
            arr[k++] = left[i++];
        }
        while(j < rightlenght){// добавляем циклы для занесения последнего элемента массива 
            arr[k++] = right[j++];
        }

    }

    
}
