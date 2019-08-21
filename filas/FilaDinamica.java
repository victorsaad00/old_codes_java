//author José Victor T. de Moura
package filas;

public class FilaDinamica implements TADFila{
	//ATRIBUTOS
	private No inicio, fim;
	private int quantidade;
	
	//CONSTRUTOR
	public FilaDinamica(){
		this.inicio = this.fim = null;
	}
	
	//MÉTODOS ESPECIAIS
	public No getInicio() {
		return inicio;
	}

	public void setInicio(No inicio) {
		this.inicio = inicio;
	}

	public No getFim() {
		return fim;
	}

	public void setFim(No fim) {
		this.fim = fim;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	//MÉTODOS PERSONALIZADOS
	@Override
	public void enqueue(int valor) {
		No auxiliar = new No(valor);
		
		if(isEmpty()){
			setInicio(auxiliar);
			setFim(auxiliar);
		}else{
			fim.setProx(auxiliar); //fim.prox = auxiliar;
			setFim(auxiliar);	  //fim = auxiliar (O novo 'FIM' passa a ser o Nó auxiliar)
		}
		setQuantidade(getQuantidade()+1);		
	}

	@Override
	public int dequeue() {
		int valorRetirado = -1;		
		
		if(!isEmpty()){
			valorRetirado = this.getInicio().getValor(); //Variável receberá o valor contido no primeiro Nó da fila
			this.setInicio(inicio.getProx()); 
				if(inicio == null){
					setFim(null);
				}
				setQuantidade(getQuantidade()-1);	
		}		
		return valorRetirado;
	}

	@Override
	public boolean isEmpty() {
		return quantidade == 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		No auxiliar = inicio;
		
		while(auxiliar != null){
			sb.append(auxiliar.getValor());
				if(auxiliar.getProx() != null){
					sb.append(", ");
				}				
				auxiliar = auxiliar.getProx();
			}
		
		sb.append("]");
		sb.append("\n");
		sb.append("Quantidade = "+quantidade);
		
		return "Fila: "+sb;
	}
	
	public void inverterFila(FilaDinamica filaPrincipal){
		if(!filaPrincipal.isEmpty()){
			FilaDinamica filaAuxiliar1 = new FilaDinamica();
			FilaDinamica filaAuxiliar2 = new FilaDinamica();
			int quantidade = filaPrincipal.quantidade;
		
			while(filaAuxiliar2.quantidade != quantidade){
				while(filaPrincipal.quantidade > 1){
					filaAuxiliar1.enqueue(filaPrincipal.dequeue());
				}
					filaAuxiliar2.enqueue(filaPrincipal.dequeue());
					
				while(filaAuxiliar1.quantidade > 1){
					filaPrincipal.enqueue(filaAuxiliar1.dequeue());
				}
				if(filaAuxiliar1.quantidade != 0){
					filaAuxiliar2.enqueue(filaAuxiliar1.dequeue());	
				}
			}
			System.out.println("Fila invertida: "+filaAuxiliar2);
	    }
	}
			
}	
	

