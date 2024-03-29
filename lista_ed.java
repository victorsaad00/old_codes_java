public class LDE {

	private Node firstNode, lastNode;
	private int size;

	public LDE() {
		firstNode = lastNode = null;
	}

	public void insert(int x) {
		if (isEmpty()) {
			firstNode = lastNode = new Node(x);  
			size++;
		} else if (x < firstNode.value) {
			insertAtFront(x);
		} else if (x > lastNode.value) {
			insertAtBack(x);
		} else if(x > firstNode.value && x < lastNode.value) {
			Node aux = new Node(x);				 	//Instanciação de um novo Nó 'aux' que receberá o valor digitado pelo usuário
			Node aux2 = firstNode;				  //Outro Nó 'aux2' aponta pro primeiro Nó da lista
				while (aux.value >= aux2.value) { //Ciclo pra percorrer a lista até que satisfaça a condição
					aux2 = aux2.next;				
				}
			aux.next = aux2;				
			Node aux3 = aux2.prev;			//Instanciação de um novo 'aux3' para ajudar a guardar a referência do nó anterior de 'aux2'
			aux2.prev = aux;
			aux3.next = aux;
			aux.prev = aux3;	
			size++;
		}else{
			System.out.println("Elemento "+x+" já está presente na lista");
		}
	}
	
	private void insertAtFront(int x){
			Node aux = new Node(x);   //Instanciação de um novo Nó 'aux' que receberá o valor digitado pelo usuário
			aux.next = firstNode;    //Nó aux aponta pro primeiro Nó da lista
			firstNode.prev = aux;   //Ainda sabendo a referência anterior do primeiro Nó da lista, faz ele apontar pro auxiliar
								  //Feito isso, ocorrerá a dupla ligação entre os elementos
			firstNode = aux;	 //Primeiro Nó da Lista aponta pro Nó auxiliar que é o novo primeiro		
			size++;				//Aumenta mais um elemento na lista
	}

	private void insertAtBack(int x) {
			Node aux = new Node(x); //Instanciação de um novo Nó 'aux' que receberá o valor digitado pelo usuário
			aux.prev = lastNode;   //Nó aux acessa a variável 'prev' que aponta pro último Nó da lista
			lastNode.next = aux;  //Último Nó da lista acessa a variável 'next' que aponta pro Nó aux
			                    //Feito isso, ocorrerá a dupla ligação entre os elementos
			lastNode = aux;		//Último Nó da lista agora aponta pro 'aux' que é o novo último
			size++;			  //Aumenta mais um elemento na lista
	}

	public void remove(int x){
		if(searchItem(x)){
			if(isEmpty()){
				System.out.println("Lista vazia");
			}else if(x == firstNode.value){
				removeFromFront();
			}else if(x == lastNode.value){
				removeFromBack();
			}else if(x > firstNode.value && x < lastNode.value){
				Node aux = firstNode;		//Nó 'aux' passa a referenciar o primeiro Nó da lista
				
				while(aux.value < x){	 //Enquanto o valor de 'aux' for menor que o valor digitado pelo usuário, percorra a lista
					if(aux.value == x){	//Quando o valor de 'aux' for igual ao valor recebido no parâmetro, break. Ou seja, saia do while
						break;
					}
					aux = aux.next;		
				}
				
				Node aux2 = aux.prev;	//Instanciação de um 'aux2' que irá referenciar o elemento anterior de 'aux'
				Node aux3 = aux.next;	//Instanciação de um 'aux3' que irá referenciar o elemento posterior de 'aux'
				aux2.next = aux3;		//A partir dessa linha de código, o 'aux2' vai apontar pro 'aux3'
				aux3.prev = aux2;		//'aux3' vai apontar pro 'aux2', havendo assim, a dupla ligação entre os elementos posterior e
										//anterior de 'aux'.
				
				aux.next = aux.prev = null; //Será que é necessário ?
				size--;
			}
		}else{
			System.out.println("Elemento "+x+" não encontrado na lista");
		}
	}
	
	private void removeFromFront(){ 
			firstNode = firstNode.next;	//O primeiro Nó da lista passa a ser o seu sucessor.
			firstNode.prev = null;	  //E o anterior do novo primeiro Nó, aponta pra null.
			size--;
		}
	

	private void removeFromBack(){
			lastNode = lastNode.prev; //O último nó da lista passa a ser o seu antecessor.
			lastNode.next = null;	//E o próximo do novo último Nó, aponta pra null.
			size--;
			
	}
	

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean searchItem(int x) {
		Node aux = firstNode;

		while (aux != null) {
			if (aux.value == x) {
				return true;
			}
			aux = aux.next;
		}

		return false;
	}
	
	public boolean search(int x, Node node){
		if(node.value == x) return true;
		else if(node.value > x) return search(x,node.next);
		else return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		Node aux = firstNode;

		sb.append("[");

		while (aux != null) {
			sb.append(aux.value);
			if (aux.next != null) {
				sb.append(", ");
			}
			aux = aux.next;
		}

		sb.append("]");

		return sb + " size = " + size;
	}

}
