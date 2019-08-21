/*package expressao_arvore;

import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int opcao = 0;

		while(opcao != 1 && opcao != 2){
			System.out.println("------------------ Calcula Expressao ----------------------");
			System.out.println("1- Inserir expressão");
			System.out.println("2- Sair");
			System.out.println("Digite sua escolha:");
			opcao = scan.nextInt();
		}
		switch(opcao){
		case 1:
			ExpTree expTree = new ExpTree();
			String expression;
			System.out.println("Digite aqui sua expressão matemática:");
			expression = scan.nextLine();
						
			//Caso o usuário digite uma expressão com espaços entre os números e operadores
			expTree.organizeExpression(expression);
			
			expTree.readExpression(expression); //CHAMA MÉTODO PRA LER A EXPRESSÃO E SEPARAR OS VALORES
			break;
		case 2:
			System.out.println("Programa finalizado");
			break;
		}
	}
}
*/