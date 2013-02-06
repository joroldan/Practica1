import java.util.Scanner;
import java.util.NoSuchElementException;

public class Principal
{
	public static void main(String[] args)
	{
		int n;
		System.out.println("Comienza la partida: Juego de la guerra");
		Scanner read = new Scanner(System.in);
		System.out.println("¿Cuántos jugadores desea que jueguen la partida?");
		try
		{
			n = read.nextInt();
		}
		catch (NoSuchElementException e)
		{
			System.err.println("El valor introducido no es válido, se asumen 4 jugadores.");
			n = 4;
		}
		Partida partida = new Partida(n);
		while (!partida.finPartida())
		{
			partida.repartir();
			partida.jugada();
		}
		System.out.println("\n\nEl ganador es: " + partida.ganador());

	}
}