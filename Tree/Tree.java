package Tree;

public class Tree {

	private node root;

	//add a value into the tree.
	public void add(int x){
		node newNode = new node(x);
		if(root == null) root = newNode;
		else {
			node aux = root;
			if(!search(x,aux)){
				while(aux != null){
					if(aux.value == x){
						break;
					} else if(aux.value > x) {
						if(aux.left == null){
							aux.left = newNode;
							break;
						} else aux = aux.left;	
					} else {
						if(aux.value < x){
							if(aux.right == null){
								aux.right = newNode;
								break;
							} else aux = aux.right;
						}
					}
				}
			}
		}
	}

	private node righerValueNode(node node){ 					//Método que retorna o valor "mais a direita" da arvore. No caso, o de maior valor.
		if(node == null) return null;										//Se for nulo ele retorna nulo.
		if(node.right != null) return righerValueNode(node.right);			//Percorre até o ultimo valor da direita da arvore, que no caso é o de maior valor.
		return node;
	}

	public node remover(node SubRoot, int x){
		node RigherLeftNode;
		if(SubRoot == null) return SubRoot;
		else if (x < SubRoot.value) SubRoot.left = remover(SubRoot.left, x);
		else if(x > SubRoot.value) SubRoot.right = remover(SubRoot.right, x);
		else if(SubRoot.right != null && SubRoot.left != null){
			RigherLeftNode = righerValueNode(SubRoot.left); 					//Recebe o maior valor da sub-arvore da esquerda. Que é o nó mais a direita da sub-arvore.
			SubRoot.left = remover(SubRoot.left, RigherLeftNode.value);			
			SubRoot.value = RigherLeftNode.value;								//Substitui o valor da sub-raiz com o valor do nó mais a direita.
		} else if(SubRoot.right == null){
			SubRoot = SubRoot.left;
		} else if(SubRoot.left == null){
			SubRoot = SubRoot.right;
		}
		return SubRoot;
	}

	public boolean exist(int value, node node){
		if(node == null) return false;
		else if(node.value == value) return true;
		else if(node.value < value) return exist(value,node.right);
		else return exist(value,node.left);
	}
	
	public int calcularNivel(int value,node node,int nivel){
		if(node == null) return -1;
		else if(node.value > value) return calcularNivel(value,node.left,nivel+1);
		else if(node.value == value) return nivel;
		else return calcularNivel(value,node.right,nivel+1);
	}

	private boolean search(int value, node node){
		if(node == null) return false;
		else if( node.value == value) return true;
		else if(node.value > value) return search(value,node.left);
		else return search(value,node.right);
	}
	
	public int calcularAlturaNode(int value) throws Exception{
		node aux = root;
		int alturaRaiz = 0,altura;
		if(search(value,aux)){
			altura = calcularAltura(value,aux,alturaRaiz);
			return altura;
		} else
			throw new Exception("Altura indisponivel");
	}

	private int calcularAltura(int value, node aux, int altura) {
		if(aux.value == value) return altura;
		else if(aux.value > value) return calcularAltura(value,aux.left,altura+1);
		else return calcularAltura(value,aux.right,altura+1);
	}

	public node getRoot() {
		return root;
	}

	public void setRoot(node root) {
		this.root = root;
	}



}
