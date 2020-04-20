
public class driver {
	public static void main(String[] args)
	{
		Board board = new Board(7, 5);
		System.out.println(board);
		System.out.println();
		
		// Comment these in or out for testing
		board.shortestPathGtP(board.aiGhost0);
		System.out.println();
		System.out.println();
		System.out.println();
		board.pacman.locateNearestDot();

		
	}
}
