import java.util.Random;

public class Baraja
{
	private int [] cartas;
	private int numcartas;

	public Baraja()
	{
		this.cartas = new int[40];
		for (int i=0; i<40; i++)
			this.cartas[i]=(i%10)+1;
		this.numcartas=40;
	}

	public void barajar()
	{
		Random generador = new Random();
		int n1,n2,aux;
		for (int i=0; i<10000; i++)
		{
			n1 = generador.nextInt(40);
			n2 = generador.nextInt(40);
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