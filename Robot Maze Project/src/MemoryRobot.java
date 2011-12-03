import java.util.Stack; 


public  class MemoryRobot extends robot {
	
	public MemoryRobot(Maze m)
	{
		currentPosition = m.findb();
		futurePosition = m.findb();
	}
	
	
	@Override
	public void Move(Maze m)
	{
		long timeout = System.currentTimeMillis();
		while(m.CheckPos(currentPosition.getx(), currentPosition.gety()) != 3)
		{
			lastPosition = currentPosition; 
			if(m.CheckPos(currentPosition.getx(), currentPosition.gety() + 1) == 1 && ((futurePosition = new position(currentPosition.getx(), currentPosition.gety()+1)) != memory.peek()))
			{
				memory.push(lastPosition);
				currentPosition.modify(0, 1);
			}
			else if(m.CheckPos(currentPosition.getx()+1, currentPosition.gety()) == 1 && ((futurePosition = new position(currentPosition.getx(), currentPosition.gety()+1)) != memory.peek()))
			{
				memory.push(lastPosition);
				currentPosition.modify(1, 0);
			}
			else if(m.CheckPos(currentPosition.getx(), currentPosition.gety() -1) == 1 && ((futurePosition = new position(currentPosition.getx(), currentPosition.gety()+1)) != memory.peek()))
			{
				memory.push(lastPosition);
				currentPosition.modify(0, -1);
			}
			else if(m.CheckPos(currentPosition.getx()-1, currentPosition.gety()) == 1 && ((futurePosition = new position(currentPosition.getx(), currentPosition.gety()+1)) != memory.peek()))
			{
				memory.push(lastPosition);
				currentPosition.modify(-1, 0);
			}
			else
			{
				lastresort.push(currentPosition);
				memory.pop();
			}
			
			System.out.printf("Took Memory Robot " + ((System.currentTimeMillis() - timeout) / 1000)); 
		
		}
	}
	
	private Boolean checkstack()
	{
		if(currentPosition == memory.peek())
		return true;
		else
		return false;
		
	}
	
	
	
	private Stack<position> memory;
	private Stack<position> lastresort;
	
}
