package expressao_arvore;

import java.util.Scanner;
import java.util.Stack;
import java.util.Scanner;

public class ExpTree {
	Stack<BinaryNode> stackInteger = new Stack<>();
	Stack<BinaryNode> stackOperator = new Stack<>();
	private BinaryNode root;
	Scanner scan = new Scanner(System.in);

	public String readExpression(String expression){
		String s = "";

		expression = organizeExpression(expression); //Chama o método caso o usuário coloque espaços entre os números e operadores. Ex: ( 2 + 3 ) => (2+3)

		if(expression.isEmpty()){
			System.out.println("String vazia");
		}else{
			for(int i = 0; i < expression.length(); i++){
				if(Character.isDigit(expression.charAt(i))){
					while(!(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/' || expression.charAt(i) == ')')){
						s = s + expression.charAt(i); 						 		//Concatenando números na String até aparecer um operador
						i++;									 				   //Percorre o array adicionando ++ no valor do contador (i)
					}					

					int valorCaracter = Integer.parseInt(s);		  			 //A variável receberá o valor do número da String por meio da função parseInt
					BinaryNode binaryNodeInt = new BinaryNode(valorCaracter);	//Cria um Nó que recebe o número 
					stackInteger.push(binaryNodeInt);						   //Coloca na pilha esse Nó
					s = "";												  	  //Limpando a String 

				}

				if(((expression.charAt(i) >= 'a')) && (expression.charAt(i) <= 'z')){
					System.out.println("Digite o valor da variável "+(char)expression.charAt(i)+" :"); //EX: "Digite o valor da variável a :"
					BinaryNode binaryNodeLetter = new BinaryNode(scan.nextInt());
					stackInteger.push(binaryNodeLetter);

				}else if(expression.charAt(i) == '-'){
					String sinal = null;
					while(!(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/' || expression.charAt(i) == ')')){
						sinal = sinal + expression.charAt(i+1);						 		
					}		
					
					int valorCaracter = Integer.parseInt(sinal)*(-1);
					BinaryNode binaryNodeInt = new BinaryNode(valorCaracter);
					stackInteger.push(binaryNodeInt);
					sinal = "";	

				}else if(expression.charAt(i) != '(' && expression.charAt(i) != ')'){
					BinaryNode binaryNodeOperator = new BinaryNode(expression.charAt(i));
					stackOperator.push(binaryNodeOperator);
				}


				if(expression.charAt(i) == ')'){					
					root = stackOperator.pop();
					root.setRight(stackInteger.pop());
					root.setLeft(stackInteger.pop());

					stackInteger.push(root);

				}

			}

		}//fim ELSE

		while(!stackOperator.isEmpty()){					//Enquanto a pilha de operador ainda tiver operador, faz o processo novamente para montar a estrutura restante
			BinaryNode number1 = stackInteger.pop();
			BinaryNode number2 = stackInteger.pop();
			BinaryNode operator = stackOperator.pop();

			root = operator;
			root.setRight(number1);
			root.setLeft(number2);

			stackInteger.push(root);
		}


		int resultado = percPosOrdem(root);
		System.out.println("Resultado da expressão digitada = "+resultado);

		return null;
	}

	private String organizeExpression(String expression){
		String[] arraySplit = new String[expression.length()]; 

		arraySplit  = expression.split(" "); //(2+3)
		String s = "";
		for(int i = 0; i < arraySplit.length; i++){
			s = s + arraySplit[i];
		}

		System.out.println("Expressão reformulada: "+s);

		return s;
	}

	private int percPosOrdem(BinaryNode p){
		int r = 0;
		if(p != null){
			if(p.getLeft() == null && p.getRight() == null){
				r = p.getValue();
			}else{
				int operando1 = percPosOrdem(p.getLeft());
				int operando2 = percPosOrdem(p.getRight());
				r = aplicarOperador(operando1, operando2, p.getValue());
			}
		}
		return r;
	}

	private int aplicarOperador(int op1, int op2, int op){
		int r = 0;
		switch(op){
		case 43: 					//43 equivale ao valor '+' na tabela ASCII
			r = op1 + op2;
			break;
		case 45: 					//45 equivale ao valor '-' na tabela ASCII
			if(op1 > op2){
				r = op1 - op2;
			}else if(op2 > op1){
				r = op2 - op1;
			}else{
				r = 0;
			}			
			break;
		case 47: 					//47 equivale ao valor '/' na tabela ASCII
			if(op1 == 0 || op2 == 0){
				System.out.println("Divisão por Zero - expressão inválida");
			}else{
				r = op1 / op2;
			}		
			break;
		case 42: 					//42 equivale ao valor '*' na tabela ASCII
			r = op1 * op2;
			break;
		}
		return r;
	}


}
