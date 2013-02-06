public class Mesa
{
	private int numJugadores;
	private Pila<Integer> [] montones;
	
	@SuppressWarnings({"rawtypes","unchecked"})
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
