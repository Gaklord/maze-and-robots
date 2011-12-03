import java.util.Scanner;
import java.io.BufferedReader;
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
			readmaze(txt);	
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
	
	private void readmaze(FileReader file) throws IOException
	{
		int i, j;
		StringBuilder sb = new StringBuilder();
		String currentLine = null;
		BufferedReader br = new BufferedReader( file );
		while( ( currentLine = br.readLine() ) != null )
		{
			sb.append( currentLine );
		}
		String data = sb.toString();
		System.out.println( "Data: " + data );
		for(i = 0; i < 11; i++)
		{
			for(j = 0; j < 11; j++)
			{
				ver[i][j] = data.charAt(i*11+j);  
				System.out.print(ver[i][j]);
			}
			System.out.println();
			
		}
		
	}
	
	public position findb()
	{
		int i, j;
		
		position entrance, fail;
		
		for(i = 0; i < 11; i++)
		{
			for(j = 0; j < 11; j++)
			{
				if(ver[i][j] == 'o')
				{
					entrance = new position(i, j);
					return entrance;
				}
				
			}
			
		}
		System.err.println("No entrance found, Fuck you");
		System.exit(1);
		return(fail = new position());
	}
	public position finde()
	{
		int i, j;
		
		position exit, fail;
		
		for(i = 0; i < 11; i++)
		{
			for(j = 0; j < 11; j++)
			{
				if(ver[i][j] == 'o')
				{
					exit = new position(i, j);
					return exit;
				}
				
			}
			
		}
		System.err.println("No exit found, Fuck you");
		System.exit(1);
		return(fail = new position());
	}
	
	private char[][] ver = new char[11][11];
	
	public static final int POINT_ENTRANCE = 0;
	public static final int POINT_SPACE = 1;
	public static final int POINT_WALL = 2;
	public static final int POINT_EXIT = 3;
	
	public int CheckPos(int x, int y)
	{
	/*	if(x < 0 && x >= 11 && y < 0 && y >= 11)
		{
			System.err.println("Out of bounds, fuck you");
			return -1; 
		}
	*/
		if(ver[x][y] == 'o')
			return 0;
		else if (ver[x][y] == ' ')
			return 1;
		else if (ver[x][y] == '*')
			return 2;
		else if (ver[x][y] == 'x')
			return 3;
		else
			System.err.println("Not valid Character, Fuck you.");
			return -2;
	}
}

 