package com.company;

public class BSearch {
    public static void  main(String[]args){
        int [] a = { -4,-1,3,7,10,11};
        BinarySearch(a,3);
    }
    static int BinarySearch(int [] a ,int key){

        int low = 0;
        int high = a.length -1;

        while (low <= high){
            int mid = (low + high) /2;
            if (mid == key){
                return mid;
            }
            else if (key > mid){
                low = mid +1;
            }
            else{
                high =mid -1;
            }
        }
        return -1;
    }
}
