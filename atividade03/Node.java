package atividade03;

public class Node {
	//ATRIBUTOS
	private Node next;
	private int size;
	private int value;
	
	//CONSTRUTOR
	public Node(int x){
		this.setValue(x);
		this.setSize(0);
		this.setNext(null);
	}
	
	//MÉTODOS ESPECIAIS
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}