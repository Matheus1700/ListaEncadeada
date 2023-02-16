# ListaEncadeada
Repositório para armazenar meu projeto de estudos de Estrutura de Dados

Projeto criado para desenvolver os estudos da disciplina de Estrutura de Dados


--------------------------Classe Lista Encadeada-------------------------------
package lista_encadeada;

// assim como em No, nÃ£o sabemos o tipo da lista, por isso o <T>
public class ListaEncadeada<T> {

	private No<T> inicio;
	private No<T> ultimo;
	private int tamanho = 0;
	
	
	// inserindo um atrÃ¡s do outro
	public void inserir(T elemento) {
		No<T> celulaNova = new No<T>(elemento);
		if (tamanho == 0) {
			this.inicio = celulaNova;
		} else {
			this.ultimo.setProximo(celulaNova);
			celulaNova.setAnterior(ultimo);
		}
		
		this.ultimo = celulaNova;
		//this.ultimo.setProximo(this.inicio);  // lista circular
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
				atual.setElemento(null);
				this.tamanho--;
				return;
			}
		}
	}
	
	// para esse metodo funcionar, tem que comentar a linha 22 que adiciona a Lista Circular e mudar o while da linha 111
	public void deletarSemListaDupla(T elementoParaRemover) {
		if (elementoParaRemover == this.inicio.getElemento()) {
			No <T> noInicial = this.inicio;
			this.inicio = noInicial.getProximo();
			noInicial.setElemento(null);
			this.tamanho--;
			return;
		}
		
		for(No<T>atual = this.inicio; atual != null; atual = atual.getProximo()) {
			if(elementoParaRemover == atual.getProximo().getElemento()) {
				No<T> noRemovido = atual.getProximo();
				No<T> novoProximo = noRemovido.getProximo();
				atual.setProximo(novoProximo);
				
				noRemovido.setElemento(null);
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
			if (atual.getElemento() != null) {
				builder.append(atual.getElemento()).append(" -- Proximo: ");
				builder.append(atual.getProximo().getElemento()).append("; ");
			}
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
--------------------------------------------------------------------
  
  
Obs: lembrar de colocar todos os testes na classe Main. TODOS MESMO, e documentados
Obs2: alterações no metodo novo e no metodo inserir (por conta da lista circular)
