public class RightHandMoveRobot extends robot {
	private int wall = 5;
	@Override
	public void Move(Maze m)
	{
		position currentPosition = m.findb();
		if (currentPosition.getx() == 1) //this sets the initial direction for the robot
			 direction = DIR_SOUTH;
		else if (currentPosition.getx() == 10)
			direction = DIR_NORTH;
		else if (currentPosition.gety() == 1)
			direction = DIR_EAST;
		else if (currentPosition.gety() == 10)
			direction = DIR_WEST;

		while (m.CheckPos(currentPosition.getx(), currentPosition.gety()) != 3)//while not end of map
		{
			while (wall == 5) //sets the position of the wall relative to robot's position, should only run once ever
				switch (direction)
				{
				case (0):currentPosition.modify(1, 0);if (m.CheckPos(currentPosition.getx()+1, currentPosition.gety()) == 2) wall = 1;break;
				case (1):currentPosition.modify(0, 1);if (m.CheckPos(currentPosition.getx(), currentPosition.gety()+1) == 2) wall = 2;break;
				case (2):currentPosition.modify(-1, 0);if (m.CheckPos(currentPosition.getx()-1, currentPosition.gety()) == 2) wall = 3;break;
				case (3):currentPosition.modify(0, -1);if (m.CheckPos(currentPosition.getx(), currentPosition.gety()-1) == 2) wall = 0;break;
				default:System.err.println("HERE BE DRAGONS"); System.exit(-82);//self terminates if robot is looking a wrong way
				}
			updateDirection();
				
		}
	}
	
	private void check_move()
	{
		
		
	}
	private void move(int direction)
	{
		
		
	}
	private void updateDirection()
	{
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
	private boolean isEnd()
	{
		//if (curPos == end)
			//return true;
	//else
		return false;
	}
}
