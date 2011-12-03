import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Maze {
	
	public Maze()
	{	
		FileReader txt = null;
		Scanner file = null;
		try
		{
			txt = new FileReader("input.txt");
			file = new Scanner(txt);
			readmaze(file);	
		}
		catch( IOException e )
		{
		}
		finally
		{
			if( file != null )
			{
				file.close();
			}
			if( txt != null )
			{
				try {
					txt.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	private void readmaze(Scanner file)
	{
		int i, j;
		
		for(i = 0; i < 8; i++)
		{
			for(j = 0; j < 8; j++)
			{
				ver[i][j] = file.next().charAt(0);  
				System.out.print(ver[i][j]);  
			}
			
		}
		
	}
	
	private char[][] ver = new char[9][9];
}
