import java.util.*;

public class deck 

{
	ArrayList <Card> deck = new ArrayList <Card>();
	
	public deck()
	{
		Suit suitNum = null;
		for (int soot = 0; soot < 4; soot++)
		{	
			switch(soot)
			{
				case 0: suitNum = Suit.HEARTS; break;
				case 1: suitNum = Suit.CLUBS; break;
				case 2: suitNum = Suit.DIAMONDS; break;
				case 3: suitNum = Suit.SPADES; break;
				default: break;
			}
			
			for (int cahd = 2; cahd < 15; cahd++)
			{
				deck.add(new Card(suitNum, cahd));
			}
		}
		
		Collections.shuffle(deck);
		Collections.shuffle(deck);
		Collections.shuffle(deck);
		
		
	}
	
	public ArrayList<Card> Deckget()
	{
		return(deck);
	}
}
