package teste;

import lista_encadeada.ListaEncadeada;

public class ListaEncadeadaTeste {

	public static void main(String[]args) {
		ListaEncadeada<Integer> lista = new ListaEncadeada<>();
		lista.inserir(1);
		
		
		lista.inserir(2);
		lista.inserir(3);
		lista.inserir(4);
		System.out.println(lista.imprimir()); // percorrendo a lista
		
		/*
		lista.limparLista();
		System.out.println("Lista depois da limpeza completa = " + lista);
		*/
		
		//lista.deletarElementoUnico(3);
		//System.out.println("Lista depois de deletar o '3' = " + lista);
			
		System.out.println("Tamanho da Lista: " + lista.getTamanho());
	}
}
