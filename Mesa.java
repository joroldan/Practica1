import java.util.concurrent.TimeoutException;
import java.util.Random;

public class Mesa
{
	private int numero_judadores;
	private Pila<Integer>[] zonas;
	private Jugador[] jugadores;
	private int jugadores_activos;

	@SuppressWarnings({"rawtypes","unchecked"})
	public Mesa(int num)
	{
		this.numero_judadores=num;
		this.jugadores_activos=num;
		this.zonas = new Pila[num];
		this.jugadores = new Jugador[num];
		for (int i=0; i<num; i++)
		{
			this.zonas[i] = new Pila<Integer>();
			this.jugadores[i] = new Jugador("Jugador" + (i+1));
			System.out.println("Creado jugador: " + this.jugadores[i]);
		}
		repartir();
	}

	private void repartir()
	{
		Baraja bar = new Baraja();
		int i=0;
		Integer aux;
		bar.barajar();
		while (bar.quedanCartas())
		{
			aux=bar.getCarta();
			System.out.println(this.jugadores[i%numero_judadores] + " recibe un " + aux);
			this.jugadores[i%numero_judadores].guardarCarta(aux);
			i++;
		}
	}

	private void colocarMonton()
	{
		Integer aux;
		//System.out.println("Colocando montones...");
		for (int i=0;i<this.numero_judadores;i++)
		{
			//System.out.println("Colocando montones...");
			if (this.jugadores[i].getActivo())
			{
				//System.out.println("Jugador activo: " + this.jugadores[i]);
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
			this.jugadores_activos--;
			System.out.println(this.jugadores[i] + " eliminado.");
		}
		else
		{
			this.zonas[i].apilar(aux);			
		}
		return aux;
	}

	private int guerra(Integer win) //Mejorar y mucho
	{
		Integer aux, aux2, max=0;
		int[] luchadores = new int[jugadores_activos];
		int j=0, ganador=0;
		boolean guerra=false;
		//Repartimos dos cartas a cada jugador de la guerra
		for (int i=0;i<numero_judadores;i++)
		{
			if ((jugadores[i].getActivo()) && (this.zonas[i].cima()==win))
			{
				//System.out.println("Jugador luchando: " + this.jugadores[i]);
				//Sacamos carta bocaabajo
				aux = pedirCarta(i);
				if (aux!=null)
				{
					System.out.println(this.jugadores[i] + " oculta un " + aux);
					aux = pedirCarta(i);
					if (aux!=null)
					{
						System.out.println(this.jugadores[i] + " saca un " + aux);
						luchadores[j++]=i+1;
					}
				}
/*
				aux=this.jugadores[i].sacarCarta();
				if (aux == null)
				{
					this.jugadores[i].setActivo(false);
					this.jugadores_activos--;
					//System.out.println(this.jugadores[i] + " eliminado.");
				}
				else
				{
					this.zonas[i].apilar(aux);
					//aux2=this.zonas[i].cima();
					//System.out.println(this.jugadores[i] + " oculta un " + aux);// + ", se lee " + aux2);
				
					//Carta bocaarriba, la que lucha
					aux=this.jugadores[i].sacarCarta();
					if (aux == null)
					{
						this.jugadores[i].setActivo(false);
						this.jugadores_activos--;
						//System.out.println(this.jugadores[i] + " eliminado.");
					}
					else
					{
						this.zonas[i].apilar(aux);
						//aux2=this.zonas[i].cima();
						//System.out.println(this.jugadores[i] + " saca un " + aux);// + ", se lee " + aux2);
						luchadores[j++]=i+1;
					}
				}
*/
			}

		}
		//Una vez tenemos los jugadores guardados en luchadores, comprobamos el ganador
		for (int i:luchadores)
		{
			if (i>0)
			{
				i--;
				//System.out.println("\t" + this.jugadores[i] + " había sacado un: " + this.zonas[i].cima());
				if (max<this.zonas[i].cima())
				{
					//System.out.println("Nuevo ganador..." + this.jugadores[i]);
					max = this.zonas[i].cima();
					ganador = i;
					guerra=false;
				}
				else if (max==this.zonas[i].cima())
				{
					guerra=true;
				}
			}
		}
		if (guerra)
		{
			System.out.println("Tenemos guerra por un " + max);
			ganador = this.guerra(max);
		}

		return ganador;
	}

	private int luchar() //Mejorar y mucho
	{
		Integer max = 0;
		int ganador = 0;
		boolean guerra = false;

		for (int i=0;i<numero_judadores;i++)
		{
			//System.out.println("Buscando ganador...");
			if (jugadores[i].getActivo())
			{
				////System.out.println("\t" + this.jugadores[i] + " había sacado un: " + this.zonas[i].cima());
				if (max<this.zonas[i].cima())
				{
					////System.out.println("Nuevo ganador..." + this.jugadores[i]);
					max = this.zonas[i].cima();
					ganador = i;
					guerra=false;
				}
				else if (max==this.zonas[i].cima())
				{
					guerra=true;
				}
			}
		}
		
		if (guerra)
		{
			//System.out.println("Tenemos guerra por un " + max);
			ganador=this.guerra(max);
		}
		
		//System.out.println("\n\nEL GANADOR ES: " + jugadores[ganador]);
		return ganador;
	}

	public Jugador partida() throws TieException
	{
		int jugador=0,i=0;
		while (jugadores_activos>1)
		{
			for (int j=0;j<numero_judadores;j++)
			{
				//System.out.println("A " + jugadores[j] + " le quedan " + jugadores[j].numeroCartas() + "cartas.");
				System.out.print(jugadores[j].numeroCartas()+"\t");
			}
			System.out.println("");
			this.colocarMonton();
			jugador = this.luchar();
			this.colorcarCartasRandomlyA(jugador);
			i++;
			if(i>10000)
			{
				throw new TieException("Tras 10.0000 turnos la partida no se ha resuelto.\nSe considera empate.");
			}
		}
		return this.jugadores[jugador];
	}

	private void colocarCartasA(int winner)
	{
		for (Pila<Integer> p: zonas)
		{
			while (p.cima()!=null)
			{
				jugadores[winner].guardarCarta(p.desapilar());
			}
		}
	}

	private void colorcarCartasRandomlyA(int winner)
	{
		int n;
		Random rand = new Random();
		for (int i=0; i<25; i++)
		{
			n=rand.nextInt(numero_judadores);
			if (this.zonas[n].cima()!=null)
				jugadores[winner].guardarCarta(this.zonas[n].desapilar());
		}
		colocarCartasA(winner);
	}

	@SuppressWarnings("serial")
	class TieException extends TimeoutException
	{
		TieException()
		{
			super();
		}

		TieException(String s)
		{
			super(s);
		}
	}
}