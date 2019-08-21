package arvore;

public class BinaryNode{
	//ATRIBUTOS
	private BinaryNode left, right;
	private int value;
	
	//CONSTRUTOR
	public BinaryNode(int newValue){
		this.setValue(newValue);
		this.setLeft(null);
		this.setRight(null);
	}
	
	//MÉTODOS ESPECIAIS
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

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
