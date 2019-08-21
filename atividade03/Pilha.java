/*
 * @Autor José Victor T. de Moura
 * 
 */
package atividade03;

import java.util.Arrays;

public class Pilha implements TADPilha {
	//ATRIBUTOS
	private int[] dados;
	private int topo;
	
	//CONSTRUTOR
	public Pilha(){
		this.topo = -1;
		this.dados = new int[10];
	}
	
	//MÉTODOS ESPECIAIS
	public int[] getDados() {
		return dados;
	}

	public void setDados(int[] dados) {
		this.dados = dados;
	}

	public int getTopo() {
		return topo;
	}

	private void setTopo(int numero) {
		if(numero == +1){
			numero++;
		}else{
			numero--;
		}
	}

	//MÉTODOS PERSONALIZADOS
	@Override
	public void push(int numero) {
		if(isEmpty()){
			topo++;
			dados[topo] = numero;			
		}else{
			realoca();
			topo++;
			dados[topo] = numero;
		}
	}

	@Override
	public int pop() {
		if(isEmpty()){
			System.out.println("pilha vazia");
		}else{
			int valorRetirado = this.getTopo();
			
			dados[topo] = 0;
			this.setTopo(-1);
			return valorRetirado;
		}
		return -1;
	}

	@Override
	public int top() {
		return this.getTopo();
	}

	@Override
	public int size() {
		return this.getTopo();
	}

	@Override
	public boolean isEmpty() {
		return this.getTopo() == -1;
	}

	public void realoca(){
		int novosDados[] = new int[dados.length * 2];
		
		for(int i = topo; i >= 0 ; i--){
			novosDados[i] = dados[i];
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		int auxiliar = topo;
		
		while(auxiliar > dados.length){
			sb.append(dados);
		}
		
		sb.append("]");
		
		return sb+"";
	}
	
	
}
