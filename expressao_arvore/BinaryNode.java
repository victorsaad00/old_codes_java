/*
 * @author José Victor T. de Moura
 * */

package expressao_arvore;

public class BinaryNode {
	//ATRIBUTOS
	private int value;
	private BinaryNode left, right;
	
	//CONSTRUTOR
	public BinaryNode(int value){
		this.value = value;
		this.left = null;
		this.right = null;
	}

	//MÉTODOS ESPECIAIS
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BinaryNode getLeft() {
		return left;
	}

	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	public BinaryNode getRight() {
		return right;
	}

	public void setRight(BinaryNode right) {
		this.right = right;
	}

}
