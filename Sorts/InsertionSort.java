package Sorts;

public class InsertionSort {
	
	public static void main(String[] args) {

		int[] v = {10,20,60,43,50,100,200,42,55,1,2,3};
		System.out.print("{");
		for(int i = 0;i<v.length;i++){
			System.out.print(v[i]+" ");
		}
		System.out.print("}");
		System.out.println();
		System.out.println("--------------------------------------");
		insertionSort(v);
		System.out.print("{");
		for(int i = 0;i<v.length;i++){
			System.out.print(v[i]+" ");
		}
		System.out.print("}");

	}
	
	static void insertionSort(int[]v){
		for(int i = 1;i<v.length;i++){
			int element = v[i];
			int j = i;
			while(j>0 && v[j-1]>element){
				v[j]=v[j-1];
				j = j - 1;
			}
			v[j] = element;
		}
	}
}
