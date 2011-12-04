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
		int x = 1;
		position memorypos = new position(); 
		long signout = System.currentTimeMillis();
		memory.push(currentPosition);
		lastresort.push(currentPosition);
		while(m.CheckPos(currentPosition.getx(), currentPosition.gety()) != 3)
		{
			memorypos = memory.peek();
			lastPosition = lastresort.peek();
			while(m.CheckPos(currentPosition.getx(), currentPosition.gety()+1) == 1 || m.CheckPos(currentPosition.getx(), currentPosition.gety()+1) == 3)
			{
				futurePosition.setPosition(currentPosition.getx(), currentPosition.gety()+1);
				if((futurePosition != memorypos) && (futurePosition != lastPosition))
				{
					memory.push(currentPosition); 
					currentPosition.modify(0, 1);
					x = 0;
				}
				
			}
			while(m.CheckPos(currentPosition.getx()+1, currentPosition.gety()) == 1 || m.CheckPos(currentPosition.getx()+1, currentPosition.gety()) == 3)
			{
				futurePosition.setPosition(currentPosition.getx()+1, currentPosition.gety());
				if((futurePosition != memorypos) && (futurePosition != lastPosition))

				{
					memory.push(currentPosition); 
					currentPosition.modify(1, 0);
					x = 0;
				}
				
			}
			while(m.CheckPos(currentPosition.getx(), currentPosition.gety()-1) == 1 || m.CheckPos(currentPosition.getx(), currentPosition.gety()-1) == 3)
			{
				futurePosition.setPosition(currentPosition.getx(), currentPosition.gety()-1);
				if((futurePosition != memorypos) && (futurePosition != lastPosition))

				{
					memory.push(currentPosition); 
					currentPosition.modify(0, -1);
					x = 0;
				}
				
			}
			while(m.CheckPos(currentPosition.getx()-1, currentPosition.gety()) == 1 || m.CheckPos(currentPosition.getx()-1, currentPosition.gety()) == 3)
			{
				futurePosition.setPosition(currentPosition.getx()-1, currentPosition.gety());
				if((futurePosition != memorypos) && (futurePosition != lastPosition))

				{
					memory.push(currentPosition); 
					currentPosition.modify(-1, 0);
					x = 0;
				}
				
			}
			if(x == 1)
			{
				lastresort.push(currentPosition);
				memory.pop();
				currentPosition.setPosition(memory.peek().getx(), memory.peek().gety());
			}
			
			x = 1;
			
		
		}
		System.out.println("OH MY GOD WE MADE IT I THINK");
		System.out.println("Took Memory Robot " + ((System.currentTimeMillis() - signout) / 1000 + " Seconds!")); 
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