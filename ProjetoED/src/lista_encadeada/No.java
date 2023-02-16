package lista_encadeada;

// vai ser um tipo generico, por isso o <T>
public class No<T> {

	private T elemento;
	private No<T> proximo;
	private No<T> anterior;
	 
	// sobrecarga de construtores dependendo do que vamos precisar
	public No(T elemento) {
		this.elemento = elemento;
		this.proximo = null;
	}
	
	public No(T elemento, No<T> proximo) {
		this.elemento = elemento;
		this.proximo = proximo;
	}
	
	public No(T elemento, No<T> proximo, No<T> anterior) {
		this.elemento = elemento;
		this.proximo = proximo;
		this.anterior = anterior;
	}
	 
	public T getElemento() {
		return elemento;
	}
	public void setElemento(T elemento) {
		this.elemento = elemento;
	}
	public No<T> getProximo() {
		return proximo;
	}
	public void setProximo(No<T> proximo) {
		this.proximo = proximo;
	}
	public No<T> getAnterior() {
		return anterior;
	}
	public void setAnterior(No<T> anterior) {
		this.anterior = anterior;
	}

	@Override
	public String toString() {
		return "No [elemento=" + elemento + ", proximo=" + proximo + ", anterior=" + anterior + "]";
	}
	

}
