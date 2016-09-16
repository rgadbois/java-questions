package net.gadbois.quicksort;

public class Main {

    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();
        int[] input = {24,2,45,20,56,75,2,56,99,53,12, 18, 22, 0, 6, 9};
        sorter.sort(input);
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
