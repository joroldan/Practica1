import java.util.Random;

class Partida
{
	private Mesa mesa;
	private Baraja baraja;
	private Jugador[] jugadores;
	private int numJugadores;
	private int numEliminados;

	public Partida(int num)
	{
		this.mesa = new Mesa(num);
		this.baraja = new Baraja();
		this.baraja.barajar();
		this.jugadores = new Jugador[num];
		for (int i=0; i<num; i++)
		{
			this.jugadores[i] = new Jugador("Jugador" + (i+1));
			System.out.println("Creado jugador: " + this.jugadores[i]);
		}
		this.numJugadores = num;
		this.numEliminados = 0;
	}

	public void repartir()
	{
		int i=0;
		Integer aux;
		while (baraja.quedanCartas())
		{
			aux=baraja.getCarta();
			System.out.println(this.jugadores[i%numJugadores] + " recibe un " + aux);
			this.jugadores[i%numJugadores].guardarCarta(aux);
			i++;
		}
	}

	public boolean finPartida()
	{
		return (this.numEliminados==this.numJugadores-1);
	}

	public Jugador ganador()
	{
		if (finPartida())
		{
			for (Jugador i: this.jugadores)
			{
				if (i.getActivo()) return i;
			}
		}
		return null;
	}

	public void jugada()
	{
		this.colocarMontones();
		int ganador = this.luchar();
		this.colocarCartasA(ganador);
	}

	private int luchar()
	{
		int[] v = new int[numJugadores-numEliminados];
		int j=0;
		for (int i=0; i<numJugadores; i++)
			if (this.jugadores[i].getActivo()) v[j++]=i;
		return this.buscarGanador(v);
	}

	private int buscarGanador(int[] v)
	{
		Integer max = 0;
		int ganador=0;
		boolean guerra=false;
		for (int i: v)
		{
			if (max<this.mesa.cima(i))
			{
				max = this.mesa.cima(i);
				ganador = i;
				guerra=false;
			}
			else if (max==this.mesa.cima(i))
			{
				guerra=true;
			}
		}
		if (guerra) ganador=guerra(v,max);
		
		return ganador;
	}

	private int guerra(int[] v, Integer max)
	{
		Integer aux=0;
		int[] luchadores = new int[numJugadores-numEliminados];
		int j=0;
		//Repartimos dos cartas a cada jugador de la guerra
		for (int i: v)
		{
			if (this.mesa.cima(i)==max)
			{
				//Sacamos carta boca abajo
				aux = pedirCarta(i);
				if (aux!=null)
				{
					System.out.println(this.jugadores[i] + " oculta un " + aux);
					//Sacamos carta boca arriba
					aux = pedirCarta(i);
					if (aux!=null)
					{
						System.out.println(this.jugadores[i] + " saca un " + aux);
						luchadores[j++]=i;
					}
				}
			}
		}

		int[] w = new int[j];
		for (int k=0; k<j; k++)
			w[k]=luchadores[k];
		
		return buscarGanador(w);
	}

	private void colocarCartasA(int winner)
	{
		int n;
		Random rand = new Random();
		for (int i=0; i<numJugadores*3; i++)
		{
			n=rand.nextInt(numJugadores);
			if (mesa.cima(n)!=null)
				jugadores[winner].guardarCarta(mesa.quitarCarta(n));
		}

		for (int i=0; i<numJugadores; i++)
		{
			while (mesa.cima(i)!=null)
			{
				jugadores[winner].guardarCarta(mesa.quitarCarta(i));
			}
		}
	}

	private void colocarMontones()
	{
		Integer aux;
		for (int i=0;i<this.numJugadores;i++)
		{
			if (this.jugadores[i].getActivo())
			{
				aux = this.pedirCarta(i);
				if (aux!=null) System.out.println(this.jugadores[i] + " saca un " + aux);
			}
		}
	}

	private Integer pedirCarta(int i)
	{
		Integer aux = this.jugadores[i].sacarCarta();
		if (aux == null)
		{
			this.jugadores[i].setActivo(false);
			this.numEliminados++;
			System.out.println(this.jugadores[i] + " eliminado.");
		}
		else
		{
			this.mesa.addCarta(aux,i);
		}
		return aux;
	}

}