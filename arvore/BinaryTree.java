package arvore;

public class BinaryTree implements TADBinaryTree{
	//ATRIBUTOS
	private BinaryNode root;

	//M�TODOS PERSONALIZADOS
	@Override
	public void add(int valor) {

		BinaryNode newNode = new BinaryNode(valor);		 			//Instancia um novo N� que recebe o valor digitado pelo usu�rio
		if(root == null){											//�rvore vazia
			root = newNode; 	  					   				//Ra�z recebe o valor
		}else{
			BinaryNode auxiliarRaiz = root;
			if(!search(valor,auxiliarRaiz)){						//auxiliarRaiz faz refer�ncia a root (ra�z)
				while(auxiliarRaiz != null){							//Ciclo para percorrer a �rvore at� achar um espa�o vazio
					if(auxiliarRaiz.getValue() > valor){		   		//Valor da auxiliarRaiz � MAIOR que o valor do usu�rio, logo, adiciona o novo valor na sub-�rvore da esquerda
						if(auxiliarRaiz.getLeft() == null){			  	//Condi��o para verificar se na esquerda de auxiliarRaiz � null.
							auxiliarRaiz.setLeft(newNode);				//Condi��o verdadeira, ent�o adiciona esse valor no respectivo local.
							break;
						}else{
							auxiliarRaiz = auxiliarRaiz.getLeft();		//Condi��o falsa, ent�o percorre a �rvore
						}		
					}else if(auxiliarRaiz.getValue() < valor){			//Valor da auxiliarRaiz � MENOR que o valor do usu�rio, logo, adiciona na sub-�rvore da direita
						if(auxiliarRaiz.getRight() == null){			//Condi��o para verificar se na direita de auxiliarRaiz � null.
							auxiliarRaiz.setRight(newNode);             //Condi��o verdadeira, ent�o adiciona esse valor no respectivo local.
							break;
						}else{
							auxiliarRaiz = auxiliarRaiz.getRight();		//Condi��o falsa, ent�o percorre a �rvore
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

	//M�TODOS ESPECIAIS
	public BinaryNode getRoot() {
		return root;
	}

	public void setRoot(BinaryNode root) {
		this.root = root;
	}
}
