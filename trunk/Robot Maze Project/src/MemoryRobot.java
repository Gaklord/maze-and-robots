import java.util.Stack; 


public  class MemoryRobot extends robot {
	
	public MemoryRobot(Maze m)
	{
		currentPosition = m.findb();
	}
	
	
	@Override
	public void Move(Maze m)
	{
		while(m.CheckPos(currentPosition.getx(), currentPosition.gety()) != 3)
		{
			if(m.CheckPos(currentPosition.getx(), currentPosition.gety() + 1) == 1 && (currentPosition != memory.peek()))
			{
				memory.push(new position(currentPosition.getx(), currentPosition.gety()));
				currentPosition.modify(0, 1);
			}
			else if(m.CheckPos(currentPosition.getx()+1, currentPosition.gety()) == 1)
			{
				memory.push(new position(currentPosition.getx(), currentPosition.gety()));
				currentPosition.modify(1, 0);
			}
			else if(m.CheckPos(currentPosition.getx(), currentPosition.gety() -1) == 1)
			{
				memory.push(new position(currentPosition.getx(), currentPosition.gety()));
				currentPosition.modify(0, -1);
			}
			else if(m.CheckPos(currentPosition.getx()-1, currentPosition.gety()) == 1)
			{
				memory.push(new position(currentPosition.getx(), currentPosition.gety()));
				currentPosition.modify(-1, 0);
			}
			else
			{
				
			}
			
		
		}
	}
	
	private Boolean checkstack()
	{
		if(currentPosition == memory.peek())
		return true;
		else
		return false;
		
	}
	
	
	
	private Stack<position> memory = new Stack();

	
}
