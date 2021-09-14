package search_and_sort;

import java.util.Arrays;
import java.util.Scanner;

public class Search_And_Sort {


    //==================================== SWAP FUNC ==========================
    public static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // =====================  LINEAR SEARCH ================================
    public static int LinearSearch(int arr[], int n){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == n)
                return i;
        }
        return -1;
    }
    
    
    // =====================  Binary SEARCH ================================
    public static int BinarySearch(int arr[], int n){
        Arrays.sort(arr);
        int s  = 0, e = arr.length-1 , mid;
        
        while(e >= e){
            mid = s + ((e - s) / 2);
            if(arr[mid] == n)
                return mid;
            else if(arr[mid] > n)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return -1;
    }
    
    
    // =====================  Binary SEARCH Recurssion ================================
    public static int BinarySearchRecursion(int arr[], int s, int e, int n){
        Arrays.sort(arr);
        
        if(s <= e){
            int mid = s + ((e - s) / 2);
            if(arr[mid] == n)
                return mid;
            else if(arr[mid] > n)
                return BinarySearchRecursion(arr, s, mid - 1, n);
            else
                return BinarySearchRecursion(arr, mid + 1, e, n);
        }
        return -1;
    }
    
    // =====================  Bubble Sort ================================
    public static void bubbleSort(int arr[]){
        boolean isSwaped = true;
        int i = 0;
        while(isSwaped){
            isSwaped = false;
            for(int j = 0; j < (arr.length) - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                    isSwaped = true;
                }
            }
            i++;
        }
    }
    
    // =====================  Selection Sort ================================
    public static void selectionSort(int arr[]){
        int min_indx;
        for(int i = 0; i < arr.length-1; i++){
            min_indx = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[min_indx] > arr[j])
                    min_indx = j;
            }
            swap(arr, min_indx, i);
        }
    }
    
    
    // =====================  Insertion Sort ================================
    public static void inserionSort(int arr[]){
        int k, i, j;
        for(i = 1; i < arr.length; i++){
            k = arr[i];
            j = i - 1;
            while(j >= 0 && arr[j]>k){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = k;
        }
    }
    
    // =====================  Merge Sort ================================
    public static void mergeSort(int arr[], int s, int e){
        int m;
        if(e > s){
            m = s + ((e - s)/2);
            mergeSort(arr, s, m);
            mergeSort(arr, m+1, e);
            merge(arr, s, m, e);
        }
    }
    // ========================== MERGE ===================
    public static void merge(int arr[], int l, int m, int r){
        int n1 = m - l + 1, n2 = r - m;
        
        int L[] = new int[n1], R[] = new int[n2];
        for(int i = 0; i < n1; i++){
            L[i] = arr[l + i];
        }
        
        for(int i = 0; i < n2; i++){
            R[i] = arr[m + 1 + i];
        }
        
        int i = 0, j = 0, k = l;
        while(i < n1 && j < n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        
    }
    
    // ==================================== Quick Sort =======================
    public static void quickSort(int arr[], int s, int e){
        if(e > s){
            int pivot = partition(arr, s, e);
            quickSort(arr, s, pivot - 1);
            quickSort(arr, pivot + 1, e);
        }
    }
    
    public static int partition(int arr[], int s, int e){
        int pivot = arr[e], k = s - 1;
        for(int i = s; i < e; i++){
            if(pivot > arr[i]){
                k++;
                swap(arr, k, i);
            }
        }
        k++;
        swap(arr, k, e);
        return k;
    }
    // ======================================================================
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[5];
        int arr2[] = {5, 2, 8, 1, 3, 7};
        int arr3[] = {1, 2, 8, 7, 9, 17, 55, 4};
        int arr4[] = {1, 2, 8, 7, 9, 17, 55, 4, 9};
        int arr5[] = {1, 2, 8, 7, 9, 17, 55, 4, 9, 5};
        int arr6[] = {1, 2, 8, 7, 9, 17, 55, 4, 9, 5};
        
//        System.out.println("Enter Array Element : ");
//        for(int i = 0; i < arr.length; i++){
//            arr[i] = sc.nextInt();
//        }
//        
//        System.out.println(Arrays.toString(arr));
//        
//        System.out.println("==============LinearSearch================");
//        System.out.println(LinearSearch(arr, 5));
//        System.out.println("==============BinarySearch================");
//        System.out.println(BinarySearch(arr, 5));
//        System.out.println(Arrays.toString(arr));
//        System.out.println("==============BinarySearchRecu.================");
//        System.out.println(BinarySearchRecursion(arr, 0, arr.length-1, 5));
//        System.out.println("==============BubleSort.================");
        bubbleSort(arr2);
        System.out.println(Arrays.toString(arr2));
        selectionSort(arr3);
        System.out.println(Arrays.toString(arr3));
        inserionSort(arr4);
        System.out.println(Arrays.toString(arr4));
        mergeSort(arr5, 0, arr5.length-1);
        System.out.println(Arrays.toString(arr5));
        quickSort(arr6, 0, arr6.length-1);
        System.out.println(Arrays.toString(arr6));
        
    }
    
}
