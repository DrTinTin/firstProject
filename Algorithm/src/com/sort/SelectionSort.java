package com.sort;

public class SelectionSort {
    public void sort(int[] array){
        for (var i = 0; i < array.length;i++){
            var minIndex = 0;
            for ( var j = i; j < array.length; j ++){
                if (array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
        }
    }

    public void swap(int[] array, int i, int j){
        var temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
