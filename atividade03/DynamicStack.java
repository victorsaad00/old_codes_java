package atividade03;

public class DynamicStack implements TADPilha {
	//ATRIBUTOS
	private Node top;
	private int size;
		
	//CONSTRUTOR
	public DynamicStack() {
		this.setSize(0);
		this.setTop(null);

	}
	
	//M�TODOS ESPECIAIS
	private int getSize() {
		return size;
	}

	private void setSize(int size) {
		if(size == 1){
			this.size += 1;
		}else if(size == -1){
			this.size -= 1;
		}
	}
	
	private Node getTop() {
		return top;
	}

	private void setTop(Node top) {
		this.top = top;
	}
	
	//M�TODOS PERSONALIZADOS
	@Override
	public void push(int x) {
		if(isEmpty()){
			this.setTop(new Node(x)); // top = new Node(x);  -> mesma coisa
		}else{
			Node auxNode = new Node(x); //Instancia��o de um novo N� que ser� o futuro primeiro elemento da pilha
			auxNode.setNext(getTop()); //Faz o novo N� (auxNode) chamar o m�todo 'setNext' para apontar pro elemento que est� no topo da pilha
			this.setTop(auxNode);	  //Chama o m�todo 'setTop' fazendo o novo N� (auxNode) ser o elemento do topo da pilha
			this.setSize(1);	 
		}
	}
	
	@Override
	public int pop() {
		if(isEmpty()){
			System.out.println("Pilha vazia");
		}else{
			int value = this.getTop().getValue(); //Armazeno o valor inteiro que est� no topo, numa vari�vel do tipo int (value)
			this.setTop(top.getNext());		     //Chamo o m�todo para que o topo  passe a referenciar o pr�ximo elemento da pilha
			this.setSize(-1);
			
			return value;					   //Retorno o valor que foi gravado na vari�vel (value)
		}
		return -1;
	}

	@Override
	public int size() {
		return this.getSize();
	}

	@Override
	public int top() {
		return this.getTop().getValue();
	}

	@Override
	public boolean isEmpty() {
		return getSize() == -1;  //Escolhe-se um valor inv�lido (-1) para tornar verdadeira a express�o, caso a pilha
								//esteja vazia
	}

	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("\n");
		sb.append("Pilha [Topo-> ");
		Node auxNode = this.getTop();
		
		while(auxNode != null){
			sb.append(auxNode.getValue());
			if(auxNode.getNext() != null){
				sb.append(",");
			}
			auxNode = auxNode.getNext();
		}
		
		sb.append("]");
		
		return sb+" Size: "+this.getSize();
	}
	
}
