package atividadepilha2;

import java.util.Stack;

public class Palindromo {

	public void separaPilhas(Stack<Character> pilha) throws PilhaVaziaException{
		Stack<Character> pilhaNumero = new Stack();
		Stack<Character> pilhaLetra = new Stack();
		
		if(!pilha.isEmpty()){
			while (!pilha.isEmpty()) {
				if (Character.isDigit(pilha.peek())) {
					pilhaNumero.push(pilha.pop());
				} else {
					pilhaLetra.push(pilha.pop());
				}
			}
			if(pilhaNumero.isEmpty() == true){
				ePalindromoLetra(pilhaLetra); 
			}else if(pilhaLetra.isEmpty() == true){
				ePalindromoNumero(pilhaNumero);
			}else if(!(pilhaNumero.isEmpty() == true && pilhaLetra.isEmpty() == true)){
				ePalindromoNumero(pilhaNumero);
				ePalindromoLetra(pilhaLetra);
			}
		}else{
			throw new PilhaVaziaException();
		}
	}
	
	private void ePalindromoNumero(Stack pilhaNumero){
		Stack pilhaAuxiliarNumero = new Stack();
		
		if(pilhaNumero.size() % 2 == 0){ 						   //Pilha par
			for(int i = 0; i <= pilhaNumero.size()/2; i++){ 	  //Diferença entre as pilhas tá no for - menor e igual
				pilhaAuxiliarNumero.push(pilhaNumero.pop());
			}
				if(pilhaNumero.equals(pilhaAuxiliarNumero)){	//Compara os elementos das duas pilhas
					System.out.println("A pilha de número é palíndromo");
				}else{
					System.out.println("A pilha de número não é palíndromo");
				}
			}
			else{													 //Pilha ímpar
				for(int i = 0; i < pilhaNumero.size()/2; i++){		//Diferença entre as pilhas tá no for - só menor
				pilhaAuxiliarNumero.push(pilhaNumero.pop()); 	  
			}
				pilhaNumero.pop(); //Tirou o elemento 'a mais' da maior pilha
			
			if(pilhaNumero.equals(pilhaAuxiliarNumero)){
				System.out.println("A pilha de número é palíndromo");
			}else{
				System.out.println("A pilha de número não é palíndromo");
			}
		}
	}
	
	private void ePalindromoLetra(Stack pilhaLetra){
		Stack pilhaAuxiliarLetra = new Stack();
		
		if(pilhaLetra.size() % 2 == 0){ 							//Pilha par
			for(int i = 0; i <= pilhaLetra.size()/2; i++){
				pilhaAuxiliarLetra.push(pilhaLetra.pop());
			}
				if(pilhaLetra.equals(pilhaAuxiliarLetra)){
					System.out.println("A pilha de letra é palíndromo");
				}else{
					System.out.println("A pilha de letra não é palíndromo");
				}
			}
		else{													 //Pilha ímpar
			for(int i = 0; i < pilhaLetra.size()/2; i++){
				pilhaAuxiliarLetra.push(pilhaLetra.pop());
			}
			pilhaLetra.pop(); //Tirou o elemento 'a mais' da maior pilha
			
			if(pilhaLetra.equals(pilhaAuxiliarLetra)){
				System.out.println("A pilha de letra é palíndromo");
			}else{
				System.out.println("A pilha de letra não é palíndromo");
			}
		}
	}
	
	
}
