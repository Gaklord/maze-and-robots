import java.util.Stack; 


public  class MemoryRobot extends robot {
	
	public MemoryRobot(Maze m)
	{
		area = m.findb();
	}
	
	
	@Override
	public void Move(Maze m)
	{
		while(m.CheckPos(area.getx(), area.gety()) != 3)
		{
			if(m.CheckPos(area.getx(), area.gety() + 1) == 1)
			{
				memory.push(new position(area.getx(), area.gety()));
				area.modify(0, 1);
			}
			else if(m.CheckPos(area.getx()+1, area.gety()) == 1)
			{
				memory.push(new position(area.getx(), area.gety()));
				area.modify(1, 0);
			}
			else if(m.CheckPos(area.getx(), area.gety() -1) == 1)
			{
				memory.push(new position(area.getx(), area.gety()));
				area.modify(0, -1);
			}
			else if(m.CheckPos(area.getx()-1, area.gety()) == 1)
			{
				if(checkstack() == false)
				{
					memory.push(new position(area.getx(), area.gety()));
					area.modify(-1, 0);
				}
			}
			else
			{
				
			}
			
		
		}
	}
	
	private Boolean checkstack()
	{
		if(area == memory.peek())
		return true;
		else
		return false;
	}
	
	
	
	private Stack<position> memory;
	private position area = new position(); 

	
}
