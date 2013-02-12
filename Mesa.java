/************************************************************************
  Mesa.java

  Mesa que se encarga de guardar las cartas que se van echando

  Laura Mallagaray Corral
  Jorge Roldán López
************************************************************************/

public class Mesa
{
	private int numJugadores;
	private Pila<Integer> [] montones;
	
	@SuppressWarnings("unchecked")//Evitamos warnings en el compilador al usar la contruccion de un vector sin generics
	public Mesa(int numJug) //constructor de la clase Mesa
	{
		this.numJugadores=numJug;
		this.montones= new Pila[numJug];
		for(int i=0; i<this.numJugadores; i++)
		{
			this.montones[i]= new Pila<Integer>();
		}
	}
	public void addCarta(Integer carta, int monton) //añade la carta pasada como parametro en la cima del monton que se le pasa 
	{
		this.montones[monton].apilar(carta);
	}
	
	public Integer quitarCarta(int monton) //quita la carta de mas arriba del monton pasado como parametro devolviendomela a su vez
	{
		return this.montones[monton].desapilar();
	}
	
	public Integer cima (int monton)
	{
		return this.montones[monton].cima();
	}
	
	public boolean montonVacio (int monton) //devuelve true si el monton pasado como parametro ya no tiene cartas y false en caso contrario
	{
		return this.montones[monton].pilaVacia();
	}
}
