/************************************************************************
  Principal.java

  Clase principal que lleva a cabo la partida de la guerra y da el ganador

  Laura Mallagaray Corral
  Jorge Roldan Lopez
************************************************************************/

import java.util.Scanner;
import java.util.NoSuchElementException;

public class Principal
{
	public static void main(String[] args)
	{
		int n;
		System.out.println("Comienza la partida: Juego de la guerra");
		System.out.println("¿Cuantos jugadores desea que jueguen la partida?");
		Scanner read = new Scanner(System.in);
		//Como hay lectura por pantalla, contemplamos un posible error de lectura
		try
		{
			n = read.nextInt();
		}
		//Si no se da un valor valido se le avisa y se asumen 4 jugadores
		catch (NoSuchElementException e)
		{
			System.err.println("El valor introducido no es valido, se asumen 4 jugadores.");
			n = 4;
		}
		//Comienza la partida para n jugadores
		Partida partida = new Partida(n);
		//Repartimos las cartas
		partida.repartir();
		//Mientras no sea el final, hacemos otra jugada
		while (!partida.finPartida()) partida.jugada();
		//Imprimimos finalmente al ganador de la partida
		System.out.println("\n\nEl ganador es: " + partida.ganador());

	}
}