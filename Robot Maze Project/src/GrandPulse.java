public class GrandPulse {
	
	public static void main(String[] args)
	{
		Maze Findme = new Maze();
		MemoryRobot mem = new MemoryRobot(Findme);
		mem.Move(Findme);
		
		System.out.println("/n/nOH GOD WE MADE IT OUT OF THE LOOPS");
	}

}
