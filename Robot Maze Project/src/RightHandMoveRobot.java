public class RightHandMoveRobot extends robot {
	
	@Override
	public void Move(Maze m)
	{
		
		updateDirection();
	}
	
	private void check_move()
	{
		
		
	}
	private void movedir()
	{
		
		
	}
	private boolean isEnd()
	{
		if (curPos == end)
			return true;
		else return false;
		
	}
}
