package atividade02;

public class Node {
	//ATRIBUTOS
	int value;
	Node prev, next;
	
	//CONSTRUTOR
	public Node(int x){
		this.value = x;
		this.next = this.prev = null;
	}	
}