public class Pila<T>
{
	private Nodo<T> registro;

	public Pila()
	{
		this.registro=null;
	}

	public void apilar(T elemento)
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

	public boolean pilaVacia()
	{
		return this.registro==null;
	}

	public T cima()
	{
		if (this.registro==null) return null;
		else return this.registro.dato;
	}

	public T desapilar()
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