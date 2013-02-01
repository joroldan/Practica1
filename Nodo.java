class Nodo<T> //todo package
{
	T dato;
	Nodo<T> sig;
	
	Nodo(T dato, Nodo n)
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