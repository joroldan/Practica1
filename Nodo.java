/************************************************************************
  Nodo.java

  Implementacion de un nodo generico para usar en Pila y Cola.

  Laura Mallagaray Corral
  Jorge Roldan Lopez
************************************************************************/

class Nodo<T>
{
	T dato; //Package
	Nodo<T> sig; //Package
	
	//Disponemos de 3 constructores para la clase Nodo, segun si le pasamos parametros y cuales le pasamos
	
	Nodo(T dato, Nodo<T> n)
	{
		this.dato=dato;
		this.sig=n;
	}

	Nodo(T dato)
	{
		this.dato=dato;
		this.sig=null;
	}

	Nodo()
	{
		this.dato=null;
		this.sig=null;
	}
}