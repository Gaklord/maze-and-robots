public class GrandPulse {
	
	public static void main(String[] args)
	{
		Maze Findme = new Maze();
		//RandomRobot mem = new RandomRobot(Findme);
		//mem.Move(Findme);
		MemoryRobot Hand = new MemoryRobot(Findme);
		Hand.Move(Findme);
		System.out.println("/n/nOH GOD WE MADE IT OUT OF THE LOOPS");
	}

}
