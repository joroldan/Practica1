/************************************************************************
  Mesa.java

  Me que se encarga de guardar las cartas que se van echando

  Laura Mallagaray Corral
  Jorge Roldán López
************************************************************************/

public class Mesa
{
	private int numJugadores;
	private Pila<Integer> [] montones;
	
	@SuppressWarnings("unchecked")//Evitamos warnings en el compilador al usar la contrucción de un vector sin generics
	public Mesa(int numJug)
	{
		this.numJugadores=numJug;
		this.montones= new Pila[numJug];
		for(int i=0; i<this.numJugadores; i++)
		{
			this.montones[i]= new Pila<Integer>();
		}
	}
	public void addCarta(Integer carta, int monton)
	{
		this.montones[monton].apilar(carta);
	}
	public Integer quitarCarta(int monton)
	{
		return this.montones[monton].desapilar();
	}
	
	public Integer cima (int monton)
	{
		return this.montones[monton].cima();
	}
	
	public boolean montonVacio (int monton)
	{
		return this.montones[monton].pilaVacia();
	}
}
