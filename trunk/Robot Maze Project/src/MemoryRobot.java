import java.util.Stack; 


public  class MemoryRobot extends robot {
	
	public MemoryRobot(Maze m)
	{
		currentPosition = m.findb();
		futurePosition = m.findb();
	}
	
	
	public void Move(Maze m)
	{
		int x = 1;
		//long signout = System.currentTimeMillis();
		memory.push(currentPosition);
		lastresort.push(currentPosition);
		while(m.CheckPos(currentPosition.getx(), currentPosition.gety()) != 3)
		{
			
			while(m.CheckPos(currentPosition.getx()+1, currentPosition.gety()) == 1 || m.CheckPos(currentPosition.getx() +1, currentPosition.gety()) == 3)
			{
				futurePosition.setPosition(currentPosition.getx()+1, currentPosition.gety());
				if((futurePosition.getx() != memory.peek().getx() && futurePosition.gety() != memory.peek().gety()) || (futurePosition.getx() != lastresort.peek().getx() && futurePosition.gety() != lastresort.peek().gety()))
				{
					memory.push(currentPosition); 
					currentPosition.modify(1, 0);
					x = 0;
				}
				break;
			}
			while(m.CheckPos(currentPosition.getx(), currentPosition.gety()+1) == 1 || m.CheckPos(currentPosition.getx(), currentPosition.gety()+1) == 3)
			{
				futurePosition.setPosition(currentPosition.getx(), currentPosition.gety()+1);
				if((futurePosition.getx() != memory.peek().getx() && futurePosition.gety() != memory.peek().gety()) || (futurePosition.getx() != lastresort.peek().getx() && futurePosition.gety() != lastresort.peek().gety()))
				{
					memory.push(currentPosition); 
					currentPosition.modify(0, 1);
					x = 0;
				}
				break;
			}
			while(m.CheckPos(currentPosition.getx(), currentPosition.gety()-1) == 1 || m.CheckPos(currentPosition.getx(), currentPosition.gety()-1) == 3)
			{
				futurePosition.setPosition(currentPosition.getx(), currentPosition.gety()-1);
				if((futurePosition.getx() != memory.peek().getx() && futurePosition.gety() != memory.peek().gety()) || (futurePosition.getx() != lastresort.peek().getx() && futurePosition.gety() != lastresort.peek().gety()))
				{
					memory.push(currentPosition); 
					currentPosition.modify(0, -1);
					x = 0;
				}
				break;
			}
			while(m.CheckPos(currentPosition.getx()-1, currentPosition.gety()) == 1 || m.CheckPos(currentPosition.getx()-1, currentPosition.gety()) == 3)
			{
				futurePosition.setPosition(currentPosition.getx()-1, currentPosition.gety());
				if((futurePosition.getx() != memory.peek().getx() && futurePosition.gety() != memory.peek().gety()) || (futurePosition.getx() != lastresort.peek().getx() && futurePosition.gety() != lastresort.peek().gety()))
				{
					memory.push(currentPosition); 
					currentPosition.modify(-1, 0);
					x = 0;
				}
				break;
			}
			if(x == 1)
			{
				lastresort.push(currentPosition);
				memory.pop();
				currentPosition.setPosition(memory.peek().getx(), memory.peek().gety());
				x = 0;
			}
			
			x = 1;
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
