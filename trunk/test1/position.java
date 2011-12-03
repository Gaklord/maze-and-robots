
public class position
{
	private int x = 0, y = 0;
	
	public position(int a, int b)
	{
		x = a;
		y = b;
	}
	public void modify(int a, int b)
	{
		x += a;
		y += b;
	}
	
	public int getx()
	{
		return x;
	}
	public int gety()
	{
		return y;
	}
}