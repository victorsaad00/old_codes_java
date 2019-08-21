package filas;

public class No {
	//ATRIBUTOS
	private No prox;
	private int valor;
	
	//CONSTRUTOR
	public No(int valor){
		this.setValor(valor);
		this.setProx(null);
	}
	
	//MÉTODOS ESPECIAIS
	public No getProx() {
		return prox;
	}

	public void setProx(No prox) {
		this.prox = prox;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
