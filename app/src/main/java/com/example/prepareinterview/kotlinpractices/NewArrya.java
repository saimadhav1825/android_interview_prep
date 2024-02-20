package com.example.prepareinterview.kotlinpractices;

import java.util.Arrays;

public class NewArrya {
    // //p = [0,2,0,4,0,6,7]
    //    //[2,4,6,7,0,0,0]

    static void method() {
        int[] arr = new int[]{0, 2, 0, 4, 0, 6, 7};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[i] == 0) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        method();
    }
}

