package HW3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
// import java.util.stream.Collectors;

// Пусть дан произвольный список целых чисел, удалить из него четные числа
public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();
        List<Integer> rand = fillRandom(n);
        System.out.println("Array with all numbers: ");
        for(int k : rand){
            System.out.println(k);
        }
        // rand = rand.stream().filter(k -> k % 2 != 0).collect(Collectors.toList());
        delOddNumb(rand);
        System.out.println("Array without odd numbers: ");
        for(int i : rand){
            System.out.println(i);
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

    public static void delOddNumb(List<Integer> arr){
        Iterator<Integer> item = arr.iterator();
        while(item.hasNext()){
            if(item.next() % 2 == 0){
                item.remove();
            }
        }

    }
}
    

