import java.util.ArrayList;

public class Checker
{
	public int royalFlush(ArrayList<Card> hand)
	{
		int[] rank = getranks(hand);
		if (rank[8] == 1 && rank[9] == 1 && rank[10] == 1 && rank[11] == 1 && rank[12] == 1)
			return 10;
		else return 0;
	}

	public int straightFlush (ArrayList<Card> hand)
	{
		int flush = 0, straight = 0;
		flush = flush(hand);
		straight = straight(hand);
		if (flush == 6 && straight == 5)
			return 9;
		else return 0;
	}
	
	public int four (ArrayList<Card> hand)
	{
		boolean fowah = false;
		int ranks[] = getranks(hand);
		for (int i = 0; i < 13; i++)
		{
			if (ranks[i] == 4)
				fowah = true;
		}
		if (fowah == true)
			return 8;
		else return 0;
	}
	
	@SuppressWarnings("unused")
	public int fullHouse (ArrayList<Card> hand)
	{
		int sameCards = 1, sameCards2 = 1;
		int largeGroupRank=0,smallGroupRank=0;
		int ranks[] = getranks(hand);
		for (int i = 12; i > 1; i--)
		{
		     if (ranks[i] > sameCards) 
		     {
		         if (sameCards != 1)
		         //if sameCards was not the default value
		         {
		             sameCards2 = sameCards;
		             smallGroupRank = largeGroupRank;
		         }
		         
		         sameCards = ranks[i];
		         largeGroupRank = i;
		     } else if (ranks[i] > sameCards2)
		     {
		         sameCards2 = ranks[i];
		         smallGroupRank = i;
		     }
		}
		if ((sameCards2 == 2) && (sameCards == 3))
		{
			return 7;
		}
		else return 0;
	}
	
	public int flush (ArrayList<Card> hand)
	{
		boolean flush=true; //assume there is a flush
		for (int i=0; i<4; i++) 
		{
			if ( hand.get(i).getSuit() != hand.get(i+1).getSuit() ) 
				flush=false;
		}
		if (flush == true)
			return 6;
		else return 0;
	}
	
	public int straight (ArrayList<Card> hand)
	{
		int[]ranks = getranks(hand);
		boolean straight=false;  //assume no straight  
		for (int i = 0; i < 10; i++) //can't have straight with lowest value of more than 11
		{
			if (ranks[i]==1 && ranks[i+1]==1 && ranks[i+2]==1 && 
					ranks[i+3]==1 && ranks[i+4]==1)
			{
				straight=true;
				break;
			}
		}
		
		if (straight == true)
			return 5;
		else return 0;
	}
	
	public int three (ArrayList<Card> hand)
	{
		boolean tree = false;
		int ranks[] = getranks(hand);
		for (int i = 0; i < 13; i++)
		{
			if (ranks[i] == 3)
				tree = true;
		}
		if (tree == true)
			return 4;
		else return 0;
	}
	
	public int twoTwo (ArrayList<Card> hand)
	{
		int rank[] = getranks(hand);
		boolean firstTwo = false, secondTwo = false;
		for (int i = 0; i < 12; i++)
		{
			if (rank[i] == 2)
				firstTwo = true;
			if (firstTwo == true)
				if (rank[i+1] == 2)
					secondTwo = true;
		}
		if (firstTwo == true && secondTwo == true)
			return 3;
		else return 0;
		
	}	
	
	public int two (ArrayList<Card> hand)
	{
		boolean too = false;
		int ranks[] = getranks(hand);
		for (int i = 0; i < 13; i++)
		{
			if (ranks[i] == 2)
				too = true;
		}
		if (too == true)
			return 2;
		else return 0;
	}
	
	public int highcard (ArrayList<Card> hand)
	{
		int[] rank = getranks(hand);
		for (int i = 12; i > 0; i--)
			if (rank[i] == 1)
				return 1;
		 return 0;
	}
	
	public int[] getranks (ArrayList<Card> check)
	{
		int[] ranks = new int[13];

		for (int i = 0; i < 13; i++)
		{
			ranks[i]=0; //zero the contents of the array
		}

		for (int i = 0; i < 5; i++)
		{
			ranks[check.get(i).getRank()-2]++;
			//increment rank array at the index of each card's rank
		}

		return ranks;
	}
	
}