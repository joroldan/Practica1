public class Cola<T>
{
	private Nodo<T> primero;
	private Nodo<T>  ultimo;
	
	public Cola()
	{ 
		this.primero=null;
		this.ultimo =null;
	}

	public void encolar (T elemento) //añade al final
	{
		Nodo<T> nuevo = new Nodo<T>(elemento);
		if (this.primero==null)
		{
			this.primero=nuevo;
			this.ultimo=nuevo;
		}
		//else this.ultimo.sig=nuevo; //pendiente de corregir
		else
		{
			this.ultimo.sig=nuevo;
			this.ultimo=nuevo;
		}
	}
	
	public boolean colaVacia()
	{
		return (this.primero == null);
	}
	
	public T primero()
	{
		if (this.primero!=null) return this.primero.dato;
		else return null;
	}
	
	public T desencolar() //elimina el elemento mas antigo
	{ 
		if (this.primero == null)         return null;
		if (this.primero == this.ultimo)  this.ultimo=null;

		T aux = this.primero.dato;
		this.primero = this.primero.sig;
		return aux;
	}
}