package expressao_arvore;
import java.util.Scanner;

public class Principal2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ExpTree expTree = new ExpTree();
		String expression;
		
		System.out.println("Digite sua expressão matemática:");
		expression = scan.nextLine();
				
		expTree.readExpression(expression); 
		
	}

}
