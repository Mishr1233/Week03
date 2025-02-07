package org.example.timeandpacecomlexity;

public class StringConcatenationPerformance {

    //StringConcatenation function
    public static void stringConcatenation(String str,int operation){
        String newstr="";
        for(int i=0;i<operation;i++){
            newstr=newstr+str;
        }

    }

    //StringBuilder concatenation function
    public static void stringBuilder(String s,int operation){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<operation;i++){
            sb.append(s);
        }
    }

    //StringBuffer concatenation function
    public static void stringBuffer(String s,int operation){
        StringBuffer sb=new StringBuffer();

        for(int i=0;i>operation;i++){
            sb.append(s);
        }
    }


    //compareString performance in ms
    public static void  compareStringPerformance(int size){

        long startTime=System.nanoTime();
        stringConcatenation("ram",size);
        long endTime =System.nanoTime();

        double stringTimeMs=(endTime-startTime)/1_000_000.0;

        startTime=System.nanoTime();
        stringBuilder("ram",size);
        endTime=System.nanoTime();

        double stringBuilderTimeMs =(endTime-startTime)/1_000_000.0;


        startTime=System.nanoTime();
        stringBuffer("ram",size);
        endTime=System.nanoTime();

        double stringBufferTimeMs=(endTime-startTime)/1_000_000.0;

        System.out.println("StringConcatenation time in (ms) :"+stringTimeMs);
        System.out.println("StringBuilderConcatenation time in (ms) :"+stringBuilderTimeMs);
        System.out.println("StringBufferConcatenation time in (ms) :"+stringBufferTimeMs);


    }



        public static void main (String[]args){
            int[] sizes = {1000, 10000, 1000000};

            for (int size : sizes) {

                System.out.println("\nDataset Size: " + size);
                compareStringPerformance(size);
            }


        }
    }

