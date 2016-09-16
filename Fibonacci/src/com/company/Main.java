package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Fibonacci fibonacci = new Fibonacci();

        for(int i=1; i<=10; i++){
            System.out.print(fibonacci.recursion(i) + " ");
        }
        System.out.println(fibonacci.recursion(10) + " ");

        for(int i=1; i<=10; i++){
            System.out.print(fibonacci.interation(i) + " ");
        }
        System.out.println(fibonacci.interation(10) + " ");


//        System.out.println("Enter number up to which Fibonacci series to print: ");
//
//        int number = new Scanner(System.in).nextInt(); System.out.println("Fibonacci series up to " + number +" numbers : ");
//
//        for(int i=1; i<=number; i++){
//            System.out.print(fibonacci.getValue(i) + " ");
//        }

    }
}
