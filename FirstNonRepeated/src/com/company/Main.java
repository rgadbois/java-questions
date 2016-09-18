package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        System.out.println(" Please enter the input string :" );
//        Scanner in = new Scanner(System.in);
//        String s=in.nextLine();

        String s = new String("Please enter the input string :" );

        FirstNonRepeated firstNonRepeated = new FirstNonRepeated(s);
        firstNonRepeated.process();
        Character c = firstNonRepeated.firstNonRepeatedChar();

        System.out.println("input '" + s + "'.");
        System.out.println("The first non repeated character is :  '" + c + "'");
    }
}
