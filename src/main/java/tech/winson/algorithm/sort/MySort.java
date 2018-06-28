package tech.winson.algorithm.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MySort {

    public static void main(String[] args) {
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
//        bubbleSort(Arrays.copyOf(arr,arr.length));
//        selectSort(Arrays.copyOf(arr,arr.length));
//        insertSort(Arrays.copyOf(arr,arr.length));
        quickSort(Arrays.copyOf(arr, arr.length));
//        shellSort(Arrays.copyOf(arr,arr.length));
//        mergeSort(Arrays.copyOf(arr,arr.length));
          new HeapSort(arr).sort();
//        for(int i :arr){
//            System.out.println(i);
//        }
    }

    /**
     * 冒泡排序(掌握)
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        System.out.println("冒泡排序：" + (System.currentTimeMillis() - start));
    }

    /**
     * 选择排序（掌握）
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
        System.out.println("选择排序：" + (System.currentTimeMillis() - start));
    }

    /**
     * 插入排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        long start = System.currentTimeMillis();
        for (int i = 1; i < arr.length; i++) {
            int now = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > now) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = now;
        }
        System.out.println("插入排序：" + (System.currentTimeMillis() - start));
    }

    /**
     * 快速排序
     *
     * @param arr
     */
    public static void quickSort(int[] arr) {
        long start = System.currentTimeMillis();
        qsort(arr, 0, arr.length - 1);
        System.out.println("快速排序：" + (System.currentTimeMillis() - start));
    }

    private static void qsort(int[] arr, int i, int j) {
        if (i < j) {
            int pivot = partition(arr, i, j);
            qsort(arr, i, pivot - 1);
            qsort(arr, pivot + 1, j);
        }
    }

    private static int partition(int[] arr, int i, int j) {
        int pivot = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                --j;
            }
            arr[i] = arr[j];             //交换比枢轴小的记录到左端

            while (i < j && arr[i] <= pivot) {
                ++i;
            }
            arr[j] = arr[i];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[i] = pivot;
        //返回的是枢轴的位置
        return i;
    }

    /**
     * 希尔排序
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        long startTime = System.currentTimeMillis();
        int gap = 1, i, j, len = arr.length;
        int temp;
        while (gap < len / 3)
            gap = gap * 3 + 1; // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
        for (; gap > 0; gap /= 3) {
            for (i = gap; i < len; i++) {
                temp = arr[i];
                for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap)
                    arr[j + gap] = arr[j];
                arr[j + gap] = temp;
            }
        }
        System.out.println("希尔排序：" + (System.currentTimeMillis() - startTime));
    }

    /**
     * 归并排序(递归版)
     *
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        long startTime = System.currentTimeMillis();
        int len = arr.length;
        int[] result = new int[len];
        mSortRecursive(arr, result, 0, len - 1);
        System.out.println("归并排序(递归版)：" + (System.currentTimeMillis() - startTime));
    }

    private static void mSortRecursive(int[] arr, int[] result, int start, int end) {
        if (start >= end) {
            return;
        }
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        mSortRecursive(arr, result, start1, end1);
        mSortRecursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2) {
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            result[k++] = arr[start1++];
        }
        while (start2 <= end2) {
            result[k++] = arr[start2++];
        }
        for (k = start; k <= end; k++) {
            arr[k] = result[k];
        }
    }

}
