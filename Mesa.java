public class Mesa
{
	private int numero_judadores;
	private Pila<Integer>[] zonas;
	private Jugador[] jugadores;

	public Mesa(int num)
	{
		this.numero_judadores=num;
		this.zonas = new Pila[num];
		this.jugadores = new Jugador[num];
		for (int i=0; i<num; i++)
		{
			this.zonas[i] = new Pila<Integer>();
			this.jugadores[i] = new Jugador();
		}
	}

	private void colocarMonton()
	{
		for (int i=0;i<numero_judadores;i++)
		{
			Integer aux = jugadores[i].sacarCarta();
			if (aux == null)
				this.zonas[i].apilar(0);
			else this.zonas[i].apilar(aux);
		}
	}

	private boolean hayGuerra(int i)
	{

	}

	public int luchar()
	{
		this.colocarMonton();
		Integer max = 0;
		int ganador = 0;
		for (int i=0;i<numero_judadores;i++)
		{
			if (max<this.zonas[i].cima())
			{
				max = this.zonas[i].cima();
				ganador = i;
			}
		}
	}
}