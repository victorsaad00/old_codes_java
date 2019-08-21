package atividade02;

public class LDE {
	//ATRIBUTOS
	private Node firstNode, lastNode;
	private int size;

	//CONSTRUTOR
	public LDE() {
		firstNode = lastNode = null;
	}

	//M�TODOS PERSONALIZADOS
	public void insert(int x) {
		if (isEmpty()) {
			firstNode = lastNode = new Node(x);  
			size++;
		} else if (x < firstNode.value) {
			insertAtFront(x);
		} else if (x > lastNode.value) {
			insertAtBack(x);
		} else if(x > firstNode.value && x < lastNode.value) {
			Node newNode = new Node(x);				  	//Instancia��o de um novo N� 'aux' que receber� o valor digitado pelo usu�rio
			Node aux2 = firstNode;				   //Outro N� 'aux2' aponta pro primeiro N� da lista
				while (newNode.value >= aux2.value) { //Ciclo pra percorrer a lista at� que satisfa�a a condi��o
					aux2 = aux2.next;				
				}
			newNode.next = aux2;				
			Node aux3 = aux2.prev;			//Instancia��o de um novo 'aux3' para ajudar a guardar a refer�ncia do n� anterior de 'aux2'
			aux2.prev = newNode;
			aux3.next = newNode;
			newNode.prev = aux3;	
			size++;
		}else{
			System.out.println("Elemento "+x+" j� est� presente na lista");
		}
	}
	
	private void insertAtFront(int x){
			Node aux = new Node(x);   //Instancia��o de um novo N� 'aux' que receber� o valor digitado pelo usu�rio
			aux.next = firstNode;    //N� aux aponta pro primeiro N� da lista
			firstNode.prev = aux;   //Ainda sabendo a refer�ncia anterior do primeiro N� da lista, faz ele apontar pro auxiliar
								   //Feito isso, ocorrer� a dupla liga��o entre os elementos
			firstNode = aux;	  //Primeiro N� da Lista aponta pro N� auxiliar que � o novo primeiro		
			size++;				 //Aumenta mais um elemento na lista
	}

	private void insertAtBack(int x) {
			Node aux = new Node(x); //Instancia��o de um novo N� 'aux' que receber� o valor digitado pelo usu�rio
			aux.prev = lastNode;   //N� aux acessa a vari�vel 'prev' que aponta pro �ltimo N� da lista
			lastNode.next = aux;  //�ltimo N� da lista acessa a vari�vel 'next' que aponta pro N� aux
			                     //Feito isso, ocorrer� a dupla liga��o entre os elementos
			lastNode = aux;		//�ltimo N� da lista agora aponta pro 'aux' que � o novo �ltimo
			size++;			   //Aumenta mais um elemento na lista
	}

	public void remove(int x){
		if(isEmpty()){
			System.out.println("Lista vazia");
			
		} else if(searchItem(x)){
			if(x == firstNode.value){
				removeFromFront();
			}else if(x == lastNode.value){
				removeFromBack();
			}else if(x > firstNode.value && x < lastNode.value){
				Node aux = firstNode;		//N� 'aux' passa a referenciar o primeiro N� da lista
				
				while(aux.value < x){	  //Enquanto o valor de 'aux' for menor que o valor digitado pelo usu�rio, percorra a lista
					if(aux.value == x){	 //Quando o valor de 'aux' for igual ao valor recebido no par�metro, break. Ou seja, saia do while
						break;
					}
					aux = aux.next;		
				}
				
				Node aux2 = aux.prev;	//Instancia��o de um 'aux2' que ir� referenciar o elemento anterior de 'aux'
				Node aux3 = aux.next;	//Instancia��o de um 'aux3' que ir� referenciar o elemento posterior de 'aux'
				aux2.next = aux3;		//A partir dessa linha de c�digo, o 'aux2' vai apontar pro 'aux3'
				aux3.prev = aux2;		//'aux3' vai apontar pro 'aux2', havendo assim, a dupla liga��o entre os elementos posterior e
										//anterior de 'aux'.
				
				aux.next = aux.prev = null; //Ser� que � necess�rio ?
				size--;
			}
		}else{
			System.out.println("Elemento "+x+" n�o encontrado na lista");
		}
	}
	
	private void removeFromFront(){ 
			firstNode = firstNode.next;	//O primeiro N� da lista passa a ser o seu sucessor.
			firstNode.prev = null;	   //E o anterior do novo primeiro N�, aponta pra null.
			size--;
		}
	

	private void removeFromBack(){
			lastNode = lastNode.prev; //O �ltimo n� da lista passa a ser o seu antecessor.
			lastNode.next = null;	//E o pr�ximo do novo �ltimo N�, aponta pra null.
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