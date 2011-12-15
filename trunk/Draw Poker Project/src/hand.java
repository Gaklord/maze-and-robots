import java.util.*;

public class hand {
	ArrayList<Card> PlayerHand = new ArrayList<Card>();
	ArrayList<Card> LenovoHand = new ArrayList<Card>();
	
	public hand(ArrayList<Card> life)
	{
			//deal 5 cards
				for (int i=0; i < 5; i++)
				{
					PlayerHand.add(life.remove(0));
				}

				//deal 5 cards to lenovo
				for (int i=0; i < 5; i++)
				{
					LenovoHand.add(new Card());
					LenovoHand.set(i, life.remove(0));
				}
				specops(life);
	}
	
	private void specops(ArrayList<Card> life)
	{
		//output player's hand to decide what cards to discard
				Scanner console = new Scanner(System.in);
				int playerChoice;
				while (PlayerHand.size() != 0)
				{
					for (int i = 0; i < PlayerHand.size(); i++)
					{
						System.out.println(i+1 + " " + PlayerHand.get(i).getValue() + " of " + PlayerHand.get(i).getSuit());
					}
					System.out.println("\n\nWhat card do you want to discard?\nEnter 0 to advance");
					//asks user to select what card to discard, or to move on. program automagically continues if the hand reaches 0 cards
					playerChoice = Integer.parseInt(console.next());
					if (playerChoice == 0)
						break;
					PlayerHand.remove(playerChoice-1);
					
				}
				//re-deal cards to player's hand to get to 5 again
				while (PlayerHand.size() != 5)
				{
					PlayerHand.add(life.remove(0));
				}
				
				for (int i = 0; i < PlayerHand.size(); i++)
				{
					System.out.println(i+1 + " " + PlayerHand.get(i).getValue() + " of " + PlayerHand.get(i).getSuit());
				}
		
		RANKED(PlayerHand);
		RANKED(LenovoHand);
	}
	
	
	void RANKED(ArrayList<Card> Dit)
	{
		int handValue; 
		Checker checkIf =  new Checker();
		
		handValue = checkIf.royalFlush(Dit);
		if (handValue == 0)
		{
			handValue = checkIf.straightFlush(Dit);
			if (handValue == 0)
			{
				handValue = checkIf.four(Dit);
				if (handValue == 0)
				{
					handValue = checkIf.fullHouse(Dit);
					if (handValue == 0)
					{
						handValue = checkIf.flush(Dit);
						if (handValue == 0)
						{
							handValue = checkIf.straight(Dit);
							if (handValue == 0)
							{
								handValue = checkIf.three(Dit);
								if (handValue == 0)
								{
									handValue = checkIf.twoTwo(Dit);
									if (handValue == 0)
									{
										handValue = checkIf.two(Dit);
										if (handValue == 0)
										{
											handValue = checkIf.highcard(Dit);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		switch (handValue)
		{
		case 10:System.out.println("ROYAL FLUSH! You must be lucky!");break;
		case 9:System.out.println("STRAIGHT FLUSH! Congrats! This one is pretty rare!");break;
		case 8:System.out.println("FOUR OF A KIND! I guess this card has alot of friends!");break;
		case 7:System.out.println("FULL HOUSE! Wasn't that a TV show?");break;
		case 6:System.out.println("FLUSH! Everyone's in uniform!");break;
		case 5:System.out.println("STRAIGHT! Line em up!");break;
		case 4:System.out.println("THREE OF A KIND! You think it would be worth more...");break;
		case 3:System.out.println("TWO PAIR! I'm seeing double... Twice!");break;
		case 2:System.out.println("PAIR! I'm seeing double!");break;
		case 1:System.out.println("HIGH CARD! Well.... it's something!");break;
		default:System.out.println("WHAT DID YOU DO?? HERE BE DRAGONS!");break;
		}	
	}
	
}
