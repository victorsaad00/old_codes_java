package filas;
import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		FilaDinamica filaDinamica = new FilaDinamica();
		 
		filaDinamica.enqueue(-1);
		filaDinamica.enqueue(0);
		filaDinamica.enqueue(1);
		filaDinamica.enqueue(2);
		filaDinamica.enqueue(3);
		filaDinamica.enqueue(4);
		filaDinamica.enqueue(5);
		filaDinamica.dequeue();
		filaDinamica.dequeue();
		
		System.out.println(filaDinamica);
		
		filaDinamica.inverterFila(filaDinamica);		
	}

}
