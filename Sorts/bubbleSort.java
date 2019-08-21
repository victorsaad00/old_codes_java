package Sorts;

public class bubbleSort {
	public static void main(String[] args) {
		int[] vetor = new int[10];
		
		
		for(int i = 9, j=0;i>0;i--,j++) {
			vetor[j] = i;
			
		}
		for(int i=0;i<10;i++)
			System.out.print(vetor[i]+" ");
		System.out.println();
		bubblesort(vetor);
		for(int i=0;i<10;i++)
			System.out.print(vetor[i]+" ");
	}
	
	public static void bubblesort(int[] vetor){
		int aux;
		for(int i = 0;i<vetor.length;i++){
			for(int j =0;j<vetor.length-1;j++){
				if(vetor[j] > vetor[j+1]){
					aux = vetor[j];
					vetor[j] = vetor[j+1];
					vetor[j+1] = aux;
				}
			}
		}
	}
}
