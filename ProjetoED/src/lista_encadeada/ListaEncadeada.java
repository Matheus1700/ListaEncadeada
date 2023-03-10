package lista_encadeada;

// assim como em No, não sabemos o tipo da lista, por isso o <T>
public class ListaEncadeada<T> {

	private No<T> inicio;
	private No<T> ultimo;
	private int tamanho = 0;
	
	
	// inserindo um atrás do outro
	public void inserir(T elemento) {
		No<T> celulaNova = new No<T>(elemento);
		if (tamanho == 0) {
			this.inicio = celulaNova;
		} else {
			this.ultimo.setProximo(celulaNova);
			celulaNova.setAnterior(ultimo);
		}
		
		this.ultimo = celulaNova;
		this.ultimo.setProximo(this.inicio);  // lista circular
		this.tamanho++;
	}
	
	 
	/*
	// inserindo SEMPRE no inicio | ordem inversa
	public void inserir(T elemento) {
		No<T> celulaNova = new No<T>(elemento);
		this.inicio  = celulaNova;
		
		if (tamanho > 0) {
			celulaNova.setProximo(ultimo);
			ultimo.setAnterior(celulaNova);
		} 
		
		this.ultimo = celulaNova;
		this.tamanho++;
	}
	*/
	
	public int getTamanho() {
		return this.tamanho;
	}
	
	
	public void deletarElementoUnico(T elementoParaRemover) {
		for (No<T>atual = this.inicio; atual != null; atual = atual.getProximo()) {
			if(atual.getElemento() == elementoParaRemover) {
				No<T> noAnterior = atual.getAnterior();
				No<T> noProximo = atual.getProximo();
				
				noAnterior.setProximo(noProximo);
				noProximo.setAnterior(noAnterior);
				atual.setAnterior(null);
				atual.setProximo(null);
				this.tamanho--;
				return;
			}
		}
	}
	
	public void limparLista() {
		for (No<T> atual = this.inicio; atual != null;) {
			No<T>proximo = atual.getProximo();
			atual.setElemento(null);
			atual.setProximo(null);
			atual = proximo;
		}
		
		this.tamanho = 0;
	   	this.inicio = null; 
	   	this.ultimo = null;
	}
	

	public String imprimirOrdemNormal() {
		if (tamanho == 0) {
			return "[]";
		}
		
		StringBuilder builder = new StringBuilder();
		No<T> atual = this.inicio;
		builder.append("[");
		
		while (atual.getProximo() != this.inicio) {
			builder.append(atual.getElemento()).append(" -- Proximo: ");
			builder.append(atual.getProximo().getElemento()).append("; ");
			atual = atual.getProximo();	
		}

		builder.append(atual.getElemento()).append(" -- Proximo: ");
		builder.append(atual.getProximo().getElemento()).append("]");
		return builder.toString();
	}
	
	
	public String imprimir() {
		if (tamanho == 0) {
			return "[]";
		}
		
		StringBuilder builder = new StringBuilder();
		No<T> atual = this.inicio;
		builder.append("[");
		
		do {
			if (atual.getProximo() == null) {
				atual.setProximo(this.inicio);
			}
			
			builder.append(atual.getElemento()).append(" -- Proximo: ");
			builder.append(atual.getProximo().getElemento()).append("; ");
			atual = atual.getProximo();
			
		} while (atual.getProximo() != this.inicio);

		builder.append(atual.getElemento()).append(" -- Proximo: ");
		builder.append(atual.getProximo().getElemento()).append("]");
		return builder.toString();
	}
	
	
}
