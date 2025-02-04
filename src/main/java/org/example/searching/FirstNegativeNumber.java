package org.example.searching;

public class FirstNegativeNumber {


    //negative number function first occurrence
    public static int negativeNuber(int[]nums){

        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[]nums={5,3,4,2,-1};
        System.out.println("Index of first negative number :"+negativeNuber(nums));
    }
}
