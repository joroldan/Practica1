import java.util.LinkedList;

public class Mesa
{
	private int numero_judadores;
	private Pila<Integer>[] zonas;
	private LinkedList<Jugador> jugadores;
	private int jugadores_activos;

	public Mesa(int num)
	{
		this.numero_judadores=num;
		this.jugadores_activos=num;
		this.zonas = new Pila[num];
		this.jugadores = new LinkedList<Jugador>();
		for (int i=0; i<num; i++)
		{
			this.zonas[i] = new Pila<Integer>();
			this.jugadores.add(new Jugador("Jugador"+(i+1));
		}
	}

	private void colocarMonton()
	{
		Integer aux;
		for (int i=0;i<numero_judadores;i++)
		{
			if (jugadores.get(i).getActivo())
			{
				aux = this.jugadores[i].sacarCarta();
				if (aux == null)
				{
					this.jugadores[i].setActivo(false);
					System.out.println(this.jugadores.getNombre() + " saca un " + aux);
					this.zonas[i].apilar(0); //Temporal
				}
				else
				{
					this.zonas[i].apilar(aux);
					System.out.println(this.jugadores.getNombre() + " saca un " + aux);
				}
			}
			this.zonas[i].apilar(0); //Temporal
		}
	}

	private boolean guerra(int[] v)
	{

	}

	private void eliminarJugadores()
	{
		for (int i=0;i<numero_judadores;i++)
		{
			if ((jugadores[i].getActivo()) && (this.jugadores[i].verNumeroCartas()==0))
			{
				this.jugadores[i].setActivo(false);
				this.jugadores_activos--;
				System.out.println(this.jugadores.getNombre() + " eliminado.");
			}
		}
	}

	private int luchar()
	{
		Integer max = 0;
		int ganador = 0;
		int[] jugadores_en_guerra = new int[this.jugadores_activos];

		for (int j=0;j<numero_judadores;j++)
		{
			jugadores_en_guerra[j]=-1;
		}

		for (int i=0;i<numero_judadores;i++)
		{
			if (jugadores[i].getActivo())
			{
				if (max<this.zonas[i].cima()))
				{
					max = this.zonas[i].cima();
					ganador = i;

					jugadores_en_guerra[0]=i;
					jugadores_en_guerra[1]=-1;
				}
				else if (max==this.zonas[i].cima()))
				{
					//posible guerra
				}
			}
		}
	}

	public int turno()
	{
		this.colocarMonton();
		this.luchar();


	}
}