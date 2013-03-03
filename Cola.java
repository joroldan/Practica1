/************************************************************************
  Cola.java

  Implementacion de una cola generica

  Laura Mallagaray Corral
  Jorge Roldan Lopez
************************************************************************/

public class Cola<T>
{
	private Nodo<T> primero;
	private Nodo<T>  ultimo;
	
	public Cola() //Constructor sin parametros de la clase Cola
	{ 
		this.primero=null;
		this.ultimo =null;
	}

	public void encolar (T elemento) //coloca al final
	{
		Nodo<T> nuevo = new Nodo<T>(elemento);
		if (this.primero==null)
		{
			this.primero=nuevo;
			this.ultimo=nuevo;
		}
		else
		{
			this.ultimo.sig=nuevo;
			this.ultimo=nuevo;
		}
	}
	
	public boolean colaVacia() //Devuelve true si la cola esta vacia y false en caso contrario
	{
		return (this.primero == null);
	}
	
	public T primero() //Devuelve el dato correspondiente al primer elemento de la cola, y si este no existe, devuelve null
	{
		if (this.primero!=null) return this.primero.dato;
		else return null;
	}
	
	public T desencolar() //elimina el elemento mas antiguo y lo devuelve
	{ 
		if (this.primero == null)         return null;
		if (this.primero == this.ultimo)  this.ultimo=null;

		T aux = this.primero.dato;
		this.primero = this.primero.sig;
		return aux;
	}
}