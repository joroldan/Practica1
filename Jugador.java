/************************************************************************
  Jugador.java

  Jugador de la guerra, con sus cartas

  Laura Mallagaray Corral
  Jorge Roldán López
************************************************************************/

public class Jugador
{
	final String nombre;
	Cola<Integer> mazo;
	boolean activo;
	int numCartas;
	
	public Jugador(String s) //Constructor de la clase Jugador
	{
		this.nombre = s;
		this.numCartas = 0;
		this.mazo   = new Cola<Integer>();
		this.activo = true;
	}
	
	public Integer sacarCarta() //Se saca una carta del mazo del jugador
	{
		numCartas--;
		return this.mazo.desencolar();
	}
	
	public void guardarCarta(Integer carta) //Se añade una carta al final del mazo del jugador
	{
		numCartas++;
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
	
	public int numeroCartas()
	{
		return numCartas;
	}

	public String toString()
	{
		return this.nombre;
	}
}