package org.example.inputstrem;

import java.util.*;
public class ReverseStringUsingStringBuilder {


    //Reverse function for string
    public static String reverse(String str){

        StringBuilder sb =new StringBuilder(str);
        sb.reverse();

        return sb.toString();

    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter a string :");
        String str=sc.next();

        //print reverse String
        System.out.println("\nreverse string");
        System.out.println(reverse(str));

    }
}
