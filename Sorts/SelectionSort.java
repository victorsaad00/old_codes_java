package Sorts;

public class SelectionSort {
	public static void main(String[] args) {
		int[] vetor = {10,23,12,11,15,60,80,94,5,1};
		selectionSort(vetor);
		
		for(int i=0;i<vetor.length;i++){
			System.out.print(vetor[i] +" ");
		}
	}

	public static void selectionSort(int[] vetor){
		int min,aux;
		for(int i =0; i<vetor.length-1; i++){
			min = i;
			for(int j = i+1;j < vetor.length;j++){
				if(vetor[j]<vetor[min]) min = j;
			}
			
			if(min != i){
				aux = vetor[i];
				vetor[i] = vetor[min];
				vetor[min]=aux;
			}
		}
	}
}
