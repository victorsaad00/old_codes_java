package Sorts;

public class QuickSort {
	public static void main(String[] args) {
		QuickSort Qs = new QuickSort();
		int[] v = {10,20,60,42,50,100,200,42,55,1,2,3};
		System.out.println(v.length+" vetor length");
		System.out.print("{");
		for(int i = 0;i<v.length;i++){
			System.out.print(v[i]+" ");
		}
		System.out.print("}");
		System.out.println();
		System.out.println("--------------------------------------");
		Qs.quickSort(v, 0, v.length - 1);
		System.out.print("{");
		for(int i = 0;i<v.length;i++){
			System.out.print(v[i]+" ");
		}
		System.out.print("}");

	}

	int partition(int arr[], int left, int right){
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];

		while (i <= j) {
			while (arr[i] < pivot) i++;
			while (arr[j] > pivot) j--;

			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		};
		return i;
	}

	void quickSort(int arr[], int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1)
			quickSort(arr, left, index - 1);
		if (right > index)
			quickSort(arr, index, right);
	}
}
