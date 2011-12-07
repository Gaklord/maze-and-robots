public class GrandPulse {
	
	public static void main(String[] args)
	{
		Maze Findme = new Maze();
		//RandomRobot Blind = new RandomRobot(Findme);
		//Blind.Move(Findme);
		MemoryRobot Brain = new MemoryRobot(Findme);
		Brain.Move(Findme);
		RightHandMoveRobot Touma = new RightHandMoveRobot(Findme);
		Touma.Move(Findme);
		System.out.println("\n\nOH GOD WE MADE IT OUT OF THE LOOPS");
	}

}
