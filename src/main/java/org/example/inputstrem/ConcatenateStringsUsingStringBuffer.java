package org.example.inputstrem;

import java.util.Scanner;

public class ConcatenateStringsUsingStringBuffer {


    //concateString function
    public static String concateStrings(String[] str){

        StringBuffer sb =new StringBuffer();

        for(int i=0;i<str.length;i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        //Taking input for number of strings
        System.out.println("Enter number of String :");
        int n=sc.nextInt();

        //Store String in String array
        System.out.println("Enter string :");
        String[] str=new String[n];

        //Taking strings input from user
        for(int i=0;i<n;i++){
            str[i]=sc.next();
            }

        //print concatenated strings
        System.out.println("\nconcate Strings :");
        System.out.println(concateStrings(str));
    }
}
