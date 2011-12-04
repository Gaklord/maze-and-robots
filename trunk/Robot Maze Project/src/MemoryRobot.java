import java.util.Stack; 


public  class MemoryRobot extends robot {
	
	public MemoryRobot(Maze m)
	{
		currentPosition = m.findb();
		futurePosition = m.findb();
	}
	
	
	public void Move(Maze m)
	{
		//long timeout = System.currentTimeMillis();
		memory.push(currentPosition);
		while(m.CheckPos(currentPosition.getx(), currentPosition.gety()) != 3)
		{
			lastPosition = currentPosition;
			System.out.println("Made it past here");
			if((m.CheckPos(currentPosition.getx(), currentPosition.gety() + 1) == 1 || m.CheckPos(currentPosition.getx()+1, currentPosition.gety()) == 3) && ((futurePosition = new position(currentPosition.getx(), currentPosition.gety()+1)) != memory.peek()))
			{
				memory.push(lastPosition);
				currentPosition.modify(0, 1);
				
			}
			else if((m.CheckPos(currentPosition.getx()+1, currentPosition.gety()) == 1 || m.CheckPos(currentPosition.getx()+1, currentPosition.gety()) == 3) && ((futurePosition = new position(currentPosition.getx()+1, currentPosition.gety())) != memory.peek()))
			{
				memory.push(lastPosition);
				currentPosition.modify(1, 0);
			}
			else if((m.CheckPos(currentPosition.getx(), currentPosition.gety() -1) == 1 || m.CheckPos(currentPosition.getx()+1, currentPosition.gety()) == 3) && ((futurePosition = new position(currentPosition.getx(), currentPosition.gety()-1)) != memory.peek()))
			{
				memory.push(lastPosition);
				currentPosition.modify(0, -1);
			}
			else if((m.CheckPos(currentPosition.getx()-1, currentPosition.gety()) == 1 || m.CheckPos(currentPosition.getx()+1, currentPosition.gety()) == 3) && ((futurePosition = new position(currentPosition.getx()-1, currentPosition.gety())) != memory.peek()))
			{
				memory.push(lastPosition);
				currentPosition.modify(-1, 0);
			}
			else
			{
				lastresort.push(currentPosition);
				memory.pop();
				memory.push(lastresort.peek());
			}
			
//			System.out.printf("Took Memory Robot " + ((System.currentTimeMillis() - timeout) / 1000)); 
		
		}
		System.out.println("OH MY GOD WE MADE IT I THINK");
		System.out.println(currentPosition.getx() + " " + currentPosition.gety());
		position end = m.finde();
		System.out.println(end.getx() + " " + end.gety());

	}
	
	private Boolean checkstack()
	{
		if(currentPosition == memory.peek())
		return true;
		else
		return false;
		
	}
	
	
	
	private Stack<position> memory = new Stack<position>();
	private Stack<position> lastresort = new Stack<position>();
	
}
