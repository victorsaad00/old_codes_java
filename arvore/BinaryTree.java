package arvore;

public class BinaryTree implements TADBinaryTree{
	//ATRIBUTOS
	private BinaryNode root;

	//MÉTODOS PERSONALIZADOS
	@Override
	public void add(int valor) {

		BinaryNode newNode = new BinaryNode(valor);		 			//Instancia um novo Nó que recebe o valor digitado pelo usuário
		if(root == null){											//Árvore vazia
			root = newNode; 	  					   				//Raíz recebe o valor
		}else{
			BinaryNode auxiliarRaiz = root;
			if(!search(valor,auxiliarRaiz)){						//auxiliarRaiz faz referência a root (raíz)
				while(auxiliarRaiz != null){							//Ciclo para percorrer a árvore até achar um espaço vazio
					if(auxiliarRaiz.getValue() > valor){		   		//Valor da auxiliarRaiz é MAIOR que o valor do usuário, logo, adiciona o novo valor na sub-árvore da esquerda
						if(auxiliarRaiz.getLeft() == null){			  	//Condição para verificar se na esquerda de auxiliarRaiz é null.
							auxiliarRaiz.setLeft(newNode);				//Condição verdadeira, então adiciona esse valor no respectivo local.
							break;
						}else{
							auxiliarRaiz = auxiliarRaiz.getLeft();		//Condição falsa, então percorre a árvore
						}		
					}else if(auxiliarRaiz.getValue() < valor){			//Valor da auxiliarRaiz é MENOR que o valor do usuário, logo, adiciona na sub-árvore da direita
						if(auxiliarRaiz.getRight() == null){			//Condição para verificar se na direita de auxiliarRaiz é null.
							auxiliarRaiz.setRight(newNode);             //Condição verdadeira, então adiciona esse valor no respectivo local.
							break;
						}else{
							auxiliarRaiz = auxiliarRaiz.getRight();		//Condição falsa, então percorre a árvore
						}
					}
				}
			} else {
				System.out.println("Valor ja existente.");
			}
		}
	}

	@Override
	public BinaryNode remove(BinaryNode subNode, int valor) {
		if(subNode == null){ 	
			return subNode;
		} else if(subNode.getValue() > valor){				
			subNode.setLeft(remove(subNode.getLeft(), valor));
		} else if(subNode.getValue() < valor){ 			  					   
			subNode.setRight(remove(subNode.getRight(), valor));
		} else if(subNode.getRight() != null && subNode.getLeft() != null){																
			BinaryNode auxiliar = biggestNode(subNode.getLeft());						 
			subNode.setLeft(remove(subNode.getLeft(), auxiliar.getValue()));
			subNode.setValue(auxiliar.getValue());
		}else if(subNode.getRight() == null){
			subNode = subNode.getLeft();
		}else if(subNode.getLeft() == null){
			subNode = subNode.getRight();
		}
		return subNode;
	}
	
	private BinaryNode biggestNode(BinaryNode node){
		if(node == null) return null;
		else if(node.getRight() != null) return biggestNode(node.getRight());
		else return node;
	}

	public int calcularNivel(int value, BinaryNode node, int profundidade){
		if(node == null) return -1;
		else if(node.getValue() == value) return profundidade;
		else if(node.getValue() > value) return calcularNivel(value,node.getLeft(),profundidade+1);
		else return calcularNivel(value,node.getRight(),profundidade+1);
	}

	public boolean search(int value, BinaryNode node){
		if(node == null) return false;
		else if(node.getValue() > value) return search(value,node.getLeft());
		else if(node.getValue() == value) return true;
		else return search(value, node.getRight());
	}

	boolean mirrorEquals(BinaryNode left, BinaryNode right) {
		if (left == null || right == null) return left == null && right == null;
		return mirrorEquals(left.getLeft(), right.getRight()) && mirrorEquals(left.getLeft(), right.getRight());
	}

	//MÉTODOS ESPECIAIS
	public BinaryNode getRoot() {
		return root;
	}

	public void setRoot(BinaryNode root) {
		this.root = root;
	}
}
