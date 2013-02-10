/************************************************************************
  Nodo.java

  Implementación de un nodo genérico para usar en Pila y Cola.

  Laura Mallagaray Corral
  Jorge Roldán López
************************************************************************/

class Nodo<T>
{
	T dato; //Package
	Nodo<T> sig; //Package
	
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