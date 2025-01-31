package sortingalgo.quicksort;

import java.util.Scanner;
public class ProductPrices {

    //QuickSort function
    public static void quickSort(int[] price,int left ,int right){

        if(left<right){
            int pi =partition(price,left,right);

            quickSort(price,left,pi-1);
            quickSort(price,pi+1,right);
        }
    }

    //partitioning function
    public static int partition(int[] price,int left,int right){
        int pivot=price[right];
        int i=left-1;

        for(int j=left;j<right;j++){

            if(price[j]<pivot){
                i++;
                int temp=price[j];
                price[j]=price[i];
                price[i]=temp;
            }
        }

        int temp=price[right];
        price[right]=price[i+1];
        price[i+1]=temp;

        return i+1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of product prices:");
        int n = sc.nextInt();
        int[] price = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter price " + (i + 1));
            price[i] = sc.nextInt();
        }

        // Display prices before sorting
        System.out.println("Prices before sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(price[i] + " ");
        }
        System.out.println();

        // Perform quickSort
        quickSort(price, 0, n - 1);

        // Display prices after sorting
        System.out.println("Prices after sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(price[i] + " ");
        }
        System.out.println();
    }
}

