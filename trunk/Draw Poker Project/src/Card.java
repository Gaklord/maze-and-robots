
public class Card 
{
	private int value;
	private Suit suit; 
	
	public Card(Suit s, int v)
	{	
		suit = s;
		value = v;
	}
	public Card()
	{
		value = 50;
		suit = null;
	}	
	public String getValue()
	{
		String Val = Integer.toString(value);
		switch(value)
		{
			case 11: Val = "JACK"; break;
			case 12: Val = "QUEEN"; break;
			case 13: Val = "KING"; break;
			case 14: Val = "ACE"; break;
			default:break;
		}
		return Val;
	}
	public Suit getSuit()
	{
		return suit;
	}
	public int getRank()
	{
		return value;
	}

}