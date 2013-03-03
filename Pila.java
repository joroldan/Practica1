/************************************************************************
  Pila.java

  Implementacion de una pila generica

  Laura Mallagaray Corral
  Jorge Roldan Lopez
************************************************************************/

public class Pila<T>
{
	private Nodo<T> registro;

	public Pila() //Constructor sin parametros de la clase Pila
	{
		this.registro=null;
	}

	public void apilar(T elemento) //coloca al principio
	{
		if (this.registro==null)
		{
			this.registro = new Nodo<T>(elemento);
		}
		else
		{
			Nodo<T> now = this.registro;
			this.registro = new Nodo<T>(elemento,now);
		}
	}

	public boolean pilaVacia() //Devuelve true si la pila esta vacia y false en caso contrario
	{
		return this.registro==null;
	}

	public T cima() //devuelve el dato correspondiente al elemento que se ha colocado el ultimo a la Pila
	{
		if (this.registro==null) return null;
		else return this.registro.dato;
	}

	public T desapilar() //elimina y devuelve el ultimo elemento que se ha colocado
	{
		if (this.registro==null)
		{
			return null;
		}
		else
		{
			Nodo<T> now = this.registro;
			this.registro = this.registro.sig;
			return now.dato;
		}
	}
}