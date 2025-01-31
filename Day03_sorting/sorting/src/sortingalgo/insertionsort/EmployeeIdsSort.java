package sortingalgo.insertionsort;

import java.util.Scanner;

public class EmployeeIdsSort {

    //Insertion sort function
    public static void insertionSort(int[] id,int n){

        for(int i=1;i<n;i++){
            int key=id[i]; //store key
            int j=i-1;

            //Check until find the right position
            while(j>=0 && id[j]>key){
                id[j+1]=id[j];
                j--;
            }
         //Insert in position
            id[j+1]=key;
        }


    }

    public static void main(String[] args) {
        System.out.println("Enter number of ids :");
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] id =new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter id "+(i+1));
            id[i]= sc.nextInt();
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(id[i]+" ");
        }
        insertionSort(id,n);

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(id[i]+" ");
        }

    }
}
