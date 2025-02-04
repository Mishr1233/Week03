package org.example.inputstrem;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicatesFromStringUsingStringBuilder {

    //remove duplicate from string
    public static String removeDuplicate(String str){

        StringBuilder sb=new StringBuilder();
        HashSet<Character>hs=new HashSet<>();

        for(int i=0;i<str.length();i++){
            if(hs.contains(str.charAt(i))){
               continue;
            }
            hs.add(str.charAt(i));
            sb.append(str.charAt(i));
        }
        return sb.toString();

    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter a string :");
        String str=sc.next();

        //print String
        System.out.println("\nstring");
        System.out.println(removeDuplicate(str));
    }
}
