
public class position
{
	private int x = 0, y = 0;
	
	public position(int a, int b)
	{
		x = a;
		y = b;
	}
	public position() 
	{
		//it's the default constructor. i figured we would want one so we can set stuff.
		//we can get rid of it later when we know what we're doing
		x = 0;
		y = 0;
		//this space should be impossible to start from, as there would be 2 walls and 2 out-of-bounds areas surrounding it
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
	public void setPosition(int a, int b)
	{
		x = a;
		y = b;
	}
}