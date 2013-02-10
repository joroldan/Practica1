/************************************************************************
  Partida.java

  Encargada de llevar a cabo todas las tareas de la partida y realizar el
  juego completo turno a turno

  Laura Mallagaray Corral
  Jorge Roldán López
************************************************************************/

import java.util.Random;

class Partida
{
	private Mesa mesa;
	private Baraja baraja;
	private Jugador[] jugadores;
	private int numJugadores;
	private int numEliminados;

	/************************************************************************
		Crea una partida para num jugadores, reservándoles sitio en la mesa,
		repartiendoles y creando una baraja para repartir después
	************************************************************************/
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

	/************************************************************************
		Reparte las cartas mientras queden en el monton siguiendo el orden
	************************************************************************/
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

	/************************************************************************
		Mira si la partida ha terminado, es decir, solo queda un jugador
		activo en ese momento
	************************************************************************/
	public boolean finPartida()
	{
		return (this.numEliminados==this.numJugadores-1);
	}

	/************************************************************************
		Si ya ha sido el final de la partida devuelve el ganador, sino null
	************************************************************************/
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

	/************************************************************************
		Realiza una jugada completa, con la ayuda de funciones auxiliares
	************************************************************************/
	public void jugada()
	{
		this.colocarMontones();
		int ganador = this.luchar();
		this.colocarCartasA(ganador);
	}

	/************************************************************************
		PENDIENTE DE COMENTARIO
	************************************************************************/
	private int luchar()
	{
		int[] v = new int[numJugadores-numEliminados];
		int j=0;
		for (int i=0; i<numJugadores; i++)
			if (this.jugadores[i].getActivo()) v[j++]=i;
		return this.buscarGanador(v);
	}

	/************************************************************************
		PENDIENTE DE COMENTARIO
	************************************************************************/
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

	/************************************************************************
		PENDIENTE DE COMENTARIO
	************************************************************************/
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

	/************************************************************************
		Una vez encontrado el ganador se recogen las cartas de la mesa que
		han sido lanzadas el turno anterior. No se siguen siempre el mismo
		orden para evitar llegar a empates. Así se empieza por el ganador
		hasta el final y se sigue recogiendo luego por el principio.
	************************************************************************/
	private void colocarCartasA(int winner)
	{
		// Empezamos recogiendo por el ganador hasta el final
		for (int i=winner; i<numJugadores; i++)
		{
			while (mesa.cima(i)!=null)
				jugadores[winner].guardarCarta(mesa.quitarCarta(i));
		}
		// Ahora recogemos desde el primero hasta el ganador
		for (int i=0; i<winner; i++)
		{
			while (mesa.cima(i)!=null)
				jugadores[winner].guardarCarta(mesa.quitarCarta(i));
		}
	}

	/************************************************************************
		Sirve para que al comenzar el turno, los jugadores activos saquen
		carta y la coloquen en su monton para proceder a la busqueda del
		ganador, y en caso de emparte ir a la guerra
	************************************************************************/
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

	/************************************************************************
		Dado un entero que representa a un jugador del vector jugadores, se
		pide una carta a ese jugador.
		Si es nula, el jugador es eliminado y se devuelve null
		Si no es nula se coloca en su montón de la mesa y se devuelve
	************************************************************************/
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