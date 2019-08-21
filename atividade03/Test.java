package atividade03;

public class Test {

	public static void main(String[] args) {
		DynamicStack stack = new DynamicStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.pop();
		System.out.println("Está vazia ? "+stack.isEmpty());
		System.out.println("Tamanho da pilha: "+stack.size());
		System.out.println("Elemento no topo: "+stack.top());
	
		System.out.println(stack);
	}

}
