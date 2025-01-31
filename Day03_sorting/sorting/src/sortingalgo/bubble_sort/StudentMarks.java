package sortingalgo.bubble_sort;

import java.util.*;
public class StudentMarks {

    //Bubble sort function
    public static void bubbleSort(int marks[]){
        int n= marks.length;
        for(int i=0;i< n-1;i++){

            boolean swap=false;
            for(int j=0;j<n-i-1;j++){

                if(marks[j]>marks[j+1]){

                    int temp=marks[j];
                    marks[j]=marks[j+1];
                    marks[j+1]=temp;
                    swap=true;
                }

            }
            if(!swap){
                break;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("Enter number :");
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[] marks =new int[n];

        for (int i = 0; i < n; i++) {
            marks[i]= sc.nextInt();
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(marks[i]+" ");
        }
       bubbleSort(marks);

        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(marks[i]+" ");
        }


    }
}
