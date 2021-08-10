package Lesson2.Strategy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class StrategyApp {
    public static void main(String[] args) {
        StrategyClient c = new StrategyClient();
        int[] arr0 = {1,3,2,1};
        c.setStrategy(new SelectionSort());
        c.executeStrategy(arr0);

        int[] arr1 = {11,8,65,15,7,9,154,82};
        c.setStrategy(new BubbleSort());
        c.executeStrategy(arr1);

        int[] arr2 = {9,3,4,8,12,98,75,34,28};
        c.setStrategy(new InsertingSort());
        c.executeStrategy(arr2);


    }
}

//Context
class StrategyClient {
    Sorting strategy;

    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy(int [] arr) {
        strategy.sort(arr);
    }
}

//Strategy
interface Sorting{
    void sort (int [] arr);
}

//Bubble sorting strategy
class BubbleSort implements Sorting{

    @Override
    public void sort(int[] arr) {
        System.out.println("Bubble sorting:");
        System.out.println("Before sorting: " + Arrays.toString(arr));
        for (int i = arr.length-1 ;i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr [j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        System.out.println("After sorting:" + Arrays.toString(arr));
    }
}

//Selection sorting strategy
class SelectionSort implements Sorting{

    @Override
    public void sort(int[] arr) {
        System.out.println("Selection sorting strategy:");
        System.out.println("Before sorting: " + Arrays.toString(arr));
        for (int barier = 0; barier < arr.length-1; barier++) {
            for (int j = barier+1; j < arr.length; j++) {
                if(arr[j] < arr[barier]){
                    int tmp = arr[j];
                    arr[j] = arr[barier];
                    arr[barier] = tmp;
                }
            }
        }
        System.out.println("After sorting:" + Arrays.toString(arr));
    }
}

//Insert sorting strategy
class InsertingSort implements Sorting{

    @Override
    public void sort(int[] arr) {
        System.out.println("Insert sorting strategy:");
        System.out.println("Before sorting: " + Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            int index = i;
            while (index-1 >= 0 && arr[index]<arr[index-1]){
                int tmp = arr[index];
                arr[index] = arr[index-1];
                arr[index-1] = tmp;
                index--;
            }
        }
        System.out.println("After sorting:" + Arrays.toString(arr));
    }
}