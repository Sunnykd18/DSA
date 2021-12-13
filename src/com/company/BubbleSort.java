package com.company;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {4, 3, 7, 1, 5};

        int n = a.length;
        for (int i = 0; i < n; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; i++) {
                if (a[i] < a[j]) {
                    swapped = true;
                    Swap(a, j + 1, j);
                }
            }
            if (!swapped){
                break;
            }

        }
    }
    static void Swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

}

