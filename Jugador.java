public class Jugador
{
	final String nombre;
	Cola<Integer> mazo;
	boolean activo;
	
	public Jugador(String s)
	{
		this.nombre = s;
		this.mazo   = new Cola<Integer>();
		this.activo = true;
	}
	
	public Integer sacarCarta()
	{
		return this.mazo.desencolar();
	}
	
	public void guardarCarta(Integer carta)
	{
		this.mazo.encolar(carta);
	}
	
	public boolean getActivo()
	{
		return this.activo;
	}
	
	public void setActivo(boolean eliminado)
	{
		this.activo = eliminado;
	}
	
	public int numeroCartas() //Esta mal hecho!! mucho ojo!
	{
		int num=0;
		Cola<Integer> aux= new Cola<Integer>();
		while(this.mazo.desencolar()!=null) //usar primero para no eliminarla
		{
			aux.encolar(this.mazo.desencolar());
			num++;
		}
		this.mazo=aux;
		return num;
	}

	public String toString()
	{
		return this.nombre;
	}
}
