package arvore;

import javax.naming.BinaryRefAddr;

public class Teste {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();

		binaryTree.add(8);
		binaryTree.add(3);
		binaryTree.add(10);
		binaryTree.add(1);
		binaryTree.add(6);
		binaryTree.add(4);
		binaryTree.add(7);
		binaryTree.add(14);

		System.out.println(binaryTree.getRoot().getValue());
		System.out.println(binaryTree.search(1, binaryTree.getRoot()));
		System.out.println(binaryTree.calcularNivel(14, binaryTree.getRoot(), 0));
		System.out.println(binaryTree.mirrorEquals(binaryTree.getRoot().getLeft(), binaryTree.getRoot().getRight()));
	}
}

