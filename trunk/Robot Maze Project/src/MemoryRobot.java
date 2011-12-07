import java.util.ArrayList;
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
		final position memorypos = currentPosition;  
		long signout = System.currentTimeMillis();
		//System.out.println(m.CheckPos(2, 5));
		memory.add(new position(currentPosition.getx(), currentPosition.gety()));
		lastresort.add(new position(currentPosition.getx(), currentPosition.gety()));
		while(m.CheckPos(currentPosition.getx(), currentPosition.gety()) != 3)
		{ 
			System.out.println(currentPosition.getx() + " " + currentPosition.gety());
			lastPosition = lastresort.get(lastresort.size()-1);
			if(m.CheckPos(currentPosition.getx(), currentPosition.gety()+1) == 1 || m.CheckPos(currentPosition.getx(), currentPosition.gety()+1) == 3)
			{
				futurePosition.setPosition(currentPosition.getx(), currentPosition.gety()+1);
				if(checkstack(memory, futurePosition) == true && checkstack(lastresort, futurePosition) == true)
				{
					memory.add(new position(currentPosition.getx(), currentPosition.gety())); 
					currentPosition.modify(0, 1);
					x = 0;
				}
			}
			if(m.CheckPos(currentPosition.getx()+1, currentPosition.gety()) == 1 || m.CheckPos(currentPosition.getx()+1, currentPosition.gety()) == 3)
			{
				futurePosition.setPosition(currentPosition.getx()+1, currentPosition.gety());
				if(checkstack(memory, futurePosition) == true && checkstack(lastresort, futurePosition) == true)

				{
					memory.add(new position(currentPosition.getx(), currentPosition.gety())); 
					currentPosition.modify(1, 0);
					x = 0;
				}
			}
			if(m.CheckPos(currentPosition.getx(), currentPosition.gety()-1) == 1 || m.CheckPos(currentPosition.getx(), currentPosition.gety()-1) == 3)
			{
				futurePosition.setPosition(currentPosition.getx(), currentPosition.gety()-1);
				if(checkstack(memory, futurePosition) == true && checkstack(lastresort, futurePosition) == true)

				{
					memory.add(new position(currentPosition.getx(), currentPosition.gety())); 
					currentPosition.modify(0, -1);
					x = 0;
				}
				
			}
			if(m.CheckPos(currentPosition.getx()-1, currentPosition.gety()) == 1 || m.CheckPos(currentPosition.getx()-1, currentPosition.gety()) == 3)
			{
				futurePosition.setPosition(currentPosition.getx()-1, currentPosition.gety());
				if(checkstack(memory, futurePosition) == true && checkstack(lastresort, futurePosition) == true)

				{
					memory.add(new position(currentPosition.getx(), currentPosition.gety())); 
					currentPosition.modify(-1, 0);
					x = 0;
				}
			}
			if(x == 1)
			{
				lastresort.add(new position(currentPosition.getx(), currentPosition.gety()));
				memory.remove(memory.size()-1);
				currentPosition.setPosition(memory.get(memory.size()-1).getx(), memory.get(memory.size()-1).gety());
			}
			x = 1;
			
		
		}
		System.out.println("OH MY GOD WE MADE IT I THINK");
		System.out.println("Took Memory Robot " + ((System.currentTimeMillis() - signout) / 1000 + " Seconds!")); 
		System.out.println(currentPosition.getx() + " " + currentPosition.gety());
		position end = m.finde();
		System.out.println(end.getx() + " " + end.gety());

	}
	
	private Boolean checkstack(ArrayList<position> j, position p)
	{
		
		for(int i = 0; i < j.size()-1; i++)
		{
			if(j.get(i).getx() == p.getx() && j.get(i).gety() == p.gety())
			{
				return false;
			}
		}
		
		return true;
	}
	
	
	
	private ArrayList<position> memory = new ArrayList<position>();
	private ArrayList<position> lastresort = new ArrayList<position>();
	
}
