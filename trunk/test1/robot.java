public class robot 
{
	protected position currentPosition;
	protected position lastPosition;
	int direction = 0; 
	
	//Mike you are a stupid Faggot...
	//am i rob?
  //Yes you are
	//testing again, this is on my desktop
  //Dirty Whore Desktop
	//testing again after not checking out
  //At least put on a condom
	
	public void Move( Maze m )
	{
		//Does Nothing
	}
	
	protected void updateDirection()
	{
		//Update Direction
		direction = getDirection( lastPosition, currentPosition );
	}
	
	private int getDirection (position lasPos,position curPos)
	{
		int xdif = curPos.getx() - lasPos.getx();
		int ydif = curPos.gety() - lasPos.gety();
		if (xdif > 0)
			return DIR_EAST;
		else if(xdif < 0)
			return DIR_WEST;
		else if(ydif > 0)
			return DIR_SOUTH;
		else if(ydif < 0)
			return DIR_NORTH;
		System.err.println("I'm Stuck!");
		return -1; // both positions are the same
	}
	
	public static final int DIR_NORTH = 0;
	public static final int DIR_SOUTH = 2;
	public static final int DIR_EAST = 1;
	public static final int DIR_WEST = 3;
	
// last position = new position
	//new position = move(direction)
	//direction = getdirection(last position new position)
}
