public class Casino
{
	public static void main(String[] args)
	{
		System.out.println("Casino!!!");
		Mesa m = new Mesa(5);
		System.out.println("\n\n\nLa partida la ha ganado: " + m.partida());
	}
}