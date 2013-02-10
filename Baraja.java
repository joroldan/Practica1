/************************************************************************
  Baraja.java

  Clase baraja que se usa para crear y repartir las cartas. 52 cartas

  Laura Mallagaray Corral
  Jorge Roldán López
************************************************************************/

import java.util.Random;

public class Baraja
{
	private int [] cartas;
	private int numcartas;

	public Baraja()
	{
		this.cartas = new int[52];
		for (int i=0; i<52; i++)
			this.cartas[i]=(i%13)+1;
		this.numcartas=52;
	}

	public void barajar()
	{
		Random generador = new Random();
		int n1,n2,aux;
		for (int i=0; i<10000; i++)
		{
			n1 = generador.nextInt(this.numcartas);
			n2 = generador.nextInt(this.numcartas);
			aux = this.cartas[n1];
			this.cartas[n1] = this.cartas[n2];
			this.cartas[n2] = aux;
		}
	}

	public int getCarta()
	{
		if (this.numcartas!=0)
			return this.cartas[--this.numcartas];
		else return -1;
	}

	public boolean quedanCartas()
	{
		return (this.numcartas!=0);
	}
}