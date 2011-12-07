import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Dealer 
{
	public static void main(String[] args)
	{
		ArrayList <Card> deck = new ArrayList <Card>();
		ArrayList <Card> PlayerHand = new ArrayList <Card>();
		ArrayList <Card> LenovoHand = new ArrayList <Card>();
		int handValue, handValue2;
				
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
		
		//deal 5 cards
		for (int i=0; i < 5; i++)
		{
			PlayerHand.add(deck.remove(0));
		}

		//deal 5 cards to lenovo
		for (int i=0; i < 5; i++)
		{
			LenovoHand.add(new Card());
			LenovoHand.set(i, deck.remove(0));
		}

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
			PlayerHand.add(deck.remove(0));
		}
		
		for (int i = 0; i < PlayerHand.size(); i++)
		{
			System.out.println(i+1 + " " + PlayerHand.get(i).getValue() + " of " + PlayerHand.get(i).getSuit());
		}
		
		Checker checkIf =  new Checker();
		
		handValue = checkIf.royalFlush(PlayerHand);
		if (handValue == 0)
		{
			handValue = checkIf.straightFlush(PlayerHand);
			if (handValue == 0)
			{
				handValue = checkIf.four(PlayerHand);
				if (handValue == 0)
				{
					handValue = checkIf.fullHouse(PlayerHand);
					if (handValue == 0)
					{
						handValue = checkIf.flush(PlayerHand);
						if (handValue == 0)
						{
							handValue = checkIf.straight(PlayerHand);
							if (handValue == 0)
							{
								handValue = checkIf.three(PlayerHand);
								if (handValue == 0)
								{
									handValue = checkIf.twoTwo(PlayerHand);
									if (handValue == 0)
									{
										handValue = checkIf.two(PlayerHand);
										if (handValue == 0)
										{
											handValue = checkIf.highcard(PlayerHand);
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
		
		System.out.println("Now what did that computer guy get?");
		
		handValue2 = checkIf.royalFlush(LenovoHand);
		if (handValue2 == 0)
		{
			handValue2 = checkIf.straightFlush(LenovoHand);
			if (handValue2 == 0)
			{
				handValue2 = checkIf.four(LenovoHand);
				if (handValue2 == 0)
				{
					handValue2 = checkIf.fullHouse(LenovoHand);
					if (handValue2 == 0)
					{
						handValue2 = checkIf.flush(LenovoHand);
						if (handValue2 == 0)
						{
							handValue2 = checkIf.straight(LenovoHand);
							if (handValue2 == 0)
							{
								handValue2 = checkIf.three(LenovoHand);
								if (handValue2 == 0)
								{
									handValue2 = checkIf.twoTwo(LenovoHand);
									if (handValue2 == 0)
									{
										handValue2 = checkIf.two(LenovoHand);
										if (handValue2 == 0)
										{
											handValue2 = checkIf.highcard(LenovoHand);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		switch (handValue2)
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
		if (handValue > handValue2)
			System.out.println("YOU WON! ALRIGHT!");
		else if(handValue == handValue2)
			System.out.println("Close... he almost beat you!");
		else
			System.out.println("OOOOH, HE GOT YOU! Better luck next time!");
		return; //YaY! Candy!
	}
}
