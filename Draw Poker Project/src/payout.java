import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class payout 
{
	private int OrigionalBet;
	private double total = 0;
	private double winnings = 0;
	FileReader Savefile = null;
	Scanner SaveFileRead = null;
	PrintWriter write = null;

	public payout()
	{
		try {
			Savefile = new FileReader("SAVE.TXT");
			SaveFileRead = new Scanner(Savefile);
			total = SaveFileRead.nextInt();			
		} catch (FileNotFoundException e) {
			System.err.println("YOUR SAVE FILE IS CORRUPTED! SADDNESS!");
			e.printStackTrace();
		} finally {
			SaveFileRead.close();
		}
		
	}
	public void PlaceBet()
	{
		System.out.print("You have " + total + " dollars to bet.\n" + "Enter the ammount you want to bet: ");
		Scanner input = new Scanner(System.in);
		int bet = (input.nextInt());
		OrigionalBet = bet;
		total -= bet;
	}
	public void RESET(int ammount) throws IOException
	{
		try {
			write = new PrintWriter("SAVE.TXT");
			write.println(1000);
		} catch (FileNotFoundException e) {
			System.err.println("YOUR SAVE FILE DIED! WHAT DID YOU DO? YOU MONSTER!");
			e.printStackTrace();
		} finally {
			write.close();
		}
	}
	public void ChangeTotal(int rank)
	{
		switch (rank){
		case 10: winnings = (OrigionalBet * 250);break;
		case 9: winnings = (OrigionalBet * 50);break;
		case 8: winnings = (OrigionalBet * 25);break;
		case 7: winnings = (OrigionalBet * 9);break;
		case 6: winnings = (OrigionalBet * 6);break;
		case 5: winnings = (OrigionalBet * 4);break;
		case 4: winnings = (OrigionalBet * 3);break;
		case 3: winnings = (OrigionalBet * 2);break;
		case 2: winnings = (OrigionalBet * 1);break;
		case 1: winnings = (OrigionalBet * .5);break;
		default:System.err.println("SOMETHING WENT WRONG!!!!"); System.exit(-1);
		
		total =+ winnings;
		}
	}
	public double getWinnings()
	{
		return total;
	}
	public void save()
	{
		try {
			write = new PrintWriter("SAVE.TXT");
			write.println(total);
		} catch (FileNotFoundException e) {
			System.err.println("YOUR SAVE FILE DIED! WHAT DID YOU DO? YOU MONSTER!");
			e.printStackTrace();
		} finally {
			write.close();
		}
	}
}
