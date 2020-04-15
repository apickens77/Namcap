
public class driver {
	public static void main(String[] args)
	{
		Board board = new Board(11, 6);
		System.out.println(board);
		System.out.println();
		System.out.println(board.tiles[5][0]);
		System.out.println(board.tiles[10][5]);
		
		
		board.shortestPathGtP(board.aiGhost0);
		System.out.println("done");
		
	}
}
