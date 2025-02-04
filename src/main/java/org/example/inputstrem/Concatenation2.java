package org.example.inputstrem;

import java.util.Scanner;

public class Concatenation2 {

    //String Concatenation by StringBuffer
    public static long executionStringBuffer(String str){

        //Create StringBuffer object sb
        StringBuffer sb=new StringBuffer();
        long startTime=System.nanoTime();
        for(int i=0;i<1000000;i++){
            sb.append(str);

        }
        long endTime =System.nanoTime();

        //return total time for execution
        return endTime-startTime;
    }

    //String Concatenation by StringBuilder
    public static long executionStringBuilder(String str){
        StringBuilder sb=new StringBuilder();
        long startTime=System.nanoTime();
        for(int i=0;i<1000000;i++){
            sb.append(str);

        }

        long endTime =System.nanoTime();

        //return total time
        return endTime-startTime;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter a string :");
        String str=sc.next();

        //Print execution time
        System.out.println("StringBuffer time:"+executionStringBuffer(str));
        System.out.println("StringBuilder time:"+executionStringBuilder(str));
        System.out.println("StringBuilder is faster than StringBuffer!");

    }
}
