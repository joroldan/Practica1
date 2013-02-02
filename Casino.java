import java.util.Scanner;
import java.util.NoSuchElementException;

public class Casino
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
		Mesa m = new Mesa(n);
		try
		{
			System.out.println("\n\n\nLa partida la ha ganado: " + m.partida());
		}
		catch (Mesa.TieException t)
		{
			System.out.println(t.getMessage());
		}
		
	}
}