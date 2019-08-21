/*
 * @author José Victor T. de Moura  
 */
package atividadepilha2;
import java.util.Scanner;
import java.util.Stack;

public class Teste {

	public static void main(String[] args) throws PilhaVaziaException{
		Scanner scan = new Scanner(System.in);
		Stack<Character> pilha = new Stack<>();
		Palindromo palindromo = new Palindromo();
		char simbolo = 0;
		
		while(simbolo != '#'){
				System.out.println("Digite um número ou letra:");
				System.out.println("obs: para sair, digite #");
				simbolo = scan.next().charAt(0);
				
				if(simbolo != '#'){
					  pilha.push(simbolo);
				}
		}
		palindromo.separaPilhas(pilha);	
	}
}


