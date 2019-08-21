package Sorts;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		MergeSort m = new MergeSort();
		int[] v = {10,20,60,42,50,100,200,42,55,1,2,3};
		System.out.println(v.length);
		System.out.print("{");
		for(int i = 0;i<v.length;i++){
			System.out.print(v[i]+" ");
		}
		System.out.print("}");
		System.out.println();
		System.out.println("--------------------------------------");
		m.mergeSort(v);
		System.out.print("{");
		for(int i = 0;i<v.length;i++){
			System.out.print(v[i]+" ");
		}
		System.out.print("}");

	}

	void mergeSort(int [] arr){
		if( arr.length <= 1) return;

		int mid = arr.length / 2;
		int [] left = Arrays.copyOfRange(arr, 0, mid);
		int [] right = Arrays.copyOfRange(arr, mid, arr.length);
		mergeSort(left);
		mergeSort(right);
		merge(left,right,arr);
	}

	void merge(int [] left, int [] right, int[] arr){
		int arrIndex = 0;
		int leftIndex = 0;
		int rightIndex = 0;

		//both left and right are not empty
		while( leftIndex < left.length && rightIndex < right.length){
			if(left[leftIndex] < right[rightIndex]){
				arr[arrIndex++] = left[leftIndex++];
			} else {
				arr[arrIndex++] = right[rightIndex++];
			}
		}
		//if left still has some content
		while(leftIndex < left.length){
			arr[arrIndex++] = left[leftIndex++];
		}
		//if right still has some content
		while(rightIndex < right.length){
			arr[arrIndex++] = right[rightIndex++];
		}
	}
}
