package arvore;

public interface TADBinaryTree {
	
	public void add(int valor);
	
	public BinaryNode remove(BinaryNode node, int valor);

	boolean search(int value, BinaryNode node);

	
}
