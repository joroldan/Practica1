public class JugadorGuerra extends Jugador
{
	private boolean enGuerra;

	public JugadorGuerra(String s)
	{
		super(s);
		this.enGuerra=false;
	}
	
	public boolean enGuerra()
	{
		return this.enGuerra;
	}
	
	public void enGuerra(boolean g)
	{
		this.enGuerra=g;
	}
}